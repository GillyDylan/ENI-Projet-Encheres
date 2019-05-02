package fr.eni.ecole.encheres.bll;

import java.util.Date;
import java.util.List;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class ArticleBLL implements BLL<Article>{
	
	@Override
	public Article get(int...idArticle) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Article()).selectById(idArticle[0]).get(0);
	}
	
	@Override
	public List<Article> get(String chaine) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Article()).selectByString(chaine);
	}

	@Override
	public List<Article> get() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Article()).selectAll();
	}

	@Override
	public void set(Article article) throws BLLException, DALException {
		// TODO Auto-generated method stub
		if(DAOFactory.getDAO(new Article()).selectById(article.getIdArticle()).size() == 0){
			if(article.getDateDebutEncheresArticle().before(new Date())) {
				throw new BLLException("Début de l'enchère déjà passée");
			}
			DAOFactory.getDAO(new Article()).insert(article);
		}
		else {
			DAOFactory.getDAO(new Article()).update(article);
		}
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
