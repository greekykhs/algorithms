package com.algo.leetcode;

import java.util.Stack;

/*
 * Backspace String Compare
 * 
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * 
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * 
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * 
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * 
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * 
 * Note:
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * 
 * Follow up: Can you solve it in O(N) time and O(1) space?
 * */
public class BackspaceStringCompare {

	public static void main(String[] args) {
		String S = "a##c", T = "#a#c";
		boolean b=new BackspaceStringCompare().backspaceCompare(S, T);
		System.out.println(b);
	}

	public boolean backspaceCompare(String S, String T) {
		return build(S).equals(build(T));
	}

	/*
	 * Push the character in Stack if its not equal to #
	 * Else, pop.
	 * */
	public String build(String str) {
		Stack<Character> chatStack = new Stack<>();
		for (char c : str.toCharArray()) {
			if (c != '#')
				chatStack.push(c);
			else if (!chatStack.empty())
				chatStack.pop();
		}
		return String.valueOf(chatStack);
	}
}
