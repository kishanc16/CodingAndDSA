package com.dynamicprogramming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "AGGTAB",str2 ="GXTXAABYBG";
		System.out.println("Longest Common Subsequence : "+LCS(str1,str2));
	}

	private static int LCS(String str1, String str2) {
		int n1 = str1.length();
		int n2 = str2.length();
		int table[][] = new int[n1+1][n2+1];
		String str = "";		
		for(int i=1; i<=n1; i++)
		{
			for(int j=1; j<=n2; j++)
			{
				if(i==0 || j==0)
					table[i][j] = 0;
				else if(str1.charAt(i-1) == str2.charAt(j-1)){
					table[i][j] = table[i-1][j-1]+1;
					str +=str1.charAt(i-1);
					}
				else{
					table[i][j] = Math.max(table[i-1][j],table[i][j-1] );
				}
					
			}
		}
		for(int i=0; i<=n1; i++)
		{
			for(int j=1; j<=n2; j++)
			{
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
			
		System.out.println(str);
		return table[n1][n2];
	}

}
