package com.algo.leetcode.august2020;

/*
 * Path Sum III

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
*/
public class PathSum3 {
	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		else {
			int count = countPath(root, sum, 0);
			return count + pathSum(root.left, sum) + pathSum(root.right, sum);
		}
	}

	int countPath(TreeNode root, int sum, int total) {
		if (root == null)
			return 0;
		else {
			total += root.val;
			int count = sum == total ? 1 : 0;
			count += countPath(root.left, sum, total);
			count += countPath(root.right, sum, total);
			return count;
		}
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