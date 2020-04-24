package com.algo.leetcode;

/*
 * Bitwise AND of Numbers Range
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * 
 * Example 1: Input: [5,7], Output: 4
 * Example 2:Input: [0,1], Output: 0
 * */
public class BitwiseAndOfNumRange {
	/*
	 * Algorithm
	 * 
	 * 1. FYI, as per the binary logic 0 AND 0 is 0, 
	 *    0 AND 1 is 0, 1 AND 0 is 0, 1 AND 1 is 1.
	 * 2. To solve this we will be using bitwise 
	 *    operators >> (left shift) and << (right shift). Lets say m is 1110, 
	 *    if we do m >> it will return 111 and if we do m << it will return 110.
	 * 3. Create a variable (shiftCounter) which will maintain the number of shifts.
	 * 4. In a while loop, we will check if m is less than n. We need to left shift m and n, 
	 *    increment 'shiftCounter'. There will be a situation when m will become equal to n
	 * 5. After this we will right shift n (or m) for 'shiftCounter' and return n (or m).

		e.g: lets say m is 9 and n is 12. Binary of 9 is 000001001 and 12 is 00001100. shiftCounter=0
		1). m is less than n, left shift both m and n. m=00000100 (i.e 4) and n=0000110 (i.e 6), shiftCounter=1
		2). Since m is less than n, left shift both m and n. m=0000010 (i.e 2) and n=000011 (i.e 3), shiftCounter=2
		3).  Again m is less than n, left shift both m and n. m=000001 (i.e 1) and n=00001 (i.e 1), shiftCounter=3.
		4). While loop will end, because now m and n are equal.
		5). We will now right shift n (or m) 3 times (because shiftCounter=3), this will give us n=00001000 (i.e 8). So the answer will be 8.
	 * */
	public int rangeBitwiseAnd(int m, int n) {
		int shiftCount = 0;
		while (m < n) {
			m >>= 1;
			n >>= 1;
			shiftCount++;
		}
		return n << shiftCount;
	}
}
