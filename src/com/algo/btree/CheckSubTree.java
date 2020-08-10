package com.algo.btree;

/*
 * How to check if a Tree is subtree of another Tree?
 * 
 * To verify if a tree is subtree of another, we need to traverse the Tree T 
 * in a preorder fashion.For every visited node in the traversal, 
 * see if the subtree rooted with this node is identical to another tree S.
 * 
 * Time Complexity: Time worst case complexity of above solution is O(xy), 
 * where x and y are number of nodes in given two trees.
 * */
public class CheckSubTree {
	IdenticalBinaryTrees ibt=new IdenticalBinaryTrees();
	
	boolean isSubtree(Node T, Node S)  
    { 
        if (S == null)  
            return true;    
        if (T == null) 
            return false;    
        if (ibt.isIdentical(T, S))  
            return true; 
   
        return isSubtree(T.left, S) 
                || isSubtree(T.right, S); 
    } 
}


