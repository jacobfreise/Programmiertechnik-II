package assignment4;

import java.util.ArrayList;

public class DivideAndConquer {
	public static void filesort(String inputFile, String outputFile, int maxLineCount) {
		//TODO 
	}
	public static <X extends Comparable<X>> void mergesort(ArrayList<X> list) {
		list = mergesortHelp(list);
		for (int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	public static <X extends Comparable<X>> ArrayList<X> mergesortHelp(ArrayList<X> list){
		if (list.size() <= 1){
			return list;
		}
		ArrayList<X> leftList = new ArrayList<X>();
		ArrayList<X> rightList = new ArrayList<X>();
		for (int i = 0; i < list.size(); i++){
			if (i < list.size()/2){
				leftList.add(list.get(i));
			} else {
				rightList.add(list.get(i));
			}
		}
		leftList = mergesortHelp(leftList);
		rightList = mergesortHelp(rightList);
		return merge(leftList, rightList);
	}
	
	public static <X extends Comparable<X>> ArrayList<X> merge(ArrayList<X> leftList, ArrayList<X> rightList){
		ArrayList<X> result = new ArrayList<X>();
		while (!leftList.isEmpty() && !rightList.isEmpty()){
			if (leftList.get(0).compareTo(rightList.get(0)) <= 0){
				result.add(leftList.get(0));
				leftList.remove(0);
			}
			else if (leftList.get(0).compareTo(rightList.get(0)) > 0){
				result.add(rightList.get(0));
				rightList.remove(0);
			}
		}
		while (!leftList.isEmpty()){
			result.add(leftList.get(0));
			leftList.remove(0);
		}
		while (!rightList.isEmpty()){
			result.add(rightList.get(0));
			rightList.remove(0);
		}
		
		return result;
	}
}
