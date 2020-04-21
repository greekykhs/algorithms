package com.algo.leetcode;

/*
 public class TreeNode {
    int val;
     TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
}
 * */
class Index {  
    int index = 0; 
} 
  
class ConstructBSTFromPreOrder
{
	Index index = new Index(); 
	  
	/*
	 * Algorithm 
	 * 1). We will write a recursive function constructTree(), which will create a Binary tree 
	 * 	from preorder. This function will take preorder, preIndex, min and max.
	 * 2). We will first construct the root node of BST which would be the first key in the 
	 * 	preorder sequence. But before this we will check if key is greater than min (which is 
	 * 	Integer.MIN_VALUE for root node) and less than max(which is Integer.MAX_VALUE for the root node).
	 * 3). Call the recursive function for the left sub-tree with keys in the preorder 
	 * 	 sequence that appears before the i'th index (excluding first index).
	 * 4). Call the recursive function for the right sub-tree with keys in the preorder 
	 * 	sequence that appears after the i'th index (including i'th index)
	 * */
	public TreeNode constructTree(int preorder[], Index preIndex, int key, int min, int max) {
		int size=preorder.length;
		if (preIndex.index >= size)
			return null;
		
		TreeNode root = null;

		if (key > min && key < max) {
			root = new TreeNode(key);
			preIndex.index = preIndex.index + 1;

			if (preIndex.index < size)
				root.left = constructTree(preorder, preIndex, preorder[preIndex.index], min, key);
			if (preIndex.index < size)
				root.right = constructTree(preorder, preIndex, preorder[preIndex.index], key, max);
		}
		return root;
	}
  
    public TreeNode bstFromPreorder(int[] preorder) {
    	return constructTree(preorder, index, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

	public void printInorder(TreeNode node) {
		if (node == null)
			return;
		
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}
  
	public static void main(String[] args) { 
		/* 
		 * Construct below BST
		        8
		      /    \
		     /      \
		    5       10
		   /  \     /  \
		  /    \   /    \
		 1      7 null  12
		*/
    	ConstructBSTFromPreOrder btree = new ConstructBSTFromPreOrder(); 
        //int preorder[] = new int[]{4,2}; 
    	int preorder[] = new int[]{8,5,1,7,10,12};
        TreeNode root = btree.bstFromPreorder(preorder); 
        System.out.println("Inorder traversal of the constructed Binary tree is:- "); 
        btree.printInorder(root); 
    } 
}