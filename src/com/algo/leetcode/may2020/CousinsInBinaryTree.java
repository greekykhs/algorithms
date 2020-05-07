package com.algo.leetcode.may2020;

/*Cousins in Binary Tree
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.*/
public class CousinsInBinaryTree {

	/*Check if the given values x and y are from Sibling nodes*/
	private boolean isSibling(TreeNode node, int x, int y) {
        if(node == null) 
        	return false;
        
        boolean checkSibling = false;
        //if left and right nodes are present, compare the values
        if(node.left != null && node.right != null)
            checkSibling = (node.left.val == x && node.right.val == y) ||
            			   (node.left.val == y && node.right.val == x);
        
        return checkSibling || isSibling(node.left, x, y) || isSibling(node.right, x, y);
    }
	
	private int findDepth(TreeNode node, int val, int height) {
        if(node == null) 
        	return 0;
        if(node.val == val) 
        	return height;
        
        //check if the node is present in left subtree, if yes then return it
        int level = findDepth(node.left, val, height + 1); 
        if (level != 0) 
            return level; 
  
        // if the node is not present in left subtree,check in right
        return findDepth(node.right, val, height + 1);
    }

	public boolean isCousins(TreeNode root, int x, int y) {
		return findDepth(root,x,1) == findDepth(root,y,1) && !isSibling(root,x,y); 
	}
}

class TreeNode {
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