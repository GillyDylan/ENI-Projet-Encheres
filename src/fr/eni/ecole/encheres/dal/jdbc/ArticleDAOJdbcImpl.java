package fr.eni.ecole.encheres.dal.jdbc;

import java.util.List;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class ArticleDAOJdbcImpl implements DAO<Article>{

	@Override
	public List<Article> selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Article t) throws DALException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Article t) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
