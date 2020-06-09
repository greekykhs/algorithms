package com.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeftmostColumn {
	/*
	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions=binaryMatrix.dimensions();
		int rows=dimensions.get(0);
		int cols=dimensions.get(1);
		
		if(rows==0 || cols==0)
			return -1;
		
		int result=-1, r=0, c=cols-1;
		while(r<rows && c>=0) {
			if(binaryMatrix.get(r, c)==1) {
				result=c;
				c--;
			}
			else
				r++;
		}		
		return result;
    }	
	*/
}

class BinaryMatrix {
		public int get(int x, int y){
			return 0;
		}
	 public List<Integer> dimensions=new ArrayList<Integer>();
}