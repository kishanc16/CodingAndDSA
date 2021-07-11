package com.test;

public class PalindromeString {

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		str = str.toLowerCase();
		System.out.println(isPalindrome(str));
	}
	static boolean isAlphaNumeric(char ch)
    {
        return ((ch >='a' && ch <='z') || (ch >='0' && ch <='9'));
    }
    public static int isPalindrome(String A) {
        
        int n = A.length();
        A = A.toLowerCase();
        int i=0, j=n-1;
        while(i < j)
        {
            char ch1 = A.charAt(i);
            char ch2 = A.charAt(j);
            if(!isAlphaNumeric(ch1)){
                ++i;
                continue;
            }
            if(!isAlphaNumeric(ch2)){
                --j;
                continue;
            }
           
            if(A.charAt(i) != A.charAt(j)){
                return 0;   
            }
            
            i++;
            j--;
        }
        
       return 1;
    }

}
