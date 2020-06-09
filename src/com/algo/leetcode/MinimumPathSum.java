package com.algo.leetcode;

/*
 * Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1 - > 3 - > 1 - > 1 - > 1 minimizes the sum.
*/
public class MinimumPathSum {
	public int minPathSum1(int[][] grid) {		
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		int m = grid.length;
		int n = grid[0].length;
		int[][] minSum = new int[m][n];
		
		minSum[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			minSum[i][0] =  minSum[i - 1][0] + grid[i][0];
		}
		
		for (int i = 1; i < n; i++) {
			minSum[0][i] = minSum[0][i - 1] + grid[0][i];
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				minSum[i][j] = Math.min(minSum[i - 1][j], minSum[i][j - 1]) + grid[i][j]; 
			}
		}
		
		return minSum[m - 1][n - 1];
    }
	

	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;
		int[] dp = new int[n];
		dp[0] = grid[0][0];

		for (int i = 1; i < n; i++) 
			dp[i] = dp[i - 1] + grid[0][i];
		
		for (int i = 1; i < m; i++) {
			dp[0] = dp[0] + grid[i][0];
			for (int j = 1; j < n; j++)
				dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
		}
		return dp[n - 1];
	}
	
	public static void main(String[] args) {
		int[][] grid= {{1,3,1}, {1,5,1},{4,2,1}};
		System.out.println(new MinimumPathSum().minPathSum(grid));

	}

}
