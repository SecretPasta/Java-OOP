package images;
//Class to apply a filter to an image
public class Filter extends ImageDecorator{
	private RGB filter;
	//constructor to initialize the class
	public Filter(Image image,RGB filter) {
		super(image);
		this.filter = filter;

	}
//Class to apply the filter to each pixel using the filter method in the RGB class
	@Override
	public RGB get(int x, int y) {
		return super.image.get(x, y).filter(filter);
	}

	
	
}
