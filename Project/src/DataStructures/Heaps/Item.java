package DataStructures.Heaps;

public class Item implements Comparable<Item> {
	
	private final int i;
	
	public Item(int i) {
		this.i = i;
	}
	
	public int get() {
		return i;
	}
	
	public int compareTo(Item that) {
		if(that.i < this.i) return 1;
		if(this.i < that.i) return -1;
		return 0;
	}
}
