package fr.eni.ecole.encheres.bll;

import java.util.Date;
import java.util.List;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.hibernate.ArticleDAOHibernate;

public class ArticleBLL implements BLL{
	
	@Override
	public Article get(int id) throws DALException {
		// TODO Auto-generated method stub
		return (Article) ((ArticleDAOHibernate) DAOFactory.getDAO(new Article())).selectById(id).get(0);
	}
	
	@Override
	public List<Article> get(String chaine) throws DALException {
		// TODO Auto-generated method stub
		return ((ArticleDAOHibernate) DAOFactory.getDAO(new Article())).selectByString(chaine);
	}

	@Override
	public List<Article> get() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Utilisateur()).selectAll();
	}

	@Override
	public void set(Object article) throws BLLException, DALException {
		// TODO Auto-generated method stub
		Article a = (Article) article;

		if(((ArticleDAOHibernate) DAOFactory.getDAO(new Article())).selectById(a.getIdArticle())!=null){
			if(a.getDateDebutEncheresArticle().before(new Date())) {
				throw new BLLException("Début de l'enchère déjà passée");
			}
			DAOFactory.getDAO(new Article()).insert(a);
		}
		else {
			DAOFactory.getDAO(new Article()).update(a);
		}
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}
}
