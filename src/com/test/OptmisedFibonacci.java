package com.test;

import java.util.Arrays;

public class OptmisedFibonacci {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(fibonacci(n));
		System.out.println(fib(n));
	}

	private static int fib(int n) {
		// TODO Auto-generated method stub
		int f[] = new int[n+1];
		f[0]=0;f[1]=1;
		for(int i=2;i<=n;i++)
		{
			f[i] = f[i-1]+f[i-2];
		}
		System.out.println(Arrays.toString(f));
		return f[n];
	}

	private static int fibonacci(int n) {	//Memorization
		// TODO Auto-generated method stub
		int lookup[] = new int[n+1];
		Arrays.fill(lookup, -1);
		if(lookup[n] == -1)
		{
			if(n<=1)
			{
				lookup[n]=n;
			}else{
				lookup[n]=fibonacci(n-1)+fibonacci(n-2);
			}
		}
		return lookup[n];
	}
	

}
