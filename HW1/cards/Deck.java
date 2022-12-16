package cards;

public class Deck {

	private Card[] deck;

	public Deck(int num) { // Constructor for a new deck
		deck = new Card[num * 4];
		int x = 0; // index for the array
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 4; j++, x++) {
				deck[x] = new Card(i, j); // Nested for to fill the Deck with Cards in ascending order
			}
		}
	}

	public Deck(Deck from, int num) { // Constructor for a new deck with taking cards from an existing deck
		int cardstoadd = from.getNumCards() < num ? from.getNumCards() : num; // Checking if there are less cards in
																				// "from" then num
		deck = new Card[cardstoadd]; //
		for (int i = 0; i < cardstoadd; i++) {
			deck[i] = from.takeOne();// using takeOne method to draw a card from the end of "from" and add it to the
		}

	}

	public Deck(Deck first, Deck second) { // Constructor to create a new deck by mixing two decks
		deck = new Card[first.getNumCards() + second.getNumCards()]; //
		int index = 0; // of the two decks
		while (first.getNumCards() > 0 || second.getNumCards() > 0) { // While at least one of the decks has cards the
																		// loop will continue
			if (first.getNumCards() > 0) // if first deck has cards left
				deck[index++] = first.takeOne(); // takeOne from the end of first and put it in the new deck
			if (second.getNumCards() > 0)// if second deck has cards left
				deck[index++] = second.takeOne();// takeOne from the end of second and put it in the new deck
		}
	}

	public int getNumCards() { // method to return number of cards
		return deck.length; //
	}

	public Card takeOne() { // method to take one card from the end of the deck
		if (deck.length == 0) // built in method of ArrayList
			return null;

		Card[] copy = new Card[deck.length - 1];
		for (int i = 0; i < deck.length - 1; i++) {
			copy[i] = deck[i];
		}
		Card one = deck[deck.length - 1];
		deck = copy;
		return one;

	}

	public String toString() {

		String result = "[";
		for (int i = 0; i < (deck.length - 1); i++) {
			result += deck[i] + ", ";
		}
		result += deck[deck.length - 1] + "]";
		return result;
	}

	public void sort() {
		Card temp; // Bubble sort using compareTo Method
		int size = deck.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (deck[j].compareTo(deck[j + 1]) == 1) {
					temp = deck[j];
					deck[j] = deck[j + 1];
					deck[j + 1] = temp;
				}
			}
		}

	}
}
