package simpleFX2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SimpleFX2 extends Application{

	 public static void main(String[] args) {
	        launch(args);
	    }
	//Main for class with starting values and importing FXML file
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Voting Machine");
		stage.setScene(scene);
		stage.show();
		
	}

}
