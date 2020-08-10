package com.algo.btree;

/*
 * How to check of two Binary Trees are Identical?
 * 
 * Two Binary trees are identical when they have same data and 
 * structure/arrangement of data is also same. To find if they 
 * are identical or not, we need to traverse both the trees 
 * simultaneously, and in each iteration we will compare 
 * the data of current node and the children of both the trees.
 * */
public class IdenticalBinaryTrees {
	boolean isIdentical(Node n1, Node n2) {
		if (n1 == null && n2 == null)
			return true;
		else if (n1 != null && n2 != null) {
			return (n1.data == n2.data && isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right));
		}
		return false;
	}
}
