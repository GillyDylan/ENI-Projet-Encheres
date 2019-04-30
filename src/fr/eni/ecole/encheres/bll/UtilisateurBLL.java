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
		return (Utilisateur) ((UtilisateurDAOHibernate) DAOFactory.getDAO(new Utilisateur())).selectById(id).get(0);
	}
	
	@Override
	public Utilisateur get(String chaine) throws DALException {
		// TODO Auto-generated method stub
		return (Utilisateur) ((UtilisateurDAOHibernate) DAOFactory.getDAO(new Utilisateur())).selectByChaine(chaine).get(0);
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

		if(u.getTelephoneUtilisateur() < 100000000l || u.getTelephoneUtilisateur() > 9999999999l) {
			throw new BLLException("Téléphone invalide");
		}
		if(u.getCodePostalUtilisateur() < 1000 || u.getCodePostalUtilisateur() > 99999) {
			throw new BLLException("Code postal invalide");
		}
		if(((UtilisateurDAOHibernate) DAOFactory.getDAO(new Utilisateur())).selectById(u.getIdUtilisateur())!=null) {
			if(!u.getPseudonymeUtilisateur().equals("^[a-zA-Z0-9_]*$")) {
				throw new BLLException("Le pseudonyme doit contenir uniquement des caractères alphanumériques");
			}
			if(((UtilisateurDAOHibernate) DAOFactory.getDAO(new Utilisateur())).selectByChaine(u.getPseudonymeUtilisateur())!=null) {
				throw new BLLException("Ce pseudonyme est déjà utilisé");
			}
			if(((UtilisateurDAOHibernate) DAOFactory.getDAO(new Utilisateur())).selectByChaine(u.getPseudonymeUtilisateur())!=null) {
				throw new BLLException("Cet E-Mail est déjà utilisé");
			}
			DAOFactory.getDAO(new Utilisateur()).insert(u);
		}else {
			DAOFactory.getDAO(new Utilisateur()).update(u);
		}
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		DAOFactory.getDAO(new Utilisateur()).delete(id);
	}


}
