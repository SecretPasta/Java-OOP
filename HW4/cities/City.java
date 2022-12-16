package cities;

public class City implements Comparable<City> {
	private String name;
	private Country country;
	private int population;

	// Constructor to initialize class
	public City(String name, Country country, int population) {
		this.name = name;
		this.country = country;
		this.population = population;
	}

	// returns city name
	public String getName() {
		return name;
	}

	// returns country the city is in
	public Country getCountry() {
		return country;
	}

	// returns population of the city
	public int getPopulation() {
		return population;
	}

	// Formated string of the city and which country it's in
	public String toString() {
		return name + " (of " + getCountry() + ")";
	}

	// custom method for TreeSet to use for sorting
	@Override
	public int compareTo(City city) {
		if (country.equals(city.getCountry()))
			return name.compareTo(city.getName());
		return country.compareTo(city.getCountry());
	}

	// Custom equals to compare cities
	@Override
	public boolean equals(Object o) {
		City c = (City) o;
		if (this.country.equals(c.getCountry()))
			if (this.name.equals(c.name))
				return true;
		return false;
	}
}
