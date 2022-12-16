package images;

//A class to superpose to images together
public class Superpose extends BinaryImageDecorator {

	// Constructor to initialize the class
	public Superpose(Image image1, Image image2) {
		super(image1, image2);
	}

//method to return the superposed value of each pixel by checking if and where the two images overlap
	@Override
	public RGB get(int x, int y) {
		if (x <= image1.getWidth() && y <= image1.getHeight() && x <= image2.getWidth() && y <= image2.getHeight())
			return RGB.superpose(image1.get(x, y), image2.get(x, y));
		if (((x > image1.getWidth() || y > image1.getHeight()) && (x > image2.getWidth() || y > image2.getHeight())))
			return RGB.BLACK;

		if (x <= image1.getWidth() && y <= image1.getHeight())
			return image1.get(x, y);
		return image2.get(x, y);
	}

}
