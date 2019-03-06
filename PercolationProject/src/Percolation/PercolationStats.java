import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private final double[] openSites;
	private final int trials;
	private double mean;
	private double dev;
	private double confidence = 1.05;
	
	public PercolationStats(int n, int trials) {
		this.trials = trials;
		openSites = new double[trials];
		if (n <= 0 || trials <= 0)
			throw new IllegalArgumentException();
		for (int i = 0; i < trials; i++) {
			Percolation percolation = new Percolation(n);
			openSites[i] = (double) percolation.numberOfOpenSites() / ((double) n * (double) n);
		}
	}
	
	public double mean() {
		mean = StdStats.mean(openSites);
		return mean;
	}
	
	public double stddev() {
		dev = StdStats.stddev(openSites);
		return dev;
	}
	
	public double confidenceLo() {
		return mean - ((confidence * dev) / Math.sqrt(trials));
	}
	
	public double confidenceHi() {
		return mean + ((confidence * dev) / Math.sqrt(trials));
	}
	
	public static void main(String[] args) {
		PercolationStats pstats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		System.out.println("mean = " + pstats.mean());
		System.out.println("stddev = " + pstats.stddev());
		System.out.println("95% confidence interval = [" + 
				pstats.confidenceLo() + "][" + pstats.confidenceHi() + "]");
	}
}
