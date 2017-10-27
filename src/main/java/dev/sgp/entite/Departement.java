package dev.sgp.entite;


public class Departement {
	/** id : int */
	private int id;
	/** nom : String */
	private String nom;
	/** indexId : int */
	static private int indexId = 0;

	/**Constructeur du département avec un index auto-incrémentant
	 * @param nom
	 */
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
