package ProjectProblems;


import java.util.Scanner;

public class PercolationStats {
	private final double[] openSites;
	private final int trials;
	private double mean;
	private double dev;
	
	public PercolationStats(int n, int trials) {
		this.trials = trials;
		openSites = new double[trials];
		if(n <= 0 || trials <= 0)
			throw new IllegalArgumentException();
		for(int i=0; i<trials; i++) {
			Percolation percolation = new Percolation(n);
			openSites[i] = (double)percolation.numberOfOpenSites()/((double)n*(double)n);
		}
	}
	
	public double mean() {
		mean = 0;
		for(int i=0; i<trials; i++)
			mean += openSites[i];
		mean /= trials;
		return mean;
	}
	
	public double stddev() {
		dev = 0;
		for(int i=0; i<trials; i++)
			dev += Math.pow((openSites[i] - mean),2);
		dev = Math.sqrt(dev/(trials-1));
		return dev;
	}
	
	public double confidenceLo() {
		return mean - ((1.96*dev)/Math.sqrt(trials));
	}
	
	public double confidenceHi() {
		return mean + ((1.96*dev)/Math.sqrt(trials));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size: ");
		int n = scanner.nextInt();
		System.out.println("Enter number of trials: ");
		int trials = scanner.nextInt();
		scanner.close();
		double start = System.currentTimeMillis();
		PercolationStats pstats = new PercolationStats(n,trials);
		System.out.println("mean = " + pstats.mean());
		System.out.println("stddev = " + pstats.stddev());
		System.out.println("95% confidence interval = [" + 
				pstats.confidenceLo() + "][" + pstats.confidenceHi() + "]");
		System.out.println("elapsed time: " + Double.toString((System.currentTimeMillis()-start)/1000));
	}
}
