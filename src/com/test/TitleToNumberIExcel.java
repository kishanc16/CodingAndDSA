package com.test;

public class TitleToNumberIExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(titleToNumber("Z"));
				numberToTitle(943566);
	}

	private static void numberToTitle(int n) {
		StringBuilder str = new StringBuilder();
		while (n > 0) {
			int rem = (n-1) % 26;
			n = (n-1) / 26;
			System.out.println(rem + "  " + (char) (rem + 65));
			str.append((char) ((rem +65)));
			

		}
		System.out.println(str.reverse());

	}

	public static int titleToNumber(String A) {
		int n = A.length();
		int res = 0;
		for (int i = 0; i < n; i++) {
			res = res * 26 + (A.charAt(i) - 'A' + 1);
		}

		return res;
	}
}
