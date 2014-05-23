package assignment3;

import assignment3.SquareMatrix.InitStrategy;

public class Exec {
	public static void main(String args[]) {
		int n = 4;
		// initialize the matrices
		SquareMatrix 
			a = new SquareMatrix(n, InitStrategy.Plus), 
			b = new SquareMatrix(n, InitStrategy.Minus);

		// multiply them
		SquareMatrix c = a.multiply(b);
		// print them out
		System.out.println("========== A ============");
		System.out.println(a);
		System.out.println("========== B ============");
		System.out.println(b);
		System.out.println("========== C ============");
		System.out.println(c);
	}
}
