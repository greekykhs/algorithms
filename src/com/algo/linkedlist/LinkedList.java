package com.algo.linkedlist;

public class LinkedList {
	class ListNode {
		int data;
		ListNode next;

		ListNode(int d) {
			data = d;
			next = null;
		}
	}
	ListNode head;
	
	void push(int newData) 
	{ 
		if(head==null)
		{
			head = new ListNode(newData);
		}
		else
		{
			ListNode temp = head;
			while (temp != null && temp.next!=null) {
				temp = temp.next;				
			}
			temp.next=new ListNode(newData);
		} 
	}
	void printList() {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
