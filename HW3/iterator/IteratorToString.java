package iterator;
//Class to build a string from the sequence and return it
public class IteratorToString {
	public static String toString(MyIterator it) {
		StringBuilder str = new StringBuilder("[");
		while(it.hasNext()) {
			str.append(it.next() + " ");
		}
		//str.replace(str.length(), str.length() - 1 , "]");
		str.deleteCharAt(str.length()-1);
		str.append("]");
		return str.toString();
	}
}
