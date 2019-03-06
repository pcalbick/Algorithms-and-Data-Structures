package Sorts;

import java.util.Random;

public class Shuffle {
	
	public void shuffle(Object[] a) {
		Random random = new Random();
		for(int i=0; i<a.length; i++) {
			int rand = random.nextInt(i+1);
			Object swap = a[rand];
			a[rand] = a[i];
			a[i] = swap;
		}
	}
}
