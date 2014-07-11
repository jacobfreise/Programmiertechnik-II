package assignment6.hashing;

/**
 * Hashing function that uses the default implementation of Java
 * @author toni.gruetze
 *
 * @param <T> the data type to be hashed
 */
public class DefaultHashFunction<T> implements HashFunction<T>{
	/*
	 * (non-Javadoc)
	 * @see assignment6.HashFunction#hash(java.lang.Object)
	 */
	@Override
	public int hash(T input) {
		if(null==input) {
			return 0;
		}
		return input.hashCode();
	}
}
