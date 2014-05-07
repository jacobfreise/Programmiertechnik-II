package assignment1;

import java.math.BigInteger;

public class Factorial {
    public static String hex(int n) {
    	if ((n < 0) || (n > 100)) {
//    		Parametercheck
			throw new IllegalArgumentException();
		}
    	
    	BigInteger result = BigInteger.valueOf(1);
    	
    	if (n == 0){
    		return "1";
    	}
    	
    	for (int i = 1; i <= n; i++) {
//    		Berechnung von (i-1)! * i
			result = result.multiply(BigInteger.valueOf(i));	
		}
    	
    	return result.toString(16);
    }
}
