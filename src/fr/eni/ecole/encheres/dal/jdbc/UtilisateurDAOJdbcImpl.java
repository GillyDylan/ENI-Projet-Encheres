package fr.eni.ecole.encheres.dal.jdbc;

import java.util.List;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class UtilisateurDAOJdbcImpl implements DAO<Utilisateur>{

	@Override
	public List<Utilisateur> selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Utilisateur t) throws DALException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Utilisateur t) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
