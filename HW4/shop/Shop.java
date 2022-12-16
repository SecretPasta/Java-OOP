package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private ArrayList<Instrument> Instruments;

	// Constructor to initialize the class
	public Shop() {
		Instruments = new ArrayList<>();
	}

	// Adds instrument to the ArrayList
	public void add(Instrument i) {
		Instruments.add(i);
	}

	// gets an instrument according to the serial number
	public Instrument get(int serial) {
		for (int i = 0; i < Instruments.size(); i++) {
			if (Instruments.get(i).getSerial() == serial)
				return Instruments.get(i);
		}
		return null;
	}

	// creates a list of all the serial numbers in the ArrayList
	public List<Integer> allSerials() {
		List<Integer> serials = new ArrayList<>();
		for (int i = 0; i < Instruments.size(); i++) {
			serials.add(Instruments.get(i).getSerial());
		}
		return serials;
	}

	// Creates a list of all guitars of a certain type
	public List<Integer> guitarsOfType(Type t) {
		List<Integer> guitars = new ArrayList<>();
		for (Guitar guitar : allGuitars()) {
			if (guitar.getType().equals(t))
				guitars.add(guitar.getSerial());
		}
		return guitars;
	}

	// method to sell an instrument throws appropriate exceptions if can't be sold
	// or one guitar is left
	public void sell(int serial) throws MusicShopException {
		Instrument instrument = get(serial);
		if (instrument == null)
			throw new MusicShopException("None Existant\n");
		if (instrument instanceof Guitar && allGuitars().size() <= 1) {
			throw new MusicShopException("Sale Forbidden\n");
		}
		Instruments.remove(instrument);
	}

	// creates a list of all the guitars
	private List<Guitar> allGuitars() {
		List<Guitar> guitars = new ArrayList<>();
		for (Instrument instrument : Instruments) {
			if (instrument instanceof Guitar)
				guitars.add((Guitar) instrument);
		}
		return guitars;
	}

	// method to sell everything
	public int sellAll(int[] serials) {
		int counter = 0;
		for (int i : serials) {
			try {
				sell(i);
			} catch (MusicShopException exception) {
				counter++;
			}
		}
		return counter;
	}

}
