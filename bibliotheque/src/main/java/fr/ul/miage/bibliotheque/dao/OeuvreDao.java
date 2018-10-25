package fr.ul.miage.bibliotheque.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.ul.miage.bibliotheque.entite.Oeuvre;
import fr.ul.miage.bibliotheque.util.HibernateUtil;

public class OeuvreDao extends Dao<Oeuvre> {

	private static OeuvreDao oeuvreDao;

	public OeuvreDao() {
		super(Oeuvre.class);
	}

	public static OeuvreDao getInstance() {
		if (oeuvreDao == null) {
			oeuvreDao = new OeuvreDao();
		}
		return oeuvreDao;
	}

	public Oeuvre find(String titre) {
		Oeuvre res = null;
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			Query query = session.createQuery("FROM Oeuvre U WHERE U.titre LIKE :param1");
			query.setParameter("param1", "%" + titre + "%");
			List<Oeuvre> list = query.list();
			if (!list.isEmpty()) {
				res = list.get(0);
			}
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		return res;
	}

}
