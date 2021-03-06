package br.ufc.crateus.eda.st.ordered;


public class RedBlackTree<K extends Comparable<K>, V> extends BinarySearchTree<K, V> {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;

	class RBNode extends Node {
		boolean color; 
		public RBNode(K key, V value, int count, boolean color) {
			super(key, value, count);
			this.color = color;
		}
	}
	
	private boolean isRed(Node node) {
		if (node == null) return BLACK;
		return getColor(node) == RED;
	}
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		setColor(x, getColor(h));
		setColor(h, RED);
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		setColor(x, getColor(h));
		setColor(h, RED);
		return x;
	}
	
	private void flipColors(Node h) {
		setColor(h, RED);
		setColor(h.left, BLACK);
		setColor(h.right, BLACK);
	}
	
	@SuppressWarnings("unchecked")
	private void setColor(Node node, boolean color) {
		RBNode rbn = (RBNode) node;
		rbn.color = color;
	}
	
	@SuppressWarnings("unchecked")
	private boolean getColor(Node n) {
		RBNode rbn = (RBNode) n;
		return rbn.color;
	}
	
	@Override
	public void put(K key, V value) {
		super.root = put(super.root, key, value);
		setColor(super.root, BLACK);
	}
	
	private Node put(Node r, K key, V value) {
		if (r == null) return new RBNode(key, value, 1, RED);
		int cmp = key.compareTo(r.key);
		if (cmp < 0) r.left = put(r.left, key, value);
		else if (cmp > 0) r.right = put(r.right, key, value);
		else r.value = value;
		
		if (!isRed(r.left) && isRed(r.right)) r = rotateLeft(r);
		if (isRed(r.left) && isRed(r.left.left)) r = rotateRight(r);
		if (isRed(r.left) && isRed(r.right)) flipColors(r);
		
		r.count = size(r.left) + size(r.right) + 1;
		return r;
	}
	
	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub
		super.delete(key);
	}
}
