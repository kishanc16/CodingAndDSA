package com.dynamicprogramming;

import java.util.Arrays;

public class CuttingRod {

	public static void main(String[] args) {
		int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
		int table[] = new int[arr.length +1];
		//System.out.println("Max optimal price : "+ maxOptimal(arr,arr.length));
		System.out.println("Recursive Solution : "+maxSolution(arr,arr.length ,table));
		System.out.println(Arrays.toString(table));
	}
	private static int maxSolution(int[] arr, int n,int [] table) {
		
		if(n <= 0) return 0;
		
		int max = 0;
		if(table[n] > 0)
			return table[n];
		
		for(int i=0; i<n ;i++){
			max = Math.max(max,arr[i]+maxSolution(arr, n-1-i,table));
		}
		table[n] = max;
		
		return max;
	}
	/**
	 * c(i) = max {arr[j]+c(i-j)}
	 * 
	 * where 1<=j<=i
	 * @param arr -> cost of ith length
	 * @param n
	 * @return
	 */
	private static int maxOptimal(int[] arr,int n) {
		int table[] = new int[n+1];
		table[0] = 0;
		int max =0;
		for(int i=1; i<=n; i++)
		{
			for(int j=0; j<i; j++)
			{
				max  = Math.max(max, arr[j]+table[i-j-1]); 
			}
			table[i] = max;
		}
		System.out.println(Arrays.toString(table));
		return table[n];
	}

}
