package com.datastructure;

import java.util.*;

public final class TwoSumProblem {

	public static void main(String[] args) {
		int arr[] = {2,11,10,5,7,8};
		int target  = 9;
		int [] result = findSum(arr,target);
		System.out.println(Arrays.toString(result));
		
		/**
		 * Reverse array in one for loop
		 */
		for(int i=0,j=arr.length-1;i<j;i++,j--)
		{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;			
		}
		System.out.println(Arrays.toString(arr));		
	}
/**
 * Two sum problem
 * @param arr
 * @param target
 * @return
 */
	public static int[] findSum(int[] arr, int target) {
		int [] result  = new int[2];
		Map<Integer,Integer> map  = new HashMap<>();
		for(int i=0; i<arr.length; i++)
		{
			if(!map.containsKey(target-arr[i])){
				map.put(arr[i], i);
			}else{
				result[1] = i;
				result[0] = map.get(target-arr[i]);
			}
		}
		return result;
	}

}
