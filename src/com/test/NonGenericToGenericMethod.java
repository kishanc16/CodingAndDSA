package com.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonGenericToGenericMethod<T> {
	public static void main(String[] args) {
		List list =list();
		List<Employee> e1 = list(new Employee());
		List<Employee> e2 = list(new Employee(), new Employee());
		List<String> s1 = list("string");
		List<String> s2 = list("12213","3223");
		
		System.out.println(s2);
	}

	private static List list(Object... o) {
		List ls = new ArrayList();
		ls = Arrays.asList(o);
		return ls;
	}

}
