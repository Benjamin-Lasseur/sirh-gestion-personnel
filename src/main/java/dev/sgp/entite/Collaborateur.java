package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;

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
	/** matricule : int */
	private int matricule;
	/** numSecu : String */
	private String numSecu;
	/** photo : String */
	private String photo;
	/** dateHeureCreation : ZonedDateTime */
	private ZonedDateTime dateHeureCreation;
	/** dateDeNaissance : LocalDate */
	private LocalDate dateDeNaissance;
	/** adresse : String */
	private String adresse;
	/** actif : boolean */
	private boolean actif;
	private static int matriculeStatic = 0;

	public Collaborateur(String nom, String prenom, String fonction, String departement, String email,
			String telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.departement = departement;
		this.email = email;
		this.telephone = telephone;
	}

	public Collaborateur(String nom, String prenom, LocalDate date, String adresse, String numSecu) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = date;
		this.adresse = adresse;
		this.numSecu = numSecu;
		this.matricule = ++matriculeStatic;
		this.dateHeureCreation = ZonedDateTime.now();
		this.email = nom + "." + prenom + "@societe.com";
		this.photo = "https://assets.chooseyourboss.com/companies/logos/000/004/322/square/Logo_DTA.jpg?1457453234";
		this.actif = true;
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

	/**
	 * @return the matricule
	 */
	public int getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the numSecu
	 */
	public String getNumSecu() {
		return numSecu;
	}

	/**
	 * @param numSecu
	 *            the numSecu to set
	 */
	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the dateHeureCreation
	 */
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	/**
	 * @param dateHeureCreation
	 *            the dateHeureCreation to set
	 */
	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	/**
	 * @return the dateDeNaissance
	 */
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * @param dateDeNaissance
	 *            the dateDeNaissance to set
	 */
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the actif
	 */
	public boolean isActif() {
		return actif;
	}

	/**
	 * @param actif
	 *            the actif to set
	 */
	public void setActif(boolean actif) {
		this.actif = actif;
	}

	/**
	 * @return the matriculeStatic
	 */
	public static int getMatriculeStatic() {
		return matriculeStatic;
	}

	/**
	 * @param matriculeStatic
	 *            the matriculeStatic to set
	 */
	public static void setMatriculeStatic(int matriculeStatic) {
		Collaborateur.matriculeStatic = matriculeStatic;
	}

}
