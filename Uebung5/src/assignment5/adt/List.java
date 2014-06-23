package assignment5.adt;

import java.util.Iterator;

/**
 * Abstract data type allowing random access operations
 * 
 * @author toni.gruetze
 * 
 * @param <T> the type of elements to be stored
 */
public interface List<T> extends Sequence<T> {
	/**
	 * retrieve the element at a particular index
	 * @param i the index
	 * @return the element
	 */
	public T get(int index);
	/**
	 * change the element at a particular index to a different value (i.e., without affecting any other elements)
	 * @param index the index
	 * @param item the new element
	 * @return the old (previous) element
	 */
	public T change(int index, T item);
	/**
	 * insert an element at a particular index; the indices of higher elements at that are increased by 1
	 * @param index the index
	 * @param item the new element
	 */
	public void insert(int index, T item);
	/**
	 * remove an element at a particular index; the indices of higher elements at that are decreased by 1
	 * @param index the index
	 * @return the old element
	 */
	public T remove(int index);
	/**
	 * traverse the list in the order of increasing index
	 * @return an {@link Iterator} for the traversal
	 */
	public Iterator<T> traverse();
}
