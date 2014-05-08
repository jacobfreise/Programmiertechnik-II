package assignment2;

public class DogTraining {
	public static int secondsToWait(int k, int[] b) {
		int[] timePerNumber = new int[findMax(b) + 1];
		
		for (int i = 0; i < timePerNumber.length; i++){
			timePerNumber[i] = -1;
		}
		
		for (int i = 0; i < b.length; i++){
			if ( (timePerNumber[b[i]] == -1) || (timePerNumber[b[i]] > findMinTime(i, b.length)) ){
				timePerNumber[b[i]] = findMinTime(i, b.length);
			}
		}
		
		int result = -1;
		
		for (int i = 0; i < k/2 - mod(k+1, 2); i++){
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
	
	private static int mod(int a, int b){
		return a/b - (a/b * b);
	}
	
	private static int findMinTime(int index, int length){
		if (index + 1 < length - index)
			return index + 1;
		
		return length - index;
	}
	
	private static int findMax(int[] a){
		int result = 1;
		for (int i = 0; i < a.length; i++){
			if (a[i] > result){
				result = a[i];
			}
		}
		return result;
	}
	
	
}
