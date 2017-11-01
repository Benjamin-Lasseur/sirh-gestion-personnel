package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class ListerCollaborateursController extends HttpServlet {

	/* 
	 * Controller du GET
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("departements", Constantes.DEPART_SERVICE.listerDepartments());
		req.setAttribute("collaborateurs", Constantes.COLLAB_SERVICE.listerCollaborateurs());
		req.setAttribute("afficherDesactiver", null);
		req.setAttribute("departement", null);
		req.getRequestDispatcher("/WEB-INF/views/collaborateurs/lister.jsp").forward(req, resp);
	}

	/* 
	 * Controller du POST
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<Departement> oDep= Constantes.DEPART_SERVICE.listerDepartments().stream().filter(d -> d.getNom().equals(req.getParameter("departement"))).findFirst();
		List<Collaborateur> listCollab = Constantes.COLLAB_SERVICE.listerCollaborateurs();
		String chercher = req.getParameter("cherchernom");
		if (chercher!=null) {
			listCollab = listCollab.stream().filter(c->c.getNom().toLowerCase().contains(chercher.toLowerCase())||c.getPrenom().toLowerCase().contains(chercher.toLowerCase())).collect(Collectors.toList());	
		req.setAttribute("cherchernom", chercher);
		}
		if(oDep.isPresent()){
			listCollab = listCollab.stream().filter(c->c.getDepartement().equals(oDep.get())).collect(Collectors.toList());	
		}
		if(req.getParameter("afficherDesactiver")==null){
		listCollab = listCollab.stream().filter(c -> c.isActif()).collect(Collectors.toList());
		}
		req.setAttribute("departements", Constantes.DEPART_SERVICE.listerDepartments());
		req.setAttribute("collaborateurs", listCollab);
		req.setAttribute("afficherDesactiver", req.getParameter("afficherDesactiver"));
		req.setAttribute("departement", req.getParameter("departement"));
		req.getRequestDispatcher("/WEB-INF/views/collaborateurs/lister.jsp").forward(req, resp);
	}
}
