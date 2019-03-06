import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int[] grid;
	private final WeightedQuickUnionUF quickUnion;
	private final int n;
	private int count;
	
	public Percolation(int n) {
		this.n = n;
		grid = new int[n * n];
		quickUnion = new WeightedQuickUnionUF(n * n);
		for(int i = 0; i < grid.length; i++) {
			int col = i % n;
			int row = n * (int) Math.floor((double) i / (double) n);
			open(row , col);
		}
	}
	
	public void open(int row, int col) {
		if (StdRandom.uniform(2) == 0) {
			grid[row + col] = 1;
			if (row - 1 > 0 && isOpen(row - n, col))
				union(row + col, (row - n) + col);
			if (col - 1 > 0 && isOpen(row, col - 1))
				union(row + col, row + (col - 1));
			count++;
		}
	}
	
	public boolean isOpen(int row, int col) {
		if (grid[row + col] == 1)
			return true;
		return false;
	}
	
	public boolean isFull(int row, int col) {
		if (grid[row + col] == 0)
			return true;
		return false;
	}
	
	public int numberOfOpenSites() {
		return count;
	}
	
	public boolean percolates() {
		for(int i = 0; i < n; i++) {
			int p = (grid.length - n) + i;
			int q = i;
			if(quickUnion.connected(p, q))
				return true;
		}
		return false;
	}
	
	private void union(int i, int j) {
		quickUnion.union(i, j);
	}
}
