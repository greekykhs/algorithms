package com.algo.leetcode.may2020;

/*Number Complement
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.*/
public class NumberComplement {	
	/*
	 * Algorithm:
		1). 1 XOR 1 is 0, 0 XOR 0 is 0, 1 XOR 0 or 0 XOR 1 is 1. That means to find the complement, we need to XOR with 1.
		2). We will declare two variables mask and temp. Initialize mask with 1 and temp with the input number.
		3). Now in the while loop, we will left shift mask and right shift temp, till temp become zero. Why we are doing this?
		Lets say temp is 5 (which is 101) to find the complement (010) we need to XOR 5 with 7 (111).
		mask=1, temp=5(101)
		first iteration: mask=2(10), temp=2(10)
		second iteration: mask=4(100), temp=1(1)
		third iteration: mask=8(1000), temp=0(0)
		mask-1 is 7 i.e 111.
		4). At the end we will XOR the given number with mask-1
	 * */
	public int findComplement(int num) {
		int mask = 1, temp = num;
		while (temp > 0) {
			mask = mask << 1;
			temp = temp >> 1;
		}
		return num ^ (mask - 1);
	}	
	
	public static void main(String[] args) {
		System.out.println(new NumberComplement().findComplement(5));
	}
}
