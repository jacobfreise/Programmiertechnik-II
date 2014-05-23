package assignment3;

import assignment3.SquareMatrix.InitStrategy;

public class RuntimeTestExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sizes = {1, 1, 1, 5, 5, 5, 10, 10, 10, 50, 50, 50, 100, 100, 100, 500, 500, 500, 1000, 1000, 1000};
		long[] maMultiTimes = new long[sizes.length];
		long[] doMultiTimes = new long[sizes.length];
		long[] minTimes = new long[sizes.length];
		long[] maxTimes = new long[sizes.length];
		SquareMatrix[] matrix = new SquareMatrix[sizes.length];

		for (int i = 0; i < sizes.length; i++){
			matrix[i] = new SquareMatrix(sizes[i], InitStrategy.Random);
		}
		
		long startTime;
		for (int i = 0; i < sizes.length; i++){
			startTime = java.lang.System.nanoTime();
			matrix[i].multiply(matrix[i]);
			maMultiTimes[i] = java.lang.System.nanoTime() - startTime;
		}
		
		
		for (int i = 0; i < sizes.length; i++){
			startTime = java.lang.System.nanoTime();
			matrix[i].multiply(3.0);
			doMultiTimes[i] = java.lang.System.nanoTime() - startTime;
		}
		
		for (int i = 0; i < sizes.length; i++){
			startTime = java.lang.System.nanoTime();
			matrix[i].min();
			minTimes[i] = java.lang.System.nanoTime() - startTime;
		}
		
		for (int i = 0; i < sizes.length; i++){
			startTime = java.lang.System.nanoTime();
			matrix[i].max();
			maxTimes[i] = java.lang.System.nanoTime() - startTime;
		}
		
		System.out.println("Matrixgroeße \t Sk.Multi \t M.Multi \t Minimum \t Maximum");
		
		for (int i = 0; i < sizes.length; i++){
			System.out.println(sizes[i] + "\t\t" + maMultiTimes[i] + "\t\t" + doMultiTimes[i] + "\t\t" + minTimes[i] + "\t\t" + maxTimes[i]);
		}
		
	}

}
