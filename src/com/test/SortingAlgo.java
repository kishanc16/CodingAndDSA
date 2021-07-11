package com.test;
import java.util.*;

public class SortingAlgo {
	
	public static void main(String[] args) {
		Integer arr[]= {80,60,40,40,20,20,40,40,40,40,40,40}; // 
		Arrays.sort(arr,Collections.reverseOrder()); // array should be non primitive data type
		
		
		int k = 3;
		int rank = 1,i=1,st=0;;
		ArrayList<Integer> list = new ArrayList<>();
		int n = arr.length;
		list.add(1);
		while(i< n){
			if(arr[i] != arr[i-1]){
				rank ++;				
			}
			
			if(rank > k) break;
			
			st++;
			i++;
		}
		System.out.println(st+1 +"  "+list);
		printCombination(7);
	}
	//shortest length of sum
	private static void printCombination(int num) {
		int arr[] = new int[26];
		arr[0] = 1;
		List<Integer> list = new ArrayList<>();
		for(int i =2; i<=26; i++)
		{
			arr[i-1] = i*(i-1)+(i-1);
		}
		int index = 0;
		for(int i=0; i<26; i++){
			if(arr[i] > num){
				break;
			}
			index = i;
		}
		while(index >= 0){
			while(num-arr[index] >= 0){
				num = num-arr[index];
				list.add(index);
			}
			index --;
		}
		String result = "";
		for(int i=list.size()-1; i>=0; i--)
		{
			result = result +(char)(list.get(i)+65);
		}
		System.out.println(result +"-->"+num+" "+list + "   " +Arrays.toString(arr));
	}
}
