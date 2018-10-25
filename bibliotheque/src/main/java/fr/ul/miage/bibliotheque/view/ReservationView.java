package fr.ul.miage.bibliotheque.view;

import java.util.Optional;

import fr.ul.miage.bibliotheque.control.ReservationControl;
import fr.ul.miage.bibliotheque.entite.Reservation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ReservationView implements View {

	ReservationControl reservationControl;

	@Override
	public Pane getPane() {
		reservationControl = new ReservationControl();

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		final ListView<Reservation> list = new ListView<>();
		list.setItems(reservationControl.getListeReservation());
		list.setOnMouseClicked(event -> {
			Reservation reservation = list.getSelectionModel().getSelectedItem();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Confirmer l'annulation de la réservation ?");
			Optional<ButtonType> option = alert.showAndWait();
			if (option.get() == ButtonType.OK && reservation != null) {
				reservationControl.annulerReservation(reservation);
				list.setItems(reservationControl.getListeReservation());
				list.refresh();
			}

		});

		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(25, 25, 25, 25));

		final Text titreOeuvrel = new Text("Titre Oeuvre");
		final TextField titreOeuvre = new TextField();
		final Text nomUtilisateurl = new Text("Nom Utilisateur");
		final TextField nomUtilisateur = new TextField();
		final Text prenomUtilisateurl = new Text("Prénom Utilisateur");
		final TextField prenomUtilisateur = new TextField();

		final Button reserver = new Button("Reserver l'oeuvre");
		reserver.setPrefHeight(40);
		reserver.setPrefWidth(300);
		reserver.setOnAction(event -> {
			boolean trouve = reservationControl.rechercherReservation(titreOeuvre.getText(), nomUtilisateur.getText(),
					prenomUtilisateur.getText());
			if (trouve) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText("Voulez vous valider la reservation ?");
				alert.setContentText("Ouvrage : " + reservationControl.getOeuvreTemp().getTitre() + " | Usager : "
						+ reservationControl.getUsagerTemp().getNom() + " "
						+ reservationControl.getUsagerTemp().getPrenom());
				Optional<ButtonType> option = alert.showAndWait();
				if (option.get() != null && option.get() == ButtonType.OK) {
					reservationControl.creerReservation();
					list.setItems(reservationControl.getListeReservation());
					list.refresh();
				}
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setContentText("Aucun usager, oeuvre trouvé");
				alert.showAndWait();
			}
		});

		gp.add(titreOeuvrel, 0, 0);
		gp.add(titreOeuvre, 1, 0);
		gp.add(nomUtilisateurl, 0, 1);
		gp.add(nomUtilisateur, 1, 1);
		gp.add(prenomUtilisateurl, 0, 2);
		gp.add(prenomUtilisateur, 1, 2);
		gp.add(reserver, 0, 3, 2, 1);

		hbox.getChildren().addAll(list, gp);
		return hbox;
	}

}
