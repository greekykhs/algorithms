package com.algo.leetcode;

/*
 * Max Consecutive Ones

	Given a binary array, find the maximum number of consecutive 1s in this array.
	
	Example 1:
	Input: [1,1,0,1,1,1]
	Output: 3
	
	Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
	Note:
	The input array will only contain 0 and 1.
	The length of input array is a positive integer and will not exceed 10,000
 * */
public class MaxConsecutiveOnes {	
	/*
	 * Algorithm
		1). Declare two variables max and tempmax. 
		2). Start iterating the array, if the current number is 1 increment tempmax.
		3). If we encounter 0, and tempmax is greater than max, 
			we will assign tempmax to max.
		4). To improve the performance we can check if the max is greater than or 
			equal to half of the array length, we will return max as there is 
			no point in checking the array further.
		5). When we encounter 0, we will reset tempmax to 0.
		6). At the end we will return max or tempmax, whichever is greater.
	 * */
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int tempmax = 0;
		for (int i : nums) {
			if (i == 1)
				tempmax++;
			else {
				if (tempmax > max)
					max = tempmax;
				if (max >= nums.length / 2)
					return max;

				tempmax = 0;
			}
		}
		return Math.max(max, tempmax);
	}
	public static void main(String[] args) {
		int[] nums= {1,1,0,1,1,1};
		System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
	}
}
