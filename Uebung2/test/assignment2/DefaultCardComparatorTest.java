package assignment2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import assignment2.Card.Rank;
import assignment2.Card.Suit;

public class DefaultCardComparatorTest {

	@Test
	public void test() {
		DefaultCardComparator comparator = new DefaultCardComparator();
		Card card1 = new Card(Suit.Hearts, Rank.King);
		Card card2 = new Card(Suit.Spades, Rank.Two);
		assertEquals(comparator.compare(card1, card2), -1);
		assertEquals(comparator.compare(card2, card1), 1);
		Card card3 = new Card(Suit.Hearts, Rank.Ten);
		assertEquals(comparator.compare(card3, card1), 0);
	}

}
