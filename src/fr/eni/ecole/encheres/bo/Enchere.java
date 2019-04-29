package fr.eni.ecole.encheres.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Enchere {
	
	@Id private int idUtilisateurEnchere;
	@Id private int idArticleEnchere;
	private Date dateEnchere;
	private int montantEnchere;
	
	public int getIdUtilisateurEnchere() {
		return idUtilisateurEnchere;
	}
	public void setIdUtilisateurEnchere(int idUtilisateurEnchere) {
		this.idUtilisateurEnchere = idUtilisateurEnchere;
	}
	public int getIdArticleEnchere() {
		return idArticleEnchere;
	}
	public void setIdArticleEnchere(int idArticleEnchere) {
		this.idArticleEnchere = idArticleEnchere;
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
		this.setIdUtilisateurEnchere(idUtilisateurEnchere);
		this.setIdArticleEnchere(idArticleEnchere);
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
