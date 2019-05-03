package fr.eni.ecole.encheres.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class ArticleBLL implements BLL<Article>{
	
	
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie l'article ayant pour identifiant idArticle.
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
	*/
	@Override
	public List<Article> getList() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Article()).selectAll();
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
				throw new BLLException(1010,"Impossible de changer la catégorie de d'un article déjà publié");
			}
			if(!articleOld.getDateDebutEncheresArticle().equals(article.getDateDebutEncheresArticle()))
			{
				throw new BLLException(1011,"Impossible de changer la date de début d'un article déjà publié");
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
		if(encheres.size() != 0) {
			throw new BLLException(1020,"Impossible de supprimer un article avec des enchères en cours");
		}
		DAOFactory.getDAO(new Article()).delete(article);
		
	}



}
