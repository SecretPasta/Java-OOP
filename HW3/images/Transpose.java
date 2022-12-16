package images;
//A class to transpose the image
public class Transpose extends ImageDecorator{
//Constructor to initialize the class
	public Transpose(Image image) {
		super(image);
		
	}
//method to return the Transposed image by sending y instead of x and vice versa 
	@Override
	public RGB get(int x, int y) {
		return super.image.get(y, x);
	}
	//method to returns height to compensate for Transpose
	@Override
	public int getWidth() {
		return super.getHeight();
	}
	//method to returns width to compensate for Transpose
	@Override
	public int getHeight() {
		return super.getWidth();
	}
	
	
}


