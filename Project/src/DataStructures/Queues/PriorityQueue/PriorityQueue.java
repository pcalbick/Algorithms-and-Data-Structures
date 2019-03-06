package DataStructures.Queues.PriorityQueue;

import java.util.Comparator;
import java.util.Iterator;

import Sorts.QuickSort3Way;

public class PriorityQueue implements Iterable<Item> {
	
	private static Comparator<Object> compare = Item.compare;
	private final QuickSort3Way sort;
	private Item[] arr;
	private int n = 0;
	
	public PriorityQueue() {
		sort = new QuickSort3Way();
		arr = (Item[]) new Object[1];
	}
	
	public void add(Item item) {
		arr[n++] = item;
		sort.sort(arr, compare);
		if(n > arr.length/2) arr = resize(arr.length*2);
	}
	
	private Item[] resize(int size) {
		Item[] arr = (Item[]) new Object[size];
		for(int i=0; i<arr.length; i++)
			arr[i] = this.arr[i];
		return arr;
	}
	
	public Item getMax() {
		if(n == 0)
			throw new ArrayIndexOutOfBoundsException();
		Item item = arr[--n];
		arr[n] = null;
		if(n < arr.length/4) arr = resize(arr.length/2);
		return item;
	}
	
	public void delMax() {
		if(n == 0)
			throw new ArrayIndexOutOfBoundsException();
		arr[--n] = null;
		if(n < arr.length/4) arr = resize(arr.length/2);
	}
	
	public Item getMin() {
		if(n == 0)
			throw new ArrayIndexOutOfBoundsException();
		Item item = arr[0];
		for(int i=0; i<n; i++)
			arr[i] = arr[i+1];
		--n;
		if(n < arr.length/4) arr = resize(arr.length/2);
		return item;
	}
	
	public void delMin() {
		if(n == 0)
			throw new ArrayIndexOutOfBoundsException();
		for(int i=0; i<n; i++)
			arr[i] = arr[i+1];
		--n;
		if(n < arr.length/4) arr = resize(arr.length/2);
	}
	
	public boolean isEmpty() {
		return arr.length == 0;
	}
	
	public int size() {
		return arr.length;
	}
	
	public Iterator<Item> iterator(){
		return new ItemIterator();
	}
	
	private class ItemIterator implements Iterator<Item> {
		private int i = 0;
		
		public Item next() { return arr[i++]; }
		public boolean hasNext() { return i < n; }
		public void remove() { throw new UnsupportedOperationException(); }
	}
}
