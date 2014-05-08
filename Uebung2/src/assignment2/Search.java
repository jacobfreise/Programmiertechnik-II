package assignment2;

import java.util.ArrayList;

public class Search {
	public static int[] findUnsorted(int x, int[] a) {
		/*
		 * die Indizes jedes Vorkommens von x werden in einer ArrayList gespeichert. Kein Array, da die Größe des Arrays nicht im Vorhinein bekannt ist.
		 * Die Elemente der ArrayList werden dann in den Ergebnisarray übertragen
		 */
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++){
			if (x == a[i]){
				resultList.add(i);
			}
		}
		int[] result = new int[resultList.size()];
		for (int i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i);
		}
		return result;
	}
	
	public static int[] findSorted(int x, int[] a) {
		/*
		 * der Array wird durchsucht, bis man bei x angekommen ist.
		 * Alle Vorkommen von x werden in eine ArrayList eingetragen. Die Schleife bricht ab, sobald man das erste mal an einem Element > x ankommt.
		 * Die ArrayList wird dann in den Ergebnisarray umgewandelt
		 */
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		int i = 0;
		while (x > a[i]){
			i++;
		}
		while (x == a[i]){
			resultList.add(i);
			i++;
		}

		int[] result = new int[resultList.size()];
		for (i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i);
		}
		return result;
	}
}
