package assignment5;

import java.util.Iterator;

import assignment5.adt.List;
import assignment5.adt.Queue;
import assignment5.adt.Stack;

public class SinglyLinkedSequence<T extends Comparable<T>> implements List<T>, Stack<T>, Queue<T> {

	class ListElement {
		private ListElement nextElem;
		private T item;
		
		public ListElement(T item){
			this.item = item;
			nextElem = null;
		}
		
		public T getItem(){
			return this.item;
		}
		
		public void setNextElem(ListElement elem){
			nextElem = elem;
		}
		
		public ListElement getNextElem(){
			return nextElem;
		}
		
		public void setItem(T item){
			this.item = item;
		}
	}
	
	private ListElement first = null;
	private int length = 0;
	
	@Override
	public int length() {
		return length;
	}

	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		
		if (first == null){
			first = new ListElement(element);
			length++;
			return;
		}
		ListElement active = first;
		for (int i = 0; i < length; i++){
			active = active.getNextElem();
		}
		active.setNextElem(new ListElement(element));
		length++;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if (first == null){
			return null;
		}
		ListElement removed = first;
		first = first.getNextElem();
		length--;
		return removed.getItem();
	}

	@Override
	public void push(T element) {
		this.enqueue(element);
	}

	@Override
	public T pop() {
		if (length == 0){
			throw new IllegalStateException();
		}
		ListElement active = first;
		for (int i = 0; i < length-1; i++){
			active = active.getNextElem();
		}
		T removed = active.getNextElem().getItem();
		active.setNextElem(null);
		length--;
		return removed;
	}

	@Override
	public T get(int index) {
		if (index >= length || index < 0){
			throw new IllegalArgumentException();
		}
		ListElement active = first;
		for (int i = 0; i < index; i++){
			active = active.getNextElem();
		}
		
		return active.getItem();
	}

	@Override
	public T change(int index, T item) {
		// TODO Auto-generated method stub
		if (index >= length || index < 0){
			throw new IllegalArgumentException("Index not found!");
		}
		ListElement active = first;
		for (int i = 0; i < index; i++){
			active = first.getNextElem();
		}
		T old = active.getItem();
		active.setItem(item);
		return old;
	}

	@Override
	public void insert(int index, T item) {
		if (index < 0){
			throw new IllegalArgumentException();
		}
		ListElement insert = new ListElement(item);
		if (index == 0){
			insert.setNextElem(first);
			first = insert;
			return;
		}
		ListElement active = first;
		for (int i = 0; i < index-1; i++){
			active = active.getNextElem();
		}
		insert.setNextElem(active.getNextElem());
		active.setNextElem(insert);
		
	}

	@Override
	public T remove(int index) {
		if (index >= length || index < 0){
			throw new IllegalArgumentException("Index not found!");
		}
		if (index == 0){
			T removed = first.getItem();
			first = first.getNextElem();
			return removed;
		}
		
		ListElement active = first;
		for (int i = 0; i < index-1; i++){
			active = first.getNextElem();
		}
		T removed = active.getItem();
		active.setNextElem(active.getNextElem());
		return removed;
	}

	@Override
	public Iterator<T> traverse() {
		// TODO Auto-generated method stub
		return null;
	}

}
