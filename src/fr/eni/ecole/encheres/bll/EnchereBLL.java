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
	* Ordre des paramètres : IdArticle, IdUtilisateur
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
	* Aucune recherche par String possible sur Enchère
	*/
	@Override
	public Enchere get(String chaine) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie une liste d'ench�re trié en décroissant.
	* Ordre des paramètres : IdArticle, IdUtilisateur
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
	* Aucune recherche par String possible sur Enchère
	*/
	@Override
	public List<Enchere> getList(String chaine) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}		
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoi la liste de toutes les enchères.
	*/
	@Override
	public List<Enchere> getList() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Enchere()).selectAll();
	}	
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Ajoute l'enchère.
	*/
	@Override
	public void set(Enchere enchere) throws BLLException, DALException {
		// TODO Auto-generated method stub
		if(enchere.getDateEnchere().after(enchere.getArticle().getDateFinEncheresArticle()) || enchere.getArticle().isTermine()) {
			throw new BLLException(3000, "Cette vente est terminée");
		}
		
		List<Enchere> encheres = this.getList(enchere.getArticle().getIdArticle());
		if(encheres.size() != 0) {
			for(Enchere oldEnchere : encheres) {
				if(enchere.getMontantEnchere() <= oldEnchere.getMontantEnchere()) {
					throw new BLLException(3001,"Il existe déjà une enchère plus elevée pour cet article");
				}
			}
			Enchere oldEnchere = this.get(enchere.getArticle().getIdArticle());
			if(enchere.getArticle().getUtilisateurAchetant().getIdUtilisateur() == oldEnchere.getArticle().getUtilisateurAchetant().getIdUtilisateur()) {
				throw new BLLException(3002, "Vous êtes déjà le meilleur enchérisseur");
			}
			if(enchere.getUtilisateur().getCreditUtilisateur() < enchere.getArticle().getPrixVenteArticle()) {
				throw new BLLException(3003, "Vous ne disposez que de " + enchere.getUtilisateur().getCreditUtilisateur() + " crédits");
			}
		}
		else {
			if(enchere.getMontantEnchere() < enchere.getArticle().getPrixInitialArticle()) {
				throw new BLLException(3004, "Impossible d'entrer une enchère inférieure à "+enchere.getArticle().getPrixInitialArticle());
			}
			if(enchere.getDateEnchere().before(enchere.getArticle().getDateDebutEncheresArticle())) {
				throw new BLLException(3005, "Le début des enchères n'est pas commencé");
			}
		}
		DAOFactory.getDAO(new Enchere()).insert(enchere);
	}
	

	
	/**
	* @author ${Dylan Gilly}
	*
	* Supprime l'ench�re.
	* Ordre des paramètres : IdArticle, IdUtilisateur, dateEnchere
	*/
	@Override
	public void delete(Enchere enchere) throws DALException, BLLException {
		//A faire
	}	
	
	
}
