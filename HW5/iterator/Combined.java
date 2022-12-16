package iterator;

import java.util.Iterator;

public class Combined<E> implements Iterable<E> {
	private Iterable<E> first, second;

	// Constructor to initialize the class
	public Combined(Iterable<E> first, Iterable<E> second) {
		this.first = first;
		this.second = second;
	}

	// inner Class to iterate
	private class iterator1 implements Iterator<E> {

		private Iterator<E> it1, it2;
		private boolean phase;

		// Constructor to initialize the class
		public iterator1() {
			it1 = first.iterator();
			it2 = second.iterator();
			phase = false;
		}

		// Checking if there's a next value
		@Override
		public boolean hasNext() {
			if (it1.hasNext() || it2.hasNext())
				return true;
			return false;
		}

		// Iterating and switching between the two List/Arrays
		@Override
		public E next() {
			E res = null;
			if (!phase) {
				if (it1.hasNext()) {
					res = it1.next();
				} else {
					phase = !phase;
					res = next();
					phase = !phase;
				}
			} else if (phase) {
				if (it2.hasNext()) {
					res = it2.next();
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
	//Calling iterator
	@Override
	public Iterator<E> iterator() {
		return new iterator1();
	}
}
