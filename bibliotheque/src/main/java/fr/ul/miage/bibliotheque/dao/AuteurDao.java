package fr.ul.miage.bibliotheque.dao;

import fr.ul.miage.bibliotheque.entite.Auteur;

public class AuteurDao extends Dao<Auteur> {

	private static AuteurDao auteurDao;

	public AuteurDao() {
		super(Auteur.class);
	}

	public static AuteurDao getInstance() {
		if (auteurDao == null) {
			auteurDao = new AuteurDao();
		}
		return auteurDao;
	}
}
