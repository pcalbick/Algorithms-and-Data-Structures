package Sorts;

import java.util.Comparator;

public class QuickSort3Way {

	private final int cutoff = 10;
	
	private InsertionSort insertionSort;
	
	public QuickSort3Way() {
		insertionSort = new InsertionSort();
	}
	
	public void sort(Object[] a, Comparator<Object> c) {
		sort(a,0,a.length-1,c);
		insertionSort.sort(a,0,a.length-1,c);
		
		assert isSorted(c,a,0,a.length-1);
	}
	
	private void sort(Object[] a, int lo, int high, Comparator<Object> c) {
		if(high <= lo + cutoff) return;
		int lt = lo;
		int i = lo;
		int gt = high;
		while(gt >= i) {
			if(less(c,a[i],a[lt])) exchange(a,i++,lt++);
			else if(less(c,a[lt],a[i])) exchange(a,i,gt--);
			else i++;
		}
		sort(a,lo,lt-1,c);
		sort(a,gt+1,high,c);
	}
	
	private boolean less(Comparator<Object> c, Object a, Object b) {
		return c.compare(a, b) < 0;
	}
	
	private void exchange(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private boolean isSorted(Comparator<Object> c, Object[] a, int lo, int high) {
		while(high > lo)
			if(less(c,a[high],a[--high]))
				return false;
		return true;
	}
}
