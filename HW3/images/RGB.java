package images;

//Class that has all the color related methods
public class RGB {
	private double red, green, blue;

	// constructor to intialzie the class
	public RGB(double red, double green, double blue) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	// Method to set the color to Grey
	public RGB(double grey) {
		red = grey;
		green = grey;
		blue = grey;
	}

	// Get the Red value of the color
	public double getRed() {
		return red;
	}

	// Get the Green value of the color
	public double getGreen() {
		return green;
	}

	// Get the Blue value of the color
	public double getBlue() {
		return blue;
	}

	// Method to invert the color
	public RGB invert() {
		return new RGB(1 - red, 1 - green, 1 - blue);
	}

	// method to apply a filter to the color
	public RGB filter(RGB filter) {
		return new RGB(red * filter.red, green * filter.green, blue * filter.blue);
	}

	// Method to superpose the two colors
	public static RGB superpose(RGB rgb1, RGB rgb2) {
		double r, g, b;
		if (rgb1.red + rgb2.red > 1)
			r = 1;
		else
			r = rgb1.red + rgb2.red;
		if (rgb1.green + rgb2.green > 1)
			g = 1;
		else
			g = rgb1.green + rgb2.green;
		if (rgb1.blue + rgb2.blue > 1)
			b = 1;
		else
			b = rgb1.blue + rgb2.blue;
		return new RGB(r, g, b);
	}

	// Method to mix to colors
	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		double r, g, b;
		r = alpha * rgb1.red + (1 - alpha) * rgb2.red;
		g = alpha * rgb1.green + (1 - alpha) * rgb2.green;
		b = alpha * rgb1.blue + (1 - alpha) * rgb2.blue;
		return new RGB(r, g, b);
	}

	// Method to return a string with the values of each color of a color
	public String toString() {
		return String.format("<%.4f, %.4f, %.4f>", red, green, blue);
	}

	// Static Colors for ease of use
	public static final RGB BLACK = new RGB(0);
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1, 0, 0);
	public static final RGB GREEN = new RGB(0, 1, 0);
	public static final RGB BLUE = new RGB(0, 0, 1);
}
