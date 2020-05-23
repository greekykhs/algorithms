package com.algo.leetcode.may2020;

import java.util.ArrayList;
import java.util.List;

/*Interval List Intersections
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

Note:
0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.*/
public class IntervalListIntersections {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> ans = new ArrayList<int[]>();
		int i = 0, j = 0;
		int low, high;

		while (i < A.length && j < B.length) {
			low = Math.max(A[i][0], B[j][0]);
			high = Math.min(A[i][1], B[j][1]);
			if (low <= high)
				ans.add(new int[] { low, high });

			if (A[i][1] < B[j][1])
				i++;
			else
				j++;
		}
		return ans.toArray(new int[ans.size()][]);
	}

}
