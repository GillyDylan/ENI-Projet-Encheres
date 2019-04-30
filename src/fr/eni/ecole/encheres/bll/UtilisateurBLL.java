package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.hibernate.UtilisateurDAOHibernate;

public class UtilisateurBLL implements BLL{

	@Override
	public Utilisateur get(int id) throws DALException {
		// TODO Auto-generated method stub
		return (Utilisateur) DAOFactory.getDAO(new Utilisateur()).selectById(id).get(0);
	}
	
	@Override
	public Utilisateur get(String pseudo) throws DALException {
		// TODO Auto-generated method stub
		return (Utilisateur) ((UtilisateurDAOHibernate) DAOFactory.getDAO(new Utilisateur())).selectByPseudo(pseudo).get(0);
	}

	@Override
	public List get() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Utilisateur()).selectAll();
	}

	@Override
	public void set(Object utilisateur) throws BLLException, DALException {
		// TODO Auto-generated method stub
		Utilisateur u = (Utilisateur) utilisateur;
		boolean erreur = false;
		if(((UtilisateurDAOHibernate) DAOFactory.getDAO(new Utilisateur())).selectByPseudo(u.getPseudonymeUtilisateur())!=null) {
			throw new BLLException("Ce pseudonyme est déjà utilisé");
		}
		if(((UtilisateurDAOHibernate) DAOFactory.getDAO(new Utilisateur())).selectByMail(u.getPseudonymeUtilisateur())!=null) {
			throw new BLLException("Cet E-Mail est déjà utilisé");
		}
		if(erreur == false)
		{
			if(DAOFactory.getDAO(new Utilisateur()).selectById(u.getIdUtilisateur())!=null) {
				DAOFactory.getDAO(new Utilisateur()).insert(u);
			}else {
				DAOFactory.getDAO(new Utilisateur()).update(u);
			}
		}	
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		DAOFactory.getDAO(new Utilisateur()).delete(id);
	}


}
