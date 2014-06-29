package assignment5;

import java.util.Iterator;

import assignment5.adt.List;
import assignment5.adt.Queue;
import assignment5.adt.Stack;

public class DoublyLinkedSequence<T extends Comparable<T>> implements List<T>, Queue<T>, Stack<T> {
	
	class ListElement {
		private ListElement nextElem;
		private ListElement prevElem;
		private T item;
		
		public ListElement(T item){
			this.item = item;
			nextElem = null;
			prevElem = null;
		}
		
		public T getItem(){
			return this.item;
		}
		
		public void setPrevElem(ListElement elem){
			prevElem = elem;
		}
		
		public ListElement getPrevElem(){
			return prevElem;
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
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		if (length == 0){
			first = new ListElement(element);
			length++;
			return;
		}
		ListElement active = first;
		for (int i = 0; i < length; i++){
			active = active.getNextElem();
		}
		ListElement insert = new ListElement(element);
		active.setNextElem(insert);
		insert.setPrevElem(active);
		length++;
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
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		this.push(element);
	}

	@Override
	public T dequeue() {
		if (first == null){
			return null;
		}
		T removed = first.getItem();
		first.getNextElem().setPrevElem(null);
		first = first.getNextElem();
		length--;
		return removed;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
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
			throw new IllegalArgumentException();
		}
		ListElement active = first;
		for (int i = 0; i < index; i++){
			active = active.getNextElem();
		}
		T old = active.getItem();
		active.setItem(item);
		return old;
	}

	@Override
	public void insert(int index, T item) {
		// TODO Auto-generated method stub
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
		for (int i = 0; i < index; i++){
			active = active.getNextElem();
		}
		insert.setNextElem(active);
		insert.setPrevElem(active.getPrevElem());
		active.getPrevElem().setNextElem(insert);
		active.setPrevElem(insert);
	}

	@Override
	public T remove(int index) {
		if (index < 0){
			throw new IllegalArgumentException();
		}
		if (index == 0){
			T removed = first.getItem();
			first = first.getNextElem();
			first.setPrevElem(null);
			return removed;
		}
		ListElement active = first;
		for (int i = 0; i < index; i++){
			active = active.getNextElem();
		}
		T removed = active.getItem();
		active.getPrevElem().setNextElem(active.getNextElem());
		active.getNextElem().setPrevElem(active.getPrevElem());
		return removed;
	}

	@Override
	public Iterator<T> traverse() {
		// TODO Auto-generated method stub
		return null;
	}

}
