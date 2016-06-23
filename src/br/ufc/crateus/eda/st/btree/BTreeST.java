package br.ufc.crateus.eda.st.btree;

public class BTreeST<K extends Comparable<K>, V> {
	private int m;
	private PageST<K, Object> root;
	
	public BTreeST(K sentinel, int m) {
		this.m = m;
		root = new PageST<>(true, m);
		root.insert(sentinel, null);
	}
	
	public V get(K key) {
		return get(root, key);
	}
	
	public V get(PageST<K, Object> r, K key) {
		if (r.isExternal()) r.get(key);
		return get(r.next(key), key);
	}
	
	public boolean contains(K key) {
		return contains(root, key);
	}
	
	private boolean contains(PageST<K, Object> r, K key) {
		if (r.isExternal()) r.holds(key);
		return contains(r.next(key), key);
	}
	
	public void add(K key, V value) {
		add(root, key, value);
		if (root.hasOverflowed()) {
			PageST<K, Object> left = root;
			PageST<K, Object> right = root.split();
			root = new PageST<>(false, m);
			root.enter(left);
			root.enter(right);
		}
	}
	
	private void add(PageST<K, Object> r, K key, V value) {
		if (r.isExternal()) r.insert(key, value);
		else {
			PageST<K, Object> next = r.next(key);
			add(next, key, value);
			if (next.hasOverflowed()) r.enter(next.split());
		}
	}
}
