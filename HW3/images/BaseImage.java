package images;

//Abstract class the uses Image with code to be used be other classes
abstract class BaseImage implements Image {
	private int width, height;

//Constructor to initialize the class
	public BaseImage(int width, int height) {
		this.width = width;
		this.height = height;
	}

//method to get width of an image
	@Override
	public int getWidth() {
		return width;
	}

	// method to get height of an image
	@Override
	public int getHeight() {
		return height;
	}

//method to get the color value of specific pixel on the image
	@Override
	public abstract RGB get(int x, int y);

}
