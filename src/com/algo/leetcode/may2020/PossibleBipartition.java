package com.algo.leetcode.may2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Possible Bipartition

Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

Example 1:
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]

Example 2:
Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false

Example 3:
Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 
Note:
1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].
*/
public class PossibleBipartition {
	
    public boolean possibleBipartition(int N, int[][] dislikes) {
    	//corner case
        if(N == 0 || dislikes.length == 0) 
        	return true;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        //build the graph
        int d0, d1;
        for(int[] dislike : dislikes){
        	d0=dislike[0];
        	d1=dislike[1];
        	
        	graph.putIfAbsent(d0, new HashSet<>());
        	graph.putIfAbsent(d1, new HashSet<>());
        	
        	graph.get(d0).add(d1);
        	graph.get(d1).add(d0);
        }
        
        //color each node
        int[] colors= new int[N + 1];
        for(int i = 1; i <= N; i++){
        	
        	//color the node if it hasn't been colored
        	//0 represent no color, we will change it to 1
        	//color the dislikes with -1
            if(colors[i] == 0 &&
            		!dfs(colors, 1, i, graph))
            	return false;
        }
        return true;
    }
    private boolean dfs(int[] colors, 
    		int color, int node, Map<Integer, Set<Integer>> graph){
    	//if the node is already colored
    	//check if the new color is same as old color
    	if(colors[node] != 0)
    		return colors[node]==color;
    	
    	colors[node]=color;
    	    	
    	//if the neighbours are not present return true;
    	 Set<Integer> neighbours = graph.get(node);
         if(neighbours == null) return true;
         
         for(Integer neighbour : neighbours){
        	 //in case of conflict return false;
             if(!dfs(colors, -color, neighbour, graph)) return false;
         }         
        return true;
    }
}
