package DataStructures.Bags;

import java.util.Iterator;

public class BagArray<Item> implements Iterable<Item> {
	
	private int n = 0;
	private Item[] array;
	
	@SuppressWarnings("unchecked")
	public BagArray() {
		array = (Item[]) new Object[1];
	}
	
	public void add(Item item) {
		array[n++] = item;
		if(n > array.length/2) array = resize(array.length*2);
	}
	
	public Item get(int i) {
		return array[i];
	}
	
	public void remove(int i) {
		array[i] = null;
		for(int p=i; p<array.length-1; p++)
			array[p] = array[p+1];
		if(--n < array.length/4) array = resize(array.length/2);
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
		Item[] arr = (Item[]) new Object[size];
		for(int i=0; i<arr.length; i++)
			arr[i] = array[i];
		return arr;
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
