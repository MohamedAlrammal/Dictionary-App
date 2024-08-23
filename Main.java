package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/***
 * UNCOMPLETED YET.
 */
public class Main extends Application {
	@Override
	public void start(Stage stage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene sc = new Scene(root);
			
			String css = getClass().getResource("application.css").toExternalForm();
			sc.getStylesheets().add(css);
			
			stage.setScene(sc);
			stage.show();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
