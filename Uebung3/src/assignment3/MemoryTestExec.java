package assignment3;

import assignment3.SquareMatrix.InitStrategy;

public class MemoryTestExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sizes = {1, 1, 1, 5, 10, 100, 500, 1500};
		long[] maMultiSpace = new long[sizes.length];
		long[] doMultiSpace = new long[sizes.length];
		long[] minSpace = new long[sizes.length];
		long[] maxSpace = new long[sizes.length];
		SquareMatrix[] matrix = new SquareMatrix[sizes.length];

		for (int i = 0; i < sizes.length; i++){
			matrix[i] = new SquareMatrix(sizes[i], InitStrategy.Random);
		}
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		long otherMem = runtime.totalMemory() - runtime.freeMemory();
		
		for (int i = 0; i < sizes.length; i++){
			runtime.gc();
		    matrix[i].multiply(matrix[i]);
		    long memory = runtime.totalMemory() - runtime.freeMemory() - otherMem;
		    System.out.println("Used memory is bytes: " + memory);
		    System.out.println("Used memory is megabytes: "
		        + (float) (memory)/1000000);
		}
		
		
	}

}