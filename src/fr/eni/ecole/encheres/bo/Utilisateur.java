package fr.eni.ecole.encheres.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;


@Entity
public class Utilisateur {
	@Id @GeneratedValue private int idUtilisateur;
	@Nullable @Column(nullable = true) private String pseudonymeUtilisateur;
	@NotNull @Column(nullable = false) private String nomUtilisateur;
	@NotNull @Column(nullable = false) private String prenomUtilisateur;
	@Nullable @Column(nullable = true) private String eMailUtilisateur;
	@Nullable @Column(nullable = true) private String telephoneUtilisateur;
	@NotNull @Column(nullable = false) private String rueUtilisateur;
	@NotNull @Column(nullable = false) private int codePostalUtilisateur;
	@Nullable @Column(nullable = true) private String villeUtilisateur;
	@Nullable @Column(nullable = true) private String motDePasseUtilisateur;
	@NotNull @Column(nullable = false) private int creditUtilisateur;
	@NotNull @Column(nullable = false) private boolean administrateur;
	@NotNull @Column(nullable = false) private boolean actif;
	
	public boolean isActif() {
		return actif;
	}
	
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	public void seteMailUtilisateur(String eMailUtilisateur) {
		this.eMailUtilisateur = eMailUtilisateur;
	}
	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	
	public String getPseudonymeUtilisateur() {
		return pseudonymeUtilisateur;
	}
	
	public void setPseudonymeUtilisateur(String pseudonymeUtilisateur) {
		this.pseudonymeUtilisateur = pseudonymeUtilisateur;
	}
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	
	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}
	
	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}
	
	public String geteMailUtilisateur() {
		return eMailUtilisateur;
	}
	
	public String getTelephoneUtilisateur() {
		return telephoneUtilisateur;
	}
	
	public void setTelephoneUtilisateur(String telephoneUtilisateur) {
		this.telephoneUtilisateur = telephoneUtilisateur;
	}
	
	public String getRueUtilisateur() {
		return rueUtilisateur;
	}
	
	public void setRueUtilisateur(String rueUtilisateur) {
		this.rueUtilisateur = rueUtilisateur;
	}
	
	public int getCodePostalUtilisateur() {
		return codePostalUtilisateur;
	}
	
	public void setCodePostalUtilisateur(int codePostalUtilisateur) {
		this.codePostalUtilisateur = codePostalUtilisateur;
	}
	
	public String getVilleUtilisateur() {
		return villeUtilisateur;
	}
	
	public void setVilleUtilisateur(String villeUtilisateur) {
		this.villeUtilisateur = villeUtilisateur;
	}
	
	public String getMotDePasseUtilisateur() {
		return motDePasseUtilisateur;
	}
	
	public void setMotDePasseUtilisateur(String motDePasseUtilisateur) {
		this.motDePasseUtilisateur = motDePasseUtilisateur;
	}
	
	public int getCreditUtilisateur() {
		return creditUtilisateur;
	}
	
	public void setCreditUtilisateur(int creditUtilisateur) {
		this.creditUtilisateur = creditUtilisateur;
	}
	
	public boolean isAdministrateur() {
		return administrateur;
	}
	
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public Utilisateur(String pseudonymeUtilisateur, String nomUtilisateur, String prenomUtilisateur,
			String eMailUtilisateur, String telephoneUtilisateur, String rueUtilisateur, int codePostalUtilisateur,
			String villeUtilisateur, String motDePasseUtilisateur) {
		super();
		this.setPseudonymeUtilisateur(pseudonymeUtilisateur);
		this.setNomUtilisateur(nomUtilisateur);
		this.setPrenomUtilisateur(prenomUtilisateur);
		this.seteMailUtilisateur(eMailUtilisateur);
		this.setTelephoneUtilisateur(telephoneUtilisateur);
		this.setRueUtilisateur(rueUtilisateur);
		this.setCodePostalUtilisateur(codePostalUtilisateur);
		this.setVilleUtilisateur(villeUtilisateur);
		this.setMotDePasseUtilisateur(motDePasseUtilisateur);
		this.setCreditUtilisateur(100);
		this.setActif(true);
		this.setAdministrateur(false);
	}
	
	public Utilisateur(String pseudonymeUtilisateur, String nomUtilisateur, String prenomUtilisateur,
			String eMailUtilisateur, String rueUtilisateur, int codePostalUtilisateur, String villeUtilisateur,
			String motDePasseUtilisateur) {
		super();
		this.setPseudonymeUtilisateur(pseudonymeUtilisateur);
		this.setNomUtilisateur(nomUtilisateur);
		this.setPrenomUtilisateur(prenomUtilisateur);
		this.seteMailUtilisateur(eMailUtilisateur);
		this.setRueUtilisateur(rueUtilisateur);
		this.setCodePostalUtilisateur(codePostalUtilisateur);
		this.setVilleUtilisateur(villeUtilisateur);
		this.setMotDePasseUtilisateur(motDePasseUtilisateur);
		this.setCreditUtilisateur(100);
		this.setActif(true);
		this.setAdministrateur(false);
	}
	
	public Utilisateur() {
		super();
		this.setCreditUtilisateur(100);
		this.setActif(true);
		this.setAdministrateur(false);
	}
	
	
	
	
	
	
	

}
