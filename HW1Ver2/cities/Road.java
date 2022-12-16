package cities;

public class Road {
	private City city1, city2;
	private int length;

	public Road(City city1, City city2, int length) {// Constructor for Road
		this.city1 = city1;
		this.city2 = city2;
		this.length = length;
		city1.connect(this); // using connect method to connect each city to the road (self)
		city2.connect(this); // using connect method to connect each city to the road (self)
	}

	public City getCity1() { // Method to return city1
		return city1;
	}

	public City getCity2() { // Method to return city2
		return city2;
	}

	public int getLength() { // method to return road length
		return length;
	}
}
