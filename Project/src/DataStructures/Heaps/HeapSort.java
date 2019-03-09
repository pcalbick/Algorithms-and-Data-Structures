package DataStructures.Heaps;

public class HeapSort {
	
	private int n;
	
	public void sort(Item[] a) {
		n = a.length-1;
		for(int i=n/2; i>0; i--) {
			sink(a,i,n);
		}
		while(n > 0) {
			exchange(a,1,n);
			sink(a,1,--n);
		}
	}
	
	private void sink(Item[] a, int i, int n) {
		while(i*2 <= n) {
			int j = i*2;
			if(j < n && less(a,j,j+1)) j++;
			if(!less(a,i,j)) break;
			exchange(a,j,i);
			i = j;
		}
	}
	
	private boolean less(Item[] a, int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}
	
	private void exchange(Item[] a, int i, int j) {
		Item swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
