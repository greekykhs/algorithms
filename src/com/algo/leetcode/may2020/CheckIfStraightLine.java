package com.algo.leetcode.may2020;

/*
 * Check If It Is a Straight Line
 * 
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

Constraints:
2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
*/
public class CheckIfStraightLine {

	public static void main(String[] args) {
		System.out.println(new CheckIfStraightLine().checkStraightLine(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
		//[[-4,-3],[1,0],[3,-1],[0,-1],[-5,2]]
		System.out.println(new CheckIfStraightLine().checkStraightLine(new int[][]{{-4, -3},{1,0},{3, -1}, {0, -1}, {-5, 2}}));
	}
	/*
	 * Algorithm:
	 * Points (x1,y1), (x2,y2) and (x3, y3) will be in straight line, 
	 * 	if the slope between (x1,y1) and (x2,y2) is equal to 
	 * 	the slope between (x2,y2) and (x3, y3).
	 * 
	 * slope between (x1,y1) and (x2,y2)=(y2-y1)/(x2-x1) 
	 * */

	public boolean checkStraightLine(int[][] coordinates) {
		if(coordinates==null) return false;
		
		//two points will always be in straight line
		if(coordinates.length==2) return true;
		
		double slope=(double) (((double)coordinates[1][1]-(double)coordinates[0][1])/((double)coordinates[1][0]-(double)coordinates[0][0]));
		double tempSlope;
		for(int i=1;i< coordinates.length-1;i++) {
			tempSlope=(double) (((double)coordinates[i+1][1]-(double)coordinates[i][1])/((double)coordinates[i+1][0]-(double)coordinates[i][0]));
			if(tempSlope!=slope)
				return false;
		}
		return true;
	}
	
}
