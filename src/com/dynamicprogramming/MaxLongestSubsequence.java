package com.dynamicprogramming;

import java.util.Arrays;

public class MaxLongestSubsequence {

	public static void main(String[] args) {
		int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println("Max Longest Subsequence : "+findMaxLongestSub(arr,arr.length));
	}
	/**
	 * arr(i) = 1+max{arr(j)}
	 * where 1<j<i && arr[j]<arr[i]
	 * 
	 * O(n*n)
	 */
	private static int findMaxLongestSub(int[] arr, int length) {
		int table[] =new int[length];
		table[0] =0;
		int max=0;
		for(int i=0; i<length; i++)
		{
			for(int j=0; j<i; j++){
				if(arr[i]>arr[j]){
					max = Math.max(max, table[j]); 
				}	
			}
			table[i] = max+1;
		}
		System.out.println(Arrays.toString(table));
		return table[length-1];
	}

}
