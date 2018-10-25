package fr.ul.miage.bibliotheque.dao;

import java.util.List;

import org.hibernate.Session;

import fr.ul.miage.bibliotheque.entite.Emprunt;
import fr.ul.miage.bibliotheque.util.HibernateUtil;

public class EmpruntDao extends Dao<Emprunt> {

	private static EmpruntDao empruntDao;

	public EmpruntDao() {
		super(Emprunt.class);
	}

	public static EmpruntDao getInstance() {
		if (empruntDao == null) {
			empruntDao = new EmpruntDao();
		}
		return empruntDao;
	}

	public List<Emprunt> findAllEmpruntNonRendu() {
		List<Emprunt> res = null;
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
			res = session.createQuery("FROM Emprunt E WHERE E.empruntRendu = 0").list();
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		return res;
	}
}
