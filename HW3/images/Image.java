package images;

//Interface with methods to be used by other classes
public interface Image {
	public int getWidth();

	public int getHeight();

	public RGB get(int x, int y);
}
