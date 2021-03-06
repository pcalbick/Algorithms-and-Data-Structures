package ProjectProblems.DataStructures;
import java.util.Iterator;

import ProjectProblems.DataStructures.Item;

public class Deque implements Iterable<Item> {
	private Node first = null;
	private Node last = null;
	
	private class Node {
		Item item;
		Node next;
		Node back;
	}

	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		int count = 0;
		for(Item i : this) count++;
		return count;
	}
	
	public void addFirst(Item item) {
		Node old = first;
		first = new Node();
		first.item = item;
		if(old != null)
			old.back = first;
		first.next = old;
	}
	
	public void addLast(Item item) {
		Node old = last;
		last = new Node();
		last.item = item;
		if(old != null)
			old.next = last;
		last.back = old;
	}
	
	public Item removeFirst() {
		Node n = first;
		first = first.next;
		Item item = n.item;
		n = null;
		return item;
	}
	
	public Item removeLast() {
		Node n = last;
		last = last.back;
		Item item = n.item;
		n = null;
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item> {
		private Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() { throw new UnsupportedOperationException(); };
		
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

}
