package fr.ul.miage.bibliotheque;

import fr.ul.miage.bibliotheque.view.AuteurView;
import fr.ul.miage.bibliotheque.view.EmpruntView;
import fr.ul.miage.bibliotheque.view.ExemplaireView;
import fr.ul.miage.bibliotheque.view.OeuvreView;
import fr.ul.miage.bibliotheque.view.ReservationView;
import fr.ul.miage.bibliotheque.view.UsagerView;
import fr.ul.miage.bibliotheque.view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Bibliothèque");
		Pane root = new StackPane();

		TabPane tabPane = new TabPane();

		tabPane.getTabs().add(createTabPane("Usager", new UsagerView()));
		tabPane.getTabs().add(createTabPane("Auteur", new AuteurView()));
		tabPane.getTabs().add(createTabPane("Oeuvre", new OeuvreView()));
		tabPane.getTabs().add(createTabPane("Exemplaire", new ExemplaireView()));
		tabPane.getTabs().add(createTabPane("Emprunt", new EmpruntView()));
		tabPane.getTabs().add(createTabPane("Reservation", new ReservationView()));

		root.getChildren().add(tabPane);
		primaryStage.setScene(new Scene(root, 500, 450));
		primaryStage.show();

	}

	private static Tab createTabPane(String name, View view) {
		final Tab tab = new Tab(name);
		tab.selectedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue) {
				tab.setContent(view.getPane());
			}
		});
		tab.setContent(view.getPane());
		tab.setClosable(false);
		return tab;
	}
}
