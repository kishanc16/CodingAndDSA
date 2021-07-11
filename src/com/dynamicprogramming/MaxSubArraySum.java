package com.dynamicprogramming;

import java.math.BigInteger;

public class MaxSubArraySum {

	public static void main(String[] args) {
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		int n = arr.length;
		
		System.out.println("Maximun Subarray Sum : "+findMaxSubArraySum(arr,n));
		fact(25);
	}

	private static void fact(int n) {
		// TODO Auto-generated method stub
		BigInteger num[] = new BigInteger[n+1];
		num[1] = BigInteger.ONE;
		for(int i=2;i<=n; i++)
		{
			num[i] = num[i-1].multiply(BigInteger.valueOf(i));
		}
		System.out.println(num[n]);
	}
	/**
	 * s(i) = max{s(i)+A(i), A(i)}
	 * 
	 * s(i) is the max sub sequence sum for the ith element
	 * 
	 * sum = max(sum,s(i));
	 */
	private static int  findMaxSubArraySum(int[] arr, int n) {
		
		int max = arr[0];
		int sum = 0;
		for(int i =1; i<n; i++)
		{
			max = Math.max(max+arr[i], arr[i]);
			sum = Math.max(sum, max);
			if(sum < 0) sum =0;
		}
		return sum;
	}

}
