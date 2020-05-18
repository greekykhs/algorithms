package com.algo.leetcode.may2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Permutation in String

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False

Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
*/
public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		if (findAnagrams(s2, s1).isEmpty())
			return false;
		return true;
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> output = new ArrayList<>();
		// corner case
		if (s == null || s.length() == 0 || s.length() < p.length()) {
			return output;
		}

		Map<Character, Integer> pcharCountMap = new HashMap<>();
		for (char c : p.toCharArray()) {
			pcharCountMap.put(c, pcharCountMap.getOrDefault(c, 0) + 1);
		}

		// number of distinct characters in p
		int numOfDistintCharInP = pcharCountMap.size();

		char cLeft, cRight;
		for (int left = 0, right = 0; right < s.length(); right++) {
			cRight = s.charAt(right);

			// if the char in 's' is present in map
			if (pcharCountMap.containsKey(cRight)) {
				// decrement the count in the map
				pcharCountMap.put(cRight, pcharCountMap.get(cRight) - 1);
				// when the count become zero, decrement numOfDistintCharInP
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
