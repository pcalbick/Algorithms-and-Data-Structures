package DataStructures.Heaps;

import java.util.Iterator;

public class MinBinaryHeap<Item extends Comparable<Item>> implements Iterable<Item> {
	
	private Item[] arr;
	private int n = 1;
	
	@SuppressWarnings("unchecked")
	public MinBinaryHeap() {
		arr = (Item[]) new Comparable[1];
	}
	
	public void insert(Item item) {
		if(n > arr.length/2) arr = resize(arr.length*2);
		arr[n] = item;
		swim(n++);
	}
	
	public Item get(int i) {
		return arr[i];
	}
	
	public Item delMin() {
		Item max = arr[1];
		exchange(1,--n);
		arr[n] = null;
		sink(1);
		if(n < arr.length/4) arr = resize(arr.length/2);
		return max;
	}
	
	public void swim(int i) {
		while(i>1 && greater(arr[i/2],arr[i])) {
			exchange(i,i/2);
			i = i/2;
		}
	}
	
	public void sink(int i) {
		while(2*i < n) {
			int j = i*2;
			if(j < n-1 && greater(arr[j],arr[j+1])) j++;
			if(!greater(arr[i],arr[j])) break;
			exchange(j,i);
			i = j;
		}
	}
	
	private boolean greater(Item a, Item b) {
		return a.compareTo(b) > 0;
	}
	
	private void exchange(int i, int j) {
		Item swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}
	
	private Item[] resize(int size) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Comparable[size];
		for(int i=0; i<n; i++)
			temp[i] = arr[i];
		return temp;
	}
	
	public Iterator<Item> iterator(){
		return new HeapIterator();
	}
	
	private class HeapIterator implements Iterator<Item>{
		private int i = 1;
		public boolean hasNext() { return i < n; }
		
		public Item next() { return arr[i++]; }
		
		public void remove() { throw new UnsupportedOperationException(); }
	}
}
