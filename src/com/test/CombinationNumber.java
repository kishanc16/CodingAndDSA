package com.test;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationNumber {

	public static void main(String[] args) {
		 int arr[] = {0,1, 2,3,4,5}; 
	        int n = arr.length; 
	        ArrayList<Integer> list = new ArrayList<>();
	       list = printCombination(arr, 0, n-1,list); 
	       System.out.println(Collections.max(list));
	}
	private static ArrayList<Integer> printCombination(int[] arr, int l, int r,ArrayList<Integer> list) {
		int max =0;
		if( l == r)
		{
			int sum =0;
			for(int i=0;i<=r;i++)
			{
				sum  = sum + i^arr[i];
			}
			max = Math.max(sum, max);
			list.add(max);
		}else{					
			for(int i =l;i<=r;i++)
			{
				swap(arr,l,i);
				printCombination(arr, l+1, r,list);
				swap(arr,l,i);
			}
			
		}
		return list;
	}

	private static void swap(int[] arr, int l, int i) {
		// TODO Auto-generated method stub
		int temp = arr[l];
		arr[l] = arr[i];
		arr[i ] = temp; 
	}
	
}
