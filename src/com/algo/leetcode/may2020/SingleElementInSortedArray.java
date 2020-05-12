package com.algo.leetcode.may2020;

public class SingleElementInSortedArray {

	/*Algorithm:
	1). "Every element appears exactly twice, except for one element which appears exactly once." This means length of the array would be always odd.
	2). If the length is one, return the first element.
	3). We will start iterating the array, by declaring 2 points i & j. Element at ith and jth position will be consecutive.
	4). If element at ith position is not equal to element at jth position, return the ith element, else increment the j with 2.
	5). If no such element is encountered, we can confidently return the last element in the sorted array (as it will be the one with out a duplicate value).
	*/
	public int singleNonDuplicate(int[] nums) {
		int length = nums.length;
		if (length == 1)
			return nums[0];

		for (int i = 0, j = 1; i < length - 1; i += 2) {
			if (nums[i] != nums[j])
				return nums[i];
			j += 2;
		}
		return nums[length - 1];
	}
}
