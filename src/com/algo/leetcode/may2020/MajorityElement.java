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
	public int majorityElement(int[] nums) {
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
	public static void main(String[] args) {
		System.out.println();

	}

}
