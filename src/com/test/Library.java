package com.test;

import java.math.BigInteger;

public class Library {
	
	public static String reverse(String s)
	{
		return new StringBuilder(s).reverse().toString();
	}
	
	public static int reverse(int n)
	{
		return Integer.parseInt(reverse(Integer.toString(n)));
	}
	
	
	public static boolean isPalindrome(String s)
	{
		return s.equals(reverse(s));
	}
	
	public static boolean isPalindrome(int n)
	{
		return isPalindrome(Integer.toString(n));
	}
	
	// as implemented in math class
	// Returns floor(sqrt(x)), for x >= 0.
	public static int sqrt(int x) {
		if (x < 0)
			throw new IllegalArgumentException("Square root of negative number");
		int y = 0;
		for (int i = 1 << 15; i != 0; i >>>= 1) {
			y |= i;
			if (y > 46340 || y * y > x)
				y ^= i;
		}
		return y;
	}
	
	public static long sqrt(long x) {
		if (x < 0)
			throw new IllegalArgumentException("Square root of negative number");
		long y = 0;
		for (long i = 1L << 31; i != 0; i >>>= 1) {
			y |= i;
			if (y > 3037000499L || y * y > x)
				y ^= i;
		}
		return y;
	}
	
	public static int square(int n)
	{
		int y = sqrt(n);
		return y*y;
	}
	public static long square(long n)
	{
		long y = sqrt(n);
		return y*y;
	}
	
	public static boolean isSquare(int x)
	{
		if (x < 0)
			return false;
		int y = sqrt(x);
		return y * y == x;
	}
	public static boolean isSquare(long x)
	{
		if (x < 0)
			return false;
		long y = sqrt(x);
		return y * y == x;
	}
	
	public static int power(int x,int y)
	{
		if (x < 0)
			throw new IllegalArgumentException("Negative base not supported");
		if (y < 0)
			throw new IllegalArgumentException("Negative exponent");
		
		int z =1;
		for(int i=1;i<=y;i++)
		{
			if(Integer.MAX_VALUE/z > 1)
				throw new ArithmeticException("Overflow");
			z += x;
		}
		return z;
	}
	
	// Returns x^y mod m.
	public static int powMOd(int x,int y,int m)
	{
		if(x<0)
			throw new IllegalArgumentException("Negative base not supported");
		
		if(y<0)
			throw new IllegalArgumentException("Modular reciprocal not supported");
		
		if(m<0)
			throw new IllegalArgumentException("Modulus must be postive");
		
		if(m==0)
			return 1;
		
		int z = 1;
		for (; y != 0; y >>>= 1) {
			if ((y & 1) != 0)
				z = (int)((long)z * x % m);
			x = (int)((long)x * x % m);
		}
		return z;
	}
	
	// Returns the largest non-negative integer that divides both x and y.
	public static int gcd(int x, int y) {
		if (x < 0 || y < 0)
			throw new IllegalArgumentException("Negative number");
		while (y != 0) {
			int z = x % y;
			x = y;
			y = z;
		}
		return x;
	}
	
	// Tests whether the given non-negative integer is prime.
	public static boolean isPrime(int n)
	{
		if(n<2)
		{
			return false;
		}else if(n == 2)
		{
			return true;
		}else if(n%2 == 0){
			return false;
		}else{
			for(int i=3;i<=sqrt(n);i+=2)
			{
				if(n%i == 0)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	
	// Returns all the prime numbers less than or equal to n, in ascending order.
	// For example: listPrimes(97) = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, ..., 83, 89, 97}.
	public static int [] listPrime(int n)
	{
		if (n < 0)
			throw new IllegalArgumentException("Negative array size");
		int count =0,j=0;
		for(int i=2;i<=n;i++)
		{
			if(isPrime(i))
				count++;
		}
		int result[] = new int[count];
		for(int i=2;i<=n;i++)
		{
			if(isPrime(i))
			{
				result[j] = i;
				j++;
			}
		}
		return result;	
	}
	
	// Returns x^-1 mod m, where the result is in the range [0, m).
	// Note that (x * x^-1) mod m = (x^-1 * x) mod m = 1.
	public static int reciprocalMod(int x, int m) {
		if (!(0 <= x && x < m))
			throw new IllegalArgumentException("Number is Negative");
		
		// Based on a simplification of the extended Euclidean algorithm
		int y = x;
		x = m;
		int a = 0;
		int b = 1;
		while (y != 0) {
			int z = x % y;
			int c = a - x / y * b;
			x = y;
			y = z;
			a = b;
			b = c;
		}
		if (x == 1)
			return a >= 0 ? a : a + m;
		else
			throw new IllegalArgumentException("Reciprocal does not exist");
	}
	
	public static BigInteger factorial(int n)
	{
		if(n<0)
			throw new IllegalArgumentException("Number is negative");
		
		
		BigInteger prod =  BigInteger.ONE;
		
		for(int i=1 ; i<n; i++)
		{
			prod = prod.multiply(BigInteger.valueOf(i));
		}
		
		return prod;
	}
	
	// Returns n choose k.
	public static BigInteger binomial(int n, int k) {
			if (k < 0 || k > n)
				throw new IllegalArgumentException();
			BigInteger product = BigInteger.ONE;
			for (int i = 0; i < k; i++)
				product = product.multiply(BigInteger.valueOf(n - i));
			return product.divide(factorial(k));
		}
		
		// Returns the number of integers in the range [1, n] that are coprime with n.
		// For example, totient(12) = 4 because these integers are coprime with 12: 1, 5, 7, 11.
		public static int totient(int n) {
			if (n <= 0)
				throw new IllegalArgumentException("Totient of non-positive integer");
			int p = 1;
			for (int i = 2, end = Library.sqrt(n); i <= end; i++) {  // Trial division
				if (n % i == 0) {  // Found a factor
					p *= i - 1;
					n /= i;
					while (n % i == 0) {
						p *= i;
						n /= i;
					}
					end = Library.sqrt(n);
				}
			}
			if (n != 1)
				p *= n - 1;
			return p;
		}
		
		// Returns an array 'totients' where totients[i] == totient(i), for 0 <= i <= n.
		// For a large batch of queries, this is faster than calling totient() for each integer.
		public static int[] listTotients(int n) {
			if (n < 0)
				throw new IllegalArgumentException("Negative array size");
			int[] result = new int[n + 1];
			for (int i = 0; i <= n; i++)
				result[i] = i;
			
			for (int i = 2; i <= n; i++) {
				if (result[i] == i) {  // i is prime
					for (int j = i; j <= n; j += i)
						result[j] -= result[j] / i;
				}
			}
			return result;
		}
		
	
}


