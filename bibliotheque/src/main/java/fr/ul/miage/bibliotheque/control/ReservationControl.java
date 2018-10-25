package fr.ul.miage.bibliotheque.control;

import java.util.Date;
import java.util.GregorianCalendar;

import fr.ul.miage.bibliotheque.dao.EmpruntDao;
import fr.ul.miage.bibliotheque.dao.ExemplaireDao;
import fr.ul.miage.bibliotheque.dao.OeuvreDao;
import fr.ul.miage.bibliotheque.dao.ReservationDao;
import fr.ul.miage.bibliotheque.dao.UsagerDao;
import fr.ul.miage.bibliotheque.entite.Emprunt;
import fr.ul.miage.bibliotheque.entite.Oeuvre;
import fr.ul.miage.bibliotheque.entite.Reservation;
import fr.ul.miage.bibliotheque.entite.Usager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

public class ReservationControl {

	private ObservableSet<Reservation> listeReservation;
	
	private Usager usagerTemp;

	private Oeuvre oeuvreTemp;

	public ObservableList<Reservation> getListeReservation() {
		listeReservation = FXCollections.observableSet();
		listeReservation.addAll(ReservationDao.getInstance().findAllReservationNonAnnule());
		return FXCollections.observableArrayList(listeReservation);
	}

	public boolean rechercherReservation(String titreOeuvre, String nomUsager, String prenomUsager) {
		usagerTemp = UsagerDao.getInstance().find(nomUsager, prenomUsager);
		oeuvreTemp = OeuvreDao.getInstance().find(titreOeuvre);

		return usagerTemp != null && oeuvreTemp != null;
	}

	public void creerReservation() {
		Reservation reservation = new Reservation();
		reservation.setDateReservation(new Date());
		reservation.setOeuvre(OeuvreDao.getInstance().find(oeuvreTemp.getId()));
		reservation.setUsager(UsagerDao.getInstance().find(usagerTemp.getId()));
		reservation.setReservationAnnule(0);

		ReservationDao.getInstance().create(reservation);
	}
	
	public void annulerReservation(Reservation reservation) {
		reservation.setReservationAnnule(1);
		ReservationDao.getInstance().update(reservation);
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
	
	

}
