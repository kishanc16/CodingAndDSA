package com.java8;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

//stream api is an new feature in java 8 which provides to process huge amount of data
//It has alot of method and also uses concept of  parallel stream.
//stream can not be reused.
public class StreamApi {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,4,6,8,11,13);
		
		//We will understand stream api step to step
		
		//function is an interface which accept two argument
		Function<Integer,Integer> f = new Function<Integer,Integer>() {

			@Override
			public Integer apply(Integer i) {
				// TODO Auto-generated method stub
				return 2*i;
			}
		};
		
		BinaryOperator<Integer> b = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer i, Integer j) {
				
				return i+j;
			}
		};
		Stream s = list.stream();
		
		Stream s1 = s.map(f);		//map takes as argument function
		
		Integer s2 = (Integer) s1.reduce(0,b);
		
		System.out.println(s2);

	}

}
