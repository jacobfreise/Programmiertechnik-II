package assignment6;

import java.util.ArrayList;
import java.util.Iterator;

import assignment6.hashing.DefaultHashFunction;
import assignment6.hashing.HashFunction;


/**
 * An associative array that is able to bind multiple values (elements) to one single key.
 * The implementation is based on a specific hash function
 * @param <K> the type of keys to be stored
 * @param <V> the type of elements to be stored
 */
public class HashMultiMap<K, V> {
	private final HashFunction<K> hashFunction;
	
	
	private class dataContainer{
		private final int hashKey;
		private ArrayList<V> values;
		
		dataContainer(K key){
			this.hashKey = hashFunction.hash(key);
			values = new ArrayList<V>();
		}
		
		public void add(V value){
			values.add(value);
		}
	}
	
	private ArrayList<dataContainer> hashtable;
	
	/**
	 * default constructor
	 */
	public HashMultiMap() {
		this(1024, new DefaultHashFunction<K>());
	}
	
	/**
	 * 
	 * @param tableSize size of the hashtable
	 * @param hashFunction the hashing function to be used
	 */
	public HashMultiMap(int tableSize, HashFunction<K> hashFunction) {
		this.hashFunction = hashFunction;
		this.hashtable = new ArrayList<dataContainer>(tableSize);
		
	}
	/**
	 * adds a new "binding" (key-value pair) to the multi-map
	 * @param key the key to be added
	 * @param element the element to be added
	 */
	public void bind(K key, V element) {
		int hashKey = hashFunction.hash(key);
		
		for (int i = 0; i < hashtable.size(); i++){
			if (hashtable.get(i) == null){
				break;
			}
			
			if (hashtable.get(i).hashKey == hashKey){
				hashtable.get(i).add(element);
				return;
			}
		}
		
		//add new Container, if this key does not exist
		
		dataContainer insert = new dataContainer(key);
		insert.add(element);
		hashtable.add(insert);
	}
	/**
	 * Removes all bindings (key-value pairs) with the specified key from the multi-map
	 * @param key the key to be removed  (hash code identical and <code>key.equals(y)</code>)
	 */
	public void removeBindingFor(K key) {
		int hashKey = hashFunction.hash(key);
		
		for (int i = 0; i < hashtable.size(); i++){
			if (hashtable.get(i) == null){
				break;
			}
			
			if (hashtable.get(i).hashKey == hashKey){
				hashtable.get(i).values.clear();
				break;
				
			}
		}
		
	}
	/**
	 * gets the number of bindings for a specific key is present in this multi-map
	 * @param key the key to be checked (hash code identical and <code>key.equals(y)</code>)
	 * @return <code>0</code> iff one or more bindings exist for this instance, otherwise the count of accociated values
	 */
	public int countElementsFor(K key) {
		int hashKey = hashFunction.hash(key);
		
		for (int i = 0; i < hashtable.size(); i++){
			if (hashtable.get(i) == null){
				break;
			}
			
			if (hashtable.get(i).hashKey == hashKey){
				return hashtable.get(i).values.size();
			}
		}
		
		return 0;
	}
	/**
	 * Gets all values associated with the key
	 * @param key the key (hash code identical and <code>key.equals(y)</code>)
	 * @return An iterator over all values associated with this key
	 */
	public Iterator<V> elementsFor(K key) {
		int hashKey = hashFunction.hash(key);
		
		for (int i = 0; i < hashtable.size(); i++){
			if (hashtable.get(i) == null){
				break;
			}
			
			if (hashtable.get(i).hashKey == hashKey){
				return hashtable.get(i).values.iterator();
			}
		}
		
		return new ArrayList<V>().iterator();
	}
	/**
	 * gets the number of bindings (key-value pairs) in the multi-map.
	 * @return the number of bindings
	 */
	public int count() {
		int counter = 0;
		for (int i = 0; i < hashtable.size(); i++){
			if (hashtable.get(i) == null){
				break;
			}
			counter += hashtable.get(i).values.size();
		}
		return counter;
	}
}
