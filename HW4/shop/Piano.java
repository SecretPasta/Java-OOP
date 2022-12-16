package shop;

public class Piano extends Instrument {

	private int octaves;

	// Constructor in initialize the Class
	public Piano(String company, int price, int octaves) {
		super(company, price);
		this.octaves = octaves;
	}

	// returns Octaves
	public int getOctaves() {
		return octaves;
	}

	// Formated string
	public String toString() {
		return "Piano(" + getOctaves() + " octaves) " + super.getCompany() + "(" + super.getSerial() + "), price = "
				+ super.getPrice();
	}
}
