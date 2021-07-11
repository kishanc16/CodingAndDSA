package com.test;
import java.util.*;

public class AllFactors {

	public static void main(String[] args) {
		int n = 8;
		//time O(n)
//		System.out.print(1+" ");
//		for(int i=2; i<=n/2; i++)
//		{
//			if(n%i == 0)
//				System.out.print(i+" ");
//		}
//		System.out.println(n);
		
		ArrayList<Integer>list = new ArrayList<>();
		//time - O(sqrt(n)) space O(sqrt(n))
		for(int i=1; i<=Math.sqrt(n); i++)
		{
			if(n%i == 0){							
				if(n/i == i)
					System.out.print(i+" ");	
				else{
					System.out.print(i+" ");	
					list.add(n/i);
				}
			}			
		}
		
		for(int i=list.size()-1; i>=0; i--)
			System.out.print(list.get(i)+" ");
		
	}
	 
}
