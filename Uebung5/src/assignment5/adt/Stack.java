package assignment5.adt;

/**
 * Abstract data type for Last-In-First-Out (LIFO) operations
 * 
 * @author toni.gruetze
 * 
 * @param <T> the type of elements to be stored
 */
public interface Stack<T> extends Sequence<T> {
	/**
	 * adds an element to the top of the stack
	 * @param element the element to be added
	 */
	public void push(T element);
	/**
	 * removes an element from the top of the stack
	 * @return the element from the top
	 */
	public T pop();
}
