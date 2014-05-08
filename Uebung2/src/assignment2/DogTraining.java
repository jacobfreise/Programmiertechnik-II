package assignment2;

/* 
 * 1) Der Algorithmus verwendet Techniken von Countingsort. Es wird zunächst ein Hilfsarray erzeugt, das die niedrigsten Zeiten für die Werte von
 * b speichert. 
 * 2) Der Hilfsarray wird dann nach validen Kombinationen für k durchsucht, hierbei muss man nur die Indizes 1 ... k/2 - (k+1) % 2 durchsuchen, weil sich 
 * die restlichen Kombinationen durch das Kommutativgesetz der Addition ergeben. Man muss allerdings den Fall ausschließen, dass i und k-i gleich sind,
 * deswegen der Modulo Teil.
 * Es darf nur result überschrieben werden, wenn i und k-i in b vorkommen, was gleichbedeutend ist mit timePerNumber[i] und timePerNumber[k-i] sind
 * ungleich -1
 * Die Variable result hält das momentan niedrigste Ergebnis und wird mit -1 initialisiert, weil dies der Standardwert der Ausgabe ist,
 * wenn keine gültige Kombination gefunden wird.
 * 
 */

public class DogTraining {
	public static int secondsToWait(int k, int[] b) {
		//1)
		int[] timePerNumber = new int[k];
		
		//Standardwert -1
		for (int i = 0; i < timePerNumber.length; i++){
			timePerNumber[i] = -1;
		}
		
		//Befüllen des Hilfsarrays mit den Zeiten
		for (int i = 0; i < b.length; i++){
			if (b[i] < k){
				if ( (timePerNumber[b[i]] == -1) || (timePerNumber[b[i]] > findMinTime(i, b.length)) ){
					timePerNumber[b[i]] = findMinTime(i, b.length);
				}
			}
		}
		
		// Ende 1)
		
		//2)
		int result = -1;
		
		for (int i = 1; i < k/2 - ((k+1) % 2); i++){
			//valide Kombination vorhanden? => überschreibe result mit der niedrigeren Zeit
			if ((timePerNumber[i] != -1) && (timePerNumber[k-i] != -1)){
				if (result == -1){
					result = Math.max(timePerNumber[i], timePerNumber[k-i]);
				}
				if (result > Math.max(timePerNumber[i], timePerNumber[k-i])){
					result = Math.max(timePerNumber[i], timePerNumber[k-i]);
				}
			}
		}
		
		
		return result;
	}
	
	private static int findMinTime(int index, int length){
		if (index + 1 < length - index)
			return index + 1;
		
		return length - index;
	}
}
