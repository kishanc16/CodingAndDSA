package com.dynamicprogramming;
import java.util.*;

public class CoinProblem {

	public static void main(String[] args) {
		int []arr ={9, 6, 5, 3};
		int n = arr.length;
		int amount = 4;
		//No of ways using coin to find sum
		System.out.println("Total Ways : "+ways(arr,amount,n));
		//System.out.println("Minimum Ways : "+minCount(arr,amount,n));

	}
	/**
	 * recurrence relation
	 * c(p) = min{c(p-vi)}+1
	 * 
	 * vi are coins
	 */
	private static long minCount(int[] arr, int amount, int n) {
		
		long coins[] = new long[amount+1];
		Arrays.fill(coins, Integer.MAX_VALUE);
		
		
		coins[0] = 0;
		for(int i=1; i<=amount; i++)
		{
			for(int j=0;j<n; j++)
			{
				if(arr[j]<=i)
					coins[i] = Math.min(coins[i],coins[i-arr[j]]);
			}
			coins[i]++;
		}
		
		System.out.println(Arrays.toString(coins));
		return coins[amount];
	}
	/**
	 * recurrence relation
	 * c(p) += min{c(p-vi)}
	 * 
	 * vi are coins
	 */
	private static long ways(int[] arr,int amount, int n) {
		
		long  coins[] = new long[amount+1];
		Arrays.fill(coins,0);
		if(n==0) return 1;
		coins[0] = 1;
		for(int i=0; i<n; i++)
		{
			for(int j=arr[i]; j<=amount; j++)
			{
				coins[j] += coins[j-arr[i]];
			}
			
		}
		System.out.println(Arrays.toString(coins));
		return coins[amount];
	}	
}
