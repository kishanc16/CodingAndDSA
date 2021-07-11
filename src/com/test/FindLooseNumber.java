package com.test;

public class FindLooseNumber {

	public static void main(String[] args) {
		int  R = 41 ,K = 2;
		int count =0;
		for( int  i= 1;i<=R;i++)
		{
			String str = Integer.toBinaryString(i);
			if(checkLoose(str,K))
			{
				count++;
			}
		}
		System.out.println(count);
		
	}

	private static boolean checkLoose(String str, int k) {
		String s ="101";
		int c =0;
		for(int i=0;i<str.length()-2;i++)
		{
			if((str.substring(i, i+3)).equals(s))
			{
				c++;
			}
		}
		System.out.println(str + " c:  "+ c);
		System.exit(1);
		return (c >= k)?true:false;
	}

}
