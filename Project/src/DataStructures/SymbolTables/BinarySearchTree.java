package DataStructures.SymbolTables;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>,Value> {

	private Node root;
	
	private class Node {
		private Key key;
		private Value value;
		private Node right;
		private Node left;
		private int size;
		public Node(Key key, Value value, int size) {
			this.key = key;
			this.value = value;
			this.size = size;
		}
	}
	
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}
	
	private Node put(Node node, Key key, Value value) {
		if(node == null) return new Node(key,value,1);
		else if(key.compareTo(node.key) < 0)
			node.left = put(node.left, key, value);
		else if(key.compareTo(node.key) > 0)
			node.right = put(node.right, key, value);
		else
			node.value = value;
		node.size = 1 + size(node.right) + size(node.left);
		return node;
	}
	
	public Value get(Key key) {
		if(isEmpty()) return null;
		Node node = root;
		while(node != null) {
			if(key.compareTo(node.key) < 0) node = node.left;
			else if(key.compareTo(node.key) > 0) node = node.right;
			else return node.value;
		}
		return null;
	}
	
	public void delete(Key key) {
		root = delete(root,key);
	}
	
	private Node delete(Node node, Key key) {
		if(node == null) return null;
		if(key.compareTo(node.key) < 0) node.left = delete(node.left,key);
		else if(key.compareTo(node.key) > 0) node.right = delete(node.right,key);
		else {
			if(node.right == null) return node.left;
			if(node.left == null) return node.right;
			
			Node x = node;
			node = min(x.right);
			node.right = deleteMin(x.right);
			node.left = x.left;
		}
		node.size = 1 + size(node.left) + size(node.right);
		return node;
	}
	
	private Node min(Node node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public int rank(Key key) {
		return rank(root,key);
	}
	
	private int rank(Node node, Key key) {
		if(node == null) return 0;
		if(key.compareTo(node.key) < 0) return rank(node.left,key);
		else if(key.compareTo(node.key) > 0) return 1 + size(node.left) + rank(node.right,key);
		else return size(node.left);
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node node) {
		if(node == null) return 0;
		return node.size;
	}
	
	public Key min() {
		Node i = root;
		while(i.left != null) {
			i = i.left;
		}
		return i.key;
	}
	
	public Key max() {
		Node i = root;
		while(i.right != null) {
			i = i.right;
		}
		return i.key;
	}
	
	public Key floor(Key key) {
		Node i = floor(root,key);
		if(i == null) return null;
		return i.key;
	}
	
	private Node floor(Node node, Key key) {
		if(node == null) return null;
		if(key.compareTo(node.key) == 0) return node;
		if(key.compareTo(node.key) < 0) return floor(node.left,key);
		Node x = floor(node.right,key);
		if(x != null) return x;
		return node;
	}
	
	public Key ceiling(Key key) {
		Node i = ceiling(root,key);
		if(i == null) return null;
		return i.key;
	}
	
	private Node ceiling(Node node, Key key) {
		if(node == null) return null;
		if(key.compareTo(node.key) == 0) return node;
		if(key.compareTo(node.key) > 0) return ceiling(node.right,key);
		Node x = ceiling(node.left,key);
		if(x != null) return x;
		return node;
	}
	
	public Key select(int k) {
		for(Key key : nodes())
			if(rank(key) == k)
				return key;
		return null;
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node node) {
		if(node.left == null) return node.right;
		node.left = deleteMin(node.left);
		node.size = 1 + size(node.left) + size(node.right);
		return node;
	}
	
	public void deleteMax() {
		root = deleteMax(root);
	}
	
	private Node deleteMax(Node node) {
		if(node.right == null) return node.left;
		node.right = deleteMax(node.right);
		node.size = 1 + size(node.right) + size(node.left);
		return node;
	}
	
	public Iterable<Key> nodes() {
		Queue<Key> q = new LinkedList<Key>();
		order(root,q);
		return q;
	}
	
	private void order(Node n, Queue<Key> q) {
		if(n == null) return;
		order(n.left, q);
		q.add(n.key);
		order(n.right, q);
	}
}
