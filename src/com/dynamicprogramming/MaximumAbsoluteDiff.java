package com.dynamicprogramming;

public class MaximumAbsoluteDiff {

	public static void main(String[] args) {
		int arr[] = {1,3,-1};
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int f=0 ,l =0;
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] > max){
				max = arr[i];
				l=i;
			}
			
			if(arr[i] < min){
				min = arr[i];
				f=i;
			}
		}
		System.out.println(Math.abs(max-min)+Math.abs(l-f));
	}

}
