package ProjectProblems.DataStructures;

import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private int n = 0;
	private Item[] arr;
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		arr = (Item[]) new Object[1];
	}
	
	public void enqueue(Item item) {
		arr[n++] = item;
		if(n > arr.length/2) arr = resize(arr.length*2);
	}
	
	public Item dequeue() {
		if(n == 0)
			throw new ArrayIndexOutOfBoundsException();
		Item item = arr[--n];
		if(n < arr.length/4) arr = resize(arr.length/2);
		return item;
	}
	
	public Item sample() {
		Random random = new Random();
		return arr[random.nextInt(n-1)];
	}
	
	private Item[] resize(int size) {
		@SuppressWarnings("unchecked")
		Item[] arr = (Item[]) new Object[size];
		for(int i=0; i<n; i++)
				arr[i] = this.arr[i];
		return arr;
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
		return new RandomizedQueueIterator();
	}
	
	private class RandomizedQueueIterator implements Iterator<Item> {
		private int n = 0;
		
		public boolean hasNext() { return n < arr.length; }
		
		public Item next() { return arr[n]; }
		
		public void remove() { throw new UnsupportedOperationException(); }
	}
	
}
