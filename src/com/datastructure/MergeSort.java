package com.datastructure;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {13, 12, 11, 5, 7, 6};
		sort(arr,0,arr.length-1);
		
		System.out.println(Arrays.toString(arr));

	}

	private static void sort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if (low < high) {
			int mid = (low + high) / 2;

			sort(arr, low, mid);
			sort(arr, mid + 1, high);
			mergeSort(arr, low, mid, high);
		}
	}

	private static void mergeSort(int[] arr, int low, int mid, int high) {
		// TODO Auto-generated method stub
	
		int temp[] =new int[high-low+1];
		
		int i=low, j=mid+1;
		int k =0;
		while(i<=mid && j<=high){
			if(arr[i] <= arr[j])
			{
				temp[k] = arr[i];
				i++;
			}else{
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		while(i <= mid){
			temp[k] = arr[i];
			k++;
			i++;
		}
		while(j<= high){
			temp[k] = arr[j];			
			k++;
			j++;
		}
		for(i=low; i<=high; i++){
			arr[i] = temp[i-low];
		}
	}

}
