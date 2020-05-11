package com.algo.leetcode;

import java.util.Arrays;

/*Squares of a Sorted Array

Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Note:
1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.*/
public class SquaresOfSortedArray {
	/*
	 * Solution 1:
		1). We can iterate through the array, replace each number with its square.
		2). Use Arrays.sort() to sort the array.
	*/
	public int[] sortedSquares1(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[i] = A[i] * A[i];
		}
		Arrays.sort(A);
		return A;
	}
	
	/*
	 * Algorithm 2: Using two pointers approach
		The array that we get after calculating square root of each element could be:
		A). In increasing order, if all the elements in the original 
			array are positive numbers.
		B). In decreasing order, if all the elements in the original 
			array are negative numbers.
		C). In decreasing and than increasing, if the original array 
			contains both positive and negative numbers.
		
		In the two pointers approach, we will find the points from where the array 
			value starts increasing. After finding the points, we will iterate the 
			array in both the directions and merge it to new array.
		
		'j' will initially have the count of negative numbers in the input Array. 
			We will increment the count, while iterating and finding the square 
			root. When the number is less than 0, we will increment 'j'.
		
		Let's say our input array is -3, -2, -1, 4, 5, 6. Then after finding 
			the square it would be 9, 4, 1, 16, 26, 36. In thus case j will be 3. 
		
		We will create output array outputA and start populating it.
		
		The first while loop will move square root of all the negative numbers 
			from array A to outputA, but in sorted order.		
		If the array has only 1 element, that too negative then this condition 
			is handled in second while loop.		
		Third while loop will move square root of all the positives numbers from array A to outputA.
	*/
	public int[] sortedSquares(int[] A) {
		//initially have count of negative numbers
		int j = 0;
		
		//find the square
		for (int k = 0; k < A.length; k++) {
			if (A[k] < 0)
				j++;
			A[k] = A[k] * A[k];
		}
		int i = j - 1;
		int s = 0;
		int[] outputA = new int[A.length];
		
		while (i >= 0 && j <= A.length - 1) {
			if (A[i] < A[j]) {
				outputA[s] = A[i];
				i--;
			} else {
				outputA[s] = A[j];
				j++;
			}
			s++;
		}
		while (i >= 0) {
			outputA[s] = A[i];
			i--;
			s++;
		}
		while (j <= A.length - 1) {
			outputA[s] = A[j];
			j++;
			s++;
		}
		return outputA;
	}
	public static void main(String[] args) {
		SquaresOfSortedArray s=new SquaresOfSortedArray();
		int[] A= {-3, -2, -1, 4, 5, 6};
		//int[] A= {-1};
		System.out.println(s.sortedSquares(A));
	}
}
