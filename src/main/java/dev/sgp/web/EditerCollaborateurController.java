package dev.sgp.web;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.util.Constantes;

public class EditerCollaborateurController extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<Collaborateur> c = Constantes.COLLAB_SERVICE.listerCollaborateurs().stream()
				.filter(col -> col.getMatricule() == Integer.parseInt(req.getParameter("matricule"))).findFirst();
		if (c.isPresent()){
			req.setAttribute("collaborateur", c.get());
		}
		req.getRequestDispatcher("/WEB-INF/views/collaborateurs/edit.jsp").forward(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<Collaborateur> c = Constantes.COLLAB_SERVICE.listerCollaborateurs().stream()
				.filter(col -> col.getMatricule() == Integer.parseInt(req.getParameter("matricule"))).findFirst();
		if (c.isPresent()){
			Collaborateur collaborateur = c.get();
			collaborateur.setAdresse(req.getParameter("adresse"));
			collaborateur.setTelephone(req.getParameter("telephone"));
			collaborateur.setIban(req.getParameter("iban"));
			collaborateur.setBic(req.getParameter("bic"));
			collaborateur.setFonction(req.getParameter("fonction"));
			if(req.getParameter("desactiver")==null){
				collaborateur.setActif(true);
			}else{
				collaborateur.setActif(false);
			}
			
			Optional<Departement> oDep= Constantes.DEPART_SERVICE.listerDepartments().stream().filter(d -> d.getNom().equals(req.getParameter("departement"))).findFirst();
			if(oDep.isPresent()){
				collaborateur.setDepartement(oDep.get());
			}
			req.removeAttribute("matricule");
			req.removeAttribute("afficherDesactiver");
			req.removeAttribute("departement");
			
			req.setAttribute("collaborateurs", Constantes.COLLAB_SERVICE.listerCollaborateurs().stream().filter(c2 -> c2.isActif()).collect(Collectors.toList()));
			req.getRequestDispatcher("/WEB-INF/views/collaborateurs/lister.jsp").forward(req, resp);
			
		}
		

	}

}
