package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class EnchereBLL implements BLL<Enchere>{

	@Override
	public Enchere get(int...idsEncheres) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Enchere()).selectById(idsEncheres[0],idsEncheres[1]).get(0);
	}

	@Override
	public Object get(String s) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> get() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Enchere()).selectAll();
	}


	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(Enchere enchere) throws BLLException, DALException {
		// TODO Auto-generated method stub
		if(DAOFactory.getDAO(new Enchere()).selectById(enchere.getUtilisateur().getIdUtilisateur(), enchere.getArticle().getIdArticle())!=null){
			DAOFactory.getDAO(new Enchere()).insert(enchere);
		}
		else {
			DAOFactory.getDAO(new Enchere()).update(enchere);
		}	
	}

}
