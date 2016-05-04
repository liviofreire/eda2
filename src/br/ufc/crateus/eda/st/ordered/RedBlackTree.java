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
	
	@Override
	public void put(K key, V value) {
		// TODO Auto-generated method stub
		super.put(key, value);
	}
	
	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub
		super.delete(key);
	}
}
