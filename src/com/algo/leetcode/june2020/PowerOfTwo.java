package com.algo.leetcode.june2020;

/*Power of Two
Given an integer, write a function to determine if it is a power of two.

Example 1:
Input: 1
Output: true 
Explanation: 2 power 0 = 1

Example 2:

Input: 16
Output: true
Explanation: 2 power 4 = 16

Example 3:
Input: 218
Output: false*/
public class PowerOfTwo {

	//Solution 1
	public boolean isPowerOfTwo1(int n) {
        // Corner case
        if(n == 0) return false;
        
        while(n % 2 == 0) 
        	n /= 2;
        
        return n == 1;
    }
	
	//Solution 2: Bit Manipulation
	public boolean isPowerOfTwo(int n) {
		// Corner case
		if (n == 0) return false;

		//All the digits except the highest digit must be 0
		// we will loop until we just have 1 digit
		while (n > 1) {
			//verify if if the lowest digit is 0
			if ((n & 1) != 0)
				return false;
			n >>= 1;
		}
		return true;
	}
}
