package dev.sgp.listener;

import java.util.stream.Stream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

@WebListener
public class StartupListener implements ServletContextListener {

	private CollaborateurService collaborateurService = Constantes.COLLAB_SERVICE;
	private DepartementService departementService = Constantes.DEPART_SERVICE;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Stream.of(new Departement("Comptabilite"), new Departement("Ressources humaines"),
				new Departement("Informatique"), new Departement("Administratif"))
				.forEach(departementService::sauvegarderDepartement);

		Stream.of(
				new Collaborateur("Jean", "Dupont", "Dev", Constantes.DEPART_SERVICE.listerDepartments().get(1),
						"jean.dupont@email.com", "0606060606"),
				new Collaborateur("Robert", "Dupond", "Dev", Constantes.DEPART_SERVICE.listerDepartments().get(0),
						"robert.dupont@email.com", "0707070707"),
				new Collaborateur("Nicolas", "Cage", "Dev", Constantes.DEPART_SERVICE.listerDepartments().get(2),
						"robert.dupont@email.com", "0707070707"))
				.forEach(collaborateurService::sauvegarderCollaborateur);

	}

}
