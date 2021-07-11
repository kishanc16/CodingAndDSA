package com.dynamicprogramming;

public class MinPathLengthMatrix {

	public static void main(String[] args) {
		int arr[][] = { {1, 2, 3}, 
                {4, 8, 2}, 
                {1, 5, 3} };
		int row = arr.length;
		int col = arr[0].length;
		System.out.println("Min Cost : "+RecursivefindMinCost(arr,row-1,col-1) );
		System.out.println("Min Cost : "+findMinCost(arr,row,col) );
	
	}
	// function computes the same subproblems again and again O(2^n)
	private static int RecursivefindMinCost(int[][] minCost, int row, int col) {
		if(row<0 || col<0)
			return Integer.MAX_VALUE;
		else if(row == 0 && col ==0)
			return minCost[row][col];
		else
			return minCost[row][col] + Math.min(RecursivefindMinCost(minCost, row-1, col),
					RecursivefindMinCost(minCost, row, col-1));
	}
	
	//O(m*n)
	private static int findMinCost(int[][] arr, int row, int col) {
		int dp[][] = new int[row][col];
		dp[0][0] = arr[0][0]; 
		for(int i=1; i<row; i++)
		{
			dp[i][0] = dp[i-1][0]+arr[i][0];
		}
		for(int i=1; i<col; i++)
		{
			dp[0][i] = dp[0][i-1]+arr[0][i];
		}
		for(int i=1; i<row; i++)
		{
			for(int j=1; j<col ;j++)
			{
				dp[i][j] = arr[i][j]+Math.min(dp[i-1][j], dp[i][j-1]);				
			}			
		}
					
		return dp[row-1][col-1];
	}

}
