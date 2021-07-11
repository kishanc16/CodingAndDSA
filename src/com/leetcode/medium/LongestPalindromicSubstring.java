package com.leetcode.medium;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String str = "bbababad";
		System.out.println("Longest Palindrome :"+longestPalindrome(str));

	}
	public static String longestPalindrome(String s){
		if(s == null || s.length() <= 1)
			return s;
		int maxLen = 0, start=0;
		for(int i=0; i<s.length(); i++){
			int length = Math.max(getLength(i,i,s), getLength(i,i+1,s));
			System.out.println("----- Length :"+length);
			if(length > maxLen){
				maxLen = length;
				System.out.println("start : "+ start);
				start = i-(length-1)/2;
				System.out.println("------start : "+ start +" MaxLen : "+maxLen);
			}
		}
		
		return s.substring(start,start+maxLen);
	}
	private static int getLength(int i, int j, String s) {
		if(j >= s.length()) return 0;
		
		System.out.println("i : "+ i +" j : "+j);
		int length = (i == j)?-1:0;
		
		while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
			length += 2;
			i--;
			j++;
		}
		System.out.println("Length : "+ length);
		return length;
	}
}
