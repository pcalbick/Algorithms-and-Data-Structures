package DataStructures.SymbolTables;

import DataStructures.SymbolTables.SymbolTableLinkedList.Node;

public class Client {
	
	private SymbolTable<Key,Value> st;
	private SymbolTableLinkedList stll;
	
	public Client() {
		st = new SymbolTable<Key,Value>();
		stll = new SymbolTableLinkedList();
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		for(int i=0; i<args.length; i++) {
			Key key = new Key(Integer.parseInt(args[i].substring(0, args[i].indexOf(","))));
			Value value = new Value(args[i].substring(args[i].indexOf(",")+1));
			client.st.put(key, value);
		}
		//System.out.println(client.st.get(testKey).get());
		for(Key k : client.st.iterableKeys()) {
			System.out.println(client.st.get(k).get());
		}
		System.out.println(client.st.size());
		client.st.delete(new Key(2));
		for(Key k : client.st.iterableKeys()) {
			System.out.println(client.st.get(k).get());
		}
		System.out.println(client.st.contains(new Key(5)));
		System.out.println(client.st.min().get());
		System.out.println(client.st.max().get());
		client.st.deleteMin();
		client.st.deleteMax();
		System.out.println(client.st.min().get());
	}
}
