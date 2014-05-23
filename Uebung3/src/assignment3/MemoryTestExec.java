package assignment3;

import assignment3.SquareMatrix.InitStrategy;

public class MemoryTestExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sizes = {1, 1, 1, 5, 10, 100, 500, 1500};
		long[] maMultiTimes = new long[sizes.length];
		long[] doMultiTimes = new long[sizes.length];
		long[] minTimes = new long[sizes.length];
		long[] maxTimes = new long[sizes.length];
		SquareMatrix[] matrix = new SquareMatrix[sizes.length];

		for (int i = 0; i < sizes.length; i++){
			matrix[i] = new SquareMatrix(sizes[i], InitStrategy.Random);
		}
		
		for (int i = 0; i < sizes.length; i++){
			Runtime runtime = Runtime.getRuntime();
			runtime.gc();
		    matrix[i].multiply(matrix[i]);
		    long memory = runtime.totalMemory() - runtime.freeMemory();
		    System.out.println("Used memory is bytes: " + memory);
		    System.out.println("Used memory is megabytes: "
		        + (memory)/1000000);
		}
		
		
	}

}