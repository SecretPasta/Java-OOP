package tree;

public class Node {
	
	private int count;
	private Node[] children;
	//Constructor to create array of English characters and count to 0
	public Node () {
		count = 0;
		children = new Node[26];
	}
	//returning the number of time a string appears
	public int num(String s) {
		if(s.length() == 0)
			return this.count;
		else {
			char letter = s.charAt(0);
			int index = letter - 'a';
			if(children[index] == null)
				return 0;
			return children[index].num(s.substring(1));
		}
	}
	//adding a string to the tree
	public void add(String s) {
		if(s.length() == 0) {
			this.count++;
			return;
		}
		char letter = s.charAt(0);
		int index = letter - 'a';
		if(children[index] == null) {
			children[index] = new Node();
		}
		children[index].add(s.substring(1));
	}
	
}
