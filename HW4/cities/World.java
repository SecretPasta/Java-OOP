package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class World {
	private Map<String, Country> countries;

	// Constructor to initialize the class
	public World() {
		countries = new TreeMap<>();
	}

	// adding a country to the TreeMap
	public void addCountry(String name) {
		countries.put(name, new Country(name));
	}

	// Adding a city to a TreeSet in the TreeMap according to the country name key
	// if the country doesn't exist throws an exception
	public void addCity(String name, String countryName, int population) {
		if (countries.containsKey(countryName))
			countries.get(countryName).addCity(new City(name, countries.get(countryName), population));
		else
			throw new IllegalArgumentException();
	}

	// Calculates the total population of all the countries in the TreeMap
	public int population() {
		int counter = 0;
		for (String country : countries.keySet())
			counter += countries.get(country).population();
		return counter;
	}

	// Creates a List of the cities in the TreeMap with population "under" that
	// amount
	public List<City> smallCities(int under) {
		List<City> sCities = new ArrayList<>();
		for (String country : countries.keySet()) {
			sCities.addAll(countries.get(country).smallCities(under));
		}
		return sCities;
	}

	// String of the report of the entire TreeMap and the total population of all
	// the countries
	public String report() {
		StringBuilder s = new StringBuilder();
		int counter = 0;
		for (String country : countries.keySet()) {
			s.append(countries.get(country).report() + "\n");
			counter += countries.get(country).population();
		}
		s.append("Total population is " + counter + "\n");
		return s.toString();
	}

}
