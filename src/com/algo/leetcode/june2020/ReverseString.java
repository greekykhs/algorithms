package com.algo.leetcode.june2020;

/*
 * Reverse String

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

Example 1:
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]*/
public class ReverseString {
	
	//two pointer approach
	public void reverseString1(char[] s) {
		int left = 0, right = s.length - 1;
		char temp;
		while (left < right) {
			temp = s[left];
			s[left++] = s[right];
			s[right--] = temp;
		}
	}
	public void reverseString(char[] s) {
		int length=s.length;
		char temp;
		for (int i = 0; i < length / 2; i++) {
			temp= s[i];
	        s[i] = s[length - i - 1];
	        s[length - i - 1] = temp;
	    }
	}
}
