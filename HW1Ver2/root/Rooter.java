package root;

public class Rooter {

	private double precision; // private variable

	public Rooter(double precision) {
		setPrecision(precision);
	}

	public void setPrecision(double precision) {// Constructor
		this.precision = precision;
	}

	public double sqrt(double x) { // square root calculator within a given precision
		double one = 2 / x;
		double two = x / one;
		;
		while (Math.abs((one - two)) >= precision) {
			two = x / one;
			if (one == two)
				return one;
			one = ((one + two) / 2);
		}
		return one;

	}

}
