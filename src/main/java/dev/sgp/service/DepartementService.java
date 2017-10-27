package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {
	private List<Departement> listeDepartements = new ArrayList<>();

	public List<Departement> listerDepartments() {
		return listeDepartements;
	}

	public void sauvegarderDepartement(Departement dep) {
		listeDepartements.add(dep);
	}

	public DepartementService() {
		this.listeDepartements.add(new Departement("Comptabilite"));
		this.listeDepartements.add(new Departement("Ressources humaines"));
		this.listeDepartements.add(new Departement("Informatique"));
		this.listeDepartements.add(new Departement("Administratif"));
	}
}
