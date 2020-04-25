package com.algo.leetcode;
/*
 * Jump Game
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 * */
public class JumpGameTopDown {
	public static void main(String[] args) {
		int[] nums= {2,3,1,1,4};
		//int[] nums= {3,2,1,0,4};		
		System.out.println("Can jump?"+new JumpGameTopDown().canJump(nums));

	}	
	/*
	 * Second Solution of Leet Code's Jump Game problem: Dynamic Programming Top-down
	 * 
	 * 1). We will start marking each index with a certain value (let's say GOOD, BAD and DONTNO), 
	 *     initially all the index's (except the last one) will be marked as DONTNO. 
	 * 	   We will start computing if the index is GOOD or BAD. Once the index is marked as GOOD or BAD, we won't change it. 
	 *     Since the value is not going to change, that's means it will be computed only once. 
	 *     We store these marked values let's create a array with a name valNums.
	 *     
	 * 2). We will write a recursive function jumpAllowed(). First we will check if the index 
	 * 	   is not DONTNO (i.e either GOOD or BAD) and if yes, then return true or false. 
	 * 	   Otherwise we will call jumpAllowed() recursively.
	 * 
	 * 3). The furthestJump from any position could be value at that position or the length of input array (which ever is less)
	 * 
	 * 4). Once we determine the value of the current index, we store it in valNums.
	 * */
	VALENUM[] valNums;
	public boolean canJump(int[] nums) {
		if(nums.length==0)
			return false;
		
		//create a VALENUM with length equal to input array
		valNums=new VALENUM[nums.length];
		
		//set all the values in VALENUM as DONTNO
		for(int i=0; i<nums.length;i++)
			valNums[i]=VALENUM.DONTNO;
		
		//set the last value of VALENUM as GOOD
		valNums[nums.length-1]=VALENUM.GOOD;
		
		return jumpAllowed(0, nums);
	}
	 public boolean jumpAllowed(int position, int[] nums) {
		//If the current position is already marked as YES or NO, return true of false
		 if(valNums[position]!=VALENUM.DONTNO)
			 return valNums[position]==VALENUM.GOOD?true:false;
		 
		 int furthestJump=Math.max(nums[position]+position, nums.length-1);
		 for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
		 	 if(jumpAllowed(nextPosition, nums))
			 {
				 valNums[nextPosition]=VALENUM.GOOD;
				 return true;
			 }
		 }
		 valNums[position]=VALENUM.BAD;
		 return false;
	 }
}
enum VALENUM {
    GOOD, BAD, DONTNO
}
