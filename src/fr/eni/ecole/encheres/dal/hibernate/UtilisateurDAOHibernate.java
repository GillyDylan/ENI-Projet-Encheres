package fr.eni.ecole.encheres.dal.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class UtilisateurDAOHibernate implements DAO<Utilisateur>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> selectById(int...idUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		int compteur = 0 ;
		Session session = ConnectionProvider.session;
		StringBuilder requeteBuilder = new StringBuilder();
		requeteBuilder.append("FROM Utilisateur WHERE");
		for(int id : idUtilisateur) {
			if(compteur != 0) {
				requeteBuilder.append(" OR");
			}
			requeteBuilder.append(" idUtilisateur = " + id);
			compteur++;
		}
		Query q = session.createQuery(requeteBuilder.toString());
		List<Utilisateur> utilisateurs = q.getResultList();
		return utilisateurs;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> selectAll() throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Utilisateur");
		List<Utilisateur> utilisateurs = q.getResultList();
		return utilisateurs;
	}

	@Override
	public void insert(Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.save(utilisateur);
		session.getTransaction().commit();
	}

	@Override
	public void update(Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.saveOrUpdate(utilisateur);
		session.getTransaction().commit();	
	}

	@Override
	public void delete(Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.delete(utilisateur);
		session.getTransaction().commit();
		
	}



}
