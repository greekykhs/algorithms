package com.algo.leetcode;

/*
 * Diameter of Binary Tree
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path 
 * between any two nodes in a tree. This path may or may not pass through the root.
 * 
 * Example: Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
 
   Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * */
public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println("Diameter of Binary Tree: " 
				+ new DiameterOfBinaryTree().diameterOfBinaryTree(root));
	}
	int noOfNodes;

	/*
	 *  Find the depth, which is max(depth of left node, depth of right node) + 1.
	 *  When we find the depth, we go through 1+ (depth of left node) + (depth of right node) nodes.
	 *  We will go through each node and find the highest number of nodes used in that path. 
	 *  */
	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return noOfNodes;
	}

	/*
	 * Depth = max(depth of left node, depth of right node) + 1
	 * */
	public int depth(TreeNode node) {
		if (node == null)
			return 0;
		int leftDepth = depth(node.left);
		int rightDepth = depth(node.right);
		noOfNodes = Math.max(noOfNodes, leftDepth + rightDepth);
		return Math.max(leftDepth, rightDepth) + 1;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.val = data;
	}
}