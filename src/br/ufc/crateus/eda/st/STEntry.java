package br.ufc.crateus.eda.st;

import java.util.Map.Entry;

public class STEntry<K, V> implements Entry<K, V> {
	
	private K key;
	private V value;

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		V aux = this.value;
		this.value = value;
		return aux;
	}

}
