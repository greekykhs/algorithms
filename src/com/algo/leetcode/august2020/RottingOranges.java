package com.algo.leetcode.august2020;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * Rotting Oranges
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Example 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 
Note:
1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.*/

public class RottingOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int rows = grid.length;
		int cols = grid[0].length;
		Queue<int[]> rotten = new LinkedList<>();

		int freshOrangesCount = 0, count = 0;
		// putting all the rotten oranges in a queue
		// and counting the number of fresh oranges
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (grid[i][j] == 2)
					rotten.add(new int[] { i, j });
				else if (grid[i][j] == 1)
					freshOrangesCount++;
			}
		}

		// if fresh oranges are not present
		if (freshOrangesCount == 0)
			return 0;

		int num, x, y;
		while(!rotten.isEmpty()){
            num = rotten.size();
            for(int i = 0; i < num; ++i){
                x = rotten.peek()[0]; 
                y = rotten.peek()[1];
                rotten.remove();
                
				if (x > 0 && grid[x - 1][y] == 1) {
					grid[x - 1][y] = 2;
					freshOrangesCount--;
					rotten.add(new int[] { x - 1, y });
				}
				if (y > 0 && grid[x][y - 1] == 1) {
					grid[x][y - 1] = 2;
					freshOrangesCount--;
					rotten.add(new int[] { x, y - 1 });
				}
				if (x < rows - 1 && grid[x + 1][y] == 1) {
					grid[x + 1][y] = 2;
					freshOrangesCount--;
					rotten.add(new int[] { x + 1, y });
				}
				if (y < cols - 1 && grid[x][y + 1] == 1) {
					grid[x][y + 1] = 2;
					freshOrangesCount--;
					rotten.add(new int[] { x, y + 1 });
				}
            }
            if(!rotten.isEmpty()) 
            	count++;
        }
        return (freshOrangesCount == 0) ? count : -1;
	}
}
