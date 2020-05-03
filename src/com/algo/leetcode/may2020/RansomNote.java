package com.algo.leetcode.may2020;

/*
 * Ransom Note
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") - > false
canConstruct("aa", "ab") - > false
canConstruct("aa", "aab") - > true
 * */
public class RansomNote {
	public static void main(String[] args) {
		System.out.println(new RansomNote().canConstruct("aa", "aab"));
	}
	     
	/* Algorithm
		1). If the ransomNote is null, return true. 
		2). If magazine is null return false.
		3). If length of magazine should be always equal to or greater 
			than ransomNote note. If its less return false.
		4). Now we will convert the magazine into a charArray. And we 
			will create another array charCount which will contain 
			character wise count.
		5). We will start iterating the charArray, and increase the 
			count in charCount depending on the character. e.g if the 
			char is 'a', c-'a' will return 0 and the count at the 1th 
			position will be incremented. If the char is y, c-'y' will 
			return 25 and the count at the 25th position will be incremented.
		6). Now we will reused the same charArray and convert the 
			ransomNote into array and store in charArray.
		7). We will start iterating charArray, check if the charCount is 
			greater than 0 or not for that particular char, 
			if yes decrement the count. Else return false.*/
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote == null)
			return true;
		if (magazine == null)
			return false;
		if (magazine.length() < ransomNote.length())
			return false;

		char[] charArray = magazine.toCharArray();
		
		int[] charCount = new int[26];
		for (char c : charArray) {
			charCount[c - 'a']++;
		}

		charArray = ransomNote.toCharArray();
		for (char c : charArray) {
			if (charCount[c - 'a'] > 0)
				charCount[c - 'a']--;
			else
				return false;
		}
		return true;
	}
}
