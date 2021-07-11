package com.dynamicprogramming;

import java.util.*;


public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
//		List<Integer> list =  Arrays.asList(10, -1, 2, 3, 8, -4, 100);
//		ArrayList<Integer> result = maxset(list);
		ArrayList<Integer> list = new ArrayList<>();
	
		list.add(0);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(0);
		
		//Add One To Number
		ArrayList<Integer>  res = plusOne(list);
		System.out.println(res);
	}
	 public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
	       
	        while(A.get(0) == 0){
	        	A.remove(0);
	        }
	        int n = A.size() -1;
	        int num = 0;
	        int carry = 1;
	        for(int i=n; i>=0; i--){
	        	num = A.get(i)+carry;
	        	A.set(i, num%10);
	        	carry = num/10;
	        	
	        	if(carry == 0) break;
	        }
	        if(carry != 0) A.add(0,carry);
	       return A;
	    }
	public static ArrayList<Integer> maxset(List<Integer> A) {
	       long maxSum = 0;
		    long newSum = 0;
		    ArrayList<Integer> maxArray = new ArrayList<Integer>();
		    ArrayList<Integer> newArray = new ArrayList<Integer>();
		    for (Integer i : A) {
		        if (i >= 0) {
		            newSum += i;
		            newArray.add(i);
		        } else {
		            newSum = 0;
		            newArray = new ArrayList<Integer>();
		        }
		        //
		        if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
		            maxSum = newSum;
		            maxArray = newArray;
		        }
		       // 
		    }
		    
		    return maxArray;
	    }

}
