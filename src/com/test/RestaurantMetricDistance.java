package com.test;

import java.util.Arrays;

public class RestaurantMetricDistance {
	
	public static int[] findDistance(int arr[])
	{
		int n = arr.length;
		int result[] = new int[n];
		for(int i=0; i< n-1; i++)
		{
			for(int j = i+1; j< n; j++)
			{
				if(arr[i] == arr[j])
				{
					result[i] = result[i]+Math.abs(i-j);
					result[j] = result[j]+Math.abs(j-i);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int arr[]= {1,2,2,1,5,1};
		System.out.println(Arrays.toString(findDistance(arr)));
	}

}
