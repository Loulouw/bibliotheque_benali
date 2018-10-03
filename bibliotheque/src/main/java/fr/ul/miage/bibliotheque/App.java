package fr.ul.miage.bibliotheque;

import fr.ul.miage.bibliotheque.view.UsagerView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Bibliothèque");
        Pane root = new StackPane();
        
        new UsagerView(root);
        
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
		
	}
}
