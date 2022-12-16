package images;

public class Circle extends BaseImage {
	private int centerX, centerY, radius;
	private RGB center, outside;
//Constructor to initialize the Class
	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
		super(width, height);
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}
//Constructor to create an image
	public Circle(int size, int radius, RGB center, RGB outside) {
		super(size, size);
		this.centerX = size/2;
		this.centerY = size/2;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}
//Creating an image with a circle gradient
	@Override
	public RGB get(int x, int y) {
		if ((Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2)) > Math.pow(radius, 2))//checking if a pixel is outside the circle
			return outside;
		double myAlpha = ((double) Math.sqrt(((Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2))))) / radius;//calculating the alpha for the gradient
		return RGB.mix(outside, center,myAlpha);																//for points inside the circle
	}
}
