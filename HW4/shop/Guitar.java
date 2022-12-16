package shop;

public class Guitar extends Instrument {
	private Type type;

	// Constructor to initialize the Class
	public Guitar(String company, int price, Type type) {
		super(company, price);
		this.type = type;
	}

	// returns guitar type
	public Type getType() {
		return type;
	}

	// string for guitar
	public String toString() {
		return "Guitar(" + getType().toString() + ") " + getCompany() + "(" + super.getSerial() + "), price = "
				+ super.getPrice();
	}

}
