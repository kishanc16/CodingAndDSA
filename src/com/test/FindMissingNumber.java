package com.test;

import java.util.Arrays;

public class FindMissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,7,6,8,9};
		int n = arr.length;
		findNoUsingSum(arr,n);
		findNoUsingHashing(arr,n);
		findNoUsingBitOperation(arr,n);
	}

	private static void findNoUsingBitOperation(int[] arr, int n) {
		// TODO Auto-generated method stub
		int sum1 = arr[0];
		int sum2 = 1;
		for(int i=1; i<n; i++ )
		{
			sum1 = sum1^arr[i];
		}
		for(int i=2; i<n+2; i++)
		{
			sum2 ^= i;
		}
		System.out.println("findNoUsingBitOperation : "+ (sum2^sum1));
	}

	private static void findNoUsingHashing(int[] arr, int n) {
		// TODO Auto-generated method stub
		int result[] = new int[n+2];
		Arrays.fill(result, 0);
		for(int i=0; i<n; i++)
		{
			result[arr[i]] = 1;
		}
		for(int i=0; i<n+2; i++)
		{
			if(result[i+1] == 0)
			{
				System.out.println("findNoUsingHashing: "+(i+1));
				break;
			}
				
		}
	}

	private static void findNoUsingSum(int[] arr, int n) {
		// TODO Auto-generated method stub
		int sum = ((n+1) *(n+2))/2;
		for(int i =0; i<n; i++)
		{
			sum -=arr[i];
		}
		System.out.println("findNoUsingSum : "+ sum);
	}

}
