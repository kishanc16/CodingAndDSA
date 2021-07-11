package com.test;

import java.util.Arrays;

public class CheckPalindromicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,2,3,1,1,1};
		int n = arr.length;
		findPalindromic(arr,n);
	}

	private static void findPalindromic(int[] arr, int n) {
		// TODO Auto-generated method stub
		int i =0;
		int j =n-1;
		while(i < j){
			if(arr[i] == arr[j]){
				i++;
				j--;
			}
			else if(arr[i] > arr[j]){
				arr[j-1] = arr[j]+arr[j-1];
				j--;
			}else{
				arr[i+1] = arr[i]+arr[i+1];
				i++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
