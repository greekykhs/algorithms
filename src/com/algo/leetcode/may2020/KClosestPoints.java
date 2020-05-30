package com.algo.leetcode.may2020;

import java.util.PriorityQueue;

/*
 * K Closest Points to Origin

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

Note:
1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000*/
public class KClosestPoints {
	/*Algorithm:
		1). To find the solution we need to find the distance between two points. 
		Here is the formula to find the distance [x1,y1] and [x2,y2] 
		sqrt((y2 — y1) * (y2 — y1) + (x2 — x1) * (x2 — x1)).
		2). We can ignore the square root to find the answer.
		3). To find the k closest points, we can use PriorityQueue.*/
	public int[][] kClosest(int[][] points, int K) {
		if(points.length==1) return points;
		
		PriorityQueue<int[]> pq=
				new PriorityQueue<>((a,b)->a[0]-b[0]);
		int[] point;
		for(int i=0;i<points.length; i++) {
			point=new int[] {points[i][0]*points[i][0]+
					points[i][1]*points[i][1], i};
			pq.offer(point);
		}
		int [][] result=new int[K][];
		while(--K>=0) {
			result[K]=points[pq.poll()[1]];
		}
		return result;
	}

}
