package mines;

import java.util.Random;

//game main class
public class Mines {

	private int height, width, numMines;
	private static Cell[][] game;
	private boolean showAll;

	// Constructor to initialize the class
	public Mines(int height, int width, int numMines) {
		game = new Cell[height][width]; // creating a matrix of Cell Classes
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				game[i][j] = new Cell(i, j);

		showAll = false;
		this.height = height;
		this.width = width;
		this.numMines = numMines;

		Random random = new Random(); // adding mines in random locations
		for (int z = 0; z < this.numMines; z++) {
			int x, y;
			x = random.nextInt(height);
			y = random.nextInt(width);
			if (x == 0)
				x++;
			if (y == 0)
				y++;
			if (!addMine(x, y)) // if a mine already exists here
				z--;
		}

		for (int i = 0; i < height; i++) // finding all neighbors of all cells
			for (int j = 0; j < width; j++)
				game[i][j].setNeighbors(game);
	}

	// adding a mine
	public boolean addMine(int i, int j) {
		return game[i][j].setMine();
	}

	// opening a cell
	public boolean open(int i, int j) {
		if (game[i][j].openCell() && game[i][j].checkNeighbors() && !game[i][j].isMine()) { // if the cell isn't a mine
																							// and has neighbors that
																							// are not mines
			for (Cell c : game[i][j].getNeighbors()) {
				if (!c.isMine()) // opening all non mine cells around the opened cell recursively
					open(c.getX(), c.getY());
			}
			return true;
		} else if (game[i][j].isMine()) { // if mine opening and returning false
			game[i][j].openCell();
			return false;
		}
		return true;
	}

	// Toggling flag
	public void toggleFlag(int x, int y) {
		game[x][y].setFlag();
	}

	// going through the whole matrix and checking if all non mine cells have been
	// opened
	public boolean isDone() {
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				if (!game[i][j].isMine())
					if (!game[i][j].isOpened())
						return false;

		return true;
	}

	// getting the value of each cell
	public String get(int i, int j) {
		String s = "";
		if (showAll) { // if showAll is true than behaving as if all cells are open
			if (game[i][j].isMine())
				s = "X";
			else {
				if (game[i][j].numOfMines() > 0)
					s = game[i][j].numOfMines() + "";
				else
					s = " ";
			}
		} else { // other wise checking the statues of the cell and returning an appropriate
					// corresponding string
			if (game[i][j].isOpened()) {
				if (game[i][j].isMine()) // if it's a mine
					s = "X";
				else {
					if (game[i][j].numOfMines() > 0) // number of neighboring mines
						s = game[i][j].numOfMines() + "";
					else
						s = " "; // non that it's blank
				}
			} else {
				if (game[i][j].isFlag()) // Flag status
					s = "F";
				else
					s = ".";
			}
		}
		return s;
	}

	// showAll flag
	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}

	// String that shows a text represantation of the currecnt board
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
				s.append(get(i, j));
			s.append("\n");
		}
		return s.toString();
	}

}
