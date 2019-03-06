package Sorts;

import java.util.Comparator;

public class SelectionSort {
	
	public void sort(Object[] a, Comparator<Object> comparator) {
		for(int i=0; i<a.length; i++) {
			int min = i;
			for(int j=i+1; j<a.length; j++)
				if(less(comparator,a[j], a[min]))
					min = j;
			exchange(a, i, min); 
		}
		
		assert isSorted(comparator, a, 0, a.length-1);
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
