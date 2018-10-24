package fr.ul.miage.bibliotheque.view;

import java.time.LocalDate;

import fr.ul.miage.bibliotheque.control.OeuvreControl;
import fr.ul.miage.bibliotheque.entite.Auteur;
import fr.ul.miage.bibliotheque.entite.Oeuvre;
import fr.ul.miage.bibliotheque.entite.TypeOeuvre;
import fr.ul.miage.bibliotheque.util.Utils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class OeuvreView implements View {

	private OeuvreControl oeuvreControl;

	@Override
	public Pane getPane() {
		oeuvreControl = new OeuvreControl();
		
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		final ListView<Oeuvre> list = new ListView<>();

		// Section formulaire
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(25, 25, 25, 25));

		final Text scenetitle = new Text("Gestion des Oeuvres");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		gp.add(scenetitle, 0, 0, 2, 1);

		final Label titre = new Label("Titre :");
		gp.add(titre, 0, 1);

		final TextField titreTexte = new TextField();
		gp.add(titreTexte, 1, 1);

		final Label isbn = new Label("ISBN :");
		gp.add(isbn, 0, 2);

		final TextField isbnTexte = new TextField();
		gp.add(isbnTexte, 1, 2);

		final Label dateCreation = new Label("Date de création :");
		gp.add(dateCreation, 0, 4);

		final DatePicker dateCreationPicker = new DatePicker();
		dateCreationPicker.setValue(LocalDate.now());
		gp.add(dateCreationPicker, 1, 4);

		GridPane gpAuteur = new GridPane();
		gpAuteur.setAlignment(Pos.CENTER_LEFT);
		gpAuteur.setHgap(10);
		gpAuteur.setPadding(new Insets(0, 25, 0, 25));

		final ComboBox<Auteur> listeAuteurDisponible = new ComboBox<>();
		listeAuteurDisponible.setItems(oeuvreControl.getAuteursDisponible());
		listeAuteurDisponible.setPrefWidth(150);
		listeAuteurDisponible.setMaxWidth(150);
		listeAuteurDisponible.getSelectionModel().selectFirst();
		gpAuteur.add(listeAuteurDisponible, 0, 0);

		final Button buttonAjouterAuteur = new Button("Ajouter");
		buttonAjouterAuteur.setOnAction(event -> {
			oeuvreControl.addAuteur(listeAuteurDisponible.getSelectionModel().getSelectedItem());
			listeAuteurDisponible.getSelectionModel().selectFirst();
		});
		gpAuteur.add(buttonAjouterAuteur, 1, 0);

		gp.add(gpAuteur, 0, 5, 2, 1);

		final ListView<Auteur> listAuteur = new ListView<>();
		listAuteur.setItems(oeuvreControl.getAuteurs());
		listAuteur.setMaxHeight(65);
		listAuteur.setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.SECONDARY) {
				oeuvreControl.removeAuteur(listAuteur.getSelectionModel().getSelectedItem());
				listeAuteurDisponible.getSelectionModel().selectFirst();
			}
		});
		gp.add(listAuteur, 0, 6, 2, 1);

		final ComboBox<TypeOeuvre> listeTypeOeuvre = new ComboBox<>();
		listeTypeOeuvre.setItems(oeuvreControl.getTypeOeuvre());
		listeTypeOeuvre.getSelectionModel().selectFirst();
		gp.add(listeTypeOeuvre, 0, 7, 2, 1);

		final Button mettreAJourUsager = new Button("Mettre à jour");
		mettreAJourUsager.setOnAction(event -> {
			oeuvreControl.updateOeuvre(titreTexte.getText(), isbnTexte.getText(), listAuteur.getItems(),
					listeTypeOeuvre.getValue(), Utils.localDateToDate(dateCreationPicker.getValue()));
			list.refresh();
			listAuteur.refresh();

		});
		mettreAJourUsager.setVisible(false);
		gp.add(mettreAJourUsager, 0, 8);

		final Button ajoutUsager = new Button("Ajouter oeuvre");
		ajoutUsager.setOnAction(event -> {
			oeuvreControl.ajouterOeuvre(titreTexte.getText(), isbnTexte.getText(), listAuteur.getItems(),
					listeTypeOeuvre.getValue(), Utils.localDateToDate(dateCreationPicker.getValue()));
		});
		gp.add(ajoutUsager, 1, 8);

		// Section liste
		list.setItems(oeuvreControl.getAllOeuvre());
		list.setPrefWidth(150);

		list.setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
				oeuvreControl.setOeuvreEnCours(list.getSelectionModel().getSelectedItem());
				titreTexte.setText(oeuvreControl.getOeuvreEnCours().getTitre());
				isbnTexte.setText(oeuvreControl.getOeuvreEnCours().getIsbn());
				dateCreationPicker.setValue(Utils.dateToLocalDate(oeuvreControl.getOeuvreEnCours().getDateCreation()));
				listeTypeOeuvre.getSelectionModel().select(oeuvreControl.getTypeOeuvreActuel());
				listAuteur.setItems(oeuvreControl.getAuteurs());
				listeAuteurDisponible.setItems(oeuvreControl.getAuteursDisponible());
				listeAuteurDisponible.getSelectionModel().selectFirst();
				mettreAJourUsager.setVisible(true);
			}
		});

		// Ajout
		hbox.getChildren().addAll(list, gp);

		return hbox;
	}

}
