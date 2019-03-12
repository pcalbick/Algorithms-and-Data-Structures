package DataStructures.SymbolTables;

public class Sort<Key extends Comparable<Key>,Value> {

	private final int cutoff = 10;
	
	public void sort(Key[] a, Value[] b, int n) {
		sort(a,b,0,n);
		insertionSort(a,b,0,n);
		
		assert isSorted(a,0,n);
	}
	
	private void sort(Key[] a, Object[] b, int lo, int high) {
		if(high <= lo + cutoff) return;
		int lt = lo;
		int i = lo;
		int gt = high;
		while(gt >= i) {
			if(less(a[i],a[lt])) {
				exchange(a,i,lt);
				exchange(b,i++,lt++);
			}
			else if(less(a[lt],a[i])) {
				exchange(a,i,gt);
				exchange(b,i,gt--);
			}
			else i++;
		}
		sort(a,b,lo,lt-1);
		sort(a,b,gt+1,high);
	}
	
	private void insertionSort(Key[] a, Value[] b, int lo, int high) {
		int p = high;
		int q = lo;
		for(int i=q; i<=p; i++) {
			for(int j=i; j>lo; j--) {
				if(less(a[j],a[j-1])) {
					exchange(a,j,j-1);
					exchange(b,j,j-1);
				}
				else break;
			}
		}
		
		assert isSorted(a, lo, high);
	}
	
	private boolean less(Key a, Key b) {
		return a.compareTo(b) < 0;
	}
	
	private void exchange(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private boolean isSorted(Key[] a, int lo, int high) {
		while(high > lo)
			if(less(a[high],a[--high]))
				return false;
		return true;
	}
}
