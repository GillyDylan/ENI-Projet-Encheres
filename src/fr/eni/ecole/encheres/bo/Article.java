package fr.eni.ecole.encheres.bo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

@Entity @OnDelete(action = OnDeleteAction.CASCADE)
public class Article {
	
	@Id @GeneratedValue private int idArticle;
	@NotNull @Column(nullable = false) private String nomArticle;
	@NotNull @Column(nullable = false) private String descriptionArticle;
	@NotNull @Column(nullable = false) private Date dateDebutEncheresArticle;
	@NotNull @Column(nullable = false) private Date dateFinEncheresArticle;
	@NotNull @Column(nullable = false) private int prixInitialArticle;
	@Nullable @Column(nullable = true) private int prixVenteArticle;
	@NotNull @Column(nullable = false) private boolean termine;

	@NotNull @ManyToOne @JoinColumn(name="idCategorie", referencedColumnName = "idCategorie", nullable = false) 
	private Categorie categorie;
	@NotNull @ManyToOne(cascade = CascadeType.REMOVE) @JoinColumn(name="idUtilisateurVendant", referencedColumnName = "idUtilisateur", nullable = false) 
	private Utilisateur utilisateurVendant;
	@Nullable @ManyToOne @JoinColumn(name="idUtilisateurAchetant", referencedColumnName = "idUtilisateur", nullable = true) 
	private Utilisateur utilisateurAchetant;
	@Nullable @ManyToOne @JoinColumn(name="idRetrait", referencedColumnName = "idRetrait", nullable = true) 
	private Retrait retrait;
	@Lob @Nullable @Column(nullable=true)
	private byte[] imageArticle;

	public byte[] getImageArticle() {
		return imageArticle;
	}

	public void setImageArticle(byte[] imageArticle) {
		this.imageArticle = imageArticle;
	}

	public boolean isTermine() {
		return termine;
	}

	public Retrait getRetrait() {
		return retrait;
	}

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

	public Article(String nomArticle, String descriptionArticle, Date dateDebutEncheresArticle,
			Date dateFinEncheresArticle, int prixInitialArticle, Categorie categorie, Utilisateur utilisateurVendant,
			byte[] imageArticle) {
		super();
		this.setNomArticle(nomArticle);
		this.setDescriptionArticle(descriptionArticle);
		this.setDateDebutEncheresArticle(dateDebutEncheresArticle);
		this.setDateFinEncheresArticle(dateFinEncheresArticle);
		this.setPrixInitialArticle(prixInitialArticle);
		this.setCategorie(categorie);
		this.setUtilisateurVendant(utilisateurVendant);
		this.setImageArticle(imageArticle);
		this.termine = false;
	}

	public Article(String nomArticle, String descriptionArticle, Date dateDebutEncheresArticle,
			Date dateFinEncheresArticle, int prixInitialArticle, Categorie categorie, Utilisateur utilisateurVendant) {
		super();
		this.setNomArticle(nomArticle);
		this.setDescriptionArticle(descriptionArticle);
		this.setDateDebutEncheresArticle(dateDebutEncheresArticle);
		this.setDateFinEncheresArticle(dateFinEncheresArticle);
		this.setPrixInitialArticle(prixInitialArticle);
		this.setCategorie(categorie);
		this.setUtilisateurVendant(utilisateurVendant);
		this.termine = false;
	}

	public Article() {
		super();
		this.termine = false;
	}
	
	
	
	
	

}
