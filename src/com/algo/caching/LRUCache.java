package com.algo.caching;

import java.util.HashMap;

class Entry {
	int key, value;
	Entry left, right;
}

public class LRUCache {
	HashMap<Integer, Entry> hashmap;
	Entry start, end;
	int LRU_SIZE = 7; 					

	public LRUCache() {
		hashmap = new HashMap<Integer, Entry>();
	}

	public int getEntry(int key) {
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

	public void putEntry(int key, int value) {
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
			if (hashmap.size() > LRU_SIZE)
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