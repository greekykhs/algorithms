package com.algo;

/*
 * You are given a list of n-1 integers and these integers are in the range of 1 to n. 
 * There are no duplicates in the list. One of the integers is missing in the list. Write an efficient code to find the missing integer.
 * Example: Input: arr[] = {1, 2, 4, 6, 3, 7, 8}, Output: 5
 * */
public class MissingNumber {

	public static void main(String[] args) {
		int a[] = {1, 2, 4, 6, 3, 7, 8};
		System.out.println("Missing No.:"+missingNo1(a, a.length));
		
	}
	
	/*
	 * 1. Get the sum all of the numbers in given list, let's say its A
	 * 2. Get Sum all of the numbers from 1 to n, let's say its B
	 * 3. The missing number is: (B - A)
	 * */
	public static int missingNo2(int a[], int n)
	{
		int total=0;
		//get the total of numbers in the list
		for (int i = 0; i < n; i++) 
			total=total+a[i];		
		//get the sum of 'n' numbers and subtract it from the total
		return ((n + 1) * (n + 2) / 2)-total; 
	}
	
	public static int missingNo1(int a[], int n)
	{int x1 = a[0]; 
    int x2 = 1; 
    
    /* For xor of all the elements  
       in array */
    for (int i = 1; i < n; i++) 
    {
        x1 = x1 ^ a[i];
        System.out.println(x1);
    }
		
		return n;
	}

}
