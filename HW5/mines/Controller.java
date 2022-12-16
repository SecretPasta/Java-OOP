package mines;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

//Controller class for the JavaFX GUI
public class Controller {
	// fields to be used by objects in the GUI
	@FXML
	private static int newHeight = 0;
	@FXML
	private static int newWidth = 0;
	@FXML
	private static int newMines = 0;
	@FXML
	private int count = 0;
	private int indexOfX;
	private int indexOfY;
	private Mines play;
	@FXML
	private AnchorPane anchorMain;
	@FXML
	private HBox mainHBox;
	@FXML
	private Button resetButton;
	@FXML
	private TextField widthTField;
	@FXML
	private TextField heightTField;
	@FXML
	private TextField minesTField;
	@FXML
	private GridPane gridPaneMines;

	// creating a grid the size specified by the user
	private GridPane createGridPane(Mines p) {

		for (int i = 0; i < newHeight; i++) {
			for (int j = 0; j < newWidth; j++) {
				Button bButton = new Button();
				Image img;
				ImageView imgView;
				String icon = p.get(i, j);
				switch (icon) {
				case ".": // an icon for every possible type of cell
					img = new Image("mines/blankClosed.png");
					imgView = new ImageView(img);
					imgView.setFitHeight(40);
					imgView.setFitWidth(40);
					bButton.setGraphic(imgView);
					break;
				case "F":
					img = new Image("mines/flag.png");
					imgView = new ImageView(img);
					imgView.setFitHeight(40);
					imgView.setFitWidth(40);
					bButton.setGraphic(imgView);
					break;
				case "X":
					img = new Image("mines/mine.png");
					imgView = new ImageView(img);
					imgView.setFitHeight(40);
					imgView.setFitWidth(40);
					bButton.setGraphic(imgView);
					break;
				case " ":
					img = new Image("mines/blank.png");
					imgView = new ImageView(img);
					imgView.setFitHeight(40);
					imgView.setFitWidth(40);
					bButton.setGraphic(imgView);
					break;
				case "1":
					img = new Image("mines/1.png");
					imgView = new ImageView(img);
					imgView.setFitHeight(40);
					imgView.setFitWidth(40);
					bButton.setGraphic(imgView);
					break;
				case "2":
					img = new Image("mines/2.png");
					imgView = new ImageView(img);
					imgView.setFitHeight(40);
					imgView.setFitWidth(40);
					bButton.setGraphic(imgView);
					break;
				case "3":
					img = new Image("mines/3.png");
					imgView = new ImageView(img);
					imgView.setFitHeight(40);
					imgView.setFitWidth(40);
					bButton.setGraphic(imgView);
					break;
				case "4":
					img = new Image("mines/4.png");
					imgView = new ImageView(img);
					imgView.setFitHeight(40);
					imgView.setFitWidth(40);
					bButton.setGraphic(imgView);
					break;
				case "5":
					img = new Image("mines/5.png");
					imgView = new ImageView(img);
					imgView.setFitHeight(40);
					imgView.setFitWidth(40);
					bButton.setGraphic(imgView);
					break;
				case "6":
					img = new Image("mines/6.png");
					imgView = new ImageView(img);
					imgView.setFitHeight(40);
					imgView.setFitWidth(40);
					bButton.setGraphic(imgView);
					break;
				default:
					break;
				}

				// adding an event filter for mouse clicks on cells
				bButton.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getButton() == MouseButton.SECONDARY) { // if mouse was right clicked
							indexOfX = GridPane.getRowIndex(bButton);
							indexOfY = GridPane.getColumnIndex(bButton); // getting coordinated of the clicked cell
							play.toggleFlag(indexOfX, indexOfY); // toggeling flag
							play.setShowAll(false);
							gridPaneMines.getChildren().remove(0, newWidth * newHeight);
							if (play.isDone()) { // checking if the game is done
								new ModalWindow();
								ModalWindow.WinnerWindow("WINNER!!!");
							}
							mainHBox.getChildren().set(1, createGridPane(play)); // adding the grid to the GUI
						}
					}
				});
				bButton.setOnAction(MouseEvent -> thisButton(bButton));
				gridPaneMines.add(bButton, j, i);
			}
		}
		return gridPaneMines;
	}

	private void thisButton(Button thisB) {
		indexOfX = GridPane.getRowIndex(thisB);
		indexOfY = GridPane.getColumnIndex(thisB);
		boolean Mine = play.open(indexOfX, indexOfY); // opening the cell in the specific coordinates if a mine is there
														// it returns false!
		gridPaneMines.getChildren().remove(0, newWidth * newHeight);
		if (!Mine) { // if it's a mine, open window with Defeat message
			new ModalWindow();
			ModalWindow.LooserWindow("You Lost!");
			play.setShowAll(true);
		}
		if (play.isDone()) { // checking if the game is done
			new ModalWindow();
			ModalWindow.WinnerWindow("You Win"); // if done open new window with victory message
		}
		mainHBox.getChildren().set(1, createGridPane(play)); // updating the grid
	}

	// method to be used for checking errors in input
	public int itsGood(int height, int width, int mines) {

		if (newWidth < 0 || newWidth == 0) {
			return 1;
		} else if (newHeight < 0 || newHeight == 0) {
			return 2;
		} else if (newMines < 0 || newMines == 0) {
			return 3;
		}
		if (newMines >= newHeight * newWidth)
			return 4;
		return 0;
	}

	// methods to get values from user inputs
	public static void setNewHeight(int val) {
		newHeight = val;
	}

	public static void setNewWidth(int val) {
		newWidth = val;
	}

	public static void setNewMines(int val) {
		newMines = val;
	}

	@FXML // method to start the game
	void initialize() {

		resetButton.setOnAction(event -> {
			if (count != 0)
				gridPaneMines.getChildren().remove(0, newWidth * newHeight);
			newMines = Integer.parseInt(minesTField.getText().trim()); // getting user input from text fields
			newWidth = Integer.parseInt(widthTField.getText().trim());
			newHeight = Integer.parseInt(heightTField.getText().trim());
			int op = itsGood(newHeight, newWidth, newMines); // checking for errors in input
			while (op != 0) { // and displaying appropriate message
				if (op == 1) {
					new ModalWindow();
					ModalWindow.ErrorWindow("WIDTH");
					op = itsGood(newHeight, newWidth, newMines);
				}
				if (op == 2) {
					new ModalWindow();
					ModalWindow.ErrorWindow("HEIGHT");
					op = itsGood(newHeight, newWidth, newMines);
				}
				if (op == 3) {
					new ModalWindow();
					ModalWindow.ErrorWindow("MINES");
					op = itsGood(newHeight, newWidth, newMines);
				}
				if (op == 4) {
					new ModalWindow();
					ModalWindow.ErrorWindow("MINES");
					op = itsGood(newHeight, newWidth, newMines);
				}

			}
			minesTField.setText(String.valueOf(newMines));
			heightTField.setText(String.valueOf(newHeight));
			widthTField.setText(String.valueOf(newWidth));
			play = new Mines(newHeight, newWidth, newMines); // start the game
			mainHBox.getChildren().set(1, createGridPane(play)); // update the Grid
			count++;
		});
	}
}
