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
		 RansomNote main = new RansomNote();
	        boolean result = main.canConstruct("aa", "aab");
	        System.out.println(result);
	    }
	     
	    /* Solution */
	    public boolean canConstruct(String ransomNote, String magazine) {
	         
	        char[] array = magazine.toCharArray();
	         
	        int[] countArray = new int[26];        
	        for(char c : array){            
	            countArray[c-'a']++;
	        }
	         
	        array = ransomNote.toCharArray();
	        for(char c : array){   
	            if(countArray[c-'a'] > 0){
	                countArray[c-'a']--;
	            }else {
	                return false;
	            }            
	        }
	        return true;
	    }

}
