package Sorts;

import java.util.Comparator;

public class InsertionSort {
	
	public void sort(File[] a, int lo, int high, Comparator<File> c) {
		int p = high;
		int q = lo;
		for(int i=q; i<=p; i++) {
			for(int j=i; j>lo; j--) {
				if(less(c,a[j],a[j-1]))
					exchange(a,j,j-1);
				else break;
			}
		}
		
		assert isSorted(c, a, lo, high);
	}
	
	private boolean isSorted(Comparator<File> c, File[] a, int lo, int high) {
		while(high > lo)
			if(less(c,a[high],a[--high]))
				return false;
		return true;
	}
	
	private boolean less(Comparator<File> c, File a, File b) {
		return c.compare(a, b) < 0;
	}
	
	private void exchange(File[] a, int i, int j) {
		File swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
