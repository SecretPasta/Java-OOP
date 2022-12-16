package images;
//Class to create a Gradient Image
public class Gradient extends BaseImage {
	private RGB start, end;
//Constructor to initialize the class
	public Gradient(int width, int height, RGB start, RGB end) {
		super(width, height);
		this.start = start;
		this.end = end;
	}
//Returning the mixed value of the colors depending on the location of the pixel
	@Override
	public RGB get(int x, int y) {
		return RGB.mix(start, end, (1 - (double) x / this.getWidth()));
	}

}
