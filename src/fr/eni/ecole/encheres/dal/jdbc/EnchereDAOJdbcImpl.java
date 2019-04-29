package fr.eni.ecole.encheres.dal.jdbc;

import java.util.List;

import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class EnchereDAOJdbcImpl implements DAO<Enchere>{

	@Override
	public List<Enchere> selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Enchere t) throws DALException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Enchere t) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
