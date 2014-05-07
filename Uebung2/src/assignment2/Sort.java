package assignment2;


public class Sort {
	public static void bubblesort(int[] a) {
		boolean swapped = false;
		for (int i = 0; i < a.length; i++){
			swapped = false;
			for (int j = 0; j < a.length-1; j++){
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
		quicksortHelp(a, 0, a.length-1);
	}
	
	private static void quicksortHelp(int[] a, int left, int right) {
		if (left < right){
			int pivot = divide(a, left, right);
			quicksortHelp(a, left, pivot -1);
			quicksortHelp(a, pivot+1, right);
			
		}
	}

	private static int divide(int[] a, int left, int right) {
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

	public static void countingsort(int[] a) {
	}
}
