package fr.ul.miage.bibliotheque.view;

import java.util.Optional;

import fr.ul.miage.bibliotheque.control.EmpruntControl;
import fr.ul.miage.bibliotheque.entite.Emprunt;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class EmpruntView implements View {

	EmpruntControl empruntControl;

	@Override
	public Pane getPane() {
		empruntControl = new EmpruntControl();

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		final ListView<Emprunt> list = new ListView<>();
		list.setItems(empruntControl.getEmpruntNonRendu());
		list.setOnMouseClicked(event -> {
			Emprunt emprunt = list.getSelectionModel().getSelectedItem();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Voulez vous valider le retour ?");
			Optional<ButtonType> option = alert.showAndWait();
			if (option.get() != null && option.get() == ButtonType.OK) {
				empruntControl.retourEmprunt(emprunt);
				list.setItems(empruntControl.getEmpruntNonRendu());
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

		final Button emprunter = new Button("Emprunter l'exemplaire");
		emprunter.setPrefHeight(40);
		emprunter.setPrefWidth(300);
		emprunter.setOnAction(event -> {
			boolean trouve = empruntControl.rechercherEmprunt(titreOeuvre.getText(), nomUtilisateur.getText(),
					prenomUtilisateur.getText());
			if (trouve) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText("Voulez vous valider l'emprunt ?");
				alert.setContentText("Ouvrage : " + empruntControl.getOeuvreTemp().getTitre() + " | Usager : "
						+ empruntControl.getUsagerTemp().getNom() + " " + empruntControl.getUsagerTemp().getPrenom());
				Optional<ButtonType> option = alert.showAndWait();
				if (option.get() != null && option.get() == ButtonType.OK) {
					empruntControl.creerEmprunt();
					list.setItems(empruntControl.getEmpruntNonRendu());
					list.refresh();
				}
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setContentText("Aucun usager, oeuvre trouvé ou aucun exemplaire disponible");
				alert.showAndWait();
			}
		});

		gp.add(titreOeuvrel, 0, 0);
		gp.add(titreOeuvre, 1, 0);
		gp.add(nomUtilisateurl, 0, 1);
		gp.add(nomUtilisateur, 1, 1);
		gp.add(prenomUtilisateurl, 0, 2);
		gp.add(prenomUtilisateur, 1, 2);
		gp.add(emprunter, 0, 3, 2, 1);

		hbox.getChildren().addAll(list, gp);

		return hbox;
	}

}
