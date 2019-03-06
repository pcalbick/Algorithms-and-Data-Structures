package Sorts;

import java.util.Comparator;

public class InsertionSort {
	
	public void sort(Object[] a, int lo, int high, Comparator<Object> c) {
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
	
	private boolean isSorted(Comparator<Object> c, Object[] a, int lo, int high) {
		while(high > lo)
			if(less(c,a[high],a[--high]))
				return false;
		return true;
	}
	
	private boolean less(Comparator<Object> c, Object a, Object b) {
		return c.compare(a, b) < 0;
	}
	
	private void exchange(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
