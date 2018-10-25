package fr.ul.miage.bibliotheque.view;

import fr.ul.miage.bibliotheque.control.AuteurControl;
import fr.ul.miage.bibliotheque.entite.Auteur;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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

public class AuteurView implements View{

	private AuteurControl auteurControl;
	
	@Override
	public Pane getPane() {
		auteurControl = new AuteurControl();
				
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		final ListView<Auteur> list = new ListView<>();

		// Section formulaire
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(25, 25, 25, 25));

		final Text scenetitle = new Text("Gestion des Auteur");
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


		final Button mettreAJourUsager = new Button("Mettre à jour");
		mettreAJourUsager.setOnAction(event -> {
			auteurControl.updateAuteur(prenomTexte.getText(), nomTexte.getText());
			list.refresh();

		});
		mettreAJourUsager.setVisible(false);
		gp.add(mettreAJourUsager, 0, 5);

		final Button ajoutUsager = new Button("Ajouter auteur");
		ajoutUsager.setOnAction(event -> {
			auteurControl.ajouterAuteur(prenomTexte.getText(), nomTexte.getText());
		});
		gp.add(ajoutUsager, 1, 5);

		// Section liste
		list.setItems(auteurControl.getAllAuteur());
		list.setPrefWidth(150);

		list.setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
				auteurControl.setAuteurEnCours(list.getSelectionModel().getSelectedItem());
				nomTexte.setText(auteurControl.getAuteurEnCours().getNom());
				prenomTexte.setText(auteurControl.getAuteurEnCours().getPrenom());
				mettreAJourUsager.setVisible(true);
			}
		});

		// Ajout
		hbox.getChildren().addAll(list, gp);

		return hbox;
	}

}
