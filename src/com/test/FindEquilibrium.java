package com.test;

public class FindEquilibrium {

	private static int findEqulibrium(int[] arr, int n) {
	
		int sum=0,leftsum=0;
		int result =-1;
		for(int i=0;i<n;i++)
			sum+=arr[i];
		
		for(int i=0;i<n;i++)
		{
			sum -= arr[i];
						
			if(sum == leftsum){
				result = i;
				break;
			}
			leftsum +=arr[i];
		}
		
	
		return result;
	}

	public static void main(String[] args) {
		
		int arr[] = {-7, 1, 5, 2, -4, 3, 0};
		int n = arr.length;
		System.out.println(findEqulibrium(arr,n));
	}

	
}
