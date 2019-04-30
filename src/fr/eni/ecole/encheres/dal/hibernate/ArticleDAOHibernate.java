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
		Query q = session.createQuery("FROM Article WHERE idArticle = "+idArticle);
		List<Article> articles = q.getResultList();
		return articles;
	}
	
	public List<Article> selectByString(String chaine) throws DALException {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Article WHERE nomArticle LIKE '%"+chaine+"%' OR descriptionArticle LIKE '%"+chaine+"%'");
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
	public void insert(Article article) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.save(article);
		session.getTransaction().commit();
	}

	@Override
	public void update(Article article) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.saveOrUpdate(article);
		session.getTransaction().commit();	
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
