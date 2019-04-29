package fr.eni.ecole.encheres.dal.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class UtilisateurDAOHibernate implements DAO<Utilisateur>{

	@Override
	public List<Utilisateur> selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("SELECT * FROM Utilisateur WHERE id = ");
		List<Utilisateur> utilisateurs = q.getResultList();
		return utilisateurs;
	}

	@Override
	public List<Utilisateur> selectAll() throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("SELECT * FROM Utilisateur");
		List<Utilisateur> utilisateurs = q.getResultList();
		return utilisateurs;
	}

	@Override
	public void insert(Utilisateur t) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}

	@Override
	public void update(Utilisateur t) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.saveOrUpdate(t);
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
