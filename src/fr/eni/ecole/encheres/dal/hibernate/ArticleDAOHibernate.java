package fr.eni.ecole.encheres.dal.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class ArticleDAOHibernate implements DAO<Article>{


	public List<Article> selectById(int idArticle) throws DALException {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Categorie WHERE idArticle = "+idArticle);
		List<Article> articles = q.getResultList();
		return articles;
	}

	@Override
	public List<Article> selectAll() throws DALException {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Article");
		List<Article> articles = q.getResultList();
		return articles;
	}

	@Override
	public void insert(Article t) throws DALException {
		// TODO Auto-generated method stub
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
