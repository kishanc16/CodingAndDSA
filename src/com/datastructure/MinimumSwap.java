package com.datastructure;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MinimumSwap {

	public static void main(String[] args) {
		int arr[] = {1, 5, 8, 3, 2}; 
		System.out.println(minSwap(arr,arr.length));
	}
//two solution..below
	private static int minSwap(int[] arr, int n) {
		Map<Integer,Integer> map =new TreeMap<Integer, Integer>();
		for(int i=0 ;i<n; i++)
		{
			map.put(arr[i],i);
		}
		boolean visit[] =new boolean[n];
		Arrays.fill(visit, false);
		Arrays.sort(arr);
		int ans = 0;
		
		for(int i=0; i<n; i++)
		{
			if(visit[i] || map.get(arr[i]) == i)				
				continue;
			int size=0;
			int j =i;
			while(!visit[j]){
				visit[j] = true;
				j = map.get(arr[j]);
				size++;
			}
			if(size > 0) 
            { 
                ans += (size - 1); 
            } 
		}
				
		return ans;
//		int swap=0;
//        boolean visited[]=new boolean[arr.length];
//
//        for(int i=0;i<arr.length;i++){
//            int j=i,cycle=0;
//
//            while(!visited[j]){
//                visited[j]=true;
//                j=arr[j]-1;
//                cycle++;
//            }
//
//            if(cycle!=0)
//                swap+=cycle-1;
//        }
//        return swap;

	}

}
