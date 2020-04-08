package com.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*Counting Elements

Given an integer array arr, count element x such that x + 1 is also in arr. If there're duplicates in arr, count them seperately.

Example 1:
Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.

Example 2:
Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.

Example 3:
Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.

Example 4:
Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.

Constraints:
1 <= arr.length <= 1000
0 <= arr[i] <= 1000
*/
public class CountingElements {
	/* 1). We will create a hashmap in which the key is the element (from the array), 
	 *     value is the number of occurrence of that element in the array.
	 * 2). Iterate through map, and check if the key with value equal to current key +1 
	 *     is present in the map or not. If yes, increment the elementCount.*/
	public int countElements(int[] arr) {
		 Map<Integer, Integer> countMap=new HashMap<>();        
        int key=0;
        int elementCount=0;
        for (int i = 0; i < arr.length; i++) {
        	key=arr[i];
        	if (!countMap.containsKey(key)) 
        		countMap.put(key, 1);
        	else
        		countMap.put(key, countMap.get(key)+1);        	
        }
        for (Map.Entry<Integer, Integer> element : countMap.entrySet()) {
    		if (countMap.containsKey(element.getKey()+1))
    			elementCount++;
    	}
		return elementCount;
    }
	public static void main(String[] args) {
		//int nums[] = {1,2,3};
		//int nums[] = {1,1,3,3,5,5,7,7}; 
		int nums[] = {1,3,2,3,5,0}; 
		//int nums[] = {1,1,2,2}; 
		System.out.println("***Printing original array:");
		printArray(nums);
		System.out.println(new CountingElements().countElements(nums)); 
    }
	
	public static void printArray(int[] nums)
	{
		for (int i=0; i<nums.length; i++) 
            System.out.print(nums[i]+" ");		
		System.out.println();
	}

}
