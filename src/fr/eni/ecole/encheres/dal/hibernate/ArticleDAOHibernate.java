package fr.eni.ecole.encheres.dal.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.ArticleRecherche;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class ArticleDAOHibernate implements DAO<Article>{

	
	public List<Article> selectByRecherche(ArticleRecherche recherche){
		int compteur = 0 ;
		Session session = ConnectionProvider.session;
		StringBuilder requeteBuilder = new StringBuilder();
		requeteBuilder.append("FROM Article WHERE");
		
		
		requeteBuilder.append(" ORDER BY dateDebutEncheresArticle DESC");
		Query q = session.createQuery(requeteBuilder.toString());
		List<Article> articles = q.getResultList();
		return articles;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> selectById(int...idArticle) throws DALException {
		int compteur = 0 ;
		Session session = ConnectionProvider.session;
		StringBuilder requeteBuilder = new StringBuilder();
		requeteBuilder.append("FROM Article WHERE");
		for(int id : idArticle) {
			if(compteur != 0) {
				requeteBuilder.append(" OR");
			}
			requeteBuilder.append(" idArticle = " + id);
			compteur++;
		}
		requeteBuilder.append(" ORDER BY dateDebutEncheresArticle DESC");
		Query q = session.createQuery(requeteBuilder.toString());
		List<Article> articles = q.getResultList();
		return articles;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> selectAll() throws DALException {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Article ORDER BY dateDebutEncheresArticle DESC");
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
	public void delete(Article article) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.delete(article);
		session.getTransaction().commit();
		System.out.println("smogogo");
	}

}
