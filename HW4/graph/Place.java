package graph;

import java.util.Objects;

public class Place {
	private int x, y, bound;

	// Constructor to initialize the class
	public Place(int x, int y, int bound) throws IllegalArgumentException {
		if (x < 0 || x > (bound - 1) || y < 0 || y > (bound - 1))
			throw new IllegalArgumentException();
		else {
			this.x = x;
			this.y = y;
			this.bound = bound;
		}
	}

	// get X
	public int getX() {
		return x;
	}

	// getY
	public int getY() {
		return y;
	}

	// equals method generated by Eclipse
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		return bound == other.bound && x == other.x && y == other.y;
	}

	// hashCode method for HashMap to be used for hashing
	@Override
	public int hashCode() {
		return Objects.hash(bound, x, y);
	}

}
