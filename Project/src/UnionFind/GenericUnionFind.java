package UnionFind;

public class GenericUnionFind {
	
	private int[] id;
	private int[] size;
	
	public GenericUnionFind(int length) {
		id = new int[length];
		size = new int[length];
		for(int i=0; i<length; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public int root(int p) {
		while(id[p] != p) {
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}
	
	public void union(int p, int q) {
		p = root(p);
		q = root(q);
		if(p == q)
			return;
		else if(size[p] > size[q]) {
			id[q] = p;
			size[p] += size[q];
		}
		else {
			id[p] = q;
			size[q] += size[p];
		}
	}
}
