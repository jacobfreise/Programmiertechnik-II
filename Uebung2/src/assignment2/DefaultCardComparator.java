package assignment2;

import java.util.Comparator;

public class DefaultCardComparator implements Comparator<Card> {
	@Override
	public int compare(Card card1, Card card2) {
		return decipherValue(card1) - decipherValue(card2);
	}
	
	public static int decipherValue(Card card){
		int result = 0;
		switch (card.getSuit()) {
		case Clubs:
			result = result + 100;
			break;
		case Diamonds:
			result = result + 200;
			break;
		case Hearts:
			result = result + 300;
			break;
		case Spades:
			result = result + 400;
			break;
		default:
			break;
		}
		
		switch (card.getRank()) {
		case Ace:
			result += 11;
			break;
		case King:
			result += 10;
			break;
		case Queen:
			result += 10;
			break;
		case Jack:
			result += 10;
			break;
		case Ten:
			result += 10;
			break;
		case Nine:
			result += 9;
			break;
		case Eight:
			result += 8;
			break;
		case Seven:
			result += 7;
			break;
		case Six:
			result += 6;
			break;
		case Five:
			result += 5;
			break;
		case Four:
			result += 4;
			break;
		case Three:
			result += 3;
			break;
		case Two:
			result += 2;
			break;
		}
		
		return result;
	}
	
}
