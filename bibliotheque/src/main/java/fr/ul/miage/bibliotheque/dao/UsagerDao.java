package fr.ul.miage.bibliotheque.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.ul.miage.bibliotheque.entite.Usager;
import fr.ul.miage.bibliotheque.util.HibernateUtil;

public class UsagerDao {
	
	private static UsagerDao usagerDao;
	
	public static UsagerDao getInstance() {
		if(usagerDao == null) {
			usagerDao = new UsagerDao();
		}
		return usagerDao;
	}
	
	public void create(Usager usager) {
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			
			session.save(usager);
			
			tx.commit();
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
	}
	
	
}
