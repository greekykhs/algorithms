package com.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*Write a method to find the first non-repeating character from a String?*/
public class NonRepeatingCharacter {
	/*
	Solution 1: Using LinkedHashMap.
	1). Create a LinkedHashMap, which will maintain the count.
	2). Convert the input string into a char array, start iterating it and add each character in LinkedHashMap. 
		If the character is already present in LinkedHashMap, increment the count.
	3). Loop through LinkedHashMap and find the character with the count as 1. 
	 */
	public static char getFirstNonRepeatedChar(String str) {
		Map<Character, Integer> counts = new LinkedHashMap(str.length());
		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}
		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("non repeated character not found");
	}
	
	/*
	 * Solution 2: Finds first non repeated character in a String in just one pass.
	 * 1). To cut down the iteration, we need Set and a List, set will contain
	 * repeating chars and List will contain non repeating chars. 
	 * 2). We will start iterating the input String, if the char is present in nonRepeating list,
	 * remove it and add it in repeating Set, else add the character in nonRepeating
	 * List. 
	 * 3). At the end return the 1st element from nonRepeating List.
	 */
	public static char firstNonRepeatingChar(String str) {
		Set<Character> repeating = new HashSet();
		List<Character> nonRepeating = new ArrayList();
		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			if (repeating.contains(letter)) {
				continue;
			}
			if (nonRepeating.contains(letter)) {
				nonRepeating.remove((Character) letter);
				repeating.add(letter);
			} else {
				nonRepeating.add(letter);
			}
		}
		return nonRepeating.get(0);
	}

}
