package com.algo.leetcode.may2020;

import java.util.HashMap;

/*Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times. You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2*/
public class MajorityElement {
	/*Solution 1 using Hash Map*/
	public int majorityElement1(int[] nums) {
		if(nums==null || nums.length==0)
			return -1;
		else if (nums.length==1)
			return nums[0];
		
		int length=nums.length, count=0;
		HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < length; i++) {
			if (countMap.containsKey(nums[i])) {
				count = countMap.get(nums[i]) + 1;
				if (count > length / 2)//majority element
					return nums[i];
				else
					countMap.put(nums[i], count);
			} else
				countMap.put(nums[i], 1);
		}
		return -1;
	}
	
	/*Using Boyer–Moore majority vote algorithm
	1). In this algorithm, we will process each element of the array. 
		We will maintain a counter (which is initialized with 0), 
		now let's say the current element is x.
	2). We will check if the counter is 0, if yes then set the current 
		candidate to x and increment the counter.
	3). Else, we need to increment or decrement the counter after 
		checking whether x is equal to the current candidate or not.		
	4). After iteration, if the sequence has a majority it will be x.
	
	NOTE: The Boyer–Moore majority vote algorithm produces correct result 
		only when majority element is present in the input.*/
	public int majorityElement(int[] nums)
	{
		if(nums==null || nums.length==0)
			return -1;
		else if (nums.length==1)
			return nums[0];
		
		// m stores majority element if present
		int majorityElement = -1;
		int length=nums.length, counter=0;
		
		for (int i = 0; i < length; i++)
		{
			if (counter == 0)			{
				// set the current candidate to A[j]
				majorityElement = nums[i];
				counter++;
			}
			// else increment the counter if A[j] is current candidate
			else if (majorityElement == nums[i])
				counter++;
			// decrement the counter if A[j] is not current candidate
			else
				counter--;
		}
		return majorityElement;
	}
	public static void main (String[] args)
	{
		int[] nums = {2,2,1,1,1,2,2};

		System.out.println(new MajorityElement().majorityElement(nums));
	}
}
