package ProjectProblems.DataStructures;

public class QueueClient {
	
	public static void main(String[] args) {
		RandomizedQueue<Item> rq = new RandomizedQueue<Item>();
		for(int i=0; i<10; i++) {
			Item item = new Item(Integer.toString(i));
			rq.enqueue(item);
		}
		System.out.println("Remove first 3: ");
		System.out.println(rq.dequeue().get() + rq.dequeue().get() + rq.dequeue().get());
		System.out.println("Get 3 at random: ");
		System.out.println(rq.sample().get() + rq.sample().get() + rq.sample().get());
	}
}
