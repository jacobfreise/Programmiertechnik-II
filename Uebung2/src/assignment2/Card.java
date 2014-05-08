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
		/*
		 * swapped merkt sich, ob eine Vertauschung stattgefunden hat, wenn nicht => vorzeitiger Abbruch
		 * in der zweiten for-schleife kann man -i rechnen, weil bei jeder Durchlauf ein weiteres Element ganz hinten auf jeden Fall sortiert ist
		 */
		boolean swapped = false;
		for (int i = 0; i < a.length; i++){
			swapped = false;
			for (int j = 0; j < a.length-1-i; j++){
				if (c.compare(a[j], a[j+1]) > 0){
					swap(a, j, j+1);
					swapped = true;
				}
			}
			if (!swapped)
				return;
		}
	}
	
	private static void swap(Card[] a, int j, int i) {
		Card help = a[j];
		a[j] = a[i];
		a[i] = help;
		
	}
	
	public static void quicksort(Card[] a, Comparator<Card> c) {
		/*
		 * initialer Aufruf der Hilfsfunktion mit komplettem Array
		 */
		quicksortHelp(a, 0, a.length-1, c);
	}
	
	private static void quicksortHelp(Card[] a, int left, int right, Comparator<Card> c) {
		/*
		 * Zerteile das Array, bringe die kleineren Elemente als pivot in die linke Seite und die größeren als pivot
		 * in die rechte Seite und sortiere beide Stücke des Arrays
		 */
		if (left < right){
			int pivot = divide(a, left, right, c);
			quicksortHelp(a, left, pivot -1, c);
			quicksortHelp(a, pivot+1, right, c);
		}
	}
	
	private static int divide(Card[] a, int left, int right, Comparator<Card> c) {
		/*
		 * wählt das rechteste Element als Pivot-Element
		 * durchsucht den array von links und rechts nach zwei Elementen, die größer bzw. kleiner sind als pivot und vertauscht sie.
		 * bringt pivot an die richtige Stelle
		 * returns index des pivots
		 */
		int i = left;
		int j = right - 1;
		Card pivot = a[right];
		while (i < j){
			while ((c.compare(a[i], pivot) <= 0) && (i < right)){
				i++;
			}
			
			while ((c.compare(a[j], pivot) >= 0) && (j > left)){
				j--;
			}
			
			if (i < j)
				Card.swap(a, i, j);
		}
		if ((c.compare(a[i], pivot) > 0)){
			Card.swap(a, i, right);
		}
		
		return i;
	}
	
	public static void countingsort(Card[] a) {
		/*
		 * erzeugt das Hilfsarray, mit max+1 Elementen, also den Indizes 0..max, mit dem die Adressen der Elemente berechnet werden.
		 * Füllt es mit Nullen auf
		 * Fülle das Array mit der Anzahl der Elemente von a
		 * Errechne durch Aufsummieren aller vorherigen Anzahlen die Adressen der Elemente
		 * Erzeuge das Zielarray und trage die Elemente an die richtige Stelle ein
		 * Übertrage die Elemente vom Zielarray in den Ergebnisarray
		 */
		int max = findMax(a);
		int[] adress = new int[max+1];
		
		for (int i = 0; i < adress.length; i++){
			adress[i] = 0;
		}
		
		for (int i = 0; i < a.length; i++){
			adress[DefaultCardComparator.decipherValue(a[i])] = adress[DefaultCardComparator.decipherValue(a[i])] + 1;
		}
		
		for (int i = 1; i <= max; i++){
			adress[i] += adress[i-1];
		}
		
		Card[] result = new Card[a.length];
		for (int i = a.length - 1; i >= 0; i--){
			result[adress[DefaultCardComparator.decipherValue(a[i])]-1] = a[i];
			adress[DefaultCardComparator.decipherValue(a[i])] = adress[DefaultCardComparator.decipherValue(a[i])] - 1;
		}
		
		for (int i = 0; i < result.length; i++){
			a[i] = result[i];
		}
	}

	private static int findMax(Card[] a) {
		/*
		 * Hilfsfunktion, die das Maximum der Kartenwerte in a findet
		 */
		int result = 0;
		for (int i = 0; i < a.length; i++){
			if (DefaultCardComparator.decipherValue(a[i]) > result){
				result = DefaultCardComparator.decipherValue(a[i]);
			}
		}
		return result;
	}
}
