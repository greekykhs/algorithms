package com.algo.caching;

import java.util.HashMap;

/*
 * LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache(2);

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 * */
class Entry {
	int key, value;
	Entry left, right;
}

public class LRUCache {
	HashMap<Integer, Entry> hashmap;
	Entry start, end;
	int capacity; 					

	public LRUCache(int capacity) {
		hashmap = new HashMap<Integer, Entry>();
		this.capacity=capacity;
	}

	public int get(int key) {
		//if key already exist, get the value and move the entry on the top
		if (hashmap.containsKey(key))
		{
			Entry entry = hashmap.get(key);
			removeNode(entry);
			addAtTop(entry);
			return entry.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		//if key already exist, update the value and move the entry on the top
		if (hashmap.containsKey(key))
		{
			Entry entry = hashmap.get(key);
			entry.value = value;
			removeNode(entry);
			addAtTop(entry);
		} else {
			Entry newnode = new Entry();
			newnode.left = null;
			newnode.right = null;
			newnode.value = value;
			newnode.key = key;
			//if the max size exceeded, make a room for new Entry by removing the last entry
			if (hashmap.size() >= capacity)
			{
				hashmap.remove(end.key);
				removeNode(end);
				addAtTop(newnode);

			} else {
				addAtTop(newnode);
			}
			hashmap.put(key, newnode);
		}
	}

	public void addAtTop(Entry node) {
		node.right = start;
		node.left = null;
		if (start != null)
			start.left = node;
		start = node;
		if (end == null)
			end = start;
	}

	public void removeNode(Entry node) {
		if (node.left != null) {
			node.left.right = node.right;
		} else {
			start = node.right;
		}

		if (node.right != null) {
			node.right.left = node.left;
		} else {
			end = node.left;
		}
	}
}