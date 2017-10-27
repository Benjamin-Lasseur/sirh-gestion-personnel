package dev.sgp.entite;


public class Departement {
	private int id;
	private String nom;
	static private int indexId = 0;

	public Departement(String nom) {
		this.nom = nom;
		this.id = ++Departement.indexId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
}
