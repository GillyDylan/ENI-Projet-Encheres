package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.hibernate.ArticleDAOHibernate;
import fr.eni.ecole.encheres.dal.hibernate.CategorieDAOHibernate;

public class CategorieBLL implements BLL<Categorie>{

	@Override
	public Categorie get(int idCategorie) throws DALException {
		// TODO Auto-generated method stub
		return ((CategorieDAOHibernate) DAOFactory.getDAO(new Categorie())).selectById(idCategorie).get(0);
	}

	@Override
	public List<Categorie> get(String nom) throws DALException {
		// TODO Auto-generated method stub
		return ((CategorieDAOHibernate) DAOFactory.getDAO(new Categorie())).selectByString(nom);
	}

	@Override
	public List<Categorie> get() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Categorie()).selectAll();
	}

	@Override
	public void set(Categorie categorie) throws BLLException, DALException {
		// TODO Auto-generated method stub
		Categorie c = (Categorie) categorie;
		if(((CategorieDAOHibernate) DAOFactory.getDAO(new Categorie())).selectById(c.getIdCategorie())!=null){
			DAOFactory.getDAO(new Categorie()).insert(c);
		}
		else {
			DAOFactory.getDAO(new Categorie()).update(c);
		}	
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
