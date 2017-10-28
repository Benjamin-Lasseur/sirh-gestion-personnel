package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constantes;

public class NouveauCollaborateurController extends HttpServlet {

	/*
	 * Controller du GET
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/collaborateurs/nouveau.jsp").forward(req, resp);
	}

	/*
	 * Controller du POST
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> parametres = new ArrayList<>();
		parametres.add("nom");
		parametres.add("prenom");
		parametres.add("anniversaire");
		parametres.add("adresse");
		parametres.add("numsecu");
		String nom = req.getParameter(parametres.get(0));
		String prenom = req.getParameter(parametres.get(1));
		String dateString = req.getParameter(parametres.get(2));
		LocalDate date = LocalDate.parse(dateString);
		String adresse = req.getParameter(parametres.get(3));
		String numSecu = req.getParameter(parametres.get(4));
		if(parametres.stream().filter(p->p.equals("")).findAny().isPresent()) {
			StringBuilder str = new StringBuilder("Le(s) paramètre(s) suivant(s) manque(nt): ");
			parametres.stream().forEach(p -> {if(p.equals("")) {
			str.append(" ").append(p);	
			}
			});
			resp.sendError(400, str.toString());
		}
		Collaborateur c = new Collaborateur(nom, prenom, date, adresse, numSecu);
		Constantes.COLLAB_SERVICE.sauvegarderCollaborateur(c);
		req.setAttribute("collaborateurs", Constantes.COLLAB_SERVICE.listerCollaborateurs().stream()
				.filter(c2 -> c2.isActif()).collect(Collectors.toList()));
		req.getRequestDispatcher("/WEB-INF/views/collaborateurs/lister.jsp").forward(req, resp);
	}
}
