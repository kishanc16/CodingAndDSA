package com.test;

public class NthTermDivisiblebyAandB {
	
	static long gcd(long a, long b)  
	{  
	    if (a == 0)  
	        return b;  
	  
	    return gcd(b % a, a);  
	}  
	static long divTermCount(long a, long b,  
            long lcm, int num){ 
		return num / a + num / b - num / lcm;  
	}  
	static long findNthTerm(long a, long b, long n)  
	{ 
		long low = 1, high = Integer.MAX_VALUE, mid;  
	
    long lcm = (a * b) / gcd(a, b);  
  
    while (low < high)  
    {  
        mid = (high + low) / 2;
        
        if (divTermCount(a, b, lcm, (int) mid) >= n)  
        	high = mid;   
        else
        	low = mid + 1;
            
    }  
    return low;
    }
	public static void main(String[] args) {
		 long a = 2, b = 3, n = 10;  
		    System.out.println(findNthTerm(a, b, n)); 
	}

}
