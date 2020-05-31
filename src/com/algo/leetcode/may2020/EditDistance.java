package com.algo.leetcode.may2020;

/*
 * Edit Distance

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')*/
public class EditDistance {
	/*
	 Algorithm
	We can perform below operations:
	a). Do nothing, when the characters are same.
	b). Replacement
	c). Deletion
	d). Insertion
	
	1). To solve this problem, we will create a memo table 'dp' in which length of:
	    a). columns will be length of word1 + 1
		a). rows will be length of word2 + 1
	2). We will iterate word1 and word2 to fill the first row and column of 'dp'.
	    a). The value in the first row of 'dp' will be 0 to the length of word1 (i.e 0, 1, 2, 3..)
		a). The value in the column row of 'dp' will be 0 to the length of word2 (i.e 0, 1, 2, 3..)
	REASON:
	(refer Step 1 from EditDistance-MemoTable.jpg)
	Let's say word1 is HORSE (length =5), and word2 is ROS(length=3). We will create a memo table dp [6][4]. We will now fill the first row and column of memo table.
	
	Populate the rows:
	dp[0][0] will be the number of steps to covert an empty string into an empty string it would be 0.
	dp[1][0] will be the number of steps to covert an empty string into the word 'R' it would be 1 insertion.
	dp[2][0] will be the number of steps to covert an empty string into the word 'RO' it would be 2 insertions.
	dp[3][0] will be the number of steps to covert an empty string into the word 'ROS' it would be 3 insertions.
	
	Populate the columns:
	dp[0][0] already has value 0.
	dp[0][1] will be the number of steps to transform 'H' into a empty string we need to perform 1 deletion.
	dp[0][2] will be the number of steps to transform 'HO' into a empty string we need to perform 2 deletions.
	dp[0][3] will be the number of steps to transform 'HOR' into a empty string we need to perform 3 deletions.
	dp[0][4] will be the number of steps to transform 'HORS' into a empty string we need to perform 4 deletions.
	dp[0][5] will be the number of steps to transform 'HORSE' into a empty string we need to perform 5 deletions.
	
	3). In the memo table value at the immediate top is the number of insertions (lets say i), value at the immediate left is number of deletions (lets say d), and value at the top left diagonal is the number of replacements (lets say r). 
	4). When the a character of word1 does not match with the character of word2, we will take minimum of i, d and r, increment it with 1 to populate the memo table. 
	5). When the a character of word1 match with the character of word2, we dont need to perform any thing i.e. zero replacements. In this case will populate the memo table with the value at r.
	
	e.g
	For dp[1][1] we need to convert 'H' with 'R', we will take minimum from r (0), i(1), d (1), increment it with 1. Minimum is 0 so dp[1][1] would be 1.
	
	Similarly we will populate dp[1][2] with the value 2.
	
	For dp[1][3] characters in word1 and word2 are same (which is R), so we will be performing zero replacement. In this case we will set the value at dp[1][3] with the value at the top left diagonal (which is 2). And so on..
	
	At the end dp[m][n] will give us the result.
	 * */
	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null)
			return -1;
		if (word1 == null || word1.length() == 0)
			return word2.length();
		if (word2 == null || word2.length() == 0)
			return word1.length();

		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];

		// update the first row
		for (int i = 1; i <= n; i++)
			dp[0][i] = i;

		// update the first column
		for (int j = 1; j <= m; j++)
			dp[j][0] = j;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				//zero replacements
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else {
					int replace = dp[i - 1][j - 1];
					int insert = dp[i][j - 1];
					int delete = dp[i - 1][j];

					dp[i][j] = Math.min(replace, Math.min(insert, delete))+1;
				}
			}
		}
		return dp[m][n];
	}
}
