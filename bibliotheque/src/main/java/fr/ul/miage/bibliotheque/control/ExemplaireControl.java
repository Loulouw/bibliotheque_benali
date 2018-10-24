package fr.ul.miage.bibliotheque.control;

import fr.ul.miage.bibliotheque.dao.EtatDao;
import fr.ul.miage.bibliotheque.dao.ExemplaireDao;
import fr.ul.miage.bibliotheque.dao.OeuvreDao;
import fr.ul.miage.bibliotheque.entite.Exemplaire;
import fr.ul.miage.bibliotheque.entite.Oeuvre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

public class ExemplaireControl {

	private ObservableSet<Oeuvre> listeOeuvre;

	private ObservableList<Exemplaire> listeExemplaire;

	private Oeuvre oeuvreEnCours = null;

	public ObservableList<Oeuvre> getListeOeuvre() {
		listeOeuvre = FXCollections.observableSet();
		listeOeuvre.addAll(OeuvreDao.getInstance().findAll());
		return FXCollections.observableArrayList(listeOeuvre);
	}

	public ObservableList<Exemplaire> getListeExemplaire() {
		listeExemplaire = FXCollections.observableArrayList();
		if (oeuvreEnCours != null) {
			listeExemplaire.addAll(oeuvreEnCours.getExemplaires());
		}
		return listeExemplaire;
	}

	public Oeuvre getOeuvreEnCours() {
		return oeuvreEnCours;
	}

	public void setOeuvreEnCours(Oeuvre oeuvreEnCours) {
		this.oeuvreEnCours = oeuvreEnCours;
	}

	public void ajouterExemplaire() {
		Exemplaire exemplaire = new Exemplaire(EtatDao.getInstance().find(1),
				OeuvreDao.getInstance().find(oeuvreEnCours.getId()));
		ExemplaireDao.getInstance().create(exemplaire);
		listeExemplaire.add(exemplaire);
	}
}
