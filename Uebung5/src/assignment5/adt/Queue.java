package assignment5.adt;

/**
 * Abstract data type for First-In-First-Out (FIFO) operations
 * 
 * @author toni.gruetze
 * 
 * @param <T> the type of elements to be stored
 */
public interface Queue<T> extends Sequence<T> {
	/**
	 * adds an element to the rear terminal position of the queue
	 * @param element the element to be added
	 */
	public void enqueue(T element);
	/**
	 * removes the element from the front terminal position of the queue
	 * @return the element from the front terminal position
	 */
	public T dequeue();
}
