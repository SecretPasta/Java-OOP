package equiv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Equiv<E> {

	private ArrayList<Set<E>> equivs;

	// Constructor to initialize the class
	public Equiv() {
		equivs = new ArrayList<>();
	}

	public void add(E e1, E e2) {
		Set<E> set1, set2;
		set1 = getEquivClass(e1);
		set2 = getEquivClass(e2);
		if (set1 == null && set2 == null) { // Both sets don't exist so creating and adding
			equivs.add(new HashSet<E>(Arrays.asList(e1, e2)));
			return;
		}
		if (set1 == set2) { // Checking if it's the same OBJECT, if they are then they're already in the
							// same equiv class
			return;
		}
		if (set1 != null && set2 != null) { // if they belong to the same equiv class
			set1.addAll(set2);
			equivs.remove(set2);
			return;
		}
		if (set1 == null) { // Swapping to look at only one case instead of two
			set1 = set2;
			set2 = null;
		}
		set1.addAll(Arrays.asList(e1, e2)); // Adding both cause they can't have duplicate entities
	}

	// Checking if both objects are in the same equiv class
	public boolean are(E e1, E e2) {
		if (e1.equals(e2))
			return true;
		Set<E> set1, set2;
		set1 = getEquivClass(e1);
		set2 = getEquivClass(e2);
		if (set1 == null || set2 == null)
			return false;
		return set1 == set2;
	}

	// returns the equiv class of an object, if it doesn't exist returns null
	private Set<E> getEquivClass(E e) {
		for (Set<E> set : equivs) {
			if (set.contains(e))
				return set;
		}
		return null;
	}

}
