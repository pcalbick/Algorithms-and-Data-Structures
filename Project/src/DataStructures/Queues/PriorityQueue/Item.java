package DataStructures.Queues.PriorityQueue;

import java.util.Comparator;

public class Item {
	
	private final int i;
	public static Compare compare;
	
	public Item(int i) {
		compare = new Compare();
		this.i = i;
	}
	
	public int get() {
		return i;
	}
	
	public static class Compare implements Comparator<Object> {
		public int compare(Object a, Object b) {
			Item ia = (Item)a;
			Item ib = (Item)b;
			return ia.compareTo(ib);
		}
	}
	
	public int compareTo(Item that) {
		if(that.i > this.i) return 1;
		else if(this.i < that.i) return -1;
		else return 0;
	}
}
