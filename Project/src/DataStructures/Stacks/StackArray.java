package DataStructures.Stacks;

public class StackArray {
	private String[] array;
	private int n = 0;
	
	public StackArray() {
		array = new String[1];
	}
	
	public void push(String s) {
		array[n++] = s;
		if(n > array.length/2) array = resize(array.length*2);
	}
	
	public String pop() {
		if(n - 1 < 0)
			throw new ArrayIndexOutOfBoundsException();
		String s = array[--n];
		array[n] = null;
		if(n > 0 && n < array.length/4) array = resize(array.length/2);
		return s;
	}
	
	public String[] resize(int size) {
		String[] newArray = new String[size];
		for(int i=0; i<array.length; i++)
			newArray[i] = array[i];
		return newArray;
	}
}
