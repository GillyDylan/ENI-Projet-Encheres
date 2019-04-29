package fr.eni.ecole.encheres.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ArticleVendu {
	
	@Id @GeneratedValue private int idArticleVendu;
	private String nomArticleVendu;
	private String descriptionArticleVendu;
	private Date dateDebutEncheresArticleVendu;
	private Date dateFinEncheresArticleVendu;
	@Column(nullable = true) private int prixInitialArticleVendu;
	@Column(nullable = true) private int prixVenteArticleVendu;
	private int idUtilisateur;
	private int idCategorie;
	

}
