package com.algo.leetcode.may2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * Find the Town Judge
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:
The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Example 1:
Input: N = 2, trust = [[1,2]]
Output: 2

Example 2:
Input: N = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:
Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

Example 4:
Input: N = 3, trust = [[1,2],[2,3]]
Output: -1

Example 5:
Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3

Note:
1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N
 * */
public class FindTheTownJudge {	
	public int findJudge(int N, int[][] trust) {
		if (trust.length == 0)
			return N;
		int[] indegree=new int[N+1];
		int[] outdegree=new int[N+1];
		
		for(int i=0;i<trust.length;i++) {
			outdegree[trust[i][0]]++;
			indegree[trust[i][1]]++;
		}
		for(int i=1;i<=N;i++) {
			if(indegree[i]==N-1 && outdegree[i]==0)
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		//int[][] trust={{1,3},{1,4},{2,3},{2,4},{4,3}};
		//int[][] trust={{1,2}};
		int[][] trust={{1,2},{3,2},{3,4},{3,1},{1,4},{1,5},{2,3},{2,1},{4,3},{4,2},{5,1},{2,5},{5,3},{4,1},{2,4},{3,5}};//{{1,2},{2,3}};
		System.out.println(new FindTheTownJudge().findJudge(2, trust));

	}
}
