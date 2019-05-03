package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class CategorieBLL implements BLL<Categorie>{

	@Override
	public Categorie get(int idCategorie) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Categorie()).selectById(idCategorie).get(0);
	}

	@Override
	public List<Categorie> get(String nom) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Categorie()).selectByString(nom);
	}

	@Override
	public List<Categorie> get() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Categorie()).selectAll();
	}
	
	@Override
	public List<Categorie> get(int... ids) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Categorie()).selectById(ids[0]);
	}

	@Override
	public void set(Categorie categorie) throws BLLException, DALException {
		// TODO Auto-generated method stub
		if(categorie.getLibelleCategorie().trim() != null){
			throw new BLLException(2000,"Libellé vide");
		}
		if(DAOFactory.getDAO(new Categorie()).selectByString(categorie.getLibelleCategorie()).size() != 0 ){
			throw new BLLException(2001,"Cette catégorie existe déjà");
		}
		if(DAOFactory.getDAO(new Categorie()).selectById(categorie.getIdCategorie()).size() == 0){
			DAOFactory.getDAO(new Categorie()).insert(categorie);
		}
		else {
			DAOFactory.getDAO(new Categorie()).update(categorie);
		}	
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}


}
