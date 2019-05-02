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
				throw new BLLException(1000,"D�but de l'ench�re d�j� pass�e");
			}
			if(DAOFactory.getDAO(new Article()).selectByString(article.getDescriptionArticle().trim()).size() != 0) {
				throw new BLLException(1001,"Cette description existe d�j�");
			}
			DAOFactory.getDAO(new Article()).insert(article);
		}
		else {
			Article articleOld = DAOFactory.getDAO(new Article()).selectById(article.getIdArticle()).get(0);
			if(articleOld.getCategorie().getIdCategorie() != article.getCategorie().getIdCategorie())
			{
				throw new BLLException(1010,"Impossible de changer la cat�gorie de d'un article d�j� publi�");
			}
			if(!articleOld.getDateDebutEncheresArticle().equals(article.getDateDebutEncheresArticle()))
			{
				throw new BLLException(1011,"Impossible de changer la date de d�but d'un article d�j� publi�");
			}
			if(!articleOld.getDateFinEncheresArticle().equals(article.getDateFinEncheresArticle()))
			{
				throw new BLLException(1012,"Impossible de changer la date de fin d'un article d�j� publi�");
			}
			if(!articleOld.getNomArticle().equals(article.getNomArticle()))
			{
				throw new BLLException(1013,"Impossible de changer le titre d'un article d�j� publi�");
			}
			if(articleOld.getUtilisateurVendant().getIdUtilisateur() != article.getUtilisateurVendant().getIdUtilisateur())
			{
				throw new BLLException(1014,"Impossible de changer le vendeur d'un article d�j� publi�");
			}
			if(articleOld.getDateFinEncheresArticle().after(new Date()) && articleOld.getUtilisateurAchetant().getIdUtilisateur() != article.getUtilisateurAchetant().getIdUtilisateur())
			{
				throw new BLLException(1015,"Impossible de changer l'acheteur d'un article d�j� vendu");
			}
			DAOFactory.getDAO(new Article()).update(article);
		}	
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
