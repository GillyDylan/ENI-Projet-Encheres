package fr.eni.ecole.encheres.dal.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class RetraitDAOHibernate implements DAO<Retrait>{

	@SuppressWarnings("unchecked")
	public List<Retrait> selectById(int...idRetrait) throws DALException {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Retrait WHERE idRetrait = "+idRetrait[0]);
		List<Retrait> retraits = q.getResultList();
		return retraits;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Retrait> selectByString(String chaine) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Retrait WHERE adresseRetrait LIKE '%"+chaine+"%' OR '%"+chaine+"%'");
		List<Retrait> retraits = q.getResultList();
		return retraits;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Retrait> selectAll() throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Retrait");
		List<Retrait> retraits = q.getResultList();
		return retraits;
	}

	@Override
	public void insert(Retrait retrait) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.save(retrait);
		session.getTransaction().commit();
	}

	@Override
	public void update(Retrait retrait) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.saveOrUpdate(retrait);
		session.getTransaction().commit();
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}


}
