package images;
//An Abstract Class with methods to be used by other classes
public abstract class ImageDecorator implements Image {
	protected Image image;
//Constructor to initialize the Class
	public ImageDecorator(Image image) {
		this.image = image;
	}
//Method to get width
	@Override
	public int getWidth() {
		return image.getWidth();
	}
	//Method to get height
	@Override
	public int getHeight() {
		return image.getHeight();
	}
	//Method to get the color values of a pixel
	@Override
	public abstract RGB get(int x, int y);

}
