package com.test;

import java.util.Arrays;

public class HackerRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcbaba";
		char [] ch = str.toCharArray();
		int n = ch.length;
		int result1 = findNoSubset(ch,n);
		int result2 = findPalindrome(str,n);
		
		System.out.println(result1+result2);
	}

	private static int findPalindrome(String str,int n) {
		int ans=0;
		int i =3;
			for(int j=0 ;j<n && i+j<=n;j++){
				if(isCheck(str.substring(j,j+i),i)){
					ans++;
				}
			}	
		return ans;
	}
	 static boolean isCheck(String str,int n){
		 int mid = n/2;
		 if(str.substring(0, mid).equals(str.substring(mid+1, n)))
			 return true;
		 return false;
	    }

	private static int findNoSubset(char[] ch,int n) {
		int ans = n;
		int arr[] = new int[n-1];
		for(int i=1;i<n;i++)
		{
			if(ch[i-1] == ch[i]){
				arr[i-1] = 2;
				ans++;
			}
		}
		for(int i=3; i<=n; i++){
			for(int j=0;j<n-2;j++){
				if(arr[j]+arr[j+1]==2*(i-1) ){
					arr[j] = i;
					if(i%2==0)
						ans++;
				} 
			}
		}
		System.out.println(Arrays.toString(arr));
		return ans;
	}

}
