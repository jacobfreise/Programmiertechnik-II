package assignment5.adt;

/**
 * Abstract data type for a Min-Heap
 * 
 * @author toni.gruetze
 * 
 * @param <T> the type of elements to be stored (have to be instances of {@link Comparable})
 */
public interface MinHeap<T extends Comparable<T>> {
	/**
	 * adds an element to the heap
	 * @param element the element to be added
	 */
	public void add(T element);
	/**
	 * Returns the node of minimum value of the heap after removing it from the heap
	 * @return the minimum within the heap
	 */
	public T extractMin();
	/**
	 * gets the number of elements in the heap
	 * @return the size
	 */
	public int size();
}
