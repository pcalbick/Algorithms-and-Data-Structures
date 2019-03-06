package Sorts;

import java.util.Comparator;

public class ShellSort {
	
	public void sort(File[] a, Comparator<File> comparator) {
		int n = a.length;
		int h = 1;
		while(h < n/3) h = 3*h+1;
		
		while(h >= 1) {
			for(int i=h; i<n; i++) {
				for(int j=i; j>=h && less(comparator,a[j],a[j-h]); j-=h)
					exchange(a,j,j-h);
			}
			h = h/3;
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
