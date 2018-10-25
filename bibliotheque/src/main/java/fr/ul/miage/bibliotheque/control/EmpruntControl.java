package fr.ul.miage.bibliotheque.control;

import java.util.Date;
import java.util.GregorianCalendar;

import fr.ul.miage.bibliotheque.dao.EmpruntDao;
import fr.ul.miage.bibliotheque.dao.ExemplaireDao;
import fr.ul.miage.bibliotheque.dao.OeuvreDao;
import fr.ul.miage.bibliotheque.dao.UsagerDao;
import fr.ul.miage.bibliotheque.entite.Emprunt;
import fr.ul.miage.bibliotheque.entite.Exemplaire;
import fr.ul.miage.bibliotheque.entite.Oeuvre;
import fr.ul.miage.bibliotheque.entite.Usager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

public class EmpruntControl {

	private ObservableSet<Emprunt> listeEmprunt;

	private Usager usagerTemp;

	private Oeuvre oeuvreTemp;

	private Exemplaire exemplaireTemp;

	public void retourEmprunt(Emprunt emprunt) {
		emprunt.setDateRendu(new Date());
		emprunt.setEmpruntRendu(1);
		EmpruntDao.getInstance().update(emprunt);
	}
	
	public ObservableList<Emprunt> getEmpruntNonRendu() {
		listeEmprunt = FXCollections.observableSet();
		listeEmprunt.addAll(EmpruntDao.getInstance().findAllEmpruntNonRendu());
		return FXCollections.observableArrayList(listeEmprunt);
	}

	public boolean rechercherEmprunt(String titreOeuvre, String nomUsager, String prenomUsager) {
		usagerTemp = UsagerDao.getInstance().find(nomUsager, prenomUsager);
		oeuvreTemp = OeuvreDao.getInstance().find(titreOeuvre);
		exemplaireTemp = ExemplaireDao.getInstance().findExemlaireDisponible(titreOeuvre);

		return usagerTemp != null && oeuvreTemp != null && exemplaireTemp != null;
	}

	public void creerEmprunt() {
		Date retour = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(retour);
		gc.add(GregorianCalendar.MONTH, 1);

		Emprunt emprunt = new Emprunt();
		emprunt.setDateEmprunt(new Date());
		emprunt.setDateRetour(gc.getTime());
		emprunt.setUsager(UsagerDao.getInstance().find(usagerTemp.getId()));
		emprunt.setExemplaire(ExemplaireDao.getInstance().find(exemplaireTemp.getId()));

		EmpruntDao.getInstance().create(emprunt);
	}

	public Usager getUsagerTemp() {
		return usagerTemp;
	}

	public void setUsagerTemp(Usager usagerTemp) {
		this.usagerTemp = usagerTemp;
	}

	public Oeuvre getOeuvreTemp() {
		return oeuvreTemp;
	}

	public void setOeuvreTemp(Oeuvre oeuvreTemp) {
		this.oeuvreTemp = oeuvreTemp;
	}

	public Exemplaire getExemplaireTemp() {
		return exemplaireTemp;
	}

	public void setExemplaireTemp(Exemplaire exemplaireTemp) {
		this.exemplaireTemp = exemplaireTemp;
	}

}
