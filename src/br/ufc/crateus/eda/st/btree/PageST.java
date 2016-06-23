package br.ufc.crateus.eda.st.btree;

import br.ufc.crateus.eda.st.ordered.BinarySearchST;

public class PageST<K extends Comparable<K>, V> {
	
	private boolean botton;
	BinarySearchST<K, Object> st;
	private int m;
	
	PageST(boolean booton, int m) {
		this.botton = booton;
		this.m = m;
		st = new BinarySearchST<>();
	}
	
	public void close() {
		
	}
	
	public void insert(K key, V value)  {
		st.put(key, value);
	}
	
	public void enter(PageST<K, Object> page) {
		st.put(page.st.min(), page);
	}
	
	public boolean isExternal() {
		return botton;
	}
	
	public boolean holds(K key) {
		return st.contains(key);
	}
	
	@SuppressWarnings("unchecked")
	PageST<K, Object> next(K key) {
		return (PageST<K, Object>) st.get(st.floor(key));
	}
	
	public boolean hasOverflowed() {
		return st.size() == m;
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key) {
		Object value = st.get(key);
		return (value != null)? (V) value: null;
	}
	
	public PageST<K, Object> split() {
		return null;
	}
	
	Iterable<K> keys() {
		return st.keys();
	}
}
