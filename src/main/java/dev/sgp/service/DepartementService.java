package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {
	/** listeDepartements : List<Departement> */
	private List<Departement> listeDepartements = new ArrayList<>();

	/**
	 * @return
	 */
	public List<Departement> listerDepartments() {
		return listeDepartements;
	}

	/**
	 * @param dep
	 */
	public void sauvegarderDepartement(Departement dep) {
		listeDepartements.add(dep);
	}

	/**Constructeur
	 * Création du departement service et instaciation de départements de base
	 */
	public DepartementService() {
		
	}
}
