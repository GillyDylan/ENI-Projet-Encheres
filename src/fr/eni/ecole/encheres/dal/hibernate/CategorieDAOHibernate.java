package fr.eni.ecole.encheres.dal.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.ConnectionProvider;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAO;

public class CategorieDAOHibernate implements DAO<Categorie>{


	public List<Categorie> selectById(int idCategorie) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Categorie WHERE idCategorie = "+idCategorie);
		List<Categorie> categories = q.getResultList();
		if(categories.size() != 0) {
			return categories;
		}else {
			throw new DALException("Aucune cat�gorie trouv�e");
		}
	}
	
	public List<Categorie> selectByString(String chaine) throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Categorie WHERE libelleCategorie = "+chaine);
		List<Categorie> categories = q.getResultList();
		if(categories.size() != 0) {
			return categories;
		}else {
			throw new DALException("Aucune cat�gorie trouv�e");
		}
	}

	@Override
	public List<Categorie> selectAll() throws DALException {
		// TODO Auto-generated method stub
		Session session = ConnectionProvider.session;
		Query q = session.createQuery("FROM Categorie");
		List<Categorie> categories = q.getResultList();
		if(categories.size() != 0) {
			return categories;
		}else {
			throw new DALException("Aucune cat�gorie trouv�e");
		}
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
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
