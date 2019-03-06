package Sorts;

import java.util.Comparator;

public class MergeSort {
	
	private final int cutoff = 7;
	private InsertionSort insertionSort;
	
	private void merge(Comparator<File> c, File[] a, File[] aux, int lo, int mid, int high) {
		assert isSorted(c, a, lo, mid);
		assert isSorted(c, a, mid+1, high);
		
		int i = lo;
		int j = mid+1;
		for(int k=lo; k<=high; k++) {
			if(i > mid)
				aux[k] = a[j++];
			else if(j > high) 
				aux[k] = a[i++];
			else if(less(c,a[j],a[i]))
				aux[k] = a[j++];
			else 
				aux[k] = a[i++];
		}
		
		assert isSorted(c, aux, lo, high);
	}
	
	private void sort(Comparator<File> c, File[] a, File[] aux, int lo, int high) {
		if(high <= lo + cutoff) {
			insertionSort.sort(aux,lo,high,c);
			return;
		}
		int mid = lo + (high-lo)/2;
		sort(c, aux, a, lo, mid);
		sort(c, aux, a, mid+1, high);
		merge(c, a, aux, lo, mid, high);
	}
	
	public void sort(File[] a, Comparator<File> comparator) {
		insertionSort = new InsertionSort();
		File[] aux = new File[a.length];
		for(int i=0; i<a.length; i++)
			aux[i] = a[i];
		sort(comparator, aux, a, 0, a.length-1);
		
		assert isSorted(comparator, a, 0, a.length-1);
	}
	
	public void bottomUp(File[] a, Comparator<File> comparator) {
		int n = a.length;
		File[] aux = new File[n];
		for(int p=0; p<a.length; p++)
			aux[p] = a[p];
		for(int i = 1; i < n; i = i + i)
			for(int j = 0; j < n-i; j += i+i) {
				merge(comparator, a, aux, j, j+i-1, Math.min(j+i+i-1, n-1));
				for(int p=0; p<a.length; p++)
					a[p] = aux[p];
			}
		
		assert isSorted(comparator, a, 0, a.length-1);
	}
	
	
	//Comparisons and Assertions
	private boolean less(Comparator<File> c, File a, File b) {
		return c.compare(a, b) < 0;
	}
	
	private boolean isSorted(Comparator<File> c, File[] a, int lo, int high) {
		while(high > lo)
			if(less(c,a[high],a[--high]))
				return false;
		return true;
	}
}
