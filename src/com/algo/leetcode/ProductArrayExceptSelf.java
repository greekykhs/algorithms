package com.algo.leetcode;

/*
 * Product of Array Except Self
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).
 * */
public class ProductArrayExceptSelf {
	/*
	 * Algorithm:
	1). create a new array 'output' with the length same as the input array 'nums'. 
		In 'output' array for a given index i, output[i] would contain the product 
		of all the numbers to the left of i and product of all the numbers to the right of i.
	2). We will first find the product of all the elements to the left. 
		To do this let's assume in 'output' array for a given index i, output[i] would 
		contain the product of all the numbers to the left of i. 
	3). For the element at index '0', there are no elements to the left, that's why output[0]= 1
	4). output[i-1] will have the product of elements to the left of 'i-1', 
		to do this we need to multiply nums[i - 1] with output[i-1]
	5). Declare a int variable 'right', which cntains the product of all the elements to the right.
	6). For the last element (the element at index 'length-1') there are no elements 
		to the right, that's why R will be 1.
	7). We need to update output[i] it will be the product of output[i] and 'right'. 
		After doing this we need to update 'right' (it would be product of 'right' and nums[i]).
	 */
	public int[] productExceptSelf(int[] nums) {
		int length = nums.length;
		int[] output = new int[length];
		output[0] = 1;
		for (int i = 1; i < length; i++) 			
			output[i] = nums[i - 1] * output[i - 1];		
		int right = 1;
		for (int i = length - 1; i >= 0; i--) {			
			output[i] = output[i] * right;
			right = right*nums[i];
		}
		return output;
	}

	public static void main(String[] args) {
		int[] nums= {1,2,3,4};
		new ProductArrayExceptSelf().productExceptSelf(nums);
	}
}
