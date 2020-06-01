package com.algo.leetcode.june2020;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) 
			return null;
		
		TreeNode tempNode = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tempNode);
		return root;
	}

	//BFS Solution
	public TreeNode invertTree1(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) 
			return null;
		
		queue.offer(root);
		TreeNode tempNode, currentNode;
		while (!queue.isEmpty()) {
			currentNode = queue.poll();

			if (currentNode.left != null)
				queue.offer(currentNode.left);
			
			if (currentNode.right != null)
				queue.offer(currentNode.right);
		
			tempNode = currentNode.left;
			currentNode.left = currentNode.right;
			currentNode.right = tempNode;
		}
		return root;
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
