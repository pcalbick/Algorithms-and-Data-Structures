package Queues;

public class QueueArray {
	
	private String[] array;
	private int n = 0;
	
	public QueueArray() {
		array = new String[1];
	}
	
	public void enqueue(String s) {
		array[n++] = s;
		if(n > array.length / 2) array = resize(array.length*2);
	}
	
	public String dequeue() {
		String s = array[0];
		for(int i=0; i<array.length-1; i++)
			array[i] = array[i+1];
		if(--n < array.length / 4) array = resize(array.length/2);
		return s;
	}
	
	public String[] resize(int size) {
		String[] newArray = new String[size];
		for(int i=0; i<array.length; i++) {
			if(array[i] != null)
				newArray[i] = array[i];
		}
		return newArray;
	}
}
