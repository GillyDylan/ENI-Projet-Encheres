package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.ecole.encheres.dal.jdbc.DAO;
import fr.eni.ecole.encheres.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.ecole.encheres.dal.jdbc.RetraitDAOJdbcImpl;

public class DAOFactory {
	 public static <T> DAO getDAO(T t){
	        DAO dao = null;
	        if(t instanceof Categorie) {
	            dao = new CategorieDAOJdbcImpl();
	        }
	        if(t instanceof Enchere) {
	            dao = new EnchereDAOJdbcImpl();
	        }
	        if(t instanceof Retrait) {
	            dao = new RetraitDAOJdbcImpl();
	        }
	        return dao;
	    }
}
