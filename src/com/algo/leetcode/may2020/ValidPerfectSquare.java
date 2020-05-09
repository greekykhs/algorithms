package com.algo.leetcode.may2020;

/*
 * Valid Perfect Square
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Output: true

Example 2:
Input: 14
Output: false
*/
public class ValidPerfectSquare {
	public static void main(String[] args) {
		ValidPerfectSquare validPerfectSquare=new ValidPerfectSquare();
		System.out.println("16 is perfect square? "+ validPerfectSquare.isPerfectSquare(16));
		System.out.println("14 is perfect square? "+ validPerfectSquare.isPerfectSquare(14));
	}

	public boolean isPerfectSquare1(int num) {
		if(num==0) return false;
		long sum = 0;
        for (int i = 1; sum < num; i = i + 2) {
            sum = sum + i;
            if (sum == num) {
                return true;
            }
        }
        return false;
	}
	
	/*
	 * Square root of any number ends with either 0, 1, 4, 9, 6, or 5.
	#If the last digit of any any number is 0, then the last digit of its square root will be 0.
	#If the last digit of any any number is 1 or 9, then the last digit of its square root will be 1.
	#If the last digit of any any number is 2 or 8, then the last digit #of its square root will be 4.
	#If the last digit of any any number is 3 or 7, then the last digit #of its square root will be 9.
	#If the last digit of any any number is 4 or 6, then the last digit of its square root will be 6.
	#If the last digit of any any number is 5, then the last digit of its square root will be 5.

	1). We will follow binary search to resolve this problem. 
	2). First we will check of the last digit of input is ending with 0, 1, 4, 9, 6, or 5 return false.
	3). We will create 4 variables left, right, mid and sq. Left will be initialized with 1 and right with the input number.
	4). In every iteration we will find the mid, and then check if the square of mid is equal, less, or greater than the input number. 
	5). If square of mid is equal to the input number,we will return true.
	6). If square of mid is greater than input number, then the square root of the input number will be always less than mid. In this case we will find the number from left to mid-1.
	7). If square of mid is less than input number, then the square root of the input number will be always greater than mid. In this case we will find the number from right to mid+1.
		 
	*/
	public boolean isPerfectSquare(int num) {
		int endswith=num%10;
		if(endswith==2 || endswith==3 ||
				endswith==7 || endswith==8)
			return false;
		int left=1, right=num;
		long mid, sq;
		while(left<=right) {
			mid=left+(right-left)/2;
			sq=mid*mid;
			if(sq==num)
				return true;
			else if(sq<num)
				left=(int)mid+1;
			else
				right=(int)mid-1;
		}
	    return false;
	}
}
