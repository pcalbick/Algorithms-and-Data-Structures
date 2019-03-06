package DataStrutures.Bags;

import java.util.Iterator;

public class BagLinkedList implements Iterable<Item> {
	
	private class Node {
		Item item;
		Node next;
	}
	
	private Node first;
	
	public void add(Item item) {
		Node old = first;
		first = new Node();
		first.item = item;
		first.next = old;
	}
	
	public Item get(int i) {
		Node n = first;
		for(int p=0; p<i; p++)
			n = first.next;
		return n.item;
	}
	
	public void remove(int i) {
		Node n = first;
		for(int p=0; p<i-1; p++)
			n = first.next;
		n.next = null;
		n.next = n.next.next;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		int count = 0;
		for(@SuppressWarnings("unused") Item i : this)
			count++;
		return count;
	}
	
	public Iterator<Item> iterator(){
		return new GenericItorator();
	}
	
	private class GenericItorator implements Iterator<Item> {
		private Node n = first;
		
		public boolean hasNext() {
			return n != null;
		}
		
		public Item next() {
			Node old = n;
			n = n.next;
			return old.item;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
