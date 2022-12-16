package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Maze implements GraphInterface<Place> {
	private int startx, starty, endx, endy;
	private String[][] maze;

	// Constructor to initialize the class with a 2D array that is the maze
	public Maze(int size, int startx, int starty, int endx, int endy) {
		if (startx < 0 || startx > (size - 1) || starty < 0 || starty > (size - 1) || endx < 0 || endx > (size - 1)
				|| endy < 0 || endy > (size - 1))
			throw new IllegalArgumentException();
		else {
			this.startx = startx;
			this.starty = starty;
			this.endx = endx;
			this.endy = endy;
			maze = new String[size][size];
			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++)
					maze[i][j] = ".";
			maze[startx][starty] = "S";
			maze[endx][endy] = "E";
		}
	}

	// adds a wall to the maze and returns true
	public boolean addWall(int x, int y) {
		if (!inBound(x, y))
			throw new IllegalArgumentException();
		else if (maze[x][y].equals(".")) {
			maze[x][y] = "@";
			return true;
		}
		return false;
	}

	// String to print the maze
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				s.append(maze[i][j]);
			}
			s.append("\n");
		}
		return s.toString();
	}

	// method to check if the maze is solvable
	public boolean isSolvable() {
		Graph<Place> graph = new Graph<>();
		for (int x = 0; x < maze.length; x++) {// going through the maze in a nested loop
			for (int y = 0; y < maze.length; y++) {
				if (maze[x][y] == "@") // checking if it's a wall if so skipping the iteration
					continue;
				Place currentPlace = new Place(x, y, maze.length); // creating the current place
				for (Place p : getNeighbours(x, y)) {// going through the Neighbors
					try {
						graph.addVertex(p);
					} catch (GraphException e) {
					}
					try {
						graph.addVertex(currentPlace);
					} catch (GraphException e) {
					} // adding to the graph
					try {
						graph.addEdge(currentPlace, p);
					} catch (GraphException e) {
					}
				}
			}
		}
		try {
			graph.addVertex(new Place(startx, starty, maze.length));
		} catch (GraphException e) {
		} // Adding start
		try {
			graph.addVertex(new Place(endx, endy, maze.length));
		} catch (GraphException e) {
		} // and finish points to the maze
		try {
			return graph.connected(new Place(startx, starty, maze.length), new Place(endx, endy, maze.length));

		} catch (IllegalArgumentException | GraphException e) {
			e.printStackTrace();
		}
		return false; // Never reach this line
	}

	// method to find all the Neighbors
	private List<Place> getNeighbours(int x, int y) {
		List<Place> neighbours = new ArrayList<>();
		int currentX, currentY;
		int[] directionX = { 1, -1, 0, 0 };
		int[] directionY = { 0, 0, 1, -1 };
		for (int i = 0; i < 4; i++) { // Going through 4 possible direction
			currentX = x + directionX[i];
			currentY = y + directionY[i];
			Place placeToAdd = null;
			try {
				placeToAdd = new Place(currentX, currentY, maze.length);
			} catch (IllegalArgumentException e) {
				continue;
			}
			;
			if (maze[currentX][currentY] != "@") // if it's not a wall adding to the list
				neighbours.add(placeToAdd);
		}
		return neighbours;
	}

	// checking if a point is within bounds of the maze
	private boolean inBound(int x, int y) {
		return !(x < 0 || x > (maze.length - 1) || y < 0 || y > (maze.length - 1));
	}

	// getting neighbors
	@Override
	public Collection<Place> neighbours(Place v) {
		return getNeighbours(v.getX(), v.getY());
	}

}
