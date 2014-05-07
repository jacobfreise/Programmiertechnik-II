package assignment1;


public class LadderSteps {
    public static long combinationCount(int n) {
//    	Problem entspricht Fib(n+1)
    	return LadderSteps.iterative(n+1);
    }
    
    
//  Hilfsfunktion, die Fibonacci berechnet
    private static long iterative(long n) {
    	if (n <= 0){									
    		throw new IllegalArgumentException();
    	}
    	
    	long h1 = 1;
    	long h2 = 1;
    	
    	for (int i = 2; i < n; i++){							
    		long help = h1 + h2;
    		h1 = h2;
    		h2 = help;
    	}
        
        return h2;
    	
    }
}
