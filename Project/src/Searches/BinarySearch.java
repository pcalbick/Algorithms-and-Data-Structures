package Searches;

import java.util.Scanner;

public class BinarySearch {
	private static int[] input = new int[] {10,20,30,40,50,60,70,80,90};
	private int answer;
	
	public BinarySearch(int i, int[] array) {
		answer = find(i,array);
	}
	
	public int find(int i, int[] args) {
		int low = 0;
		int high = args.length-1;
		while(low <= high) {
			int middle = ((high-low)/2)+low;
			if(args[middle] > i) high = middle - 1;
			else if(args[middle] < i) low = middle + 1;
			else return middle;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = input;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Find : ");
		int i = scanner.nextInt();
		scanner.close();
		BinarySearch search = new BinarySearch(i,array);
		System.out.println(search.answer);
	}
}
