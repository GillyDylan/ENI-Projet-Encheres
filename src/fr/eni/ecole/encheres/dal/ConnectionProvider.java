package fr.eni.ecole.encheres.dal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class ConnectionProvider {

	public static Session session;

	static {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}

	public static Session getConnection() {
		return ConnectionProvider.session;
	}
}
