package com.algo.leetcode;

/* Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * Example: Input: [0,1,0,3,12], Output: [1,3,12,0,0]
 * 
 * Note:
 * You must do this in-place without making a copy of the array.\
 * Minimize the total number of operations.
 * */
public class MoveZeroes {

	public static void main(String[] args) {
		int nums[] = {0,1,0,3,12}; 
		System.out.println("***Printing original array:");
		printArray(nums);
        new MoveZeroes().moveZeroes(nums); 
        System.out.println("***Printing array after moving zeros:");
		printArray(nums);
	}
	
	public static void printArray(int[] nums)
	{
		for (int i=0; i<nums.length; i++) 
            System.out.print(nums[i]+" ");		
		System.out.println();
	}
	/*
	 * A counter (nonZeroCount) will maintain number of non-zero elements.
	 * Traverse the array, and check if the element is non-zero.
	 * If the element is non-zero, put that element at nums[nonZeroCount] and increment the nonZeroCount.
	 * After the traversal, all non-zero elements will be shifted to the front-end.
	 * We need to run a loop again, which will make all element zero from nonZeroCount till the end.*/
	public void moveZeroes(int[] nums) {
		int nonZeroCount = 0, length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[i] != 0)
				nums[nonZeroCount++] = nums[i];
		}
		while (nonZeroCount < length)
			nums[nonZeroCount++] = 0;
	}
}
