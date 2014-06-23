package assignment5;

import java.util.Iterator;

import assignment5.adt.List;
import assignment5.adt.Queue;
import assignment5.adt.Stack;

public class ArraySequence<T extends Comparable<T>> implements List<T>, Stack<T>, Queue<T> {

	private T storage[];
	private int length;
	private int nextFirstItem;
	private int nextLastItem;
	private static int size = 25;

	@SuppressWarnings("unchecked")
	public ArraySequence() {
		storage = (T[]) new Object[size];
		length = 0;
		nextFirstItem = storage.length / 2;
		nextLastItem = storage.length / 2 + 1;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public void enqueue(T element) {
		if (nextLastItem >= storage.length -1 ) { //reached end of array
			storage[nextLastItem] = element;
			nextLastItem++;
			length++;
		} else {
			//TODO resize storage (storage.size += size);
		}
	}

	@Override
	public T dequeue() {
		T item = null;
		if (length != 0) {
			int position = nextFirstItem + 1;
			item = storage[position];
			storage[position] = null;
			length--;
			if (length == 0) { //reset start positions
				nextFirstItem = storage.length / 2;
				nextLastItem = storage.length / 2 + 1;
			}
		} else {
			//TODO throw exception
		}
		return item;
	}

	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T change(int index, T item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(int index, T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> traverse() {
		// TODO Auto-generated method stub
		return null;
	}

}
