package assignment5;

public class Molehill {
	public static int[] connections(boolean[] cellHashHill, int[][] passages) {
		int[] r = new int[2];
		r[0] = getCountVentilated(cellHashHill);
		r[1] = getCountCellPairsVentilated(cellHashHill, passages);
		return null;
	}
	
	private static int getCountVentilated(boolean[] cellHashHill) {
		if (cellHashHill == null) {
			return -1;
		}
		int r = 0;
		for (boolean c : cellHashHill) {
			if (c)
				r++;
		}
		return r;
	}
	
	private static int getCountCellPairsVentilated(boolean[] cellHashHill, int[][] passages) {
		if (cellHashHill == null || passages == null) {
			return -1;
		}
		int r = 0;
		//TODO for Jaco
		return r;
	}
}
