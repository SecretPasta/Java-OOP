package shop;

//enum for Guitar types
public enum Type {
	ACOUSTIC, ELECTRIC, CLASSICAL;

	// Overriding the toString to not print in all caps
	@Override
	public String toString() {
		switch (this) {
		case ACOUSTIC:
			return "Acoustic";
		case ELECTRIC:
			return "Electric";
		default:
			return "Classical";
		}
	}
}
