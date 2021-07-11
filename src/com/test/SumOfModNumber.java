package com.test;

import java.util.*;

public class SumOfModNumber {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,8);
		int max = list.stream()
					.max((a,b) -> a-b).get();
		int arr[] = new int[max+1];
		int mod = (int)1e9+7;
		for(int i=0;i<list.size(); i++)
		{
			arr[list.get(i)]++;
		}
		int sum = 0;
		for(int i=1; i<=max; i++)
		{
			for(int j=1; j<=max; j++){
				sum = sum+ arr[i]*arr[j]*(i%j);
				sum = sum %mod;
			}
		}
			System.out.println("Sum : "+ sum);	
	}

}
