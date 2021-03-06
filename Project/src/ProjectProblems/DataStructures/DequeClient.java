package ProjectProblems.DataStructures;

public class DequeClient {

	public static void main(String[] args) {
		Deque deque = new Deque();
		for(int i=0; i<10; i++) {
			Item item = new Item(Integer.toString(i));
			if(i < 5)
				deque.addFirst(item);
			if(i < 10)
				deque.addLast(item);
		}
		while(!deque.isEmpty()) {
			System.out.println(deque.removeFirst().get());
			System.out.println(deque.removeLast().get());
		}
		
		//Expected Stack:
		//9876501234
		//Expected Output:
		//4938271605
	}
}
