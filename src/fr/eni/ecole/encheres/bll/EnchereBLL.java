package fr.eni.ecole.encheres.bll;

import java.util.Date;
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
	public Enchere get(int...idsEncheres) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Enchere()).selectById(idsEncheres[0],idsEncheres[1]).get(0);
	}

	
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoi NULL.
	* Aucune recherche par String possible sur Ench�re
	*/
	@Override
	public Enchere get(String s) throws DALException {
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
	public List<Enchere> getList(int...idsEnchere) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Enchere()).selectById(idsEnchere[0], idsEnchere[1]);
	}
	
	
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoi NULL.
	* Aucune recherche par String possible sur Ench�re
	*/
	@Override
	public List<Enchere> getList(String s) throws DALException {
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
	* Supprime l'ench�re.
	* Ordre des param�tres : IdArticle, IdUtilisateur, dateEnchere
	*/
	public void delete(int idArticle, int idUtilisateur, Date date) throws DALException {
		
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
			if(enchere.getArticle().getIdArticle() == oldEnchere.getArticle().getIdArticle() && enchere.getMontantEnchere() < oldEnchere.getMontantEnchere()) {
				throw new BLLException(3000,"Il existe d�j� une ench�re plus elev�e pour cet article");
			}
		}
		DAOFactory.getDAO(new Enchere()).insert(enchere);
	}
}
