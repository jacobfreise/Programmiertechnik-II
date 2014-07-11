package assignment6;

import assignment6.hashing.HashFunction;

/**
 * class for storing String in a blooms filter
 * @author toni.gruetze
 *
 */
public class StringBloomsfilter {
	private final boolean[] bits;
	private final HashFunction<String>[] hashFunctions;
	private int numberOfElements;
	/**
	 * creates a new BloomsFilter for strings, based on the specified hash functions
	 * @param m size of the bit array
	 * @param hashFunctions the hash functions
	 */
	@SafeVarargs
	public StringBloomsfilter(int m, HashFunction<String>... hashFunctions) {
		if(m<1 || hashFunctions==null || hashFunctions.length<=0) {
			throw new IllegalArgumentException();
		}
		this.hashFunctions = hashFunctions;
		bits = new boolean[m];
		numberOfElements = 0;
	}
	/**
	 * adds v to the filter
	 * @param v the element to add
	 */
	public void add(String v) {
		for (int i = 0; i < hashFunctions.length; i++){
			bits[hashFunctions[i].hash(v)%bits.length] = true;
		}
		numberOfElements++;
	}
	/**
	 * checks if w might be element of this collection
	 * @param w the element to be checked
	 */
	public boolean mightContain(String w) {
		for (int i = 0; i < hashFunctions.length; i++){
			//if 1 test fails, it is definitely not in the filter
			if (!bits[hashFunctions[i].hash(w)%bits.length]){
				return false;
			}
		}
		//if all tests pass, it might be in the filter
		return true;
	}
	/**
	 * gets the number of strings added to the filter
	 * @return the number of string elements n
	 */
	public int elementCount() {
		return numberOfElements;
	}
	/**
	 * gets the estimated false positive probability of this filter
	 * @return the probability for false positives
	 */
	public double probFP() {
		double probability = 1d-1d/bits.length;
		double probability2 = probability;
		for (int i = 0; i < hashFunctions.length*numberOfElements; i++){
			probability2 *= probability;
		}
		probability = 1-probability2;
		probability2 = probability;
		for (int i = 0; i < hashFunctions.length; i++){
			probability *= probability2;
		}
		return probability;
	}
}
