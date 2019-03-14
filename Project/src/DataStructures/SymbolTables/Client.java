package DataStructures.SymbolTables;

public class Client {
	
	private SymbolTable<Key,Value> st;
	private BinarySearchTree<Key,Value> bst;
	private RedBlackBST<Key,Value> rbbst;
	
	public Client() {
		st = new SymbolTable<Key,Value>();
		bst = new BinarySearchTree<Key,Value>();
		rbbst = new RedBlackBST<Key,Value>();
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		for(int i=0; i<args.length; i++) {
			Key key = new Key(Integer.parseInt(args[i].substring(0, args[i].indexOf(","))));
			Value value = new Value(args[i].substring(args[i].indexOf(",")+1));
			client.rbbst.put(key, value);
		}
		for(Key k : client.rbbst.nodes()) {
			System.out.println(k.get() + " " + client.rbbst.get(k).get());
		}
		System.out.println(client.rbbst.get(client.rbbst.select(3)).get());
		System.out.println(client.rbbst.floor(new Key(4)).get());
		System.out.println(client.rbbst.ceiling(new Key(4)).get());
		System.out.println("");
		System.out.println(client.rbbst.size());
		client.bst.delete(new Key(2));
		for(Key k : client.bst.nodes()) {
			System.out.println(client.rbbst.get(k).get());
		}
		System.out.println(client.rbbst.contains(new Key(5)));
		System.out.println("");
		System.out.println(client.rbbst.min().get());
		System.out.println(client.rbbst.max().get());
		client.rbbst.deleteMin();
		client.rbbst.deleteMax();
		System.out.println(client.rbbst.min().get());
		System.out.println(client.rbbst.max().get());
	}
}
