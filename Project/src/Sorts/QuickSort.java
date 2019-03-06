package Sorts;

import java.util.Comparator;

public class QuickSort {
	
	private final int cutoff = 10;
	
	private InsertionSort insertionSort;
	private Shuffle shuffle;
	
	public QuickSort() {
		insertionSort = new InsertionSort();
		shuffle = new Shuffle();
	}
	
	public void sort(File[] arr, Comparator<File> comparator) {
		shuffle.shuffle(arr);
		sort(arr,0,arr.length-1,comparator);
		insertionSort.sort(arr, 0, arr.length-1, comparator);
		assert isSorted(comparator, arr, 0, arr.length-1);
	}
	
	private void sort(File[] arr, int lo, int high, Comparator<File> c) {
		if(high <= lo + cutoff) return;
		int j = partition(arr,lo,high,c);
		int m = median(arr, lo, lo+(high-lo)/2, high, c);
		exchange(arr,lo,m);
		sort(arr,lo,j-1,c);
		sort(arr,j+1,high,c);
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
	
	private int median(File[] a, int lo, int mid, int high, Comparator<File> c) {
		if((c.compare(a[lo], a[mid]) < 0 && c.compare(a[high], a[lo]) < 0) || (c.compare(a[lo], a[high]) < 0 && c.compare(a[mid], a[lo]) < 0)) return lo;
		if((c.compare(a[mid], a[lo]) < 0 && c.compare(a[high], a[mid]) < 0) || (c.compare(a[mid], a[high]) < 0 && c.compare(a[lo], a[mid]) < 0))return mid;
		return high;
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