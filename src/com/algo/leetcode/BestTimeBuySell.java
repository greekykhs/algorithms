package com.algo.leetcode;

/*
 * Best Time to Buy and Sell Stock II
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions 
 * as you like (i.e., buy one and sell one share of the stock multiple times).
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * 
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * 
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * 
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * */
public class BestTimeBuySell {
	/*
	 * Algorithm:
	 * 1). We will start traversing. If the current value is greater than the previous 
	 *     one (difference is greater than 0), then we will consider it as profit 
	 *     and do the transaction (buy and sell).
	 * 2). We will keep on adding the profit obtained from every consecutive transaction.
	 * 3). The total sum we obtain will be the maximum profit.
	 * */
	public int maxProfit(int[] prices) {
	    int profit = 0;
	    for(int i=1; i<prices.length; i++){
	        int diff = prices[i]-prices[i-1];
	        if(diff > 0){
	        	System.out.println("("+prices[i-1]+","+prices[i]+")");
	        	profit += diff;
	        }
	    }
	    return profit;
	}
		
	public static void main(String[] args) {
		BestTimeBuySell obj=new BestTimeBuySell();
		int prices1[] = {7,1,5,3,6,4}; 
		System.out.println("***Input:");
		printArray(prices1);
		System.out.println("Max Profit:"+obj.maxProfit(prices1));
		System.out.println();
		
		int prices2[] = {1,2,3,4,5}; 
		System.out.println("***Input:");
		printArray(prices2);
		System.out.println("Max Profit:"+obj.maxProfit(prices2));
		System.out.println();
		
		int prices3[] = {7,6,4,3,1}; 
		System.out.println("***Input:");
		printArray(prices3);
		System.out.println("Max Profit:"+obj.maxProfit(prices3));
		System.out.println();
		
		
	}
	public static void printArray(int[] nums)
	{
		for (int i=0; i<nums.length; i++) 
            System.out.print(nums[i]+" ");		
		System.out.println();
	}

}
