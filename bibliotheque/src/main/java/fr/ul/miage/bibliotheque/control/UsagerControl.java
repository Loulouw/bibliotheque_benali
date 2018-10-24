package fr.ul.miage.bibliotheque.control;

import java.time.LocalDate;

import fr.ul.miage.bibliotheque.dao.UsagerDao;
import fr.ul.miage.bibliotheque.entite.Usager;
import fr.ul.miage.bibliotheque.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UsagerControl {

	private ObservableList<Usager> listeUsager;

	private Usager usagerEnCours = null;
	
	public boolean ajouterUsager(String prenom, String nom, String commune, LocalDate dateNaissance) {
		boolean res = true;
		try {
			usagerEnCours = new Usager(prenom, nom, commune, Utils.localDateToDate(dateNaissance));
			UsagerDao.getInstance().create(usagerEnCours);
			listeUsager.add(usagerEnCours);
		} catch (RuntimeException re) {
			res = false;
		}
		return res;
	}
	
	public void updateUsager(String prenom, String nom, String commune, LocalDate dateNaissance) {
		usagerEnCours.setPrenom(prenom);
		usagerEnCours.setNom(nom);
		usagerEnCours.setCommune(commune);
		usagerEnCours.setDateNaissance(Utils.localDateToDate(dateNaissance));
		UsagerDao.getInstance().update(usagerEnCours);
	}

	public ObservableList<Usager> getAllUsager() {
		listeUsager = FXCollections.observableArrayList(UsagerDao.getInstance().findAll());
		return listeUsager;
	}

	public Usager getUsagerEnCours() {
		return usagerEnCours;
	}

	public void setUsagerEnCours(Usager usagerEnCours) {
		this.usagerEnCours = usagerEnCours;
	}

}
