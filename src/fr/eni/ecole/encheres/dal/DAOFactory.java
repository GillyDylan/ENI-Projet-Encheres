package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.hibernate.ArticleDAOHibernate;
import fr.eni.ecole.encheres.dal.hibernate.CategorieDAOHibernate;
import fr.eni.ecole.encheres.dal.hibernate.EnchereDAOHibernate;
import fr.eni.ecole.encheres.dal.hibernate.HibernateDAO;
import fr.eni.ecole.encheres.dal.hibernate.RetraitDAOHibernate;
import fr.eni.ecole.encheres.dal.hibernate.UtilisateurDAOHibernate;
import fr.eni.ecole.encheres.dal.jdbc.ArticleDAOJdbcImpl;
import fr.eni.ecole.encheres.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.ecole.encheres.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.ecole.encheres.dal.jdbc.RetraitDAOJdbcImpl;
import fr.eni.ecole.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {
	 public static <T> DAO getDAO(T t){
		 	DAO dao = null;
	        if(t instanceof Categorie) {
	            dao = new CategorieDAOHibernate();
	        }
	        if(t instanceof Enchere) {
	            dao = new EnchereDAOHibernate();
	        }
	        if(t instanceof Retrait) {
	            dao = new RetraitDAOHibernate();
	        }
	        if(t instanceof Utilisateur) {
	            dao = new UtilisateurDAOHibernate();
	        }
	        if(t instanceof Article) {
	            dao = new ArticleDAOHibernate();
	        }
	        return dao;
	    }
}
