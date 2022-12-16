package mines;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
//Class to manage extra opened windows in the game
public class ModalWindow {
	
	//Creates no window for if the player wins the game
	public static void WinnerWindow(String title) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);

		Pane pane = new Pane();
		pane.getChildren().addAll(newHbox1(window));
		Scene scene = new Scene(pane, 600, 400);
		window.setScene(scene);
		window.setTitle(title);
		window.showAndWait();
	}
	//HBox for Gif and button to play again
	public static HBox newHbox1(Stage window) {
		HBox winnerHBox = new HBox();
		Image img = new Image("mines/victory.gif");
		ImageView imgView = new ImageView(img);
		Button b1 = new Button("Play Again");
		b1.setOnAction(event -> window.close());
		winnerHBox.getChildren().addAll(imgView, b1);
		return winnerHBox;
	}

	//Creates no window for if the player loses the game
	public static void LooserWindow(String title) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);

		Pane pane = new Pane();
		pane.getChildren().addAll(newHbox2(window));
		Scene scene = new Scene(pane, 400, 400);
		window.setScene(scene);
		window.setTitle(title);
		window.showAndWait();
	}
	//HBox for Gif and button to try again
	public static HBox newHbox2(Stage window) {
		HBox winnerHBox = new HBox();
		Image img = new Image("mines/defeat.gif");
		ImageView imgView = new ImageView(img);
		Button b1 = new Button("Try Again");
		b1.setOnAction(event -> window.close());
		winnerHBox.getChildren().addAll(imgView, b1);
		return winnerHBox;
	}
	//Window to display error messages
	public static void ErrorWindow(String title) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);

		Pane pane = new Pane();
		pane.getChildren().addAll(newHbox3(window, title));
		Scene scene = new Scene(pane, 220, 300);
		window.setScene(scene);
		window.setTitle("ERROR!!!");
		window.showAndWait();
	}
	//Hbox for Error Messages
	public static HBox newHbox3(Stage window, String title) {
		HBox winnerHBox = new HBox();
		VBox buttons = new VBox();
		TextField reset = new TextField();
		Image img = new Image("mines/error.png");
		ImageView imgView = new ImageView(img);
		Button b1 = new Button("SET " + title);
		if (title.equals("HEIGHT")) {
			buttons.getChildren().add(reset);
			b1.setOnAction(event -> {
				Controller.setNewHeight(Integer.parseInt(reset.getText().trim()));
				window.close();
			});
		} else if (title.equals("WIDTH")) {
			buttons.getChildren().add(reset);
			b1.setOnAction(event -> {
				Controller.setNewWidth(Integer.parseInt(reset.getText().trim()));
				window.close();
			});
		} else if (title.equals("MINES")) {
			buttons.getChildren().add(reset);
			b1.setOnAction(event -> {
				Controller.setNewMines(Integer.parseInt(reset.getText().trim()));
				window.close();
			});
		}
		buttons.getChildren().add(b1);
		winnerHBox.getChildren().addAll(imgView, buttons);
		return winnerHBox;
	};
}
