package com.algo.leetcode.may2020;

/*
 * Counting Bits

Given a non negative integer number num. For every numbers i in the range 0 <= i <= num calculate the number of 1's in their binary representation and return them as an array.

Example 1:
Input: 2
Output: [0,1,1]

Example 2:
Input: 5
Output: [0,1,1,2,1,2]

Follow up:
It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.*/
public class CountingBits {
	/*
	 * Algorithm:
	 * 	1). We can solve this by checking if the number is even or odd.
		2). If the number is odd (1, 3, 5, 7), the number of 1 bits is 
			equal to the number (i - 1) plus 1.
		3). In case of even number, the number of 1's is equal to the number 
			which is half of it. e.g the number 8 has the same 1's as the number 4. 
			10 has the same amount of 1's as number 5. Reason is number i is just 
			left shift by 1 bit from number i / 2, thus we should have the same number of 1 bits.
	 * */
	public int[] countBits(int num) {
		int[] result = new int[num + 1];

		for (int i = 1; i <= num; i++) {
			if ((i & 1) == 0)
				result[i] = result[i / 2];
			else
				result[i] = result[i - 1] + 1;
		}
		return result;
	}	
	public static void main(String[] args) {
		new CountingBits().countBits(5);
	}
}
