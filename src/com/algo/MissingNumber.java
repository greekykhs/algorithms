package com.algo;

/*
 * You are given a list of n-1 integers and these integers are in the range of 1 to n. 
 * There are no duplicates in the list. One of the integers is missing in the list. Write an efficient code to find the missing integer.
 * Example: Input: arr[] = {1, 2, 4, 6, 3, 7, 8}, Output: 5
 * */
public class MissingNumber {

	public static void main(String[] args) {
		int a[] = {1, 2, 4, 6, 3, 7, 8};
		System.out.println("Missing No.:"+missingNo2(a, a.length));
		
	}

	/*
	 * Solution 1:
	Algorithm:
	1). Sum of all the n numbers from 1 to n is n*(n+1)/2. Since in the input one number is missing, the formula would be (n+1)(n+2)/2, where n is the length of input array.
	2). We will first calculate the sum using this formula.
	3). Now we will start iterating the given array and calculate the sum of all the elements in the array.
	4). We will subtract both the sums, it will give us the value of the missing element.
	
	Complexity Analysis:
	Time Complexity: O(n), because of only one traversal of array is needed.
	Space Complexity: O(1), because no extra space is needed
	 * */
	public static int missingNo1(int a[], int n)
	{
		int total=0;
		//get the total of numbers in the list
		for (int i = 0; i < n; i++) 
			total=total+a[i];		
		//get the sum of 'n' numbers and subtract it from the total
		return ((n + 1) * (n + 2) / 2)-total; 
	}
	
	/*
	 * Solution 2: Using XOR
	Algorithm:
	1). FYI, 1 XOR 1 is 0, 0 XOR 0 is 0, 1 XOR 0 or 0 XOR 1 is 1.
	2). Assume a1 ^ a2 ^ a3 ^....^ an = a and a1 ^ a2 ^ a3 ^...^ an-1 = b. Then a ^ b = an. Using this we can find the missing number. 
	3). Create two variables x and y. 
	4). Calculate XOR of all the natural number from 1 to n and store it as y.
	5). Calculate XOR of all the elements of the array and store it as x.
	6). The missing number will be x ^ y.
	
	Complexity Analysis:
	Time Complexity: O(n), because of only one traversal of array is needed.
	Space Complexity: O(1), because no extra space is needed
	 * */
	public static int missingNo2(int a[], int n) {
		int x = a[0];
		int y = 1;
		for (int i = 1; i < n; i++)
			x = x ^ a[i];		
		/*
		 * For xor of all the elements from 1 to n+1
		 */
		for (int i = 2; i <= n + 1; i++)
			y = y ^ i;		

		return (x ^ y);
	}

}
