package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class UtilisateurBLL implements BLL{

	@Override
	public Utilisateur get(int id) throws DALException {
		// TODO Auto-generated method stub
		return (Utilisateur) DAOFactory.getDAO(new Utilisateur()).selectById(id);
	}

	@Override
	public List get() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Utilisateur()).selectAll();
	}

	@Override
	public void set(Object utilisateur) throws BLLException, DALException {
		// TODO Auto-generated method stub
		boolean erreur = false;
		if(erreur == false)
		{
			//if(DAOFactory.getDAO(new Utilisateur()).selectById(((Utilisateur) utilisateur).getIdUtilisateur())!=null) {
				DAOFactory.getDAO(new Utilisateur()).insert(utilisateur);
			//}else {
			//	DAOFactory.getDAO(new Utilisateur()).update(utilisateur);
			//}
		}
		
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		DAOFactory.getDAO(new Utilisateur()).delete(id);
	}


}
