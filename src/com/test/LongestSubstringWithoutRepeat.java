package com.test;
import java.util.*;

public class LongestSubstringWithoutRepeat {
	
	public static void main(String[] args) {
		String str ="pwwkew";
		int ans  =0;
		//ans = lengthOfLongestSubstringBrute(str);
		ans = lengthOfLongestSubstring(str);
		System.out.println(ans);

	}
	//sliding window
	private static int lengthOfLongestSubstring(String str) {
		/*int chr[] = new int[128];
		int left = 0;
		int right = 0;
		int max = 0;
		while(right < str.length()){
			int c = str.charAt(right);
			chr[c]++;
			while(chr[c] > 1){
				char p = str.charAt(left);
				chr[p]--;
				left++;
			}
			max = Math.max(max, right-left+1);
			right++;
		}
		return max;
		*/
		  HashSet<Character> set = new HashSet<>();
		  int st = 0;
		  int max = 0;
		  for(int i=0; i<str.length(); i++){
		  		char c = str.charAt(i);
		  		while(set.contains(c)){
		  			char cp = str.charAt(st);
		  			set.remove(cp);
		  			st++;
		  		}
		  		set.add(c);
		  		max = Math.max(max, i-st+1);
		  }
		  return max;
		 
	}
	//bruteForce
	private static int lengthOfLongestSubstringBrute(String s) {
		char ch[] = s.toCharArray();
        int n = ch.length;
        
        if(n == 0)
            return 0;
               
        int max = 0;
        for(int i=0; i<n; i++){
            Set<Character> set = new HashSet<>();
            for(int j=i; j<n; j++){
                char c = ch[j];
                if(set.contains(c)){
                    max = Math.max(max, set.size());
                    break;
                }
                set.add(c);
            }
            max = Math.max(max, set.size());
        }
        
        return max;
	}

}
