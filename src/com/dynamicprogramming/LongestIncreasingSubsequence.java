package com.dynamicprogramming;

import java.util.TreeSet;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = {10,9,2,5,3,7,101,18};
		int ans  = LIS(arr,arr.length);
		System.out.println(lengthOfLIS(arr));
		System.out.println(ans);
		
	}

	private static int lengthOfLIS(int[] arr) {
		TreeSet<Integer> set = new TreeSet<>();
		for(int i=0; i<arr.length; i++){
			Integer x = set.ceiling(arr[i]);
			if(x != null){
				set.remove(x);
			}
			set.add(arr[i]);
		}
		return set.size();
	}

	private static int LIS(int[] arr, int n) {
		int max = 1;
		int dp[] = new int[n];
		dp[0] = 1;
		for(int i=1; i<n; i++){
			int maxVal=0;
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j]){
					maxVal = Math.max(maxVal,dp[j]);
				}
			}
			dp[i] = maxVal+1;
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
