package fr.ul.miage.bibliotheque.dao;

import fr.ul.miage.bibliotheque.entite.Exemplaire;

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
}
