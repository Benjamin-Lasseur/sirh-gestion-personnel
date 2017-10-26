package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String matricule = req.getParameter("matricule");
		String titre = req.getParameter("titre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		if (matricule == null || titre == null || nom == null || prenom == null) {
			resp.setStatus(400);
			StringBuilder str = new StringBuilder("Les paramètres suivants sont incorrects: ");
			if (matricule == null) {
				str.append("Matricule");
			}
			if (titre == null) {
				str.append(" - Titre");
			}
			if (nom == null) {
				str.append(" - Nom");
			}
			if (prenom == null) {
				str.append(" - Prenom");
			}
			resp.getWriter().write(str.toString());
		} else {
			String retour = "</br>";
			StringBuilder str2 = new StringBuilder("Matricule :").append(matricule).append(retour).append("Titre :").append(titre).append(retour).append("Nom :").append(nom).append(retour).append("Prenom :").append(prenom);
			;
			
			resp.setStatus(201);
			resp.getWriter().write(str2.toString());
		}

	}
}
