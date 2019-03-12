package DataStructures.SymbolTables;

public class Key implements Comparable<Key> {
	
	private int i;
	
	public Key(int i) {
		this.i = i;
	}
	
	public int get() {
		return i;
	}
	
	public int compareTo(Key that) {
		if(this.i > that.i) return 1;
		if(that.i > this.i) return -1;
		return 0;
	}
}
