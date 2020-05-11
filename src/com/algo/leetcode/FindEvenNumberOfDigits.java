package com.algo.leetcode;

/*
 * Find Numbers with Even Number of Digits

Given an array nums of integers, return how many of them contain an even number of digits.
 
Example 1:
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.

Example 2:
Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits.

Constraints:
1 <= nums.length <= 500
1 <= nums[i] <= 10^5
 * */
public class FindEvenNumberOfDigits {
	/*
	 * Algorithm
		1). We need to check the length of each number, 
			if the length is even, increment the counter.
		2). To find the length we will convert each number 
			into String by using Integer.toString() method.
		3). Then we will divide the length of converted String 
			by 2, if the remainder is 0, it is even.
	 * */
	public int findNumbers(int[] nums) {
		int count = 0;
		if(nums.length!=0)
		{
			String strNum;
			for (int i = 0; i < nums.length; i++) {
				strNum = Integer.toString(nums[i]);
				if (strNum.length() % 2 == 0)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		FindEvenNumberOfDigits find=new FindEvenNumberOfDigits();
		int[] nums1= {12,345,2,6,7896};
		System.out.println("In [12,345,2,6,7896], Numbers with Even Number of Digits is:"+find.findNumbers(nums1));
		
		int[] nums2= {555,901,482,1771};
		System.out.println("In [555,901,482,1771], Numbers with Even Number of Digits is:"+find.findNumbers(nums2));
	}
}
