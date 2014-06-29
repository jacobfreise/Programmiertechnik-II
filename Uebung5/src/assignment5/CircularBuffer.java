package assignment5;

public class CircularBuffer<T extends Comparable<T>> extends ArraySequence<T>{
	
	private Object[] storage;
	private int size;
	private int active;
	private int nextLastItem;
	private int nextFirstItem;
	private int length = 0;
	
	@SuppressWarnings("unchecked")
	public CircularBuffer(int size){
		this.storage = new Object[size];
		this.size = size;
		this.nextFirstItem = size/2;
		this.nextLastItem = size/2 + 1;
	}
	
	@Override
	public void insert(int index, T item){
		
	}
}
