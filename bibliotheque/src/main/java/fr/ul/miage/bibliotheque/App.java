package fr.ul.miage.bibliotheque;

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

		root.getChildren().add(tabPane);
		primaryStage.setScene(new Scene(root, 500, 450));
		primaryStage.show();

	}

	private static Tab createTabPane(String name, View view) {
		Tab tab = new Tab(name);
		tab.setContent(view.getPane());
		tab.setClosable(false);
		return tab;
	}
}
