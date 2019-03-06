package Sorts;

import java.util.Comparator;

public class QuickSort3Way {

	private final int cutoff = 10;
	
	private InsertionSort insertionSort;
	
	public QuickSort3Way() {
		insertionSort = new InsertionSort();
	}
	
	public void sort(File[] a, Comparator<File> c) {
		sort(a,0,a.length-1,c);
		insertionSort.sort(a,0,a.length-1,c);
		
		assert isSorted(c,a,0,a.length-1);
	}
	
	private void sort(File[] a, int lo, int high, Comparator<File> c) {
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
	
	private boolean less(Comparator<File> c, File a, File b) {
		return c.compare(a, b) < 0;
	}
	
	private void exchange(File[] a, int i, int j) {
		File swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private boolean isSorted(Comparator<File> c, File[] a, int lo, int high) {
		while(high > lo)
			if(less(c,a[high],a[--high]))
				return false;
		return true;
	}
}
