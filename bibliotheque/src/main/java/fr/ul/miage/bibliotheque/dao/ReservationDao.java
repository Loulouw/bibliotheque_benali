package fr.ul.miage.bibliotheque.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import fr.ul.miage.bibliotheque.entite.Reservation;
import fr.ul.miage.bibliotheque.util.HibernateUtil;

public class ReservationDao extends Dao<Reservation> {

	private static ReservationDao reservationDao;

	public ReservationDao() {
		super(Reservation.class);
	}

	public static ReservationDao getInstance() {
		if (reservationDao == null) {
			reservationDao = new ReservationDao();
		}
		return reservationDao;
	}

	public List<Reservation> findAllReservationNonAnnule() {
		List<Reservation> res = new ArrayList<>();
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			res.addAll(session.createQuery("FROM Reservation R WHERE R.reservationAnnule = 0").list());
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		return res;
	}

	public Reservation findReservation(int idUsager, int idOeuvre) {
		Reservation res = null;
		try {
			HibernateUtil.openSessionAndBindToThread();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			List<Reservation> temp = session
					.createQuery("FROM Reservation R WHERE R.reservationAnnule = 0 AND R.usager.id = " + idUsager
							+ " AND R.oeuvre.id = " + idOeuvre)
					.list();
			if (!temp.isEmpty())
				res = temp.get(0);
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}
		return res;
	}

}
