package assignment2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import assignment2.Card.Rank;
import assignment2.Card.Suit;

public class DefaultCardComparatorTest {

	@Test
	public void test() {
		DefaultCardComparator comparator = new DefaultCardComparator();
		Card card1 = new Card(Suit.Hearts, Rank.King);
		Card card2 = new Card(Suit.Spades, Rank.Two);
		assertTrue(comparator.compare(card1, card2) < 0);
		assertTrue(comparator.compare(card2, card1) > 0);
		Card card3 = new Card(Suit.Hearts, Rank.Ten);
		assertTrue(comparator.compare(card3, card1) == 0);
	}

}
