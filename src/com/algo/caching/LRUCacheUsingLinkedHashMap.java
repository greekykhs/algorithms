package com.algo.caching;

import java.util.LinkedHashMap;

/*
 * How can we implement Least Recently Used(LRU) Cache using LinkedHashMap?
To implement LRUCache, we need to extend LinkedHashMap. FYI, the LinkedHashMap can order the elements in Insertion order as well as Access order. 

By default, LinkedHashMap maintains the data in Insertion order. However we can configure LinkedHashMap to maintain the data in Access order by setting the accessOrder flag to true.

In our LRUCache we will set accessOrder flag to true in its three argument copy constructor. Additionally, we will override method removeEldestEntry that LinkedHashMap calls after every put method call to check whether it should remove the eldest element. In our implementation, we will return true when size becomes greater than the capacity to let LinkedHashMap remove the least recently accessed element.
 * */
public class LRUCacheUsingLinkedHashMap<K, V> 
	extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;
	private final int capacity;

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		// Remove the eldest element whenever
		// size of cache exceeds the capacity
		return (size() > this.capacity);
	}

	public LRUCacheUsingLinkedHashMap(int capacity) {
		// Call constructor of LinkedHashMap with
		// accessOrder set to true to
		// achieve LRU Cache behavior
		super(capacity + 1, 1.0f, true);
		this.capacity = capacity;
	}

	/**
	 * Returns the value corresponding to input 
	 * key from Cache Map.
	 * 
	 * @param key Key for the element whose value 
	 * needs to be returned
	 * @return Value of the element with input key 
	 * or null if no such element exists
	 */
	public V find(K key) {
		return super.get(key);
	}

	/**
	 * Set the element with input key and value in 
	 * the cache. If the element already
	 * exits, it updates its value.
	 * 
	 * @param key   Key of the element
	 * @param value Value of the element
	 */
	public void set(K key, V value) {
		super.put(key, value);
	}
}