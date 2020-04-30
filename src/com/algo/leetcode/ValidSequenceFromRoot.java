package com.algo.leetcode;

/*
 * Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree.
 * 
 * Given a binary tree where each path going from the root to 
 * any leaf form a valid sequence, check if a given string is 
 * a valid sequence in such binary tree. 
 * 
 * We get the given string from the concatenation of an array of 
 * integers arr and the concatenation of all values of the nodes 
 * along a path results in a sequence in the given binary tree.
 * */

public class ValidSequenceFromRoot {

	public boolean isValidSequence(TreeNode root, int[] arr) {
		//if root node is null and array length is 0 return true.
		if(root==null) 
			return arr.length==0;
		return isValidSequence(root, arr, 0);
	}

	public boolean isValidSequence(TreeNode node, int[] arr, int i) {
		//if the value of node is not equal to value at ith index of array, return false
		if(node.val!=arr[i]) 
			return false;
		
		//if the last index of input array is reached,
		//we need to check if the current node is a leaf node or not?
		if(i==arr.length-1)
			return node.left==null && node.right==null;
		
		//if left child is present check whether the sequence is valid or not
		if(node.left!=null && isValidSequence(node.left, arr, i+1))
			return true;
		
		//if right child is present check whether the sequence is valid or not
		if(node.right!=null && isValidSequence(node.right, arr, i+1))
			return true;
		
		return false;
	}
}
