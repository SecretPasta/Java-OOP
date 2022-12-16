package shop;

public abstract class Instrument {

	private int price;
	private String company;
	private static int serialCounter = -1;
	private int serial;

	// Constructor to initialize Class
	public Instrument(String company, int price) {
		this.price = price;
		serialCounter = serialCounter + 1;
		serial = serialCounter;
		this.company = company;
	}

	// returns price of the instrument
	public int getPrice() {
		return price;
	}

	// returns serial of the instrument
	public int getSerial() {
		return serial;
	}

	// returns company of an instrument
	public String getCompany() {
		return company;
	}

}
