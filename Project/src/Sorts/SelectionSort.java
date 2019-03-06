package Sorts;

import java.util.Comparator;

public class SelectionSort {
	
	public void sort(File[] a, Comparator<File> comparator) {
		for(int i=0; i<a.length; i++) {
			int min = i;
			for(int j=i+1; j<a.length; j++)
				if(less(comparator,a[j], a[min]))
					min = j;
			exchange(a, i, min); 
		}
		
		assert isSorted(comparator, a, 0, a.length-1);
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
