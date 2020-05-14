package com.algo;

public class RemoveKElements {
	public static void main(String[] args) {
		//System.out.println(removeKdigits("1432219", 3));// Output: 1219
		//System.out.println(removeKdigits("10200", 1)); // Output: 200
		//System.out.println(removeKdigits("12345111111177", 5)); // Output: 111111117
		System.out.println(removeKdigits("10", 2)); // Output: 111111117
	}

	/*
	 * 1. Iterate the number k times. 
	 * 2. If the next number of a particular number is equal or smaller, remove it. 
	 * 3. Remove leading zeros.
	 */
	public static String removeKdigits(String num, int k) {
        if(num==null)
            return "0";
        else if(num.length()==0)
            return "0";
        StringBuilder stringBuilder = new StringBuilder(num);
		int j = 0;
		for (int i = 0; i < k; i++) {
			j = 0;
			while (j < stringBuilder.length() - 1 && stringBuilder.charAt(j) <= stringBuilder.charAt(j + 1)) {
				j++;
			}
			stringBuilder.delete(j, j + 1);
		}

		while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0')
			stringBuilder.delete(0, 1);

		if (stringBuilder.length() == 0) {
            return "0";
        }		
		return stringBuilder.toString();
    }
}
