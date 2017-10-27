package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constantes;

public class NouveauCollaborateurController extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/collaborateurs/nouveau.jsp").forward(req, resp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		LocalDate date = LocalDate.parse(req.getParameter("anniversaire"));
		String adresse = req.getParameter("adresse");
		String numSecu = req.getParameter("numsecu");
		Collaborateur c = new Collaborateur(nom, prenom, date, adresse, numSecu);
		Constantes.COLLAB_SERVICE.sauvegarderCollaborateur(c);
		req.setAttribute("collaborateurs", Constantes.COLLAB_SERVICE.listerCollaborateurs().stream().filter(c2 -> c2.isActif()).collect(Collectors.toList()));
		req.getRequestDispatcher("/WEB-INF/views/collaborateurs/lister.jsp").forward(req, resp);
	}
}
