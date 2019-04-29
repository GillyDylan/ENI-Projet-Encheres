package fr.eni.ecole.encheres.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Article {
	
	@Id @GeneratedValue private int idArticle;
	private String nomArticle;
	private String descriptionArticle;
	private Date dateDebutEncheresArticle;
	private Date dateFinEncheresArticle;
	@Column(nullable = true) private int prixInitialArticle;
	@Column(nullable = true) private int prixVenteArticle;
	@OneToOne private Categorie categorieArticle;
	@ManyToOne private Utilisateur utilisateurVendant;
	@ManyToOne private Utilisateur utilsiateurAchetant;

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescriptionArticle() {
		return descriptionArticle;
	}

	public void setDescriptionArticle(String descriptionArticle) {
		this.descriptionArticle = descriptionArticle;
	}

	public Date getDateDebutEncheresArticle() {
		return dateDebutEncheresArticle;
	}

	public void setDateDebutEncheresArticle(Date dateDebutEncheresArticle) {
		this.dateDebutEncheresArticle = dateDebutEncheresArticle;
	}

	public Date getDateFinEncheresArticle() {
		return dateFinEncheresArticle;
	}

	public void setDateFinEncheresArticle(Date dateFinEncheresArticle) {
		this.dateFinEncheresArticle = dateFinEncheresArticle;
	}

	public int getPrixInitialArticle() {
		return prixInitialArticle;
	}

	public void setPrixInitialArticle(int prixInitialArticle) {
		this.prixInitialArticle = prixInitialArticle;
	}

	public int getPrixVenteArticle() {
		return prixVenteArticle;
	}

	public void setPrixVenteArticle(int prixVenteArticle) {
		this.prixVenteArticle = prixVenteArticle;
	}

	public Categorie getCategorie() {
		return categorieArticle;
	}

	public void setCategorie(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}


	public Article(int idArticle, String nomArticle, String descriptionArticle, Date dateDebutEncheresArticle,
			Date dateFinEncheresArticle, int prixInitialArticle, int prixVenteArticle,
			Categorie categorieArticle) {
		super();
		this.setIdArticle(idArticle);
		this.setNomArticle(nomArticle);
		this.setDescriptionArticle(descriptionArticle);
		this.setDateDebutEncheresArticle(dateDebutEncheresArticle);
		this.setDateFinEncheresArticle(dateFinEncheresArticle);
		this.setPrixInitialArticle(prixInitialArticle);
		this.setPrixVenteArticle(prixVenteArticle);
		this.setCategorie(categorieArticle);
	}
	
	public Article(String nomArticle, String descriptionArticle, Date dateDebutEncheresArticle,
			Date dateFinEncheresArticle, int prixInitialArticle, int prixVenteArticle,
			Categorie categorieArticle) {
		super();
		this.setNomArticle(nomArticle);
		this.setDescriptionArticle(descriptionArticle);
		this.setDateDebutEncheresArticle(dateDebutEncheresArticle);
		this.setDateFinEncheresArticle(dateFinEncheresArticle);
		this.setPrixInitialArticle(prixInitialArticle);
		this.setPrixVenteArticle(prixVenteArticle);
		this.setCategorie(categorieArticle);
	}
	
	

	
	public Article(String nomArticle, String descriptionArticle, int prixInitialArticle, int prixVenteArticle,
			Categorie categorie) {
		super();
		this.setNomArticle(nomArticle);
		this.setDescriptionArticle(descriptionArticle);
		this.setPrixInitialArticle(prixInitialArticle);
		this.setPrixVenteArticle(prixVenteArticle);
		this.setCategorie(categorie);
	}
	
	
	
	
	

}
