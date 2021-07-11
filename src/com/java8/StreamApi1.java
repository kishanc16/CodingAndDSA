package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 
 * @author 503132605
 * In this example we study about map and reduce 
 * step by step
 */
public class StreamApi1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,4,6,8,11,13);
		
//		Stream s = list.stream();
//		Stream s1 = s.map(new Function<Integer,Integer>(){
//			@Override
//			public Integer apply(Integer i) {
//				// TODO Auto-generated method stub
//				return 2*i;
//			}			
//		});
//		Integer result = (Integer) s1.reduce(0,new BinaryOperator<Integer>(){
//
//			@Override
//			public Integer apply(Integer i, Integer j) {
//				
//				return i+j;
//			}
//			
//		});
		Integer result = list.stream()
				.map(i -> i*2)
				.reduce(0,(c,i) -> c+i);
		//or
		Integer result1 = list.stream().map(i->i*2).reduce(0,Integer :: sum); // static method Integer.sum()
		
		System.out.println(result1);

	}

}
