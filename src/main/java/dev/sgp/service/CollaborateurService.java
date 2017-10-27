package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constantes;

public class CollaborateurService {
	/** listeCollaborateurs : List<Collaborateur> */
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();

	/** Lister les collaborateur
	 * @return List<Collaborateur>
	 */
	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	/**Sauvegarder un nouveau collaborateur
	 * @param collab
	 */
	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}

	/**Constructeur
	 * Création du collaborateur service et instaciation de dummys
	 */
	public CollaborateurService() {
		this.listeCollaborateurs.add(new Collaborateur("Jean", "Dupont", "Dev",
				Constantes.DEPART_SERVICE.listerDepartments().get(1), "jean.dupont@email.com", "0606060606"));
		this.listeCollaborateurs.add(new Collaborateur("Robert", "Dupond", "Dev",
				Constantes.DEPART_SERVICE.listerDepartments().get(0), "robert.dupont@email.com", "0707070707"));
		this.listeCollaborateurs.add(new Collaborateur("Nicolas", "Cage", "Dev",
				Constantes.DEPART_SERVICE.listerDepartments().get(2), "robert.dupont@email.com", "0707070707"));
	}
}