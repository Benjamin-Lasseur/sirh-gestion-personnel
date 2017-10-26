package dev.sgp.collab;

public class Collaborateur {
	/** nom : String */
	private String nom;
	/** prenom : String */
	private String prenom;
	/** fonction : String */
	private String fonction;
	/** departement : String */
	private String departement;
	/** email : String */
	private String email;
	/** telephone : String */
	private String telephone;

	public Collaborateur(String nom, String prenom, String fonction, String departement, String email,
			String telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.departement = departement;
		this.email = email;
		this.telephone = telephone;
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

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the fonction
	 */
	public String getFonction() {
		return fonction;
	}

	/**
	 * @param fonction
	 *            the fonction to set
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	/**
	 * @return the departement
	 */
	public String getDepartement() {
		return departement;
	}

	/**
	 * @param departement
	 *            the departement to set
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
