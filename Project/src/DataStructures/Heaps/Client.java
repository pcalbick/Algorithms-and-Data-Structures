package DataStructures.Heaps;

public class Client {
	
	private MaxBinaryHeap<Item> maxHeap;
	private MinBinaryHeap<Item> minHeap;
	private HeapSort heapSort;
	
	public Client() {
		maxHeap = new MaxBinaryHeap<Item>();
		minHeap = new MinBinaryHeap<Item>();
		heapSort = new HeapSort();
	}
	
	public void sort(String[] args) {
		Item[] items = new Item[args.length+1];
		for(int i=0; i<args.length; i++)
			items[i+1] = new Item(Integer.parseInt(args[i]));
		heapSort.sort(items);
		for(int i=1; i<items.length; i++)
			System.out.print(items[i].get() + " ");
		System.out.println("");
	}
	
	public void max(String[] args) {
		for(int i=0; i<args.length; i++) {
			Item item = new Item(Integer.parseInt(args[i]));
			maxHeap.insert(item);
		}
		System.out.println(maxHeap.delMax().get());
		for(Item i : maxHeap)
			System.out.print(i.get() + " ");
		System.out.println("");
	}
	
	public void min(String[] args) {
		for(int i=0; i<args.length; i++) {
			Item item = new Item(Integer.parseInt(args[i]));
			minHeap.insert(item);
		}
		System.out.println(minHeap.delMin().get());
		for(Item i : minHeap)
			System.out.print(i.get() + " ");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.max(args);
		client.min(args);
		client.sort(args);
	}
}
