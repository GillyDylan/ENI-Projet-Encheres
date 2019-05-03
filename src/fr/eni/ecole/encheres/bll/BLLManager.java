package fr.eni.ecole.encheres.bll;

import java.text.Normalizer;

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
	public static <T> BLL<T> getBLL(T t){
		BLL bll = null;
   
        if(t instanceof Utilisateur) {
        	bll = new UtilisateurBLL();
        }
        if(t instanceof Article) {
        	bll = new ArticleBLL();
        }
        if(t instanceof Categorie) {
        	bll = new CategorieBLL();
        }
        if(t instanceof Retrait) {
        	bll = new RetraitBLL();
        }
        if(t instanceof Enchere) {
        	bll = new EnchereBLL();
        }
        return bll;
    }
	
	public static String normalize(String input) {
		return Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
}
