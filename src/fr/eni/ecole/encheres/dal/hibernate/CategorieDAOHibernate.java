package fr.eni.ecole.encheres.dal.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class CategorieDAOHibernate implements DAO<Categorie>{

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> selectById(int...idCategorie) throws DALException {
		// TODO Auto-generated method stub
		int compteur = 0 ;
		Session session = ConnectionProvider.session;
		StringBuilder requeteBuilder = new StringBuilder();
		requeteBuilder.append("FROM Categorie WHERE");
		for(int id : idCategorie) {
			if(compteur != 0) {
				requeteBuilder.append(" OR");
			}
			requeteBuilder.append(" idCategorie = " + id);
			compteur++;
		}
		Query q = session.createQuery(requeteBuilder.toString());
		List<Categorie> categories = q.getResultList();
		return categories;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> selectAll() throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Categorie");
		List<Categorie> categories = q.getResultList();
		return categories;
	}

	@Override
	public void insert(Categorie categorie) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.save(categorie);
		session.getTransaction().commit();
	}

	@Override
	public void update(Categorie categorie) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		session.beginTransaction();
		session.saveOrUpdate(categorie);
		session.getTransaction().commit();
		
	}

	@Override
	public void delete(Categorie categorie) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
