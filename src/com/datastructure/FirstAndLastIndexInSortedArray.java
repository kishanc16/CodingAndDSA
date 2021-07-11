package com.datastructure;
import java.util.*;

public class FirstAndLastIndexInSortedArray {
	
	//first and last index of element in sorted array
	public static void main(String[] args) {
		Integer arr[] = {1,1,2,2,3,5,5,6,7,9,9,10,11,11};
		int x =8;
		List<Integer> A = Arrays.asList(arr);
		 ArrayList<Integer> result = new ArrayList<Integer>();
	        int first = binarySearch(A,0,A.size()-1,x);
	        int second = binarySearch(A,first,A.size()-1,x+1)-1;
	        
	       // System.out.print(first +" "+second);
	        if(first <= second){
	            result.add(first);
	            result.add(second);
	        }else{
	            result.add(-1);
	            result.add(-1);
	        }
	    System.out.println(result);
	        
		System.out.println(searchRange(A,x));
	}
	//this program correct output Time - O(log n)
	public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(-1);
        result.add(-1);
        int low = 0, high = A.size()-1;
        int ans = -1;
        while(low <= high)
        {
            int mid = (low+high)/2;
            
            if(A.get(mid) == B){
                ans = mid;
                high = mid-1;
            }else if(A.get(mid)< B)  low = mid+1;
            else
                high = mid-1;
            
        }
        if(ans == -1) return result;
        result.set(0,ans);
        low = ans;
        ans = -1;
        high = A.size()-1;
        while(low <= high)
        {
            int mid = (low+high)/2;
            
            if(A.get(mid) == B){
                ans = mid;
                low = mid+1;
            }else if(A.get(mid)< B) low = mid+1;
            else
                high = mid-1;            
        }
        result.set(1,ans);
        return result;
    }
	//this program failed one test case output Time - O(log n)
	static int binarySearch(List<Integer> A,int low, int high, int B)
    {
        int ans = high+1;
        while(low <= high)
        {
            int mid = (low+high)/2;
            
            if(A.get(mid) >= B){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
