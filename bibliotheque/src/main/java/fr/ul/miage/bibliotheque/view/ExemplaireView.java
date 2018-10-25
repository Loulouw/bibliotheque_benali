package fr.ul.miage.bibliotheque.view;

import fr.ul.miage.bibliotheque.control.ExemplaireControl;
import fr.ul.miage.bibliotheque.entite.Etat;
import fr.ul.miage.bibliotheque.entite.Exemplaire;
import fr.ul.miage.bibliotheque.entite.Oeuvre;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ExemplaireView implements View {

	private ExemplaireControl exemplaireControl;

	@Override
	public Pane getPane() {
		exemplaireControl = new ExemplaireControl();

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);

		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(25, 25, 25, 25));

		final TableView<Exemplaire> tableExemplaire = new TableView<>();
		TableColumn<Exemplaire, Integer> numeroCol = new TableColumn<>("Numéro");
		numeroCol.setCellValueFactory(new PropertyValueFactory<Exemplaire, Integer>("id"));

		TableColumn<Exemplaire, Etat> etatCol = new TableColumn<>("État");
		etatCol.setCellValueFactory(new PropertyValueFactory<Exemplaire, Etat>("etat"));

		TableColumn<Exemplaire, Boolean> emprunterCol = new TableColumn<>("Emprunter");
		emprunterCol.setCellValueFactory(new PropertyValueFactory<Exemplaire, Boolean>("emprunter"));

		tableExemplaire.getColumns().addAll(numeroCol, etatCol, emprunterCol);
		tableExemplaire.setItems(exemplaireControl.getListeExemplaire());

		final Button buttonAjouterExemplaire = new Button("Ajouter Exemplaire");
		buttonAjouterExemplaire.setOnAction(event -> {
			exemplaireControl.ajouterExemplaire();
			tableExemplaire.refresh();
		});

		final ListView<Oeuvre> listOeuvre = new ListView<>();
		listOeuvre.setItems(exemplaireControl.getListeOeuvre());
		listOeuvre.setPrefWidth(150);
		listOeuvre.setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				exemplaireControl.setOeuvreEnCours(listOeuvre.getSelectionModel().getSelectedItem());
				tableExemplaire.setItems(exemplaireControl.getListeExemplaire());
			}
		});

		gp.add(tableExemplaire, 0, 0);
		gp.add(buttonAjouterExemplaire, 0, 1);

		hbox.getChildren().addAll(listOeuvre, gp);
		return hbox;
	}

}
