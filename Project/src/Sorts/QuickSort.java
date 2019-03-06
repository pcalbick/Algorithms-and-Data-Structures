package Sorts;

import java.util.Comparator;

public class QuickSort {
	
	private final int cutoff = 10;
	
	private InsertionSort insertionSort;
	
	public QuickSort() {
		insertionSort = new InsertionSort();
	}
	
	public void sort(Object[] arr, Comparator<Object> comparator) {
		sort(arr,0,arr.length-1,comparator);
		insertionSort.sort(arr, 0, arr.length-1, comparator);
		assert isSorted(comparator, arr, 0, arr.length-1);
	}
	
	private void sort(Object[] arr, int lo, int high, Comparator<Object> c) {
		if(high <= lo + cutoff) return;
		int j = partition(arr,lo,high,c);
		int m = median(arr, lo, lo+(high-lo)/2, high, c);
		exchange(arr,lo,m);
		sort(arr,lo,j-1,c);
		sort(arr,j+1,high,c);
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
	
	private int median(Object[] a, int lo, int mid, int high, Comparator<Object> c) {
		if((c.compare(a[lo], a[mid]) < 0 && c.compare(a[high], a[lo]) < 0) || (c.compare(a[lo], a[high]) < 0 && c.compare(a[mid], a[lo]) < 0)) return lo;
		if((c.compare(a[mid], a[lo]) < 0 && c.compare(a[high], a[mid]) < 0) || (c.compare(a[mid], a[high]) < 0 && c.compare(a[lo], a[mid]) < 0))return mid;
		return high;
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
