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
		
	}
}