package assignment4;

import java.util.ArrayList;

public class TripToReno {

	public static int[] getStops(int d, int z, int[] t) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int fuel = d;
		int dist = 0;
		for (int i = 0; i < t.length; i++){
			dist += t[i];
			if (fuel < t[i]){
				fuel = d - t[i];
				list.add(i-1);
			}
			else {
				fuel -= t[i];
			}
		}
		if (fuel < z - dist){
			list.add(t.length-1);
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}
	
	public static int timeCompare(int kmhProf, int kmhBike, int d, int z, int[] t) {
		int numberOfStops = getStops(d, z, t).length;
		double timeProf = (z/kmhProf) + (numberOfStops*0.25);
		double timeBike = z/kmhBike;
		System.out.println(numberOfStops + " " + timeProf + " " + timeBike);
		if (timeProf < timeBike)
			return 1;
		if (timeProf == timeBike)
			return 0;
		return -1;
	}
}
