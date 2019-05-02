package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class CategorieBLL implements BLL<Categorie>{

	@Override
	public Categorie get(int...idCategorie) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Categorie()).selectById(idCategorie[0]).get(0);
	}

	public List<Categorie> get(String nom) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Categorie()).selectByString(nom);
	}

	public List<Categorie> get() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Categorie()).selectAll();
	}

	public void set(Categorie categorie) throws BLLException, DALException {
		// TODO Auto-generated method stub
		if(DAOFactory.getDAO(new Categorie()).selectById(categorie.getIdCategorie())!=null){
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
