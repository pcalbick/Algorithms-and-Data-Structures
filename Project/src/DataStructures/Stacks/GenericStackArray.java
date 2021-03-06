package DataStructures.Stacks;

import java.util.Iterator;

public class GenericStackArray<Item> implements Iterable<Item> {
	
	private Item[] array;
	private int n = 0;
	
	@SuppressWarnings("unchecked")
	public GenericStackArray() {
		array = (Item[]) new Object[1];
	}
	
	public void push(Item item) {
		array[n++] = item;
		if(n > array.length/2) resize(array.length*2);
	}
	
	public Item pop() {
		if(n == 0)
			throw new ArrayIndexOutOfBoundsException();
		Item item = array[--n];
		array[n] = null;
		if(n < array.length/4) resize(array.length/2);
		return item;
	}
	
	private Object[] resize(int size) {
		Object[] array = new Object[size];
		for(int i=0; i<n; i++)
			array[i] = this.array[i];
		return array;
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
		private int i = n;
		
		public Item next() { return array[i--]; }
		
		public boolean hasNext() { return i > 0; }
		
		public void remove() { throw new UnsupportedOperationException(); }
	}
}
