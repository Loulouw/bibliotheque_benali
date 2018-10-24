package fr.ul.miage.bibliotheque.control;

import java.util.Date;
import java.util.HashSet;
import fr.ul.miage.bibliotheque.dao.AuteurDao;
import fr.ul.miage.bibliotheque.dao.OeuvreDao;
import fr.ul.miage.bibliotheque.dao.TypeOeuvreDao;
import fr.ul.miage.bibliotheque.entite.Auteur;
import fr.ul.miage.bibliotheque.entite.Oeuvre;
import fr.ul.miage.bibliotheque.entite.TypeOeuvre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

public class OeuvreControl {

	private ObservableSet<Oeuvre> listeOeuvre;

	private ObservableList<Auteur> listeAuteur;

	private ObservableList<Auteur> listeAuteurDisponible;

	private ObservableList<TypeOeuvre> listeTypeOeuvre;

	private Oeuvre oeuvreEnCours = null;

	public void ajouterOeuvre(String titre, String isbn, ObservableList<Auteur> auteurs, TypeOeuvre typeOeuvre,
			Date dateCreation) {
		oeuvreEnCours = new Oeuvre(typeOeuvre, titre, isbn, new HashSet<>(auteurs), dateCreation);
		OeuvreDao.getInstance().create(oeuvreEnCours);
		listeOeuvre.add(oeuvreEnCours);
	}

	public void updateOeuvre(String titre, String isbn, ObservableList<Auteur> auteurs, TypeOeuvre typeOeuvre,
			Date dateCreation) {
		oeuvreEnCours.setTitre(titre);
		oeuvreEnCours.setIsbn(isbn);
		oeuvreEnCours.setAuteurs(new HashSet<>(auteurs));
		oeuvreEnCours.setTypeOeuvre(typeOeuvre);
		oeuvreEnCours.setDateCreation(dateCreation);
		OeuvreDao.getInstance().update(oeuvreEnCours);
	}

	public ObservableList<Oeuvre> getAllOeuvre() {
		listeOeuvre = FXCollections.observableSet();
		listeOeuvre.addAll(OeuvreDao.getInstance().findAll());
		return FXCollections.observableArrayList(listeOeuvre);
	}

	public ObservableList<Auteur> getAuteursDisponible() {
		listeAuteurDisponible = FXCollections.observableArrayList(AuteurDao.getInstance().findAll());
		if (oeuvreEnCours != null) {
			listeAuteurDisponible.removeAll(oeuvreEnCours.getAuteurs());
		}
		return listeAuteurDisponible;
	}

	public ObservableList<Auteur> getAuteurs() {
		listeAuteur = FXCollections.observableArrayList();
		if (oeuvreEnCours != null) {
			listeAuteur.addAll(oeuvreEnCours.getAuteurs());
		}
		return listeAuteur;
	}

	public ObservableList<TypeOeuvre> getTypeOeuvre() {
		listeTypeOeuvre = FXCollections.observableArrayList(TypeOeuvreDao.getInstance().findAll());
		return listeTypeOeuvre;
	}

	public void addAuteur(Auteur auteur) {
		listeAuteur.add(auteur);
		listeAuteurDisponible.remove(auteur);
	}

	public void removeAuteur(Auteur auteur) {
		listeAuteur.remove(auteur);
		listeAuteurDisponible.add(auteur);
	}

	public Oeuvre getOeuvreEnCours() {
		return oeuvreEnCours;
	}

	public void setOeuvreEnCours(Oeuvre oeuvreEnCours) {
		this.oeuvreEnCours = oeuvreEnCours;
	}

	public TypeOeuvre getTypeOeuvreActuel() {
		if (oeuvreEnCours == null) {
			return listeTypeOeuvre.get(0);
		} else {
			return oeuvreEnCours.getTypeOeuvre();
		}
	}

}
