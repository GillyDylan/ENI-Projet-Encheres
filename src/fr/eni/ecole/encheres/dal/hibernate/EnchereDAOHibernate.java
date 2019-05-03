package fr.eni.ecole.encheres.dal.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class EnchereDAOHibernate implements DAO<Enchere>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Enchere> selectById(int...idsEnchere) throws DALException {
		System.out.println(idsEnchere[1]);
		Session session = ConnectionProvider.session;
		Query q;
		if(idsEnchere[1] != 0)
		{
			q = session.createQuery("FROM Enchere WHERE idArticle = "+idsEnchere[0]+" AND idUtilisateur = "+idsEnchere[1]+" ORDER BY dateEnchere DESC");
		}
		else {
			q = session.createQuery("FROM Enchere WHERE idArticle = "+idsEnchere[0]+" ORDER BY dateEnchere DESC");
		}
		List<Enchere> encheres = q.getResultList();
		return encheres;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Enchere> selectAll() throws DALException {
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Enchere");
		List<Enchere> encheres = q.getResultList();
		return encheres;
	}

	@Override
	public void insert(Enchere enchere) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.save(enchere);
		session.getTransaction().commit();
	}

	@Override
	public void update(Enchere enchere) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.saveOrUpdate(enchere);
		session.getTransaction().commit();	
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enchere> selectByString(String string) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
