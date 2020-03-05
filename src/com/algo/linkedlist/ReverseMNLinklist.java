package com.algo.linkedlist;

import com.algo.linkedlist.LinkedList.ListNode;

public class ReverseMNLinklist {
	public static void main(String[] args) {
		LinkedList myLinkList=new LinkedList();
		myLinkList.push(1);
		myLinkList.push(2);
		myLinkList.push(3);	
		myLinkList.push(4);
		myLinkList.push(5);
		myLinkList.push(6);		
		myLinkList.printList();
		
		ListNode reverseHead=reverseBetween(myLinkList.head, 3, 5);
		while (reverseHead != null) {
			System.out.print(reverseHead.data + " ");
			reverseHead = reverseHead.next;
		}
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return null;
		ListNode current = head, previous = null;
		/*
		 * Step 1: Decrement m and n until m reaches 1. After completion of step 1:
		 *         a). m will become 1 and n will be equal to previous value of m.
		 *         b). current will point to the element at n position. 
		 *         c). previous will be the previous of element at n position.
		 */
		while (m > 1) {
			previous = current;
			current = current.next;
			m--;
			n--;
		}
		ListNode nprevious = previous, ncurrent = current, temp;
		/* Step 2: Reverse the nodes until n becomes 0. After completion of step 2:
		 *        a). m will remain 1, and n will be 0.
		 *        b). current will point to the element at last position.
		 *        c). previous will be the previous of element at the last position.
		 *        d). previous will be the element at n position (n which was passed).
		 *        e). ncurrent  will be the element at m position (m which was passed),
		 *            nprevious will be its previous element. */
		while (n > 0) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
			n--;
		}
		
		/*Step 3: nprevious will point to previous and ncurrent will point to current.*/
		if (previous != null)
			nprevious.next = previous;
		ncurrent.next = current;
		return head;
	}
}
