package assignment6.hashing;

/**
 * The abstract data type for a hashing function
 * @author toni.gruetze
 *
 * @param <T> the data type to be hashed
 */
public interface HashFunction<T> {
	/**
	 * gets the hash value for the input
	 * @param input the input to be hased
	 * @return the hash value
	 */
	public int hash(T input);
}
