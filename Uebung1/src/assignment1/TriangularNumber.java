package assignment1;

public class TriangularNumber {
    public static String hex(int n) {
        
    	if (n <= 0){
    		throw new IllegalArgumentException();
    	}
    	
    	int result = (n*(n+1))/2;
        
        return Integer.toHexString(result);
        
    }
}
