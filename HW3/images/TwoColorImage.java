package images;
//A class to create an image using two colors and a custom outside func
public class TwoColorImage extends BaseImage{

	private RGB zero,one;
	private TwoDFunc func;
	
	//Constructor to initialize the class
	public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
		super(width, height);
		this.zero = zero;
		this.one = one;
		this.func = func;
	}
//Method to get a pixel's value using an outside func method
	@Override
	public RGB get(int x, int y) {
		double alpha = func.f((double) x/super.getWidth(), (double) y/super.getHeight());
		if(alpha > 1)
			alpha = 1;
		if(alpha<0)
			alpha = 0;
		return RGB.mix(one, zero, alpha);
	}

}
