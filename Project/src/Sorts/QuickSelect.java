package Sorts;

import java.util.Comparator;

public class QuickSelect {
	
	public File select(File[] arr, Comparator<File> c, int k) {
		int lo = 0;
		int high = arr.length-1;
		while(lo < high) {
			int j = partition(arr,lo,high,c);
			if(j < k) lo = j + 1;
			else if(j > k) high = j - 1;
			else return arr[k];
		}
		return arr[k];
	}
	
	private int partition(File[] arr, int lo, int high, Comparator<File> c) {
		int i = lo;
		int j = high + 1;
		while(true) {
			while(less(c,arr[++i],arr[lo]))
				if(i == high) break;
			while(less(c,arr[lo],arr[--j]))
				if(j == lo) break;
			if(i >= j) break;
			exchange(arr,i,j);
		}
		exchange(arr,lo,j);
		return j;
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
