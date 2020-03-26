package com.algo.linkedlist;

import com.algo.linkedlist.LinkedList.ListNode;
/*
 * Given a linked list, swap every two adjacent nodes and return its head. 
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 * Example: Given 1- > 2- > 3- > 4, you should return the list as 2- > 1- > 4- > 3.
 * */
public class SwapNodesInPairs {

	public static void main(String[] args) {
		LinkedList myLinkList=new LinkedList();
		myLinkList.push(1);
		myLinkList.push(2);
		myLinkList.push(3);	
		myLinkList.push(4);
		myLinkList.printList();
		
		ListNode swappedHead=swapPairsRecursive(myLinkList.head);
		//ListNode swappedHead=swapPairsIterative(myLinkList.head);
		while (swappedHead != null) {
			System.out.print(swappedHead.data + " ");
			swappedHead = swappedHead.next;
		}
	}	

	public static ListNode swapPairsIterative(ListNode head)
	{
		if(head == null || head.next == null)   
	        return head;
		
		ListNode temp = head;
		int data;
		  
        //Traverse, and swap data of each node with its next node’s data.
        while (temp != null && temp.next != null) { 
        	data= temp.data; 
            temp.data = temp.next.data; 
            temp.next.data = data; 
            temp = temp.next.next; 
        } 
		return head;
	}

	public static ListNode swapPairsRecursive(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else {
			ListNode newHead = head.next;
			head.next = swapPairsRecursive(head.next.next);
			newHead.next = head;
			return newHead;
		}
	}
}
