package iterator;

import java.util.Iterator;

public class TwoArrays implements Iterable<Integer> {
	private int[] a1, a2;

	// Constructor to initialize the class
	public TwoArrays(int[] a1, int[] a2) {
		this.a1 = a1;
		this.a2 = a2;
	}

	// Inner Class for iterator
	private class iterator1 implements Iterator<Integer> {

		private int i1, i2;
		private boolean phase;

		// Constructor to initialize the inner Class
		public iterator1() {
			i1 = 0;
			i2 = 0;
			phase = false; // switch between arrays
		}

		// method to check if there's a next value in the arrays
		@Override
		public boolean hasNext() {
			if (i1 == a1.length && i2 == a2.length)
				return false;
			return true;
		}

		// method to iterate in the arrays
		@Override
		public Integer next() {
			Integer res = null;
			if (!phase) {
				if (i1 < a1.length) {
					res = a1[i1++];
				} else {
					phase = !phase;
					res = next();
					phase = !phase;
				}
			} else if (phase) {
				if (i2 < a2.length) {
					res = a2[i2++];
				} else {
					phase = !phase;
					res = next();
					phase = !phase;
				}
			}

			phase = !phase;
			return res;
		}

	}

	// Calling Iterator
	@Override
	public Iterator<Integer> iterator() {
		return new iterator1();
	}

}
