package assignment4;

import java.util.ArrayList;

public class TripToReno {

	public static int[] getStops(int d, int z, int[] t) {
		ArrayList<Integer> result = new ArrayList<Integer>();
        int capacity = d;
        int waycount = 0;
        int count;
        for(count=0;count<t.length-1;count++){
            d=d-t[count];
            if(d-t[count+1]<0){
                result.add(count);
                waycount+= capacity-d;
                d= capacity;
            }
        }
        count++;
        if((z-waycount)>d){
            result.add(count);
        }
        
        //int[] result_final = new int[result.size()];
        //result_final= result.toArray();
        return ListToIntArray(result);
        //return result.toArray();
    }

	public static int[] ListToIntArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        
        for (int i = 0; i < array.length; i++)
            array[i] = list.get(i).intValue();
        
        return array;
    }
	
	public static int timeCompare(int kmhProf, int kmhBike, int d, int z, int[] t) {
        int[] stops = getStops(d,z,t);
        float timeProf = (float) z/kmhProf;
        float timeBike = (float) z/kmhBike;
		if(timeProf*60+stops.length*15 > timeBike*60){
            return -1;
        }
        else{
            if(timeProf*60+stops.length*15 < timeBike*60){
                return 1;
            }
            else{
                return 0;
            }
        }
	}
    
    
    
}
