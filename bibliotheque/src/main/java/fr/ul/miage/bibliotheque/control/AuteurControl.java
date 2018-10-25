package fr.ul.miage.bibliotheque.control;

import fr.ul.miage.bibliotheque.dao.AuteurDao;
import fr.ul.miage.bibliotheque.entite.Auteur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AuteurControl {
	private ObservableList<Auteur> listeAuteur;

	private Auteur auteurEnCours = null;

	public boolean ajouterAuteur(String prenom, String nom) {
		boolean res = true;
		try {
			auteurEnCours = new Auteur(prenom, nom);
			AuteurDao.getInstance().create(auteurEnCours);
			listeAuteur.add(auteurEnCours);
		} catch (RuntimeException re) {
			res = false;
		}
		return res;
	}

	public void updateAuteur(String prenom, String nom) {
		auteurEnCours.setPrenom(prenom);
		auteurEnCours.setNom(nom);
		AuteurDao.getInstance().update(auteurEnCours);
	}

	public ObservableList<Auteur> getAllAuteur() {
		listeAuteur = FXCollections.observableArrayList(AuteurDao.getInstance().findAll());
		return listeAuteur;
	}

	public Auteur getAuteurEnCours() {
		return auteurEnCours;
	}

	public void setAuteurEnCours(Auteur auteurEnCours) {
		this.auteurEnCours = auteurEnCours;
	}
}
