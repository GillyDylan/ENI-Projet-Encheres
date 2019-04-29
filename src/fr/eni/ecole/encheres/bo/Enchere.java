package fr.eni.ecole.encheres.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Enchere {
	
	@Id private int idUtilisateur;
	@Id private int idArticleVendu;
	private Date dateEnchere;
	private int montantEnchere;
	
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public int getIdArticleVendu() {
		return idArticleVendu;
	}
	public void setIdArticleVendu(int idArticleVendu) {
		this.idArticleVendu = idArticleVendu;
	}
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public int getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	
	public Enchere(int idUtilisateurEnchere, int idArticleEnchere, Date dateEnchere, int montantEnchere) {
		super();
		this.setIdUtilisateur(idUtilisateurEnchere);
		this.setIdArticleVendu(idArticleEnchere);
		this.setDateEnchere(dateEnchere);
		this.setMontantEnchere(montantEnchere);
	}
	
	public Enchere(int montantEnchere) {
		super();
		this.setMontantEnchere(montantEnchere);
	}
	
	public Enchere() {
		super();
	}
	
	
	
	
	

}
