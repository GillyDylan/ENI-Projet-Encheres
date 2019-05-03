package fr.eni.ecole.encheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class RetraitBLL implements BLL<Retrait>{

	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie le retrait ayant pour identifiant idRetrait.
	*/
	@Override
	public Retrait get(int...idRetrait) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Retrait()).selectById(idRetrait[0]).get(0);
	}
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie le retrait contenant la chaine entrée.
	*/
	@Override
	public Retrait get(String chaine) throws DALException {
		// TODO Auto-generated method stub
		return BLLManager.getBLL(new Retrait()).getList(chaine).get(0);
	}

	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste des retraits ayant les identifiants entrés
	* en paramètre.
	*/
	@Override
	public List<Retrait> getList(int...idRetrait) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Retrait()).selectById(idRetrait);
	}

	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste des retraits contenant dans leurs 
	* adresses et villes la chaine entrée en paramètre.
	*/
	@Override
	public List<Retrait> getList(String chaine) throws DALException {
		// TODO Auto-generated method stub
		List<Retrait> retraits = BLLManager.getBLL(new Retrait()).getList();
		List<Retrait> retraitsTrouves = new ArrayList<>();
		for(Retrait retrait : retraits) {
			String adresse = retrait.getAdresseRetrait();
			String ville = retrait.getVilleRetrait();
			//Remplace les majuscules en minuscules
			adresse = adresse.toLowerCase();
			ville = ville.toLowerCase();
			chaine = chaine.toLowerCase();
			//Retirer ponctuations et espaces/tab
			adresse = adresse.replaceAll("[\\p{Punct}\\p{Blank}]", ""); 
			ville = ville.replaceAll("[\\p{Punct}\\p{Blank}]", ""); 
			chaine = chaine.replaceAll("[\\p{Punct}\\p{Blank}]", "");
			//Retirer les accents
			adresse = BLLManager.normalize(adresse); 
			ville = BLLManager.normalize(ville); 
			chaine = BLLManager.normalize(chaine);
							
			if(ville.contains(chaine) || adresse.contains(chaine)) {
				retraitsTrouves.add(retrait);
			}
		}
		return retraitsTrouves;
	}

	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste de tous les retraits
	*/
	@Override
	public List<Retrait> getList() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Retrait()).selectAll();
	}

	
	/**
	* @author ${Dylan Gilly}
	*
	* Ajoute le retrait
	*/
	@Override
	public void set(Retrait retrait) throws BLLException, DALException {
		// TODO Auto-generated method stub
		if(BLLManager.getBLL(new Retrait()).getList(retrait.getIdRetrait()).size() == 0){
			DAOFactory.getDAO(new Retrait()).insert(retrait);
		}
		else {
			DAOFactory.getDAO(new Retrait()).update(retrait);
		}	
	}

	
	/**
	* @author ${Dylan Gilly}
	*
	* Supprime le retrait
	*/
	@Override
	public void delete(Retrait retrait) throws DALException, BLLException {
		// TODO Auto-generated method stub
		//A faire
	}




	
}
