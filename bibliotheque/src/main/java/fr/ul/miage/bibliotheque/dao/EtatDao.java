package fr.ul.miage.bibliotheque.dao;

import fr.ul.miage.bibliotheque.entite.Etat;

public class EtatDao extends Dao<Etat>{

	private static EtatDao etatDao;
	
	public EtatDao() {
		super(Etat.class);
	}
	
	public static EtatDao getInstance() {
		if (etatDao == null) {
			etatDao = new EtatDao();
		}
		return etatDao;
	}
}
