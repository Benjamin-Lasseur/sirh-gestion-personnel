package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class NouveauCollaborateurController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/collaborateurs/nouveau.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom =req.getParameter("nom");
		String prenom =req.getParameter("prenom");
		LocalDate date = LocalDate.parse(req.getParameter("anniversaire"));
		String adresse =req.getParameter("adresse");
		String numSecu =req.getParameter("numsecu");
		Collaborateur c = new Collaborateur(nom, prenom, date, adresse, numSecu);
		Constantes.COLLAB_SERVICE.sauvegarderCollaborateur(c);
		req.getRequestDispatcher("/WEB-INF/views/collaborateurs/lister.jsp").forward(req, resp);
	}
}

