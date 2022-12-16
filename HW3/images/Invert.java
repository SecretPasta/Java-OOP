package images;
//Class to invert an image
public class Invert extends ImageDecorator{
//Constructor to initialize a class
	public Invert(Image image) {
		super(image);
	}
//Method to invert each pixel using the invert method from the RGB class
	@Override
	public RGB get(int x, int y) {
		return super.image.get(x, y).invert();
	}

}
