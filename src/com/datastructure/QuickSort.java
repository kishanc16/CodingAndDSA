package com.datastructure;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 13, 12, 11, 5, 7, 6 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int i, int j) {

		int pi = partition(arr, i, j);

		if (i < pi - 1) {
			mergeSort(arr, i, pi - 1);
		}
		if (pi < j) {
			mergeSort(arr, pi, j);
		}
	}
	//mid element takes as a pivot element
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[(low + high) / 2];
		while (low <= high) {

			while (arr[low] < pivot) {
				low++;
			}
			while (pivot < arr[high]) {
				high--;
			}
			if (low <= high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;

				low++;
				high--;
			}
		}
		return low;
	}
}
