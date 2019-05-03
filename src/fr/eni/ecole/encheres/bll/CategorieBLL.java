package fr.eni.ecole.encheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class CategorieBLL implements BLL<Categorie>{

	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la cat�gorie ayant pour identifiant idCategorie.
	*/
	@Override
	public Categorie get(int...idCategorie) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Categorie()).selectById(idCategorie[0]).get(0);
	}
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la cat�gorie contenant la chaine entr�e.
	*/
	@Override
	public Categorie get(String chaine) throws DALException {
		// TODO Auto-generated method stub
		return BLLManager.getBLL(new Categorie()).getList(chaine).get(0);
	}

	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste des cat�gories ayant les identifiants entr�s
	* en param�tre.
	*/
	@Override
	public List<Categorie> getList(int...idCategorie) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Categorie()).selectById(idCategorie);
	}

	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste des cat�gories contenant dans leurs 
	* libell�s la chaine entr�e en param�tre.
	*/
	@Override
	public List<Categorie> getList(String chaine) throws DALException {
		// TODO Auto-generated method stub
		List<Categorie> categories = BLLManager.getBLL(new Categorie()).getList();
		List<Categorie> categoriesTrouves = new ArrayList<>();
		for(Categorie categorie : categories) {
			String nom = categorie.getLibelleCategorie();
			//Remplace les majuscules en minuscules
			nom = nom.toLowerCase();
			chaine = chaine.toLowerCase();
			//Retirer ponctuations et espaces/tab
			nom = nom.replaceAll("[\\p{Punct}\\p{Blank}]", ""); 
			chaine = chaine.replaceAll("[\\p{Punct}\\p{Blank}]", "");
			//Retirer les accents
			nom = BLLManager.normalize(nom); 
			chaine = BLLManager.normalize(chaine);
					
			if(nom.contains(chaine)) {
				categoriesTrouves.add(categorie);
			}
		}
		return categoriesTrouves;
	}
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste de toutes les cat�gories
	*/
	@Override
	public List<Categorie> getList() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Categorie()).selectAll();
	}
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Ajoute la cat�gorie
	*/
	@Override
	public void set(Categorie categorie) throws BLLException, DALException {
		// TODO Auto-generated method stub
		if(categorie.getLibelleCategorie().trim() != null){
			throw new BLLException(2000,"Libell� vide");
		}
		if(BLLManager.getBLL(new Categorie()).getList(categorie.getLibelleCategorie()).size() != 0 ){
			throw new BLLException(2001,"Cette cat�gorie existe d�j�");
		}
		if(BLLManager.getBLL(new Categorie()).getList(categorie.getIdCategorie()).size() == 0){
			DAOFactory.getDAO(new Categorie()).insert(categorie);
		}
		else {
			DAOFactory.getDAO(new Categorie()).update(categorie);
		}	
	}


	/**
	* @author ${Dylan Gilly}
	*
	* Supprime la cat�gorie
	*/
	@Override
	public void delete(Categorie categorie) throws DALException, BLLException {
		// TODO Auto-generated method stub
		List<Article> articles = BLLManager.getBLL(new Article()).getList();
		for(Article article : articles) {
			if(article.getCategorie().getIdCategorie() == categorie.getIdCategorie()) {
				throw new BLLException(2010,"Impossible de supprimer une cat�gorie utilis�e dans un article");
			}
		}
	}
}
