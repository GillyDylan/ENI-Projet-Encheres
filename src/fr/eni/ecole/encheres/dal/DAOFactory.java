package fr.eni.ecole.encheres.dal;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.ecole.encheres.dal.jdbc.DAO;

public class DAOFactory {
	 public static <T> DAO getDAO(T t){
	        DAO dao = null;
	        if(t instanceof Categorie) {
	            dao = new CategorieDAOJdbcImpl();
	        }
	        return dao;
	    }
}
