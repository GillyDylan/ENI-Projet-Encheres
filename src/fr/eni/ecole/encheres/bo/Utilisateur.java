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
	@NotNull @Column(nullable = false) private String pseudonymeUtilisateur;
	@NotNull @Column(nullable = false) private String nomUtilisateur;
	@NotNull @Column(nullable = false) private String prenomUtilisateur;
	@NotNull @Column(nullable = false) private String eMailUtilisateur;
	@Nullable @Column(nullable = true) private String telephoneUtilisateur;
	@NotNull @Column(nullable = false) private String rueUtilisateur;
	@NotNull @Column(nullable = false) private int codePostalUtilisateur;
	@NotNull @Column(nullable = false) private String villeUtilisateur;
	@NotNull @Column(nullable = false) private String motDePasseUtilisateur;
	@NotNull @Column(nullable = false) private int creditUtilisateur;
	@NotNull @Column(nullable = false) private boolean administrateur;
	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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
	public void setEMailUtilisateur(String eMailUtilisateur) {
		this.eMailUtilisateur = eMailUtilisateur;
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
	
	public Utilisateur(int idUtilisateur, String pseudonymeUtilisateur, String nomUtilisateur, String prenomUtilisateur,
			String eMailUtilisateur, String telephoneUtilisateur, String rueUtilisateur, int codePostalUtilisateur,
			String villeUtilisateur, String motDePasseUtilisateur, int creditUtilisateur, boolean administrateur) {
		super();
		this.setIdUtilisateur(idUtilisateur);
		this.setPseudonymeUtilisateur(pseudonymeUtilisateur);
		this.setNomUtilisateur(nomUtilisateur);
		this.setPrenomUtilisateur(prenomUtilisateur);
		this.setEMailUtilisateur(eMailUtilisateur);
		this.setTelephoneUtilisateur(telephoneUtilisateur);
		this.setRueUtilisateur(rueUtilisateur);
		this.setCodePostalUtilisateur(codePostalUtilisateur);
		this.setVilleUtilisateur(villeUtilisateur);
		this.setMotDePasseUtilisateur(motDePasseUtilisateur);
		this.setCreditUtilisateur(creditUtilisateur);
		this.setAdministrateur(administrateur);
	}
	
	public Utilisateur(String pseudonymeUtilisateur, String nomUtilisateur, String prenomUtilisateur,
			String eMailUtilisateur, String telephoneUtilisateur, String rueUtilisateur, int codePostalUtilisateur,
			String villeUtilisateur, String motDePasseUtilisateur, int creditUtilisateur, boolean administrateur) {
		super();
		this.setPseudonymeUtilisateur(pseudonymeUtilisateur);
		this.setNomUtilisateur(nomUtilisateur);
		this.setPrenomUtilisateur(prenomUtilisateur);
		this.setEMailUtilisateur(eMailUtilisateur);
		this.setTelephoneUtilisateur(telephoneUtilisateur);
		this.setRueUtilisateur(rueUtilisateur);
		this.setCodePostalUtilisateur(codePostalUtilisateur);
		this.setVilleUtilisateur(villeUtilisateur);
		this.setMotDePasseUtilisateur(motDePasseUtilisateur);
		this.setCreditUtilisateur(creditUtilisateur);
		this.setAdministrateur(administrateur);
	}
	
	public Utilisateur(String pseudonymeUtilisateur, String nomUtilisateur, String prenomUtilisateur,
			String eMailUtilisateur, String rueUtilisateur, int codePostalUtilisateur, String villeUtilisateur,
			String motDePasseUtilisateur, int creditUtilisateur, boolean administrateur) {
		super();
		this.setPseudonymeUtilisateur(pseudonymeUtilisateur);
		this.setNomUtilisateur(nomUtilisateur);
		this.setPrenomUtilisateur(prenomUtilisateur);
		this.setEMailUtilisateur(eMailUtilisateur);
		this.setRueUtilisateur(rueUtilisateur);
		this.setCodePostalUtilisateur(codePostalUtilisateur);
		this.setVilleUtilisateur(villeUtilisateur);
		this.setMotDePasseUtilisateur(motDePasseUtilisateur);
		this.setCreditUtilisateur(creditUtilisateur);
		this.setAdministrateur(administrateur);
	}
	
	public Utilisateur() {
		super();
	}
	
	
	
	
	
	
	

}
