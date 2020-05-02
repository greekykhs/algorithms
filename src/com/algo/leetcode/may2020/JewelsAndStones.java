package com.algo.leetcode.may2020;

import java.util.HashSet;
import java.util.Set;

/*
 * Jewels and Stones
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:
Input: J = "z", S = "ZZ"
Output: 0

Note:
S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 * */
public class JewelsAndStones {
	/*
	 * Algorithm
	1). If the length of either J or S is 0, return 0.
	2). Create a set and add all the Jewels in it by iterating J.
	3). numberOfStones is the count of Stones which are also jewels.
	4). Now we start iterating the stones we have (i.e S) 
		and check if the stone is present in jewel set, if yes increment numberOfStones.
	5). Return the numberOfStones.
	 * */
	public int numJewelsInStones(String J, String S) {
		int numberOfStones = 0;
		if(J.length()==0 || S.length()==0)
			return 0;
		
        Set<Character> jSet = new HashSet<>();
        
        //adding all the jewels in the set
        for(int j = 0; j < J.length(); j++)
            jSet.add(J.charAt(j));
        
        for(int i = 0; i < S.length(); i++)
        	//if the stone is present in jewels increment numberOfStones
            if(jSet.contains(S.charAt(i)))
                numberOfStones++;
        
        return numberOfStones;
	}
}
