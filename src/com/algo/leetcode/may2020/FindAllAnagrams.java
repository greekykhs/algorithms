package com.algo.leetcode.may2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 * */
public class FindAllAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> output = new ArrayList<>();
		//corner case
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return output;
        }

        Map<Character, Integer> pcharCountMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pcharCountMap.put(c, pcharCountMap.getOrDefault(c, 0) + 1);
        }
        
        //number of distinct characters in p
        int numOfDistintCharInP = pcharCountMap.size();
        
        char cLeft, cRight;
        for (int left = 0, right = 0; right < s.length(); right++) {
            cRight = s.charAt(right);
            
            //if the char in 's' is present in map
            if (pcharCountMap.containsKey(cRight)) {
            	//decrement the count in the map
            	pcharCountMap.put(cRight, pcharCountMap.get(cRight) - 1);
            	//when the count become zero, decrement numOfDistintCharInP
                if (pcharCountMap.get(cRight) == 0)
                    numOfDistintCharInP -= 1;
           }

            while (numOfDistintCharInP <= 0) {
                cLeft = s.charAt(left);
                if (pcharCountMap.containsKey(cLeft)) {
                	pcharCountMap.put(cLeft, pcharCountMap.get(cLeft) + 1);
                    if (pcharCountMap.get(cLeft) > 0)
                        numOfDistintCharInP += 1;
                }
                if (right - left + 1 == p.length()) {
                	output.add(left);
                }
                left++;
            }
        }
		return output;
	}
}
