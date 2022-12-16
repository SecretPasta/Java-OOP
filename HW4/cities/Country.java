package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Country implements Comparable<Country> {
	private Set<City> cities;
	private String name;

	// Constructor to initialize the class
	public Country(String name) {
		this.name = name;
		cities = new TreeSet<>();
	}

	// adds city to the contry's TreeSet and if the country doesn't exist throws an
	// exception
	public void addCity(City city) {
		if (this.name.equals(city.getCountry().name))
			cities.add(city);
		else
			throw new IllegalArgumentException();
	}

	// Calculates the total population of all the cities to get the country's
	// population
	public int population() {
		int counter = 0;
		for (City c : cities)
			counter += c.getPopulation();
		return counter;
	}

	// returns country's name
	public String toString() {
		return name;
	}

	// Creates a List of the cities with a population "under" that amount
	public List<City> smallCities(int under) {
		List<City> sCities = new ArrayList<>();
		for (City c : cities) {
			if (c.getPopulation() < under)
				sCities.add(c);
		}
		return sCities;
	}

	// Custom Compare to to be used by TreeMap for sorting
	@Override
	public int compareTo(Country country) {
		return this.name.compareTo(country.name);
	}

	// Custom equals to compare countries
	@Override
	public boolean equals(Object o) { // This one is good
		return o.equals(name);
	}

	// String to print a report of all the cities and population of the country
	public String report() {
		StringBuilder s = new StringBuilder(name);
		int counter = 0;
		for (City c : cities) {
			counter += c.getPopulation();
		}
		s.append("(" + counter + ") : ");
		for (City c : cities) {
			s.append(c.getName() + "(" + c.getPopulation() + "), ");
		}
		s.delete(s.length() - 2, s.length());
		return s.toString();
	}

}
