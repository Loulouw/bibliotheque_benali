package fr.ul.miage.bibliotheque.control;

import java.time.LocalDate;

import fr.ul.miage.bibliotheque.dao.UsagerDao;
import fr.ul.miage.bibliotheque.entite.Usager;
import fr.ul.miage.bibliotheque.util.Utils;

public class UsagerControl {

	public static boolean ajouterUsager(String prenom, String nom, String commune, LocalDate dateNaissance) {
		boolean res = true;
		try {
			Usager usager = new Usager(prenom, nom, commune, Utils.localDateToDate(dateNaissance));
			UsagerDao.getInstance().create(usager);
		} catch (RuntimeException re) {
			res = false;
		}
		return res;
	}

}
