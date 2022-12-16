package iterator;

import java.util.NoSuchElementException;

//class to print an array
public class MyArray implements MyIterator {

	private int[] x;
	private int index;

	// constructor to initialize fields
	public MyArray(int[] x) {
		this.x = x;
		this.index = 0;
	}

	// Overriding the MyIterrator interface to check in there's a next
	@Override
	public boolean hasNext() {
		if ((index) >= x.length)
			return false;
		return true;
	}

	@Override // returning next if there is next otherwise throwing an exception
	public int next() {
		if (hasNext()) {
			return x[index++];
		}
		throw new NoSuchElementException();
	}

}
