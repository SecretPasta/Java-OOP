package images;
//Abstract Class to be used by other classes
public abstract class BinaryImageDecorator implements Image {

	protected Image image1,image2;
//Constructor to initialize the class
	public BinaryImageDecorator(Image image1, Image image2) {
		this.image1 = image1;
		this.image2 = image2;
	}
	//Method to get the width of an image being the largest of the two
	@Override
	public int getWidth() {
		return Math.max(image1.getWidth(), image2.getWidth());
	}
	//Method to get the height of an image being the largest of the two
	@Override
	public int getHeight() {
		return Math.max(image1.getHeight(), image2.getHeight());
	}
}
