package tree;
import java.util.Scanner;
public class ReversedWords {
	
	//returns how many times a substring appears in reversed order
	public static int checkReversed() {
		Scanner s = new Scanner(System.in); 
		String currentLine = s.next();
		int result = 0;
		Node storage = new Node();
		while(!currentLine.equals("X")) {
			if(storage.num(new StringBuilder(currentLine).reverse().toString()) > 0) {
				result++;
			}
				storage.add(currentLine);
				currentLine = s.next();
		}
		s.close();
		return result;
	}
	
}
