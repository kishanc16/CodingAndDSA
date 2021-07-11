package com.test;

public class BiggestNoWithSumOfDigit {

	public static void main(String[] args) {
		int num = 595;
		System.out.println(findBiggestNum(num));
	}
	/**
	 * find biggest number rather than given in input
	 * whose sum of digit same as input
	 */
	private static int findBiggestNum(int num) {
		// TODO Auto-generated method stub
		int  max = num;
		int  div = 10;
		while(max >= div)
		{
			int rem  = max%div;
			
			if(rem != div-1)
			{
				max -=(rem+1);
			}
			if(findDigitSum(max)> findDigitSum(num))
			{
				num = max;
			}
			div *=10;
		}
		return num;
		
	}
	private static int findDigitSum(int n )
	{
		int sum =0;
		while(n>0)
		{
			int rem = n%10;
			n = n/10;
			sum+=rem;
		}
		return sum;
	}
}
