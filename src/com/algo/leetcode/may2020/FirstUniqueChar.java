package com.algo.leetcode.may2020;

import java.util.HashMap;

/*First Unique Character in a String
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.*/
public class FirstUniqueChar {
	public int firstUniqChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < n; i++) {
            if (countMap.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
	public static void main(String[] args) {
		String s="loveleetcode";
		System.out.println(new FirstUniqueChar().firstUniqChar(s));
	}
}
