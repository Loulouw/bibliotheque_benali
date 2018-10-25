package fr.ul.miage.bibliotheque.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.ul.miage.bibliotheque.entite.Exemplaire;
import fr.ul.miage.bibliotheque.util.HibernateUtil;

public class ExemplaireDao extends Dao<Exemplaire> {

	private static ExemplaireDao exemplaireDao;

	public ExemplaireDao() {
		super(Exemplaire.class);
	}

	public static ExemplaireDao getInstance() {
		if (exemplaireDao == null) {
			exemplaireDao = new ExemplaireDao();
		}
		return exemplaireDao;
	}

	public Exemplaire findExemlaireDisponible(String titreOeuvre) {
		Exemplaire res = null;
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			Query queryGenerale = session
					.createQuery("SELECT E FROM Exemplaire E inner join E.oeuvre O " + "WHERE O.titre = :param1");
			queryGenerale.setParameter("param1", titreOeuvre);

			List<Exemplaire> exemplaireOeuvre = queryGenerale.list();

			Query querySecondaire = session
					.createQuery("SELECT E FROM Exemplaire E inner join E.oeuvre O inner join E.emprunts P "
							+ "WHERE O.titre = :param1 AND P.empruntRendu = 0");
			querySecondaire.setParameter("param1", titreOeuvre);
			List<Exemplaire> exemplaireEmprunter = querySecondaire.list();

			exemplaireOeuvre.removeAll(exemplaireEmprunter);
			if (!exemplaireOeuvre.isEmpty()) {
				res = exemplaireOeuvre.get(0);
			}

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		return res;
	}
}
