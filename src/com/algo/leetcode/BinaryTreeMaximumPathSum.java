package com.algo.leetcode;

/*
 * Binary Tree Maximum Path Sum
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

 * */
class TreeNodee {
	int val;
	TreeNodee left;
	TreeNodee right;

	TreeNodee() {
	}

	TreeNodee(int val) {
		this.val = val;
	}

	TreeNodee(int val, TreeNodee left, TreeNodee right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class MaxPathSum{
	public int val; 
}
public class BinaryTreeMaximumPathSum {
	/* 
	 For any node, there can be 4 ways from which the max path goes through:
	 1. From the node only.
	 2. Max path through the left child and node
	 3. Max path through the right child and node
	 4. Max path through the left child, node and then max path through the right node.
	 
	 We are going to trace all these above mentioned path and find the max one. We will be 
	 calling a recursive function, in which we consider each node as a root with a subtree. 
	 This function will return the maximum path sum 'maxNodeLeftRight' such that at most one child of root is involved. 
	 This maxNodeLeftRight will used in previous function call to calculate the maximum path.

	 * */
	public int maxPathSum(TreeNode node, MaxPathSum maxSum) {
		if (node == null)
			return 0;

		// find the max path sum going through left
		// and right child of the node
		int left = maxPathSum(node.left, maxSum);
		int right = maxPathSum(node.right, maxSum);

		//Max path through the left child and node
		int maxleft = Math.max(left + node.val, node.val);
		
		// Max path through the right child and node
		int maxright = Math.max(right + node.val, node.val);

		//find maximum path is right or left
		int maxNodeLeftRight = Math.max(maxleft, maxright);
		
		//Max path through the left child, node and then max path through the right node.
		int max_top = Math.max(maxNodeLeftRight, left + right + node.val);

		// Store the Maximum Result.
		maxSum.val = Math.max(maxSum.val, max_top);

		return maxNodeLeftRight;
	}
	public int maxPathSumm(TreeNode node, MaxPathSum maxSum)
	{
		if(node==null) return 0;
		
		//find the max path sum going through left 
		//and right child of the node
		int left=maxPathSum(node.left, maxSum);
		int right=maxPathSum(node.right, maxSum);
		
		int maxNodeLeftRight= Math.max(Math.max(left, right) + node.val, 
                node.val); 
		
		 int max_top = Math.max(maxNodeLeftRight, left+right + node.val); 
		  
	        // Store the Maximum Result. 
		 maxSum.val = Math.max(maxSum.val, max_top); 
				
		return maxNodeLeftRight;
	}
	public int maxPathSum(TreeNode root) {
		MaxPathSum maxSum=new MaxPathSum();
		maxSum.val=Integer.MIN_VALUE;
		
		maxPathSum(root, maxSum);
		return maxSum.val;
	}
}

