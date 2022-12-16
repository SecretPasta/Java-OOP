package mines;

import java.util.ArrayList;
import java.util.List;

//Class to describe a single cell in a mine sweeper game
public class Cell {
	private boolean opened, flag, mine;
	private int x, y;
	private List<Cell> neighbors;

	// Constructor to initialize the class
	public Cell(int x, int y) {
		opened = false;
		flag = false;
		mine = false;
		this.x = x;
		this.y = y;
		neighbors = new ArrayList<>();
	}

	// method to return the whole class
	public Cell getCell() {
		return this;
	}

	// Creating an ArrayList of all neighbors of a cell
	public void setNeighbors(Cell[][] board) {
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i == x && j == y)
					continue; // going over all potential cells and catching exception
				else { // if going out of bounds
					try {
						neighbors.add(board[i][j]);
					} catch (IndexOutOfBoundsException e) {
						continue;
					}
				}
			}
		}
	}

	// returns the list of neighbors
	public List<Cell> getNeighbors() {
		return neighbors;
	}

	// counts how many of the neighbors are mines
	public int numOfMines() {
		int count = 0;
		for (Cell n : neighbors) {
			if (n.isMine())
				count++;
		}
		return count;
	}

	// Checking if any of the neighbors are mines
	public boolean checkNeighbors() {
		for (Cell i : neighbors)
			if (i.isMine())
				return false;
		return true;
	}

	// returns if a cell has been opened
	public boolean isOpened() {
		return opened;
	}

	// checking if a cell has been flagged
	public boolean isFlag() {
		return flag;
	}

	// checking if a cell is a mine
	public boolean isMine() {
		return mine;
	}

	// opening a cell and returning true if it's not a mine
	public boolean openCell() {
		if (!opened && !mine)
			return opened = true;
		if (!opened && mine) {
			return opened = false;
		}
		return false;
	}

	// flag toggle
	public void setFlag() {
		if (flag)
			flag = false;
		else
			flag = true;
	}

	// setting a mine
	public boolean setMine() {
		return mine = true;
	}

	// get X coordinate
	public int getX() {
		return x;
	}

	// get Y coordinate
	public int getY() {
		return y;
	}

}
