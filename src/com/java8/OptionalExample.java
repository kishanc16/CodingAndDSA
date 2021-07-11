package com.java8;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		String[] str = new String[10]; 
		str[2] = "AgraIsCool";
		//*****
		Optional<String> isNull = Optional.ofNullable(str[2]);
		if(isNull.isPresent()){
			System.out.println("Some value is present");
			String str2 = str[2].substring(2, 5);
			System.out.println("Substring is: "+ str2);
		}else{
			System.out.println("Cannot get the substring from an empty string");
		}
		//**********
		Optional<String> GOT = Optional.of("Game Of Throne");
		Optional<String> nothing = Optional.empty();
		if(GOT.isPresent()){
			System.out.println("Value is present : "+GOT);
		}else{
			System.out.println("Cannot get the substring from an empty string");
		}
		//*******
		if(nothing.isPresent()){
			System.out.println("Value is present");
		}else{
			System.out.println("Cannot get the substring from an empty string");
		}
		//***********
		GOT.ifPresent(x -> System.out.println("Value : "+x));
		nothing.ifPresent(x -> System.out.println("Nothing is there"));
		
		System.out.println(nothing.orElse("Value : Object is empty"));
		System.out.println(GOT.orElse("Value : Object is empty"));
	} 
}


