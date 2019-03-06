package Sorts;

import java.util.Comparator;
import java.util.Random;

public class File {
	
	public static Comparator<File> ALPHABETICAL = new alphabetcial();
	public static Comparator<File> REVERSE = new reverse();
	public static Comparator<File> BY_ID = new byId();
	private final String s;
	private final int id;
	
	public File(String s, int index) {
		this.s = s;
		
		Random random = new Random();
		this.id = random.nextInt(index)+1;
	}
	
	private static class alphabetcial implements Comparator<File> {
		public int compare(File p, File q) {
			return p.compareTo(q);
		}
	}
	
	private static class reverse implements Comparator<File> {
		public int compare(File p, File q) {
			return q.compareTo(p);
		}
	}
	
	private static class byId implements Comparator<File> {
		public int compare(File p, File q) {
			//not stack-overflow safe
			return p.id - q.id;
		}
	}
	
	public int compareTo(File that) {
		for(int i=0; i<this.s.length(); i++) {
			if((i == that.s.length() && i < this.s.length()) || this.s.charAt(i) > that.s.charAt(i)) return 1;
			else if(this.s.charAt(i) < that.s.charAt(i) || (i == this.s.length()-1 && i < that.s.length()-1)) return -1;
		}
		return 0;
	}
	
	public int getId() {
		return id;
	}
	
	public String get() {
		return s;
	}
}
