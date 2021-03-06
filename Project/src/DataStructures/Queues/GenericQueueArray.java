package DataStructures.Queues;

import java.util.Iterator;

public class GenericQueueArray<Item> implements Iterable<Item> {
	
	private Item[] array;
	private int n = 0;
	
	@SuppressWarnings("unchecked")
	public GenericQueueArray() {
		array = (Item[]) new Object[1];
	}
	
	public void enqueue(Item item) {
		array[n++] = item;
		if(n > array.length/2) array = resize(array.length*2);
	}
	
	public Item dequeue() {
		Item item = array[0];
		for(int i=1; i<n; i++)
			array[i] = array[i+1];
		if(n < array.length/4) array = resize(array.length/2);
		return item;
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
	
	private Item[] resize(int size) {
		@SuppressWarnings("unchecked")
		Item[] array = (Item[]) new Object[size];
		for(int i=0; i<array.length; i++)
			array[i] = this.array[i];
		return array;
	}
	
	public Iterator<Item> iterator(){
		return new GenericIterator();
	}
	
	private class GenericIterator implements Iterator<Item> {
		private int i = n;
		
		public Item next() { return array[--i]; }
		
		public boolean hasNext() { return i != 0; }
		
		public void remove() { throw new UnsupportedOperationException(); }
	}
}
