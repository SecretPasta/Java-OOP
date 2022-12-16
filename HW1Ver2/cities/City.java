package cities;

public class City {

	private Road[] roads;
	private int numRoads;
	private String name;

	public City(String name) { // Constructor for City
		this.name = name;
		this.numRoads = 0;
		roads = new Road[10];
	}

	public void connect(Road r) {// method to add a new road to the array of roads
		roads[numRoads++] = r;
	}

	public City nearestCity() { // method to find the nearest city
		if (numRoads == 0) // if there are no roads return null
			return null;
		Road shortest = roads[0]; // creating "shortest" to hold the shortest road
		for (int i = 1; i < numRoads; i++) {
			if (roads[i].getLength() < shortest.getLength()) // going through the array and checking if any road is
																// shorter
				shortest = roads[i]; // if one is found placing it in "shortest"
		}
		return shortest.getCity1().toString() == this.toString() ? shortest.getCity2() : shortest.getCity1();
	}

	public String toString() {// method to return city name
		return (name);
	}

}
