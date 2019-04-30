package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DAO;
import fr.eni.ecole.encheres.dal.hibernate.ArticleDAOHibernate;
import fr.eni.ecole.encheres.dal.hibernate.CategorieDAOHibernate;
import fr.eni.ecole.encheres.dal.hibernate.EnchereDAOHibernate;
import fr.eni.ecole.encheres.dal.hibernate.RetraitDAOHibernate;
import fr.eni.ecole.encheres.dal.hibernate.UtilisateurDAOHibernate;

public class BLLManager {
	public static <T> BLL getBLL(T t){
		BLL bll = null;
   
        if(t instanceof Utilisateur) {
        	bll = new UtilisateurBLL();
        }
       /* if(t instanceof Article) {
        	bll = new ArticleBLL();
        }
        if(t instanceof Categorie) {
        	bll = new CategorieBLL();
        }
        if(t instanceof Enchere) {
        	bll = new EnchereBLL();
        }
        if(t instanceof Retrait) {
        	bll = new RetraitBLL();
        }*/
        return bll;
    }
}