package mines;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MineFX extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	// Initial parameters for the GUI
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
		Image icon = new Image("mines/mineRed.png");
		stage.getIcons().add(icon);
		Scene scene = new Scene(root);
		stage.setTitle("Sponge Sweeper");
		stage.setScene(scene);
		stage.show();

	}

}
