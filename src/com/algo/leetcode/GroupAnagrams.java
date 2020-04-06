package com.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Group Anagrams
 * Given an array of strings, group anagrams together.
 * 
 * Example: 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * */
public class GroupAnagrams {

	/*
	 * Algorithm:
	 * To find if two strings are anagram, we need to sort them and compare. 
	 * They are anagram if they are equal.
	 * 
	 * We will create a map, with key as the sorted string and value is the list of Strings.
	 * */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> groupAnagrams=new ArrayList<List<String>>();
		if(strs.length>0)
		{
	        Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
	        char[] charArray;
	        String key;
	        
	        for (String str : strs) {
	            charArray = str.toCharArray();
	            Arrays.sort(charArray);
	            key = String.valueOf(charArray);
	            if (!anagramMap.containsKey(key)) 
	            	anagramMap.put(key, new ArrayList<String>());
	            
	            anagramMap.get(key).add(str);
	        }
	        groupAnagrams=new ArrayList(anagramMap.values()); 
		}
        return groupAnagrams; 
    }
	public static void main(String[] args) {

        String strs[]= {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));

	}

}
