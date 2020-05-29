package com.algo.leetcode.may2020;

import java.util.HashMap;
import java.util.HashSet;

/*
 * Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 
Constraints:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
 * */
public class CourseSchedule1 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(prerequisites == null)
			return false;
	 
	    int len = prerequisites.length;	 
	    if(numCourses == 0 || len == 0)
	        return true;
	   
		HashMap<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
		
		// Nodes on the current path
		HashMap<Integer, HashSet<Integer>> neighbors = 
				new HashMap<Integer, HashSet<Integer>>();
		HashSet<Integer> curPath = new HashSet<Integer>();
		
		//Convert graph presentation from edge list to adjacency list
		for (int i = 0; i < prerequisites.length; i++) {
			if (!neighbors.containsKey(prerequisites[i][1]))
				neighbors.put(prerequisites[i][1], new HashSet<Integer>());
			neighbors.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}

		// The graph is possibly not connected, so need to check every node.
		for (int prerequisite[] : prerequisites) 
			// Use DFS method to check if there's cycle in any curPath
			if (hasCycle(neighbors, prerequisite[0], -1, curPath, memo))
				return false;

		return true;
	}

	boolean hasCycle(HashMap<Integer, HashSet<Integer>> neighbors, int kid, int parent, 
			HashSet<Integer> curPath, HashMap<Integer, Boolean> memo) {
		if (memo.containsKey(kid))
			return memo.get(kid);
		
		//The current node is already in the set of the current path
		if (curPath.contains(kid))
			return true;
		if (!neighbors.containsKey(kid))
			return false;

		curPath.add(kid);
		for (Integer neighbor : neighbors.get(kid)) {
			boolean hasCycle = hasCycle(neighbors, neighbor, kid, curPath, memo);
			memo.put(kid, hasCycle);
			if (hasCycle)
				return true;
		}
		curPath.remove(kid);
		return false;
	}
}
