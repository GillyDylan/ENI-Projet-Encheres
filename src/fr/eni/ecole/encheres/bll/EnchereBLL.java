package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class EnchereBLL implements BLL<Enchere>{
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie l'ench�re la plus r�cente.
	* Ordre des param�tres : IdArticle, IdUtilisateur
	*/
	@Override
	public Enchere get(int...idEnchere) throws DALException {
		// TODO Auto-generated method stub
		if(idEnchere.length != 1)
		{
			return DAOFactory.getDAO(new Enchere()).selectById(idEnchere[0],idEnchere[1]).get(0);
		}
		else {
			return DAOFactory.getDAO(new Enchere()).selectById(idEnchere[0]).get(0);
		}
	}
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie NULL.
	* Aucune recherche par String possible sur Ench�re
	*/
	@Override
	public Enchere get(String chaine) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie une liste d'ench�re tri� en d�croissant.
	* Ordre des param�tres : IdArticle, IdUtilisateur
	*/
	@Override
	public List<Enchere> getList(int...idEnchere) throws DALException {
		// TODO Auto-generated method stub
		if(idEnchere.length != 1)
		{
			return DAOFactory.getDAO(new Enchere()).selectById(idEnchere[0], idEnchere[1]);
		}else {
			return DAOFactory.getDAO(new Enchere()).selectById(idEnchere[0]);
		}
	}		
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie NULL.
	* Aucune recherche par String possible sur Ench�re
	*/
	@Override
	public List<Enchere> getList(String chaine) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}		
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoi la liste de toutes les ench�res.
	*/
	@Override
	public List<Enchere> getList() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Enchere()).selectAll();
	}	
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Ajoute l'ench�re.
	*/
	@Override
	public void set(Enchere enchere) throws BLLException, DALException {
		// TODO Auto-generated method stub
		List<Enchere> encheres = DAOFactory.getDAO(new Enchere()).selectAll();
		for(Enchere oldEnchere : encheres) {
			if(enchere.getArticle().getIdArticle() == oldEnchere.getArticle().getIdArticle() && enchere.getMontantEnchere() <= oldEnchere.getMontantEnchere()) {
				throw new BLLException(3000,"Il existe déjà une enchère plus elevée pour cet article");
			}
		}
		Enchere oldEnchere = this.get(enchere.getArticle().getIdArticle());
		if(enchere.getArticle().getUtilisateurAchetant().getIdUtilisateur() == oldEnchere.getArticle().getUtilisateurAchetant().getIdUtilisateur()) {
			throw new BLLException(3001, "Vous êtes déjà le meilleur enchérisseur");
		}
		DAOFactory.getDAO(new Enchere()).insert(enchere);
	}
	

	
	/**
	* @author ${Dylan Gilly}
	*
	* Supprime l'ench�re.
	* Ordre des param�tres : IdArticle, IdUtilisateur, dateEnchere
	*/
	@Override
	public void delete(Enchere enchere) throws DALException, BLLException {
		//A faire
	}	
	
	
}
