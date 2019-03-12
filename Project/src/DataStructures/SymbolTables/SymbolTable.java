package DataStructures.SymbolTables;

import java.util.Iterator;

public class SymbolTable<Key extends Comparable<Key>,Value> {
	
	private int n = 0;
	private Key[] keys;
	private Value[] values;
	private Sort<Key,Value> sort;
	
	public SymbolTable() {
		keys = (Key[]) new Comparable[1];
		values = (Value[]) new Object[1];
		sort = new Sort<Key,Value>();
	}
	
	public void put(Key key, Value value) {
		keys[n] = key;
		values[n++] = value;
		sort.sort(keys,values,n-1);
		if(n > keys.length/2) {
			keys = (Key[]) resize(keys, keys.length*2);
			values = (Value[]) resize(values, values.length*2);
		}
	}
	
	public Value get(Key key) {
		if(isEmpty()) return null;
		int i = rank(key);
		if(i < n && keys[i].compareTo(key) == 0) return values[i];
		else return null;
	}
	
	public void delete(Key key) {
		if(isEmpty()) return;
		int i = rank(key);
		keys[i] = null;
		values[i] = null;
		while(i+1 < n) {
			keys[i] = keys[i+1];
			values[i] = values[i+1];
			i++;
		}
		keys[--n] = null;
		values[n] = null;
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	public int rank(Key key) {
		int low = 0;
		int high = n-1;
		while(low <= high) {
			int middle = ((high-low)/2)+low;
			if(keys[middle].compareTo(key) > 0) high = middle - 1;
			else if(keys[middle].compareTo(key) < 0) low = middle + 1;
			else return middle;
		}
		return low;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	public Key min() {
		return keys[0];
	}
	
	public Key max() {
		return keys[n-1];
	}
	
	public Key floor(Key key) {
		int i = 0;
		while(key.compareTo(keys[i]) < 0) {
			i++;
		}
		return keys[i];
	}
	
	public Key ceiling(Key key) {
		int i = 0;
		while(key.compareTo(keys[i]) < 0) {
			i++;
		}
		return keys[i+1];
	}
	
	public Key select(int k) {
		return keys[k];
	}
	
	public void deleteMin() {
		keys[0] = null;
		values[0] = null;
		for(int i=0; i<n; i++) {
			keys[i] = keys[i+1];
			values[i] = values[i+1];
		}
		keys[--n] = null;
		values[n] = null;
	}
	
	public void deleteMax() {
		keys[--n] = null;
		values[n] = null;
	}
	
	public Iterable<Key> iterableKeys() {
		return new IterableKeys(0,n-1);
	}
	
	public Iterable<Key> iterableKeys(int lo, int hi){
		return new IterableKeys(lo,hi);
	}
	
	private class IterableKeys implements Iterable<Key> {
		private int lo;
		private int hi;
		
		public IterableKeys(int lo, int hi) {
			this.lo = lo;
			this.hi = hi;
		}
		
		public Iterator<Key> iterator() {
			return new KeyIterator(lo,hi);
		}
		
		private class KeyIterator implements Iterator<Key> {
			private int lo;
			private int hi;
			public KeyIterator(int lo, int hi) {
				this.lo = lo;
				this.hi = hi;
			}
			public boolean hasNext() { return lo <= hi; }
			public Key next() { return keys[lo++]; }
			public void remove() { throw new UnsupportedOperationException(); }
		}
	}
	
	public Iterable<Value> iterableValues() {
		return new IterableValues(0,n-1);
	}
	
	public Iterable<Value> iterableValues(int lo, int hi){
		return new IterableValues(lo,hi);
	}
	
	private class IterableValues implements Iterable<Value> {
		private int lo;
		private int hi;
		
		public IterableValues(int lo, int hi) {
			this.lo = lo;
			this.hi = hi;
		}
		
		public Iterator<Value> iterator() {
			return new ValueIterator(lo,hi);
		}
		
		private class ValueIterator implements Iterator<Value> {
			private int lo;
			private int hi;
			public ValueIterator(int lo, int hi) {
				this.lo = lo;
				this.hi = hi;
			}
			public boolean hasNext() { return lo <= hi; }
			public Value next() { return values[lo++]; }
			public void remove() { throw new UnsupportedOperationException(); }
		}
	}
	
	private Comparable[] resize(Comparable[] a, int size) {
		Comparable[] arr = new Comparable[size];
		for(int i=0; i<n; i++) {
			arr[i] = a[i];
		}
		return arr;
	}
	
	private Object[] resize(Object[] a, int size) {
		Object[] arr = new Object[size];
		for(int i=0; i<n; i++) {
			arr[i] = a[i];
		}
		return arr;
	}
}
