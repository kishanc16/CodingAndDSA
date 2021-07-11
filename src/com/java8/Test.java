package com.java8;

public class Test {
	int a, b;
	
	Test(int a, int b){
		this.a = a;
		this.b = b;
	}
}
class A extends Test{
	int c,d;
	A(int c, int d){
		super(c,d);
		this.c = c;
		this.d = d;
	}
	
	public static void main(String ar[]){
		A obj = new A(10,20);
		System.out.println(obj.a);
	}
}
