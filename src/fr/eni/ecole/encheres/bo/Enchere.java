package fr.eni.ecole.encheres.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Enchere {
	
	@ManyToOne @JoinColumn(name="idUtilisateur") @Id private Utilisateur utilisateur;
	@ManyToOne @JoinColumn(name="idArticle") @Id private Article article;
	private Date dateEnchere;
	private int montantEnchere;
	
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
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
	
	public Enchere(Utilisateur utilisateur, Article article, Date dateEnchere, int montantEnchere) {
		super();
		this.setUtilisateur(utilisateur);
		this.setArticle(article);
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
