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
		int length=nums.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < length; i++) {
			if (map.containsKey(nums[i])) {
				int count = map.get(nums[i]) + 1;
				if (count > length / 2) {
					return nums[i];
				} else
					map.put(nums[i], count);

			} else
				map.put(nums[i], 1);
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
