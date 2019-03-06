package Sorts;

import java.util.Comparator;
import java.util.Random;

public class File {
	
	public static Comparator<Object> ALPHABETICAL = new alphabetcial();
	public static Comparator<Object> REVERSE = new reverse();
	public static Comparator<Object> BY_ID = new byId();
	private final String s;
	private final int id;
	
	public File(String s, int index) {
		this.s = s;
		
		Random random = new Random();
		this.id = random.nextInt(index)+1;
	}
	
	private static class alphabetcial implements Comparator<Object> {
		public int compare(Object p, Object q) {
			File fp = (File)p;
			File fq = (File)q;
			return fp.compareTo(fq);
		}
	}
	
	private static class reverse implements Comparator<Object> {
		public int compare(Object p, Object q) {
			File fp = (File)p;
			File fq = (File)q;
			return fq.compareTo(fp);
		}
	}
	
	private static class byId implements Comparator<Object> {
		public int compare(Object p, Object q) {
			File fp = (File)p;
			File fq = (File)q;
			//not stack-overflow safe
			return fp.id - fq.id;
		}
	}
	
	public int compareTo(File that) {
		String a = this.s.toLowerCase();
		String b = that.s.toLowerCase();
		for(int i=0; i<a.length(); i++) {
			if((i == b.length() && i < a.length()) || a.charAt(i) > b.charAt(i)) return 1;
			else if(a.charAt(i) < b.charAt(i) || (i == a.length()-1 && i < b.length()-1)) return -1;
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
