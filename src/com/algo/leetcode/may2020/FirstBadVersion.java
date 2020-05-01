package com.algo.leetcode.may2020;

/*(May LeetCoding Challenge): First Bad Version

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
*/
public class FirstBadVersion extends VersionControl{
	@Override
	boolean isBadVersion(int version) {
		// TODO Auto-generated method stub
		return false;
	}
	/*
	 * Algorithm:
	  1). First Bad Version is a typical example of Binary search. 
	  	To solve this we will maintain 2 pointers start and end.
	  2). We will start iterating and find the middle element. 
	  	To avoid overflow I used '(end-start)/2 + start' instead of '(start + end)/2'.
	  3). Now we will check id middle is the bad version, if yes then we need 
	  	to find the bad version from start to middle, else bad version is present 
	  	between 'middle+1 and end'. We will change start and end positing depending 
	  	on whether the middle element is the bad version of not. 
	 * */
	public int firstBadVersion(int n) {
		int start=1, end=n, mid=0;
		while (start<end) {
			mid=start+(end-start)/2;
			if(isBadVersion(mid))
				end=mid;
			else
				start=mid+1;
		}
		return start;
	}
}
