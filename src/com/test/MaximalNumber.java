package com.test;

import java.util.*;

//Find the biggest number formed ex = 99577711
public class MaximalNumber {

	public static void main(String[] args) {
		String str[]= {"11","7","9","95","77"};
		
		/*Arrays.sort(str, new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return (s2+s1).compareTo(s1+s2);
			}
			
		});
		for(String s:str)
		{
			System.out.print(s);
		}*/
	List<String> list = Arrays.asList(str);
	Collections.sort(list,(a,b)-> (b+a).compareTo(a+b));
	list.stream()
	.forEach(System.out::print);
		
	}

}
