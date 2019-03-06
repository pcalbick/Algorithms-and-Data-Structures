package Queues;

import java.util.Iterator;

public class GenericQueueLinkedList implements Iterable<Item> {
	
	private Node first = null;
	private Node last = null;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public void enqueue(Item item) {
		Node node = last;
		last = new Node();
		last.item = item;
		node.next = last;
	}
	
	public Item dequeue() {
		Node node = first;
		first = node.next;
		return node.item;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		int count = 0;
		for(Item i : this)
			count++;
		return count;
	}
	
	public Iterator<Item> iterator(){
		return new GenericIterator();
	}
	
	private class GenericIterator implements Iterator<Item> {
		private Node n = first;
		
		public Item next() {
			Node nn = n;
			n = n.next;
			return nn.item;
		}
		
		public boolean hasNext() {
			return n != last;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
