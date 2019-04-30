package fr.eni.ecole.encheres.dal.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class UtilisateurDAOHibernate implements DAO<Utilisateur>{


	public List<Utilisateur> selectById(int id) throws DALException {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Utilisateur WHERE id = "+id);
		List<Utilisateur> utilisateurs = q.getResultList();
		return utilisateurs;
	}
	
	
	public List<Utilisateur> selectByChaine(String chaine) throws DALException {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Utilisateur WHERE pseudonymeUtilisateur = '"+chaine+"' OR eMailUtilisateur = '"+chaine+"'");
		List<Utilisateur> utilisateurs = q.getResultList();
		return utilisateurs;
	}
	
	public List<Utilisateur> selectByMail(String mail) throws DALException {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Utilisateur WHERE eMailUtilisateur = '"+mail+"'");
		List<Utilisateur> utilisateurs = q.getResultList();
		return utilisateurs;
	}

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
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		Utilisateur utilisateur = (Utilisateur) session.get(Utilisateur.class, id);
		session.beginTransaction();
		session.delete(utilisateur);
		session.getTransaction().commit();
		
	}

}
