package fr.ul.miage.bibliotheque.view;

import java.time.LocalDate;

import fr.ul.miage.bibliotheque.control.UsagerControl;
import fr.ul.miage.bibliotheque.entite.Usager;
import fr.ul.miage.bibliotheque.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class UsagerView implements View {

	private UsagerControl usagerControl = new UsagerControl();

	@Override
	public Pane getPane() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		final ListView<Usager> list = new ListView<>();

		// Section formulaire
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(25, 25, 25, 25));

		final Text scenetitle = new Text("Gestion des Usagers");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		gp.add(scenetitle, 0, 0, 2, 1);

		final Label prenom = new Label("Prénom :");
		gp.add(prenom, 0, 1);

		final TextField prenomTexte = new TextField();
		gp.add(prenomTexte, 1, 1);

		final Label nom = new Label("Nom :");
		gp.add(nom, 0, 2);

		final TextField nomTexte = new TextField();
		gp.add(nomTexte, 1, 2);

		final Label commune = new Label("Commune :");
		gp.add(commune, 0, 3);

		final TextField communeTexte = new TextField();
		gp.add(communeTexte, 1, 3);

		final Label dateNaissance = new Label("Date de Naissance :");
		gp.add(dateNaissance, 0, 4);

		final DatePicker dateNaissancePicker = new DatePicker();
		dateNaissancePicker.setValue(LocalDate.now());
		gp.add(dateNaissancePicker, 1, 4);

		final Button mettreAJourUsager = new Button("Mettre à jour");
		mettreAJourUsager.setOnAction(event -> {
			usagerControl.updateUsager(prenomTexte.getText(), nomTexte.getText(), communeTexte.getText(),
					dateNaissancePicker.getValue());
			list.refresh();

		});
		mettreAJourUsager.setVisible(false);
		gp.add(mettreAJourUsager, 0, 5);

		final Button ajoutUsager = new Button("Ajouter usager");
		ajoutUsager.setOnAction(event -> {
			usagerControl.ajouterUsager(prenomTexte.getText(), nomTexte.getText(), communeTexte.getText(),
					dateNaissancePicker.getValue());
		});
		gp.add(ajoutUsager, 1, 5);

		// Section liste
		list.setItems(usagerControl.getAllUsager());
		list.setPrefWidth(150);

		list.setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
				usagerControl.setUsagerEnCours(list.getSelectionModel().getSelectedItem());
				nomTexte.setText(usagerControl.getUsagerEnCours().getNom());
				prenomTexte.setText(usagerControl.getUsagerEnCours().getPrenom());
				communeTexte.setText(usagerControl.getUsagerEnCours().getCommune());
				dateNaissancePicker
						.setValue(Utils.dateToLocalDate(usagerControl.getUsagerEnCours().getDateNaissance()));
				mettreAJourUsager.setVisible(true);
			}
		});

		// Ajout
		hbox.getChildren().addAll(list, gp);

		return hbox;
	}

}
