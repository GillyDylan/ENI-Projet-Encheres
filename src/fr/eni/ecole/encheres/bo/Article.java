package fr.eni.ecole.encheres.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Article {
	
	@Id @GeneratedValue private int idArticle;
	private String nomArticle;
	private String descriptionArticle;
	private Date dateDebutEncheresArticle;
	private Date dateFinEncheresArticle;
	private int prixInitialArticle;
	@Column(nullable = true) private int prixVenteArticle;

	@ManyToOne @JoinColumn(name="idCategorie", referencedColumnName = "idCategorie") private Categorie categorie;
	@ManyToOne @JoinColumn(name="idUtilisateurVendant", referencedColumnName = "idUtilisateur") private Utilisateur utilisateurVendant;
	@ManyToOne @JoinColumn(name="idUtilisateurAchetant", referencedColumnName = "idUtilisateur") private Utilisateur utilisateurAchetant;
	
	@ManyToOne @JoinColumn(name="idRetrait", referencedColumnName = "idRetrait", nullable = true) private Retrait retrait;


	public Utilisateur getUtilisateurVendant() {
		return utilisateurVendant;
	}

	public void setUtilisateurVendant(Utilisateur utilisateurVendant) {
		this.utilisateurVendant = utilisateurVendant;
	}

	public Utilisateur getUtilisateurAchetant() {
		return utilisateurAchetant;
	}

	public void setUtilisateurAchetant(Utilisateur utilisateurAchetant) {
		this.utilisateurAchetant = utilisateurAchetant;
	}

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
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Article(int idArticle, String nomArticle, String descriptionArticle, Date dateDebutEncheresArticle,
			Date dateFinEncheresArticle, int prixInitialArticle, int prixVenteArticle,
			Categorie categorie) {
		super();
		this.setIdArticle(idArticle);
		this.setNomArticle(nomArticle);
		this.setDescriptionArticle(descriptionArticle);
		this.setDateDebutEncheresArticle(dateDebutEncheresArticle);
		this.setDateFinEncheresArticle(dateFinEncheresArticle);
		this.setPrixInitialArticle(prixInitialArticle);
		this.setPrixVenteArticle(prixVenteArticle);
		this.setCategorie(categorie);
	}
	
	public Article(String nomArticle, String descriptionArticle, Date dateDebutEncheresArticle,
			Date dateFinEncheresArticle, int prixInitialArticle, int prixVenteArticle,
			Categorie categorie) {
		super();
		this.setNomArticle(nomArticle);
		this.setDescriptionArticle(descriptionArticle);
		this.setDateDebutEncheresArticle(dateDebutEncheresArticle);
		this.setDateFinEncheresArticle(dateFinEncheresArticle);
		this.setPrixInitialArticle(prixInitialArticle);
		this.setPrixVenteArticle(prixVenteArticle);
		this.setCategorie(categorie);
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
	
	public Article() {
		super();
	}
	
	
	
	
	

}
