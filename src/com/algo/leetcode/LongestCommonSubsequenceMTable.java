package com.algo.leetcode;

/*
 * Longest Common Subsequence
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

If there is no common subsequence, return 0.

Example 1:
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:
1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
 * */
public class LongestCommonSubsequenceMTable {
	/*
	 * Algorithm 1 is taking exponential time. If you check the example where we are 
	 * passing 'bd' and 'abcd', you will notice we are calling the recursive function 
	 * twice for values 'd' and 'c' (which is again calling the recursive function to 
	 * get the longest common subsequence).
	 * 
	 * Instead of calling the recursive function again and again for the same parameters, 
	 * we can make use of memorization. In this technique we store the results for each 
	 * recursive call's and while executing the recursive function we will check if the 
	 * result is already computed. If yes, we will return the result, else calculate it.
	 * 
	 * Steps:
	 * 1). Create a memorization table lcs (two dimensional array) of text1.length+1 
	 * 		and text2.length+1.
	 * 2). Since we have created 2 dimensional array of int type, value at any index is zero.
	 * 3). We will start comparing each character of text1 with each character of text2, 
	 * 		and while doing so we will fill our memorization table.
	 * 4). If text1[i-1]=text2[j-1], we will set lcs[i][j]=1 + value at left diagonally 
	 * 		upward position of memorization table (lcs[i-1][j-1]).
	 * 5). Else set lcs[i][j]=value at exactly upper position or value at exactly left 
	 * 		position, which ever is higher.
	 * 6). Longest Common Subsequence would be the value at the last index of 
	 * 		memorization table (i.e lcs [m][n]).
	 * */
	public int longestCommonSubsequence(String text1, String text2) {
		int m=text1.length();
		int n=text2.length();
		int lcs[][]=new int[m+1][n+1];
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; ++j){
				if(text1.charAt(i-1)==text2.charAt(j-1))
					lcs[i][j]=1+lcs[i-1][j-1];
				else
					lcs[i][j]=Math.max(
							lcs[i][j-1], lcs[i-1][j]);
			}
		}
     return lcs[m][n];
    }
	
	public static void main(String[] args) {
//		System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("bd", "abcd"));
		System.out.println(new LongestCommonSubsequenceMTable().longestCommonSubsequence("abcde", "ace"));

	}

}
