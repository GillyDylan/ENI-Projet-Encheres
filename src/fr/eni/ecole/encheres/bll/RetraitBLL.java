package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.hibernate.RetraitDAOHibernate;

public class RetraitBLL implements BLL{

	@Override
	public Retrait get(int idRetrait) throws DALException {
		// TODO Auto-generated method stub
		return (Retrait)((RetraitDAOHibernate) DAOFactory.getDAO(new Categorie())).selectById(idRetrait).get(0);
	}

	@Override
	public List get(String chaine) throws DALException {
		// TODO Auto-generated method stub
		return ((RetraitDAOHibernate) DAOFactory.getDAO(new Categorie())).selectByString(chaine);
	}

	@Override
	public List get() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Categorie()).selectAll();
	}

	@Override
	public void set(Object retrait) throws BLLException, DALException {
		// TODO Auto-generated method stub
		Retrait r = (Retrait) retrait;
		if(((RetraitDAOHibernate) DAOFactory.getDAO(new Retrait())).selectById(r.getIdRetrait())!=null){
			DAOFactory.getDAO(new Retrait()).insert(r);
		}
		else {
			DAOFactory.getDAO(new Retrait()).update(r);
		}	
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}
	
}
