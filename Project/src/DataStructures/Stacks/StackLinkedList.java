package DataStructures.Stacks;

public class StackLinkedList {
	
	private class Item {
		String s;
		Item next;
	}
	
	private Item first = null;
	
	public void push(String s) {
		Item old = first;
		first = new Item();
		first.s = s;
		first.next = old;
	}
	
	public String pop() {
		String s = first.s;
		first = first.next;
		return s;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}
