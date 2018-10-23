package fr.ul.miage.bibliotheque.dao;

import fr.ul.miage.bibliotheque.entite.Emprunt;

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
}
