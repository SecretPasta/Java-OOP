package images;
//A class to mix the images
public class Mix extends Superpose {
	private double alpha;
	public Mix(Image image1, Image image2,double alpha) {
		super(image1, image2);
		this.alpha = alpha;
	}


//method to mix the colors of two images where they overlap using mix for the RGB class
	@Override
	public RGB get(int x, int y) {
		if(x<=image1.getWidth() && y<=image1.getHeight() && x<=image2.getWidth() && y<=image2.getHeight())
			return RGB.mix(image1.get(x, y), image2.get(x, y), alpha);
		return super.get(x, y);
	}

}
