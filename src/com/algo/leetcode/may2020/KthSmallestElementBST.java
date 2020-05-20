package com.algo.leetcode.may2020;

import java.util.concurrent.atomic.AtomicInteger;

/*Kth Smallest Element in a BST
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 <= k <= BST's total elements.

Example 1:
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?*/
public class KthSmallestElementBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// Function to find k'th smallest element in BST
		// Here i denotes the number of nodes processed so far
		public static int kthSmallest(TreeNode root, AtomicInteger i, int k)
		{
			// base case
			if (root == null) {
				return Integer.MAX_VALUE;
			}

			// search in left subtree
			int left = kthSmallest(root.left, i, k);

			// if k'th smallest is found in left subtree, return it
			if (left != Integer.MAX_VALUE) {
				return left;
			}

			// if current element is k'th smallest, return its value
			if (i.incrementAndGet() == k) {
				return root.val;
			}

			// else search in right subtree
			return kthSmallest(root.right, i, k);
		}

		// Function to find k'th smallest element in BST
		public static int kthSmallest(TreeNode root, int k)
		{
			// maintain index to count number of nodes processed so far
			AtomicInteger i = new AtomicInteger(0);

			// traverse the tree in in-order fashion and return k'th element
			return kthSmallest(root, i, k);
		}


}
/*
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
*/