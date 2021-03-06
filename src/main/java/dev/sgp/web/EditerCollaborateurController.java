package dev.sgp.web;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.util.Constantes;

@WebServlet("/collaborateurs/edit")
public class EditerCollaborateurController extends HttpServlet {

	/*
	 * Controller du POST
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<Collaborateur> c = Constantes.COLLAB_SERVICE.listerCollaborateurs().stream()
				.filter(col -> col.getMatricule() == Integer.parseInt(req.getParameter("matricule"))).findFirst();
		if (c.isPresent()) {
			req.setAttribute("collaborateur", c.get());
		}
		req.setAttribute("departements", Constantes.DEPART_SERVICE.listerDepartments());
		req.getRequestDispatcher("/WEB-INF/views/collaborateurs/edit.jsp").forward(req, resp);
	}

	/*
	 * Controller du POST
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<Collaborateur> c = Constantes.COLLAB_SERVICE.listerCollaborateurs().stream()
				.filter(col -> col.getMatricule() == Integer.parseInt(req.getParameter("matricule"))).findFirst();
		if (c.isPresent()) {
			Collaborateur collaborateur = c.get();
			collaborateur.setAdresse(req.getParameter("adresse"));
			collaborateur.setTelephone(req.getParameter("telephone"));
			collaborateur.setIban(req.getParameter("iban"));
			collaborateur.setBic(req.getParameter("bic"));
			collaborateur.setFonction(req.getParameter("fonction"));
			if (req.getParameter("desactiver") == null) {
				collaborateur.setActif(true);
			} else {
				collaborateur.setActif(false);
			}

			Optional<Departement> oDep = Constantes.DEPART_SERVICE.listerDepartments().stream()
					.filter(d -> d.getNom().equals(req.getParameter("departement"))).findFirst();
			if (oDep.isPresent()) {
				collaborateur.setDepartement(oDep.get());
			}
			req.setAttribute("departements", Constantes.DEPART_SERVICE.listerDepartments());
			req.setAttribute("collaborateurs", Constantes.COLLAB_SERVICE.listerCollaborateurs().stream()
					.filter(c2 -> c2.isActif()).collect(Collectors.toList()));
			req.getRequestDispatcher("/WEB-INF/views/collaborateurs/lister.jsp").forward(req, resp);

		}

	}

}
