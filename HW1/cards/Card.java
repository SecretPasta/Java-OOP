package cards;

public class Card {

	private int num, suit;

	public Card(int num, int suit) { // Constructor for Card
		this.num = num;
		this.suit = suit;
	}

	public int getNum() { // method to return card value
		return num;
	}

	public int getSuit() {// method to return card suit
		return suit;
	}

	public String toString() { // method to return formated string for each type of card
		String result = "";
		switch (suit) {

		case 0:
			result += num + "C";
			break;
		case 1:
			result += num + "D";
			break;
		case 2:
			result += num + "H";
			break;
		case 3:
			result += num + "S";
			break;
		}

		return result;
	}

	public int compareTo(Card other) {// method to find out which card is greater
		int res = 0;
		int val1, val2; // creating a value for each card
		val1 = (this.getNum() * 10) + this.getSuit(); // Multiplying the card num by 10 and adding the suit
		val2 = (other.getNum() * 10) + other.getSuit();// so that if card value is the same the suit will decide which
														// is greater
		if (val1 == val2) // Example: 9H and 9S -> 9H is 90+2 and 9S is 90+3 -> 92<93
			res = 0;
		else if (val1 > val2)
			res = 1;
		else
			res = -1;

		return res;
	}

}
