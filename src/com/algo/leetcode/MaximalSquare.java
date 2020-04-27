package com.algo.leetcode;

/*
 * Maximal Square
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:
Input: 
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 * */
public class MaximalSquare {
	/*
	 * Algorithm:
1). Instead of creating a memo table of r*c, we will create an array of length c (where c is the length of input array).
2). a variable maxSquare will hold the maximum value present in the memo table. 
3). a variable leftTopDiagonalVal will contain the value of the left top diagonal of current position from the memo table. We will pre-populate the leftTopDiagonalVal with the value at first position of input array (matrix[0][0]).
4). a variable 'temp' will hold the value at jth position of memo table, where j is the current column index.
5). Now we will start iterating. For the first row and first column, we will copy the value from the input array. If the value if 1, we will update maxSquare (it would be either the current value of maxSquare or the value at jth position of memo table, whichever is higher).
6). For other rows and column, if the value at the input array is zero, we will update value at jth position of memo table as zero. Else, we will take the minimum value at jth position, j-1 position of memo table and leftTopDiagonalVal, increment the minimum value with 1 and update the value at jth position of memo table. Then we will update maxSquare.
7). We will update leftTopDiagonalVal. 
8). Output would be square of maxSquare.
	 * */
	public int maximalSquare(char[][] matrix) {
		int r = matrix.length;
		if (r == 0)
			return 0;
		int c = matrix[0].length;
		if (c == 0)
			return 0;

		int maxSquare = 0;
		int[] memoTable = new int[c];
		int leftTopDiagonalVal = matrix[0][0] == '0' ? 0 : 1;

		int temp;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				temp = memoTable[j];
				
				//either first row or column
				if (i == 0 || j == 0) {
					if (matrix[i][j] == '1') {
						memoTable[j] = 1;
						maxSquare = Math.max(maxSquare, memoTable[j]);
					} else
						memoTable[j] = 0;
				} else {
					if (matrix[i][j] == '1') {
						memoTable[j] = 1 + Math.min(Math.min(memoTable[j], memoTable[j - 1]), leftTopDiagonalVal);
						maxSquare = Math.max(maxSquare, memoTable[j]);
					} else
						memoTable[j] = 0;
				}
				leftTopDiagonalVal = (j == c - 1) ? memoTable[0] : temp;
			}
		}
		return maxSquare * maxSquare;
	}

	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		System.out.println(new MaximalSquare().maximalSquare(matrix));
	}

}
