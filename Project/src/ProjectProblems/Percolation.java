package ProjectProblems;


import java.util.Random;

public class Percolation {
	private int[] grid;
	private int[] id;
	private int[] sz;
	private final int n;
	private int count;
	
	public Percolation(int n) {
		if(n <= 0)
			throw new IllegalArgumentException();
		this.n = n;
		grid = new int[n*n];
		id = new int[n*n];
		sz = new int[n*n];
		for(int i=0; i<grid.length; i++) {
			int col = i%n;
			int row = n*(i/n);
			open(row,col);
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public void open(int row, int col) {
		Random random = new Random();
		if(random.nextInt(2) == 1) {
			grid[row+col] = 1;
			if(row-1 > 0 && isOpen(row-n,col))
				union(row+col,(row-n)+col);
			if(col-1 > 0 && isOpen(row,col-1))
				union(row+col,row+(col-1));
			count++;
		}
	}
	
	public boolean isOpen(int row, int col) {
		if(grid[row+col] == 1)
			return true;
		return false;
	}
	
	public boolean isFull(int row, int col) {
		if(grid[row+col] == 0)
			return true;
		return false;
	}
	
	public int numberOfOpenSites() {
		return count;
	}
	
	public boolean percolates() {
		for(int i=grid.length-n; i<grid.length; i++)
			if(root(i) < n)
				return true;
		return false;
	}
	
	private int root(int i) {
		while(id[i] != i) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	private void union(int i, int j) {
		int p = root(i);
		int q = root(j);
		if(p == q)
			return;
		if(sz[p] < sz[q]) {
			id[p] = q;
			sz[q] += sz[p];
		} else {
			id[q] = p;
			sz[p] += sz[q];
		}
	}
}
