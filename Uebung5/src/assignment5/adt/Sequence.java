package assignment5.adt;

/**
 * Abstract data type for typed sequential (ordered) collections
 * 
 * @author toni.gruetze
 *
 * @param <T> the type of elements to be stored
 */
public interface Sequence<T> {
	/**
	 * gets the length of the sequence
	 * @return the length
	 */
	public int length();
}
