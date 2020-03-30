package com.algo.leetcode;

/* 
 * https://leetcode.com/problems/number-of-islands/submissions/
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.*/
public class NumberOfIslands {
	public static void main(String[] args) {
		//example 1
		char[][] grid1 ={ 
						{ '1', '1', '1', '1', '0' },
						{ '1', '1', '0', '1', '0' },
						{ '1', '1', '0', '0', '0' },
						{ '0', '0', '0', '0', '0' }};
		//example 2
		char[][] grid2 = { 
						{ '1', '1', '0', '0', '0'  },
						{ '1', '1', '0', '0', '0'  },
						{ '0', '0', '1', '0', '0' },
						{ '0', '0', '0', '1', '1' }};
		System.out.println(new NumberOfIslands().numIslands(grid1));
	}
	
	/*
	 * Iterate the 2D array, every-time you encounter the 1:
	 * a). increase the island count
	 * b). recursively replace all the horizontally/vertically land(1) with water(0).
	 * */
	public int numIslands(char[][] grid) {
		if (grid==null)
			return 0;
		int numOfIslands=0;
		
		for(int i=0;i<grid.length; i++) {
			for(int j=0;j<grid[0].length; j++) {
				if(grid[i][j]=='1')	{
					//increase the lsland count
					++numOfIslands;
					
					//replace all the horizontally/vertically land with water
					replaceLandWithWater(grid, i, j);
				}
			}
		}
        return numOfIslands;
    }
	
	private void replaceLandWithWater(char[][] grid, int i, int j){
//		if(i<0 || j<0 || grid[i][j]=='0' || i>=grid.length || j>=grid[0].length)
		if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0')
			return;
		
		//replace land with water
		grid[i][j]='0';
		
		//replace left land with water
		replaceLandWithWater(grid, i, j-1);
		//replace right land with water
		replaceLandWithWater(grid, i, j+1);
		//replace upper land with water
		replaceLandWithWater(grid, i+1, j);
		//replace lower land with water
		replaceLandWithWater(grid, i-1, j);		
	}
}
