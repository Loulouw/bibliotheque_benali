package fr.ul.miage.bibliotheque.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.service.ServiceRegistry;

public final class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	private HibernateUtil() {
	    throw new IllegalStateException("Utility class");
	  }
	
	public static synchronized void buildSessionFactory() {
		if (sessionFactory == null) {
			// loads configuration and mappings
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			// builds a session factory from the service registry
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
	}

	public static void openSessionAndBindToThread() {
		if (sessionFactory == null) {
			buildSessionFactory();
		}
		Session session = sessionFactory.openSession();
		ThreadLocalSessionContext.bind(session);
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			buildSessionFactory();
		}
		return sessionFactory;
	}

	public static void closeSessionAndUnbindFromThread() {
		Session session = ThreadLocalSessionContext.unbind(sessionFactory);
		if (session != null) {
			session.close();
		}
	}

	public static void closeSessionFactory() {
		if ((sessionFactory != null) && !sessionFactory.isClosed()) {
			sessionFactory.close();
		}
	}
}