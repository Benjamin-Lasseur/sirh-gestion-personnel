package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constantes;

public class CollaborateurService {
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}

	public CollaborateurService() {
		this.listeCollaborateurs.add(new Collaborateur("Jean", "Dupont", "Dev",
				Constantes.DEPART_SERVICE.listerDepartments().get(1), "jean.dupont@email.com", "0606060606"));
		this.listeCollaborateurs.add(new Collaborateur("Robert", "Dupond", "Dev",
				Constantes.DEPART_SERVICE.listerDepartments().get(0), "robert.dupont@email.com", "0707070707"));
		this.listeCollaborateurs.add(new Collaborateur("Nicolas", "Cage", "Dev",
				Constantes.DEPART_SERVICE.listerDepartments().get(2), "robert.dupont@email.com", "0707070707"));
	}
}