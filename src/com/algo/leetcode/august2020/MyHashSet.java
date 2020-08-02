package com.algo.leetcode.august2020;

/*
 * Design HashSet
Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:
MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:
All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.
 * */
public class MyHashSet {
	class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}
	private int size;
	private Node[] array;
	
	/** Initialize your data structure here. */
	public MyHashSet() {
		this.size = 100;
		this.array = new Node[100];
	}

	public void add(int key) {
		int index = key % this.size;
		if (this.array[index] == null) {
			this.array[index] = new Node(key);
			return;
		} else {
			Node p = this.array[index];
			while (p != null && p.val != key)
				p = p.next;

			if (p != null)
				return;

			Node newHead = new Node(key);
			newHead.next = this.array[index];
			this.array[index] = newHead;
		}
	}
	 /** Returns true if this set contains the specified element */
	public void remove(int key) {
		int index = key % this.size;
		if (this.array[index] == null) 
			return;
		else {
			Node p = this.array[index];

			if (p.val == key) {
				this.array[index] = p.next;
				return;
			}

			while (p.next != null && p.next.val != key)
				p = p.next;
			if (p.next == null)
				return;

			p.next = p.next.next;
		}
	}

	public boolean contains(int key) {
		int index = key % this.size;
		if (this.array[index] == null)
			return false;
		Node p = this.array[index];
		while (p != null && p.val != key)
			p = p.next;
		return p != null;
	}
}
