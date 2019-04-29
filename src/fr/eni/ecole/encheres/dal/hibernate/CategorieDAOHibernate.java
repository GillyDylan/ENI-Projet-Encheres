package fr.eni.ecole.encheres.dal.hibernate;

import java.util.List;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class CategorieDAOHibernate implements DAO<Categorie>{

	@Override
	public List<Categorie> selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Categorie t) throws DALException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Categorie t) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
