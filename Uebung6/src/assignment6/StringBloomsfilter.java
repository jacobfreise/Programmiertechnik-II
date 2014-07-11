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
	}
	/**
	 * adds v to the filter
	 * @param v the element to add
	 */
	public void add(String v) {
		// TODO implement
	}
	/**
	 * checks if w might be element of this collection
	 * @param w the element to be checked
	 */
	public boolean mightContain(String w) {
		// TODO implement
		return false;
	}
	/**
	 * gets the number of strings added to the filter
	 * @return the number of string elements n
	 */
	public int elementCount() {
		// TODO implement
		return 0;
	}
	/**
	 * gets the estimated false positive probability of this filter
	 * @return the probability for false positives
	 */
	public double probFP() {
		// TODO implement
		return 0D;
	}
}
