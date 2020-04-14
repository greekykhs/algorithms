package com.algo.leetcode;

import java.util.HashMap;

/*
 * Contiguous Array
 * 
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * 
 * Example 1: Input: [0,1], Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * 
 * Example 2: Input: [0,1,0], Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * 
 * Note: The length of the given binary array will not exceed 50,000.
 * */
public class ContiguousArray {

	/*
	 * Algorithm:
	 * 1. Replace all the 0's with -1, this will help us to find out 
	 *    the maximum length subarray with sum = 0.
	 * 2. Declare a HashMap, this will help us to find the subarray with
	 *    sum=0 and start index is not 0.
	 * 3. Declare three variables sum, maxLength and endIndex. Initialize maxsize 
	 *    with -1 to handle cases where all 1's or 0's. maxsize=-1 means there is no such subarray.
	 * 4. Now we will start iterating, and update the sum.
	 * 5. If the sum is equal to 0, increment the maxLength and update endIndex.
	 * 6. We will check if the sum is present in the HashMap. If not present 
	 *    add the sum as key and value as index.
	 * 7. If the value is present, check if the difference of current index and 
	 *    previously stored value in hash (for the sum) is more than maxsize. 
	 *    If yes, update maxsize and endIndex.
	 * 8. Replace all the -1's with 0
	 */
	public int findMaxLength(int[] arr) {
		int length = arr.length;
		
		//replace all the 0's with -1
		for (int i = 0; i < length; i++)  
			arr[i] = (arr[i] == 0) ? -1 : 1;
		   
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>(); 
  
        int sum = 0, maxLength = 0;
        int endIndex = -1; 
          
        for (int i = 0; i < length; i++)  
		{
			sum += arr[i];
			//if the sum is zero increment the max length and update the end index
			if (sum == 0) {
				maxLength = i + 1;
				endIndex = i;
			}
			if (hM.containsKey(sum)) {
				if (maxLength < i - hM.get(sum)) {
					maxLength = i - hM.get(sum );
					endIndex = i;
				}
			} else
				hM.put(sum, i);
		} 
  
        //replace -1 with 0
        for (int i = 0; i < length; i++) 
            arr[i] = (arr[i] == -1) ? 0 : 1; 
         
        int end = endIndex - maxLength + 1; 
        System.out.println(end + " to " + endIndex); 
        System.out.println(maxLength);
        return maxLength; 
	}
	public static void main(String[] args) {
		int nums[] ={0,0,1,0,0,0,1,1};// {1, 0, 0, 1, 0, 1, 1};
		new ContiguousArray().findMaxLength(nums);

	}

}
