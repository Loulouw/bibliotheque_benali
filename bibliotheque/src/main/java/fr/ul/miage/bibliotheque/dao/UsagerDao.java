package fr.ul.miage.bibliotheque.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.ul.miage.bibliotheque.entite.Usager;
import fr.ul.miage.bibliotheque.util.HibernateUtil;

public class UsagerDao extends Dao<Usager> {

	private static UsagerDao usagerDao;

	private UsagerDao() {
		super(Usager.class);
	}

	public static UsagerDao getInstance() {
		if (usagerDao == null) {
			usagerDao = new UsagerDao();
		}
		return usagerDao;
	}

	public Usager find(String nom, String prenom) {
		Usager res = null;
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			Query query = session.createQuery("FROM Usager U WHERE U.nom LIKE :param1 AND U.prenom LIKE :param2");
			query.setParameter("param1", "%" + nom + "%");
			query.setParameter("param2", "%" + prenom + "%");
			List<Usager> list = query.list();
			if (!list.isEmpty()) {
				res = list.get(0);
			}
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		return res;
	}

}
