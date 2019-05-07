package fr.eni.ecole.encheres.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.ArticleRecherche;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class ArticleBLL implements BLL<Article>{
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie l'article ayant pour identifiant idArticle.
	* @throws DALException
	*/
	@Override
	public Article get(int...idArticle) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Article()).selectById(idArticle[0]).get(0);
	}
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie le dernier article publié contenant dans son 
	* titre ou sa description la chaine entrée en paramètre.
	* @throws DALException
	*/
	@Override
	public Article get(String chaine) throws DALException {
		// TODO Auto-generated method stub	
		return BLLManager.getBLL(new Article()).getList(chaine).get(0);
	}
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste des articles ayant les identifiants entrés
	* en paramètre.
	* @throws DALException
	*/
	@Override
	public List<Article> getList(int...idArticle) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Article()).selectById(idArticle);
	}
		
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste des articles contenant dans leurs 
	* titres ou leurs descriptions la chaine entrée en paramètre.
	* @throws DALException
	*/
	@Override
	public List<Article> getList(String chaine) throws DALException {
		// TODO Auto-generated method stub
		List<Article> articles = BLLManager.getBLL(new Article()).getList();
		List<Article> articlesTrouves = new ArrayList<>();
		for(Article article : articles) {
			
			String description = article.getDescriptionArticle();
			String titre = article.getNomArticle();
			
			//Remplace les majuscules en minuscules
			description = description.toLowerCase();
			titre = titre.toLowerCase();
			chaine = chaine.toLowerCase();
			//Retirer ponctuations et espaces/tab
			description = description.replaceAll("[\\p{Punct}\\p{Blank}]", ""); 
			titre = titre.replaceAll("[\\p{Punct}\\p{Blank}]", "");
			chaine = chaine.replaceAll("[\\p{Punct}\\p{Blank}]", "");
			//Retirer les accents
			description = BLLManager.normalize(description); 
			titre = BLLManager.normalize(titre);
			chaine = BLLManager.normalize(chaine);
			
			if(description.contains(chaine) || titre.contains(chaine)) {
				articlesTrouves.add(article);
			}
		}
		return articlesTrouves;
	}	
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste de tous les articles
	* @throws DALException
	*/
	@Override
	public List<Article> getList() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Article()).selectAll();
		//return this.getList("gogo", 0, true, true, true, true);
	}
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste de tous les articles selon les paramètres d'entrée :
	* String "filtre" est la chaine a rechercher, null si aucune
	* int idCategorie est l'id de la catégorie a rechercher, 0 si aucune
	* @throws DALException
	* 
	*/
	public List<Article> getList(ArticleRecherche recherche, Utilisateur utilisateur) throws DALException{
		List<Article> articles;
		List<Article> articlesFiltres = new ArrayList<>();
		
		if(recherche.getFiltre() == null || recherche.getFiltre()=="" ) {
			articles = this.getList();
		}
		else {
			articles = this.getList(recherche.getFiltre());
		}
		
		if(recherche.getCategorie() != null)
		{
			for( Article article : articles) {
				if(article.getCategorie().getIdCategorie() == recherche.getCategorie().getIdCategorie()) {
					articlesFiltres.add(article);
				}
			}
		}
		else {
			articlesFiltres = articles;
		}
		
		articles.clear();
		articles.addAll(articlesFiltres);
		articlesFiltres.clear();
		
		if(!recherche.isParam1() && !recherche.isParam2() && !recherche.isParam3()) {
			if(recherche.isAchat()) {
				for( Article article : articles) {
					if(article.getUtilisateurVendant().getIdUtilisateur() != utilisateur.getIdUtilisateur()) {
						articlesFiltres.add(article);
					}
				}
			}
			else {
				for( Article article : articles) {
					if(article.getUtilisateurVendant().getIdUtilisateur() == utilisateur.getIdUtilisateur()){
						articlesFiltres.add(article);
					}
				}
			}
		} 
		else {	
			if(recherche.isAchat()) {
				if(recherche.isParam1()) {
					for( Article article : articles) {
						if(article.getUtilisateurVendant().getIdUtilisateur() != utilisateur.getIdUtilisateur() && !article.isTermine()) {
							articlesFiltres.add(article);
						}
					}
				}
				if(!recherche.isParam1() && recherche.isParam2()) {
					List<Enchere> encheres = BLLManager.getBLL(new Enchere()).getList();
					for( Article article : articles) {
						boolean trouve = false;
						for(Enchere enchere : encheres) {
							if(enchere.getArticle().getIdArticle() == article.getIdArticle() && enchere.getUtilisateur().getIdUtilisateur() == utilisateur.getIdUtilisateur()) {
								trouve = true;
							}
						}
						if(trouve) {
							articlesFiltres.add(article);
						}
					}
				}
				if(recherche.isParam3()) {
					for( Article article : articles) {
						if(article.getUtilisateurAchetant().getIdUtilisateur() == utilisateur.getIdUtilisateur() && article.isTermine()) {
							articlesFiltres.add(article);
						}
					}
				}
			}
			else {
				if(recherche.isParam1()) {
					for( Article article : articles) {
						
					}
				}
			}
		}
		return articlesFiltres;
		
		
	}
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Ajoute l'article
	*/
	@Override
	public void set(Article article) throws BLLException, DALException {
		// TODO Auto-generated method stub
		if(BLLManager.getBLL(new Article()).getList(article.getIdArticle()).size() == 0){
			if(article.getDateDebutEncheresArticle().before(new Date())) {
				throw new BLLException(1000,"Début de l'enchère déjà passée");
			}
			if(BLLManager.getBLL(new Article()).getList(article.getDescriptionArticle().trim()).size() != 0) {
				throw new BLLException(1001,"Cette description existe déjà");
			}
			DAOFactory.getDAO(new Article()).insert(article);
		}
		else {
			Article articleOld = BLLManager.getBLL(new Article()).get(article.getIdArticle());
			if(articleOld.getCategorie().getIdCategorie() != article.getCategorie().getIdCategorie())
			{
				throw new BLLException(1010,"Impossible de changer la cat�gorie de d'un article déjà publié");
			}
			if(!articleOld.getDateDebutEncheresArticle().equals(article.getDateDebutEncheresArticle()))
			{
				throw new BLLException(1011,"Impossible de changer la date de d�but d'un article déjà publié");
			}
			if(!articleOld.getDateFinEncheresArticle().equals(article.getDateFinEncheresArticle()))
			{
				throw new BLLException(1012,"Impossible de changer la date de fin d'un article déjà publié");
			}
			if(!articleOld.getNomArticle().equals(article.getNomArticle()))
			{
				throw new BLLException(1013,"Impossible de changer le titre d'un article déjà publié");
			}
			if(articleOld.getUtilisateurVendant().getIdUtilisateur() != article.getUtilisateurVendant().getIdUtilisateur())
			{
				throw new BLLException(1014,"Impossible de changer le vendeur d'un article déjà publié");
			}
			if(articleOld.getDateFinEncheresArticle().after(new Date()) && articleOld.getUtilisateurAchetant().getIdUtilisateur() != article.getUtilisateurAchetant().getIdUtilisateur())
			{
				throw new BLLException(1015,"Impossible de changer l'acheteur d'un article déjà vendu");
			}
			DAOFactory.getDAO(new Article()).update(article);
		}	
	}	
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Supprime l'article
	*/
	@Override
	public void delete(Article article) throws DALException, BLLException {
		// TODO Auto-generated method stub
		List<Enchere> encheres = BLLManager.getBLL(new Enchere()).getList(article.getIdArticle());
		/*if(encheres.size() != 0) {
			throw new BLLException(1020,"Impossible de supprimer un article avec des enchères en cours");
		}
		else {*/
			for(Enchere enchere : encheres) {
				DAOFactory.getDAO(new Enchere()).delete(enchere);
			}
			DAOFactory.getDAO(new Article()).delete(article);	
		
	}
}
