package DataStructures.SymbolTables;

public class Value implements Comparable<Value> {
	
	private String val;
	
	public Value(String val) {
		this.val = val;
	}
	
	public String get() {
		return val;
	}
	
	public int compareTo(Value that) {
		for(int i=0; i<this.val.length(); i++) {
			if(i >= that.val.length() || that.val.charAt(i) > this.val.charAt(i)) return -1;
			if(this.val.charAt(i) > that.val.charAt(i) || (i+1 == this.val.length() && i+1 < that.val.length())) return 1;
		}
		return 0;
	}
}
