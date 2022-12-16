package cards;

import java.util.ArrayList; // Adding ArrayList as it has plenty of built in methods that make managing the deck array a lot easier
import java.util.Comparator;// Adding Comparator to create a custom way of comparing the Cards as we have two parameters to compare to sort the deck

public class Deck {

	private ArrayList<Card> deck; // creating ArrayList of type Card

	public Deck(int num) { // Constructor for a new deck
		deck = new ArrayList<>(num * 4); // calling ArrayList Constructor
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 4; j++) {
				deck.add(new Card(i, j)); // Nested for to fill the Deck with Cards in ascending order

			}
		}
	}

	public Deck(Deck from, int num) { // Constructor for a new deck with taking cards from an existing deck
		deck = new ArrayList<>(num * 4); // calling ArrayList Constructor
		int cardstoadd = from.getNumCards() < num ? from.getNumCards() : num; // Checking if there are less cards in
																				// "from" then num
		for (int i = 0; i < cardstoadd; i++) {
			deck.add(from.takeOne());// using takeOne method to draw a card from the end of "from" and add it to the
										// new deck
		}

	}

	public Deck(Deck first, Deck second) { // Constructor to create a new deck by mixing two decks
		deck = new ArrayList<>(first.getNumCards() + second.getNumCards()); // calling ArrayList Constructor to the size
																			// of the two decks
		while (first.getNumCards() > 0 || second.getNumCards() > 0) { // While at least one of the decks has cards the
																		// loop will continue
			if (first.getNumCards() > 0) // if first deck has cards left
				deck.add(first.takeOne()); // takeOne from the end of first and put it in the new deck
			if (second.getNumCards() > 0)// if second deck has cards left
				deck.add(second.takeOne());// takeOne from the end of second and put it in the new deck
		}
	}

	public int getNumCards() { // method to return number of cards
		return deck.size(); // built in method of ArrayList
	}

	public Card takeOne() { // method to take one card from the end of the deck
		if (deck.isEmpty()) // built in method of ArrayList
			return null;
		return deck.remove(getNumCards() - 1); // built in method of ArrayList which returns and removes the indexed
												// cell (in our case the last index)
	}

	public String toString() { // method to crate a formated string of all the cards in the Deck using
								// StringBuilder
		StringBuilder result = new StringBuilder("["); // creating a new string "result" of type "StringBuilder" with
														// the first char being opening bracket
		for (int i = 0; i < (deck.size() - 1); i++) // adding all the cards but the last one
		{
			result.append(deck.get(i).toString() + ", "); // adding each card using append which built into
															// StringBuidler
		}
		result.append(deck.get(deck.size() - 1) + "]");// Adding last card and closing bracket
		return result.toString();
	}

	public void sort() { // A method to sort the deck using ArrayLists's sorting method but also using
							// Comparator to allow us to
		deck.sort(new Comparator<Card>() { // create a custom way of comparing the Cards as they need to be sorted by
											// num and suit. Creating a Comparator
			@Override // of type "Card" that will use compareTo method which we already wrote to
						// compare and sort the deck array.
			public int compare(Card card1, Card card2) {
				return card1.compareTo(card2);
			}
		});

	}
}
