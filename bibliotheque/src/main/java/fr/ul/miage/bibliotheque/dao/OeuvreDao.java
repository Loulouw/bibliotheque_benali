package fr.ul.miage.bibliotheque.dao;

import fr.ul.miage.bibliotheque.entite.Oeuvre;

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

}
