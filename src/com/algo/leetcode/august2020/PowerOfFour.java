package com.algo.leetcode.august2020;

/*
 * Power of Four
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:
Input: 16
Output: true

Example 2:
Input: 5
Output: false

Follow up: Could you solve it without loops/recursion?
 * */
public class PowerOfFour {
	
	/*
	 * Solution 1: With loop In this approach we keep dividing the number by 4. If
	 * in any iteration n%4 becomes non-zero and n is not 1 then n is not a power of
	 * 4, otherwise n is a power of 4.
	 */
	public boolean isPowerOfFour1(int num)
    { 
        if(num == 0) 
        return false; 
        while(num != 1) 
        {  
            if(num % 4 != 0) 
            return false; 
            num = num / 4;      
        } 
        return true; 
    }  
	
	/*
	 * Solution 2: Without loop If num & (0x55555555) != 0 then the answer is true,
	 * because if the number is a power of 2, there must be only one '1' bit and
	 * that '1' bit must be in the even position of the number.
	 * 
	 * FYI, for Hex number 0x55555555, the binary representation is 0101 0101 0101.
	 * The bit '1' must be in the even position. If the bit 1 (and the only bit 1)
	 * is in the odd position, the result of (num & 0x55555555) must be equal to
	 * zero.
	 */
	public boolean isPowerOfFour(int num) {
		if (num <= 0) 
			return false;
		

		if ((num & (num - 1)) != 0)
			return false;
		
		// check if the '1' bit is on the even position
		return (num & 0x55555555) != 0;
	}
}
