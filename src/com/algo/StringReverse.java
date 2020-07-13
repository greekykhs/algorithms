package com.algo;

public class StringReverse {
	//Reverse a String using CharAt Method
	public String reverStringCharAt(String str) {
		String reverseStr="";
		for(int i=str.length()-1;i>=0;i--)
			reverseStr=reverseStr+str.charAt(i);
		return reverseStr;
	}
	
	// Reverse a String using String Builder
	public String reverStringBuilder(String str) {
		return new StringBuilder(str)
				.reverse().toString();
	}
	
	// Reverse a String using String Buffer
	public String reverStringBuffer(String str) {
		return new StringBuffer(str)
				.reverse().toString();
	}
	
	//Reverse a String using Reverse Iteration
	public String reverStringItr(String str) {
		char c[]=str.toCharArray();
		String reverseStr="";
		//For loop to reverse a string
		for(int i=c.length-1;i>=0;i--)
			reverseStr+=c[i];
		
		return reverseStr;
	}
	
	//Reverse a String using Recursion
	public String reverStringRec(String str) {
		if(str.length() == 0)
			return " ";
		return str.charAt(str.length()-1) + 
				reverStringRec(str.substring(0,str.length()-1));
	}
}
