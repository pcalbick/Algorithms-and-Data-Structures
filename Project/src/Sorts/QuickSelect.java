package Sorts;

import java.util.Comparator;

public class QuickSelect {
	
	public Object select(Object[] arr, Comparator<Object> c, int k) {
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
	
	private int partition(Object[] arr, int lo, int high, Comparator<Object> c) {
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
	
	private boolean less(Comparator<Object> c, Object a, Object b) {
		return c.compare(a, b) < 0;
	}
	
	private void exchange(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
