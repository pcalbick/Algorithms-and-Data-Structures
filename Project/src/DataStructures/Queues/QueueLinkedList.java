package DataStructures.Queues;

public class QueueLinkedList {
	
	private class Item {
		String s;
		Item next;
	}
	
	private Item first = null;
	private Item last = null;
	
	public void enqueue(String s) {
		Item old = last;
		last = new Item();
		last.s = s;
		old.next = last;
	}
	
	public String dequeue() {
		String s = first.s;
		first = first.next;
		return s;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}
