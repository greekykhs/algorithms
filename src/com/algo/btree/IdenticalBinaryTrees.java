package com.algo.btree;

public class IdenticalBinaryTrees {
	boolean isIdentical(Node n1, Node n2)  
    { 
        if (n1 == null && n2 == null) 
            return true; 
        else if (n1 != null && n2 != null) { 
            return (n1.data == n2.data 
                    && isIdentical(n1.left, n2.left) 
                    && isIdentical(n1.right, n2.right));    
        }
        return false; 
    } 
}
