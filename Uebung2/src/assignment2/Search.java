package assignment2;

import java.util.ArrayList;

public class Search {
	public static int[] findUnsorted(int x, int[] a) {
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
		ArrayList<Integer> resultList = new ArrayList<Integer>();
//		for (int i = 0; i < a.length; i++){
//			if (x == a[i]){
//				resultList.add(i);
//			} GIT SEARCH DEVELOP
//			if (x < a[i]){
//				break;
//			}
//		}
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
