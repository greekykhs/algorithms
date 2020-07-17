package com.algo;

public class MaxConsecutiveOnes {
	public static void main(String[] args) {
//		int arr[] = new int[] { 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1 };
//		System.out.println(findMaxConsecutiveOnes(arr));
		
		int arr[] = new int[] { 1, 1, 0, 1};
		System.out.println(getMaxLength(arr));
	}
	
	// Function to return the count of maximum 
    // consecutive 1's in a binary circular array 
	
	/*
	 * Algorithm:
		1). We will start iterating the array from left to right till we encounter a zero, during the iteration we will increment 'onesFromStart'. And 'start' will contain the index where we last constinous one was present.
		2). We will start iterating the array from right to left till we encounter a zero, during the iteration we will increment 'onesFromEnd'. And 'end' will contain the index where we last constinous one was present
		3). When onesFromStart is greater than onesFromEnd, that means array contain all 1's.
		4). We will maintain 2 count 'result' and 'onesInMid'. We will start iterating the array from 'start' to 'end' (i.e mid region). We will increment onesInMid when we get 1, else we will set onesInMid as 0 when we encounter zero. 
		5). At the end the max(result, onesFromStart + onesFromEnd) will give the maximum number of constinous 1s. Here onesFromStart + onesFromEnd is the number of constinous one when we when we join end and start of the array.

	 * */
	public static int getMaxLength(int arr[]) {
		int n = arr.length;

		// Starting index
		int start = 0;
		//it will contain number of ones from left
		//to right till we encounter zero.
		int onesFromStart = 0;
		while (start < n && arr[start] == 1) {
			onesFromStart++;
			start++;
		}

		// Ending index
		int end = n - 1;
		//it will contain number of ones from right
		//to left till we encounter zero.
		int onesFromEnd = 0;
		while (end >= 0 && arr[end] == 1) {
			onesFromEnd++;
			end--;
		}

		// The array contains all 1s
		if (start > end)
			return n;

		//number of ones between start and end
		int onesInMid = 0;
		int result = 0;

		for (int i = start; i <= end; i++) {
			if (arr[i] == 1) {
				onesInMid++;
				result = Math.max(result, onesInMid);
			} else
				onesInMid = 0;
		}
		return Math.max(result, onesFromStart + onesFromEnd);
	}

	/*
	 * Let's say we want to find maximum consecutive one’s in a binary array.
	
		Algorithm:
		1). Maintain two counters current and max. 
		2). Start iterating the array, if 3.a). the current number is 1, we need to increment 'current'.
		3). If the current number is 0, then we need perfom below checks:
		3.a) If the 'current' is greater than 'max', we set 'current' in 'max'.
		3.b). If max is greater than equal to half of array length, so we should return max as there is no point in checking the array further.
		3.c). Set the 'current' as zero.
		4). Return 'current' or 'max', which ever is higher.
	*/
	public static int findMaxConsecutiveOnes(int[] arr) {
		int max = 0;
		int current = 0;
		for (int i : arr) {
			if (i == 1)
				current++;
			else {
				if (current > max)
					max = current;
				if (max >= arr.length / 2)
					return max;
				current = 0;
			}
		}
		return Math.max(max, current);
	}
}
