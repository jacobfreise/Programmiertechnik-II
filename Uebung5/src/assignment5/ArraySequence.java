package assignment5;

import java.util.Iterator;

import assignment5.adt.*;

public class ArraySequence<T extends Comparable<T>> implements List<T>, Stack<T>, Queue<T> {

	private Object storage[];
	private int length;
	private int nextFirstItem;
	private int nextLastItem;
	private static int size = 25;

	public ArraySequence() {
		storage = new Object[size];
		length = 0;
		nextFirstItem = storage.length / 2;
		nextLastItem = storage.length / 2 + 1;
	}
	
	private void resize(){
		Object[] newstorage = new Object[storage.length+size];
		for (int i = 0; i < storage.length; i++){
			newstorage[i+12] = storage[i];
		}
		nextFirstItem = 11;
		nextLastItem += 12;
		storage = newstorage;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public void enqueue(T element) {
		if (nextLastItem <= storage.length -1 ) { //reached end of array
			storage[nextLastItem] = element;
			nextLastItem++;
			length++;
		} else {
			resize();
			storage[nextLastItem] = element;
			nextLastItem++;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T dequeue() {
		T item = null;
		if (length > 0) {
			int position = nextFirstItem + 1;
			item = (T) storage[position];
			storage[position] = null;
			length--;
			if (length == 0) { //reset start positions
				nextFirstItem = storage.length / 2;
				nextLastItem = storage.length / 2 + 1;
			} else {
				nextFirstItem ++;
			}
		} else {
			throw new IllegalStateException();
		}
		return item;
	}

	@Override
	public void push(T element) {
		storage[nextFirstItem] = element;
		if (nextFirstItem > 0) {
			nextFirstItem--;
		} else {
			resize();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		T removed = null;
		if(length > 0){
			removed = (T) storage[nextLastItem-1];
			storage[nextLastItem-1] = null;
			length--;
			if (length == 0){
				nextFirstItem = storage.length / 2;
				nextLastItem = storage.length / 2 + 1;
			} else {
				nextLastItem++;
			}
		} else{
			throw new IllegalStateException();
		}
		return removed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		int position = index + nextFirstItem + 1;
		if (index >= length || index < 0){
			throw new IllegalStateException();
		}
		return (T) storage[position];
	}

	@SuppressWarnings("unchecked")
	@Override
	public T change(int index, T item) {
		int position = index + nextFirstItem + 1;
		if (index >= length || index < 0){
			throw new IllegalStateException();
		}
		T removed = (T) storage[position];
		storage[position] = item;
		return removed;
	}

	@Override
	public void insert(int index, T item) {
		int position = index + nextFirstItem + 1;
		if (index >= length || index < 0){
			throw new IllegalStateException();
		}
		for (int i = nextLastItem; i > position; i--){
			storage[i] = storage[i-1];
		}
		if (nextLastItem < storage.length-1){
			nextLastItem++;
		} else{
			resize();
		}
		length++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		int position = index + nextFirstItem + 1;
		if (index >= length || index < 0 || length == 0){
			throw new IllegalStateException();
		}
		T removed = (T) storage[position];
		for (int i = position; i < nextLastItem; i++){
			storage[i] = storage[i+1];
		}
		length--;
		if (length == 0){
			nextFirstItem = storage.length / 2;
			nextLastItem = storage.length / 2 + 1;
		} else{
			nextLastItem--;
		}
		return removed;
	}

	@Override
	public Iterator<T> traverse() {
		// TODO Auto-generated method stub
		return null;
	}

}
