package com.algo.leetcode.may2020;

/*
 * Maximum Sum Circular Subarray
Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 < = i  < A.length, and C[i+A.length] = C[i] when i > = 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i < = k1, k2 < = j with k1 % A.length = k2 % A.length.)

Example 1:
Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3

Example 2:
Input: [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10

Example 3:
Input: [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4

Example 4:
Input: [3,-2,2,-3]
Output: 3
Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3

Example 5:
Input: [-2,-3,-1]
Output: -1
Explanation: Subarray [-1] has maximum sum -1
 
Note:
-30000 < = A[i] < = 30000
1 < = A.length < = 30000*/
public class MaximumSumCircularSubarray {	
	public int maxSubarraySumCircular1(int[] A) {
		if(A==null || A.length==0) 
			return 0;
		int sum=A[0];
		int maxTillNow=A[0], maxTotal=A[0];
		int minTillNow=A[0], minTotal=A[0];
		
		for(int i=1; i<A.length; i++) {
			if(A[i]+maxTillNow > A[i])
				maxTillNow+=A[i];
			else
				maxTillNow=A[i];
			
			if(A[i]+minTillNow < A[i])
				minTillNow+=A[i];
			else
				minTillNow=A[i];
			
			maxTotal=Math.max(maxTotal, maxTillNow);
			minTotal=Math.min(minTotal, minTillNow);
			sum+=A[i];
		}
		if(sum==minTotal)
			return maxTotal;
		else
			return Math.max(sum-minTotal, maxTotal);
	}

	public int maxSubarraySumCircular(int[] A) {
		if(A==null || A.length==0) 
			return 0;
		int sum=0;
		int maxTillNow=0, maxTotal=Integer.MIN_VALUE;
		int minTillNow=0, minTotal=Integer.MAX_VALUE;
		for (int a: A) {
			sum+=a;
			maxTillNow=Math.max(a+maxTillNow, a);
			maxTotal=Math.max(maxTotal, maxTillNow);
			
			minTillNow=Math.min(a+minTillNow, a);
			minTotal=Math.min(minTotal, minTillNow);
		}
		
		if(maxTotal>0)
			return Math.max(maxTotal, sum-minTotal);
		return maxTotal;		
		
	}
	public static void main(String[] args) {
		MaximumSumCircularSubarray m=new MaximumSumCircularSubarray();
		int[] A= {1,-2,3,-2};
		System.out.println(m.maxSubarraySumCircular(A));
	}
}
