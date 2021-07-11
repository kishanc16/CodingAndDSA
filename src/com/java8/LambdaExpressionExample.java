package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@FunctionalInterface
interface Drawing {
	public void draw();
	
	default void area(){
		System.out.println("Calculating the Area ...");
	}
	default void area1(){
		System.out.println("Calculating the Area ...");
	}
	default void area2(){
		System.out.println("Calculating the Area ...");
	}
	static void area3(){
		System.out.println("Calculating the Area ...");
	}
	static void area4(){
		System.out.println("Calculating the Area ...");
	}
}

interface Square {
	public void parameter();

	public void area();
}

public class LambdaExpressionExample {

	public static void main(String ar[]) {
		String name = "Kishan";
		
		Drawing d = () ->{} ;
		
		d.draw();
		d.area();
		
		Square sq = new Square() {

			public void parameter() {
				System.out.println("Kishan");
			}

			public void area() {

			}
		};
		sq.parameter();

		List<Integer> list = Arrays.asList(2, 4, 6, 8, 9, 11);

		Consumer<Integer> c = new Consumer<Integer>() {

			@Override
			public void accept(Integer i) {
				System.out.println(i);
			}
		};
		 list.forEach(c); // calling consumer object
		 list.forEach(System.out::println); // call by method "::" means method reference
		 list.forEach(LambdaExpressionExample::doubleit);
		 
		 int arr[] = {3,4,5,67,8,9,2};
		 int min = IntStream.of(arr)
				 		.min()
				 		.getAsInt();
		 System.out.println("Min : "+ min);
		 
		 /**
		  * Find the top 3 employees which have highest salary
		  * 
		  *  listOfEmployee.stream()
		  *  	.sorted(Comparator.compairingInt(Employee :: getSalary()).reversed)
		  *  	.limit(3)
		  *  	.map(Employee::getName())
		  *  	.collect(Collectors.toList());
		  */
	}

	public static void doubleit(int i) {
		System.out.println(2 * i);
	}
}
