package assignment2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	private Card[] actual;

	@Before
	public void setUp() {
		actual = new Card[10];
		actual[0] = new Card(Card.Suit.Diamonds, Card.Rank.Ace);
		actual[1] = new Card(Card.Suit.Diamonds, Card.Rank.Eight);
		actual[2] = new Card(Card.Suit.Spades, Card.Rank.Seven);
		actual[3] = new Card(Card.Suit.Spades, Card.Rank.Three);
		actual[4] = new Card(Card.Suit.Hearts, Card.Rank.Queen);
		actual[5] = new Card(Card.Suit.Clubs, Card.Rank.Queen);
		actual[6] = new Card(Card.Suit.Clubs, Card.Rank.Seven);
		actual[7] = new Card(Card.Suit.Hearts, Card.Rank.Ace);
		actual[8] = new Card(Card.Suit.Diamonds, Card.Rank.Ace);
		actual[9] = new Card(Card.Suit.Diamonds, Card.Rank.Queen);
	}

	@Test
	public void testBubblesort() {
		String expectedString = "Clubs Seven, Clubs Queen, Diamonds Eight, Diamonds Queen, Diamonds Ace, Diamonds Ace, Hearts Queen, Hearts Ace, Spades Three, Spades Seven";
		Card.bubblesort(actual, new DefaultCardComparator());
		assertEquals(expectedString, cardsToString(actual));
	}

	@Test
	public void testQuicksort() {
		String expectedString = "Clubs Seven, Clubs Queen, Diamonds Eight, Diamonds Queen, Diamonds Ace, Diamonds Ace, Hearts Queen, Hearts Ace, Spades Three, Spades Seven";
		Card.quicksort(actual, new DefaultCardComparator());
		assertEquals(expectedString, cardsToString(actual));
	}

	@Test
	public void testCountingsort() {
		String expectedString = "Clubs Seven, Clubs Queen, Diamonds Eight, Diamonds Queen, Diamonds Ace, Diamonds Ace, Hearts Queen, Hearts Ace, Spades Three, Spades Seven";
		Card.countingsort(actual);
		assertEquals(expectedString, cardsToString(actual));
	}

	public String cardsToString(Card[] cards) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < cards.length; i++) {
			if (i > 0) {
				result.append(", ");
			}
			result.append(cards[i].getSuit().name()).append(' ')
					.append(cards[i].getRank().name());
		}
		return result.toString();
	}
}
