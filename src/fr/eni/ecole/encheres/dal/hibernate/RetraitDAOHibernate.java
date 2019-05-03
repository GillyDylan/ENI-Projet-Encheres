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
	@Override
	public List<Retrait> selectById(int...idRetrait) throws DALException {
		// TODO Auto-generated method stub
		int compteur = 0 ;
		Session session = ConnectionProvider.session;
		StringBuilder requeteBuilder = new StringBuilder();
		requeteBuilder.append("FROM Retrait WHERE");
		for(int id : idRetrait) {
			if(compteur != 0) {
				requeteBuilder.append(" OR");
			}
			requeteBuilder.append(" idRetrait = " + id);
			compteur++;
		}
		Query q = session.createQuery(requeteBuilder.toString());
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
	public void delete(Retrait retrait) throws DALException {
		// TODO Auto-generated method stub
		
	}


}
