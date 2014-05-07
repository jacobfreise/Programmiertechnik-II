package assignment1; 

public class Fibonacci {
	
    public static long iterative(long n) {
    	if (n <= 0 || n > 50){									//Parametercheck für ungültige n
    		throw new IllegalArgumentException();
    	}
    	
    	long h1 = 1;
    	long h2 = 1;
    	
    	for (int i = 2; i < n; i++){							//iterative Berechnung der n-ten Fib-Zahl
    		long help = h1 + h2;
    		h1 = h2;
    		h2 = help;
    	}
        
        return h2;
    	
    }
    
    public static long recursive(long n) {
    	if (n <= 0L || n > 50L){									//Parametercheck für ungültige n
    		throw new IllegalArgumentException();
    	}
    	
    	if (n <= 2L){											//Abbruchkriterium
    		return 1L;
    	}
    	
    	return Fibonacci.recursive(n - 1L) + Fibonacci.recursive(n - 2L);		//Rekursionsaufruf
    }
}
