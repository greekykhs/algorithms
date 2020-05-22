package com.algo.leetcode.may2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*Sort Characters By Frequency

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:
Input: "tree"
Output: "eert"
Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input:"cccaaa"
Output:"cccaaa"
Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input:"Aabb"
Output:"bbAa"
Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

*/
public class SortCharactersByFrequency {
	//using priority queue
	public String frequencySort(String s) {
		//corner case
		if (s == null || s.length() == 0)
			return s;
		
		//cntArry will maintain the count of each character
		//there are a total 256 characters that's why size is 256
		int[] cntArry=new int[256];
		for (char c : s.toCharArray())
			cntArry[c]++;
		
		//Comparator is added in the priority queue, here the
		//comparison will be based on the frequency with which
		//any character is present in the count array i.e cntArry		
		PriorityQueue<Character> pq=new PriorityQueue<>(
				(a,b)-> cntArry[b]-cntArry[a]);
		
		//character been added is based on the fact what 
		//is the frequency of it in the counter
		for(int i=0; i<256; i++) 
			pq.offer((char)i);
		
		StringBuilder sb=new StringBuilder();
		Character c;
		while(!pq.isEmpty()) {
			//poll will first give the character which is present
			//max number of times
			c=pq.poll();
			//append the character in string builder depending on 
			//the frequency present in count array
			for(int i=0; i<cntArry[c]; i++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	//using hash map
	public String frequencySort1(String s) {
		StringBuilder res = new StringBuilder();
		if (s == null || s.length() == 0)
			return res.toString();

		//Map to store each char and its frequency
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		//An array of lists of chars, at the index (which is same as frequency)
		List<Character>[] bucket = new List[s.length() + 1];
		Character key;
		int frequency;
		for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
			key = entry.getKey();
			frequency = entry.getValue();
			if (bucket[frequency] == null)
				bucket[frequency] = new ArrayList<Character>();
			bucket[frequency].add(key);
		}
		//Iterate the list from high to low index
		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] != null) {
				for (char c : bucket[i]) {
					for (int j = 0; j < i; j++) {
						res.append(c);
					}
				}
			}
		}
		return res.toString();
	}
	
}
