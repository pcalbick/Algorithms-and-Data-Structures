package DataStructures.Stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericStackLinkedList implements Iterable<Item> {
	
	private Node first = null;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public void push(Item item) {
		Node old = first;
		first = new Node();
		first.item = item;
		first.next = old;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		int count = 0;
		for(Item i : this) count++;
		return count;
	}
	
	public Iterator<Item> iterator(){
		return new GenericIterator();
	}
	
	private class GenericIterator implements Iterator<Item> {
		private Node index = first;
		
		public Item next() {
			if(index.next == null)
				throw new NoSuchElementException();
			Item item = index.item;
			index = index.next;
			return item;
		}
		
		public boolean hasNext() {
			return index.next != null;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
