package assignment2;

import java.util.Comparator;

public class Card {
	public static enum Suit {
		Clubs, Spades, Hearts, Diamonds
	}

	public static enum Rank {
		Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
	}

	private final Suit suit;
	private final Rank rank;

	public Card(Suit s, Rank r) {
		this.suit = s;
		this.rank = r;
	}

	public Suit getSuit() {
		return this.suit;
	}

	public Rank getRank() {
		return this.rank;
	}
	
	public static void bubblesort(Card[] a, Comparator<Card> c) {
	}
	
	public static void quicksort(Card[] a, Comparator<Card> c) {
	}
	
	public static void countingsort(Card[] a) {
	}
}
