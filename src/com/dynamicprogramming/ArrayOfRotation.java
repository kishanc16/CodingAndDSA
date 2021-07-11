package com.dynamicprogramming;
import java.util.*;

public class ArrayOfRotation {

	public static void main(String[] args) {
		int arr[] = {19,5,4,8,7,5,4,3,2,1};
		int n = arr.length;
		int result[] = new int[n];
		int count =0;
		
		//Counting number of element if(a[i] >=a[i+1]) and store in res[0]
		for(int i=0; i<n-1; i++)
		{
			if(arr[i] >= arr[i+1]){
				count++;
			}
		}
		result[0] = count;
		int first =0,last=0;
		for(int i=1;i<arr.length; i++)
		{
			if(arr[0]>=arr[1]) first=1;
			
			//left rotation perform on n-2 and n-1 th element
			int mod = i%n;
			if(arr[(n-2+mod)%n] >= arr[(n-1+mod)%n]){
				last = 1;
			}
			result[i] = result[i-1]-first+last;
		}
		
		System.out.println(Arrays.toString(result));
	}

}
