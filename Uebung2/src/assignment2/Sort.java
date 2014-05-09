package assignment2;


public class Sort {
	public static void bubblesort(int[] a) {
		/*
		 * swapped merkt sich, ob eine Vertauschung stattgefunden hat, wenn nicht => vorzeitiger Abbruch
		 * in der zweiten for-schleife kann man -i rechnen, weil bei jeder Durchlauf ein weiteres Element ganz hinten auf jeden Fall sortiert ist
		 */
		boolean swapped = false;
		for (int i = 0; i < a.length; i++){
			swapped = false;
			for (int j = 0; j < a.length-1-i; j++){
				if (a[j] > a[j+1]){
					Sort.swap(a, j, j+1);
					swapped = true;
				}
			}
			if (!swapped)
				return;
		}
	}
	
	private static void swap(int[] a, int j, int i) {
		
		int help = a[j];
		a[j] = a[i];
		a[i] = help;
		
	}

	public static void quicksort(int[] a) {
		/*
		 * initialer Aufruf der Hilfsfunktion mit komplettem Array
		 */
		quicksortHelp(a, 0, a.length-1);
	}
	
	private static void quicksortHelp(int[] a, int left, int right) {
		/*
		 * Zerteile das Array, bringe die kleineren Elemente als pivot in die linke Seite und die größeren als pivot
		 * in die rechte Seite und sortiere beide Stücke des Arrays
		 */
		if (left < right){
			int pivot = divide(a, left, right);
			quicksortHelp(a, left, pivot -1);
			quicksortHelp(a, pivot+1, right);
			
		}
	}

	private static int divide(int[] a, int left, int right) {
		/*
		 * wählt das rechteste Element als Pivot-Element
		 * durchsucht den array von links und rechts nach zwei Elementen, die größer bzw. kleiner sind als pivot und vertauscht sie.
		 * bringt pivot an die richtige Stelle
		 * returns index des pivots
		 */
		int i = left;
		int j = right - 1;
		int pivot = a[right];
		while (i < j){
			while ((a[i] <= pivot) && (i < right)){
				i++;
			}
			
			while ((a[j] >= pivot) && (j > left)){
				j--;
			}
			
			if (i < j)
				Sort.swap(a, i, j);
		}
		if (a[i] > pivot){
			Sort.swap(a, i, right);
		}
		
		return i;
	}
	
	private static int findMax(int[] a){
		/*
		 * Hilfsfunktion, die das Maximum in a findet
		 */
		int result = 0;
		for (int i = 0; i < a.length; i++){
			if (a[i] > result){
				result = a[i];
			}
		}
		return result;
	}

	public static void countingsort(int[] a) {
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
			adress[a[i]] = adress[a[i]] + 1;
		}
		
		for (int i = 1; i <= max; i++){
			adress[i] += adress[i-1];
		}
		
		int[] result = new int[a.length];
		for (int i = a.length - 1; i >= 0; i--){
			result[adress[a[i]]-1] = a[i];
			adress[a[i]] = adress[a[i]] - 1;
		}
		
		for (int i = 0; i < result.length; i++){
			a[i] = result[i];
		}
	}
}
