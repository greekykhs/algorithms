package com.algo.leetcode.august2020;

/*
 * Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false
 

Constraints:
s consists only of printable ASCII characters.
 * */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;
		if (s.equals(""))
			return true;

		//two pointer from left and right
		int left = 0;
		int right = s.length() - 1;
		char leftChar;
		char rightChar;

		// Scan from left and right to the middle
		while (left <= right) {
			//Update left and right char
			leftChar = s.charAt(left);
			rightChar = s.charAt(right);
			
			//Skip non-alphanumeric character
			if (!Character.isLetterOrDigit(leftChar)) {
				left++;
			} else if (!Character.isLetterOrDigit(rightChar)) {
				right--;
			} else {
				//Check if same char (ignoring cases)
				if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar))
					return false;
				
				left++;
				right--;
			}
		}
		return true;
	}
	
	
}
