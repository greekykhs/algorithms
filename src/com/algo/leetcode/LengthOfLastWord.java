package com.algo.leetcode;

/*
 * Length of Last Word
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word (last word means the last appearing word if we loop 
 * from left to right) in the string.
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 * 
 * Example: Input: "Hello World" Output: 5
 * */
public class LengthOfLastWord {

	public static void main(String[] args) {
		String s=" ";
		System.out.println("Length of last word of "+s+", is "
				+new LengthOfLastWord().lengthOfLastWord(s));
	}

	public int lengthOfLastWord(String s) {
        int length=0;
        String lastWord="";
        if(s!=null && !"".equals(s.trim()))
        {
        	String[] splited = s.split("\\s+");
        	lastWord=splited[splited.length-1];    		
        	length=lastWord.length();
        }
        return length;
    }
}
