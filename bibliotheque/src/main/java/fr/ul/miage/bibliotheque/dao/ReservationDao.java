package fr.ul.miage.bibliotheque.dao;

import fr.ul.miage.bibliotheque.entite.Reservation;

public class ReservationDao extends Dao<Reservation>{

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
	
}
