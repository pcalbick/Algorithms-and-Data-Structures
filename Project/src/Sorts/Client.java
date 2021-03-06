package Sorts;

import java.util.Comparator;

public class Client {
	
	private int cutoff = 32;
	private int idCutoff = 5;
	private static final int index = 5;
	
	private static Comparator<Object> forward = File.ALPHABETICAL;
	private static Comparator<Object> reverse = File.REVERSE;
	private static Comparator<Object> byId = File.BY_ID;
	
	private Shuffle shuffle;
	private SelectionSort selectionSort;
	private InsertionSort insertionSort;
	private ShellSort shellSort;
	private MergeSort mergeSort;
	private QuickSort quickSort;
	private QuickSort3Way quickSort3;
	
	public static void main(String[] args) {
		
		//First sort usually slow?
		
		double watch = System.currentTimeMillis();
		File[] arr = new File[args.length];
		for(int i=0; i<args.length; i++) {
			arr[i] = new File(args[i],index);
		}
		System.out.println("Size: " + arr.length);
		
		Client client = new Client();
		
		//client.print("Shuffle",arr,null);
		//client.print("SelectionSort",arr,forward);
		//client.print("InsertionSort",arr,forward);
		client.print("ShellSort",arr,reverse);
		client.print("MergeSort",arr,reverse);
		//client.print("MergeBottomUp",arr,reverse);
		client.print("QuickSort",arr,forward);
		client.print("QuickSort3", arr, forward);
		
		//client.byId(arr,forward);
		//client.quickSelect(arr,forward,arr.length/2);
		System.out.println("Running Time: " + Double.toString((System.currentTimeMillis() - watch)/1000));
	}
	
	public Client() {
		shuffle = new Shuffle();
		selectionSort = new SelectionSort();
		insertionSort = new InsertionSort();
		shellSort = new ShellSort();
		mergeSort = new MergeSort();
		quickSort = new QuickSort();
		quickSort3 = new QuickSort3Way();
	}
	
	private void print(String sort, File[] arr, Comparator<Object> comparator) {
		//Tukey's Ninther is an options for Quick and Merge Sorts but introduces vulnerabilities
		shuffle.shuffle(arr); // Important for QuickSort and QuickSelect Optimization
		double watch = System.currentTimeMillis();
		switch (sort) {
			case "SelectionSort":
				System.out.println("Shuffled...");
				System.out.println("Selection Sort: ");
				selectionSort.sort(arr,comparator);
				break;
			case "InsertionSort":
				System.out.println("Shuffled...");
				System.out.println("Insertion Sort: ");
				insertionSort.sort(arr,0,arr.length-1,comparator);
				break;
			case "ShellSort":
				System.out.println("Shuffled...");
				System.out.println("Shell Sort: ");
				shellSort.sort(arr,comparator);
				break;
			case "MergeSort":
				System.out.println("Shuffled...");
				System.out.println("Merge Sort: ");
				mergeSort.sort(arr,comparator);
				break;
			case "MergeBottomUp":
				System.out.println("Shuffled...");
				System.out.println("Merge Sort (Bottom-Up): ");
				mergeSort.bottomUp(arr,comparator);
				break;
			case "QuickSort":
				System.out.println("Shuffled...");
				System.out.println("Quick Sort: ");
				quickSort.sort(arr,comparator);
				break;
			case "QuickSort3":
				System.out.println("Shuffled...");
				System.out.println("Quick Sort (3-Way): ");
				quickSort3.sort(arr,comparator);
				break;
			case "Shuffle":
				System.out.println("Shuffle: ");
				break;
			default:
				System.out.println("No Such Sort.");
				break;
		}
		watch = (System.currentTimeMillis() - watch)/1000;
		for(int i=0; i<arr.length/cutoff; i++)
			System.out.print(arr[i].get() + " ");
		if(cutoff > 1) System.out.println(" ...");
		else System.out.println("");
		System.out.println(Double.toString(watch));
		System.out.println("");
	}
	
	@SuppressWarnings("unused")
	private void quickSelect(File[] arr, Comparator<Object> comparator, int find) {
		int k = find;
		QuickSelect qs = new QuickSelect();
		File file = (File)qs.select(arr, comparator, k);
		System.out.println("Element " + Integer.toString(find) + ": " + file.get());
	}
	
	@SuppressWarnings("unused")
	private void byId(File[] arr, Comparator<Object> comparator) {
		shuffle.shuffle(arr);
		System.out.println("Sorted By ID: ");
		
		double watch = System.currentTimeMillis();
		quickSort.sort(arr, comparator);
		mergeSort.sort(arr,byId);
		watch = (System.currentTimeMillis()-watch)/1000;
		assert sortedById(arr,comparator);
		
		if(idCutoff > 0) {
			int k = idCutoff;
			for(int i=0; i<arr.length; i++) {
				if(i <= k) {
					System.out.println(Integer.toString(arr[i].getId()) + " " + arr[i].get());
				} else if(arr[i].getId() == index) {
					break;
				} else {
					if(arr[i].getId() < arr[i+1].getId()) {
						k = i + idCutoff;
						System.out.println("...");
					}
				}
			}
		} else {
			for(int i=0; i<arr.length/cutoff; i++)
				System.out.println(Integer.toString(arr[i].getId()) + " " + arr[i].get());
		}
		
		if(cutoff > 1) System.out.println(" ...");
		else System.out.println("");
		System.out.println(Double.toString(watch));
		System.out.println("");
	}
	
	private boolean sortedById(File[] arr, Comparator<Object> c) {
		int k = 0;
		for(int i=0; i<index; i++) {
			for(int j=k; j<arr.length-1; j++) {
				if(arr[j].getId() != arr[j+1].getId()) {
					k=j;
					break;
				}
				else if(c.compare(arr[j], arr[j+1]) > 0)
					return false;
			}
		}
		return true;
	}
}
