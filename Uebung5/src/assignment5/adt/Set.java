package assignment5.adt;

/**
 * Abstract data type for a set storing elements with no repeated values (<code>x.compareTo(y)!=0</code>)
 * 
 * @author toni.gruetze
 * 
 * @param <T> the type of elements to be stored (have to be instances of {@link Comparable})
 */
public interface Set<T extends Comparable<T>> {
	/**
	 * adds the element to this set, if it is not present already
	 * @param element the element to be added
	 */
	public void add(T element);
	/**
	 * Removes the element from this set, if it is present
	 * @param element the element to be removed
	 */
	public void remove(T element);
	/**
	 * Checks whether the element is present in this set
	 * @param element the element to be checked
	 * @return <code>true</code> iff <code>y</code> is part of this instance and <code>element.compareTo(y)==0</code>
	 */
	public boolean contains(T element);
	/**
	 * gets the number of elements in the set
	 * @return the size
	 */
	public int size();
}
