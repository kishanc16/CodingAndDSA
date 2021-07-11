package com.test;
import java.util.*;
public class FindTriplet {

	public static void main(String[] args) {
	
		int ar[] = {1, 2, 4, -3, -1, 5, 6};
		int n = ar.length;
		System.out.println(findTriplet(ar,n));
		
	}

	private static int  findTriplet(int[] arr, int n) {
		
		Arrays.sort(arr);
		int count =0;
		boolean found =false;
		for(int i=0;i<n-1;i++)
		{
			int l = i+1;
			int r =n-1;
			int x = arr[i];
			while(l<r)
			{
				if((x + arr[l] + arr[r]) == 0)
				{
					count++;
					l++;
					r--;
					found = true;
				}
				else if((x + arr[l] + arr[r]) < 0){
					l++;
				}else{
					r--;
				}
				
			}
			
		}
		if(!found)
			System.out.println("No Triplet Found");
		return count;
		}

}
