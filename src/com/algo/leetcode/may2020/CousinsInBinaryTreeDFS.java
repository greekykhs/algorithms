package com.algo.leetcode.may2020;

/*Cousins in Binary Tree
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.*/
public class CousinsInBinaryTreeDFS {
	public boolean isCousins(TreeNode root, int x, int y) {
		return dfsStarter(root, x, y);
	}
	
	private boolean dfsStarter(TreeNode root, int x, int y) {
		int[] parent = new int[10000];
		int[] height = new int[10000];
		if (root == null)
			return false;

		dfs(parent, height, root, 0);

		if (parent[x] != parent[y] && height[x] == height[y])
			return true;
		return false;
	}
	
	private void dfs(int[] parent, int[] height, TreeNode node, int ht) {
		height[node.val] = ht;
		if (node.left != null) {
			parent[node.left.val] = node.val;
			dfs(parent, height, node.left, ht + 1);
		}
		if (node.right != null) {
			parent[node.right.val] = node.val;
			dfs(parent, height, node.right, ht + 1);
		}
	}
}

/*
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
*/