package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class ListerCollaborateursController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final CollaborateurService collabService = Constantes.COLLAB_SERVICE;
//		List<Collaborateur> listCol = new ArrayList<>();
//		listCol.add(new Collaborateur("Jean", "Dupont", "Dev", "Info", "jean.dupont@email.com", "0606060606"));
//		listCol.add(new Collaborateur("Robert", "Dupond", "Dev", "Info", "robert.dupont@email.com", "0707070707"));
//		listCol.add(new Collaborateur("Nicolas", "Cage", "Dev", "Info", "robert.dupont@email.com", "0707070707"));
//		req.setAttribute("listCol", Constantes.COLLAB_SERVICE.listerCollaborateurs());
		req.getRequestDispatcher("/WEB-INF/views/collaborateurs/lister.jsp").forward(req, resp);
	}
}
