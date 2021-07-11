package com.datastructure;
import java.util.*;

public class PrimeFactorizationSieve {
	final static int max = 1000001;
	static int []spf = new int[max];
	static void sieve(){
		
		spf[1] = 1;
		for(int i=2; i<max; i++){
			spf[i] = i;
		}
		for(int i=4; i<max ;i+=2){
			spf[i] = 2;
		}
		for(int i=3; i*i<max; i++)
		{

            // checking if i is prime 
			if(spf[i] == i){
				
				// marking SPF for all numbers divisible by i 
				for(int j=i*i; j<max; j+=i){
					 // marking spf[j] if it is not  
                    // previously marked 
					if(spf[j] == j){
						spf[j] = i;
					}
				}
			}
		}
	}
	static List<Integer> getFactorization(int n){
		List<Integer> list = new ArrayList<>();
		while(n != 1){
			list.add(spf[n]);
			n = n/spf[n];
		}
		return list;
	}
	public static void main(String ar[]){
		sieve();
		int n = 1024;
		//System.out.println(Arrays.toString(spf));
		List<Integer> result = getFactorization(n);
		System.out.println(result);
	}

}
