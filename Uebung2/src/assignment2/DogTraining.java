package assignment2;


/* 
 * 1) Der Algorithmus verwendet Techniken von Countingsort. Es wird zunächst ein Hilfsarray erzeugt, das die niedrigsten Zeiten für die Werte von
 * b speichert. 
 * 2) Der Hilfsarray wird dann nach validen Kombinationen für k durchsucht, hierbei muss man nur die Indizes 1 ... k/2 - (k+1) % 2 durchsuchen, weil sich 
 * die restlichen Kombinationen durch das Kommutativgesetz der Addition ergeben. Man muss allerdings den Fall ausschließen, dass i und k-i gleich sind,
 * deswegen der Modulo Teil. Dabei tritt der Spezialfall k = 3 auf, der in der Hilfsfunktion mod behandelt wird.
 * Es darf nur result überschrieben werden, wenn i und k-i in b vorkommen, was gleichbedeutend ist mit timePerNumber[i] und timePerNumber[k-i] sind
 * ungleich -1
 * Die Variable result hält das momentan niedrigste Ergebnis und wird mit -1 initialisiert, weil dies der Standardwert der Ausgabe ist,
 * wenn keine gültige Kombination gefunden wird.
 * 
 */

public class DogTraining {
	
	public static int secondsToWait(int k, int[] b) {
		//Parameterchecks
		if(b.length>500000) throw new IllegalArgumentException("Maximale Arraygröße von 500.000 überschritten");
		if(k > 1000000) throw new IllegalArgumentException("Maximales k von 1.000.000 überschritten");
		if(b.length<2) throw new IllegalArgumentException("Minimale Arraygröße von 2 unterschritten");
		
		//1)
		int[] timePerNumber = new int[k];
		
		//Standardwert -1
		for (int i = 0; i < timePerNumber.length; i++){
			timePerNumber[i] = -1;
		}
		
		//Befüllen des Hilfsarrays mit den Zeiten
		for (int i = 0; i < b.length; i++){
			/*Parametercheck */
			if(b[i] > 1000000) throw new IllegalArgumentException("Mindestens ein b[n] ist größer als 1.000.000");
			else if(b[i] <= 0) throw new IllegalArgumentException("Mindestens ein b[n] ist kleiner als 1");
			/*               */
			if (b[i] < k){
				if ( (timePerNumber[b[i]] == -1) || (timePerNumber[b[i]] > findMinTime(i, b.length)) ){
					timePerNumber[b[i]] = findMinTime(i, b.length);
				}
			}
		}
		
		// Ende 1)
		
		//2)
		int result = -1;
			
		for (int i = 1; (i <= k/2 - (mod(k, 2))); i++){
			//valide Kombination vorhanden? => überschreibe result mit der niedrigeren Zeit
			if ((timePerNumber[i] != -1) && (timePerNumber[k-i] != -1)){
				if (result == -1 || result > Math.max(timePerNumber[i], timePerNumber[k-i])){
					result = Math.max(timePerNumber[i], timePerNumber[k-i]);
				}
			}
		}
		
		
		return result;
	}
	
	private static int mod(int k, int i) {
		if (k == 3){
			return 0;
		}
		
		return (k+1) % i;
	}

	private static int findMinTime(int index, int length){
		if (index + 1 < length - index)
			return index + 1;
		
		return length - index;
	}
}
