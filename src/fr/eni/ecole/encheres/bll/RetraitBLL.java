package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class RetraitBLL implements BLL<Retrait>{

	@Override
	public Retrait get(int...idRetrait) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Retrait()).selectById(idRetrait[0]).get(0);
	}

	@Override
	public List<Retrait> getList(String chaine) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Retrait()).selectByString(chaine);
	}

	@Override
	public List<Retrait> getList() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Retrait()).selectAll();
	}

	@Override
	public void set(Retrait retrait) throws BLLException, DALException {
		// TODO Auto-generated method stub
		if(DAOFactory.getDAO(new Retrait()).selectById(retrait.getIdRetrait()).size() == 0){
			DAOFactory.getDAO(new Retrait()).insert(retrait);
		}
		else {
			DAOFactory.getDAO(new Retrait()).update(retrait);
		}	
	}

	@Override
	public void delete(Retrait retrait) throws DALException, BLLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Retrait get(String s) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Retrait> getList(int... ids) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}


	
}
