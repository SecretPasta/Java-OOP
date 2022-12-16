package simpleFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Question2 extends Application {
	// main for class
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(createRoot());
		stage.setTitle("Voting Machine");
		stage.setScene(scene);
		stage.show();
	}

	// counter
	private int i = 0;

	private VBox createRoot() {
		VBox root = new VBox(10);
		HBox myHBox = new HBox(15);

		Button b = new Button("Ofra Haza"); // creating buttons
		Button c = new Button("Yardena Arazi");
		b.setMaxWidth(Double.MAX_VALUE); // setting a max width to be unlimited and a
		b.setMinWidth(10); // minimum value of 10 pixels
		c.setMaxWidth(Double.MAX_VALUE);
		c.setMinWidth(10);

		myHBox.getChildren().addAll(b, c); // adding the buttons
		myHBox.setPadding(new Insets(10)); // adding spacing
		TextField myText = new TextField(); // creating a text field
		myText.setText("0");
		myText.setPadding(new Insets(15));
		myText.setAlignment(Pos.CENTER);
		myText.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		class LabelIncrease implements EventHandler<ActionEvent> { // a subclass to increment counter

			public void handle(ActionEvent event) {
				i++;
				myText.setText(i + "");
			}
		}
		class LabelDecrease implements EventHandler<ActionEvent> {// a subclass to decrement counter

			public void handle(ActionEvent event) {
				i--;
				myText.setText(i + "");
			}
		}
		b.setOnAction(new LabelIncrease());// Ofra button will increment
		c.setOnAction(new LabelDecrease());// Yardena button will decrement
		root.getChildren().addAll(myHBox, myText); // adding both boxes
		root.setPadding(new Insets(10)); // adding spacing
		return root;
	}

}