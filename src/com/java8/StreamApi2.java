package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamApi2 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3,5,88,8,11,13,2,9,32);
	 
		//System.out.println(list.stream()
		//	.filter(i -> i%2 ==0 ).map(i -> i*2)
		//	.reduce(0,(c,e)-> c+e));
		
		//boiler plate code
		Predicate<Integer> p = new Predicate<Integer>() {
			@Override
			public boolean test(Integer i) {
				
				return i%2==0;
			}
		};
		
		System.out.println(list.stream()
				.filter(p)
				.reduce(0,(c,e) -> c+e));
		
		//find first element 
//		System.out.println(list.stream()
//				.filter(i -> i%5 == 0 )
//				.findFirst()
//				.orElse(0));
		
		//lazy method;
//		System.out.println(list.stream()
//				.filter(StreamApi2 :: divideBy2)
//				.map(StreamApi2 :: multiplyBy2)
//				.reduce(0,(c,e) -> c+e));
		
		Comparator<Integer> comp = new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				System.out.println("Executed : 	" +arg0 +" "+arg1);
				return arg0-arg1;
			}
		};
		//find max elements from list
		System.out.println(list.stream()
				.max(comp).get());
	}
	//prove lazy method
	public static boolean divideBy2(int i){
		System.out.println("Divide Executed");
		return i%2 == 0;
	}
	public static int multiplyBy2(int i){
		System.out.println("Multiply Executed");
		return i*2;
	}
}
