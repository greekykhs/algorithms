package com.algo.leetcode;

/*
 * Middle of the Linked List
 * 
 * Given a non-empty, singly linked list with head node head, 
 * return a middle node of linked list. If there are two middle nodes, 
 * return the second middle node.
 * 
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * 
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * 
 * Note: The number of nodes in the given list will be between 1 and 100.
 * */
public class MiddleOfLinkedList {
	ListNode head;
	class ListNode {
		int data;
		ListNode next;

		ListNode(int d) {
			data = d;
			next = null;
		}
	}

	/* 
	 * We will maintain two pointers.
	 * First pointer will be the slow one, and the second one will be faster. 
	 * During each iteration, we will move the slow pointer by one and fast pointer by two.
	 * When the fast pointer reaches the end, the slow one 
	 * will be at the middle of the linked list.
	 * */
	public ListNode middleNode(ListNode head) {
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		if (head != null) {
			while (fastPointer != null && fastPointer.next != null) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next.next;				
			}
		}
		return slowPointer;
    }
	
	public void push(int new_data) {
		ListNode new_node = new ListNode(new_data);
		new_node.next = head;
		head = new_node;
	}

	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.data + "-->");
			node = node.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		MiddleOfLinkedList linkedlist = new MiddleOfLinkedList();
		for (int i=5; i>0; --i)
			linkedlist.push(i);
		System.out.println("Printing the original list..");
		linkedlist.printList(linkedlist.head);
		ListNode middleNode =linkedlist.middleNode(linkedlist.head);
		System.out.println("Printing the list from middle node..");
		linkedlist.printList(middleNode);
	}
}