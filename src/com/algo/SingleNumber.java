package com.algo;

public class SingleNumber {

	public static void main(String[] args) {
		//int nums[] = {2,2,1};
		int nums[] = {4,1,2,1,2};
		System.out.println(new SingleNumber().singleNumber(nums));
	}

	/* Given a non-empty array of integers, every element appears twice except for one.
	 * Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. 
	 * Could you implement it without using extra memory?
	 * 
	 * Example 1: Input: [2,2,1]. Output: 1
	 * Example 2: Input: [4,1,2,1,2]. Output: 4
	 * 
	 * Algorithm: We can do this problem by XORing all array elements, 
	 * this will gives us the number with single occurrence. 
	 * FYI: XOR of a number with itself is 0. And XOR of a number with 0 is number itself
	 * */
	public int singleNumber(int[] nums) {
		int res = nums[0]; 
        for (int i = 1; i < nums.length; i++) 
            res = res ^ nums[i];       
        return res; 
	}
}
