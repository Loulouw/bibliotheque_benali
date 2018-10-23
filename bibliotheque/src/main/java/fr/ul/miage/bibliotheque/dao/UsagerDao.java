package fr.ul.miage.bibliotheque.dao;

import fr.ul.miage.bibliotheque.entite.Usager;

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

}
