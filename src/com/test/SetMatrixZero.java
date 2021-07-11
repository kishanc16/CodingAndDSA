package com.test;
import java.util.*;

public class SetMatrixZero {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> mainList = new ArrayList<ArrayList<Integer>>();
		ArrayList<String> list = new ArrayList<String>();
		list.add("ABCD");
		//list.add("ab");
		//list.add("abcd");
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(1);
		list1.add(1);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(1);
		list2.add(1);
		//mainList.add(list);
		mainList.add(list1);
		mainList.add(list2);
		//System.out.println(mainList);
		//setZeroes(mainList);
		System.out.println(longestCommonPrefix(list));
	}
	public static String longestCommonPrefix(ArrayList<String> A) {
		int n = A.size();
        int ch[][] = new int[n][26];
        boolean check[][] = new boolean[n][26];
        for(int i=0; i<n; i++)
        {
            String str = A.get(i);
            for(int j=0; j<str.length(); j++)
            {
                char chr = str.charAt(j);
            	if(chr>='a' && chr<='z')
            		ch[i][str.charAt(j)-'a']++;
            	else{
            		ch[i][str.charAt(j)-'A']++;
            		check[i][str.charAt(j)-'A']= true;
            	}
            }
        }
        for(int i=0; i<n; i++)
        {
        	for(int j=0; j<26; j++)
        	{
        		System.out.print(ch[i][j]+" ");
        	}
        	System.out.println();
        }
        int min,minA;
        String result ="";
        for(int i=0; i<26; i++)
        {
            min = Integer.MAX_VALUE;
            minA = Integer.MAX_VALUE;
            for(int j=0; j<n; j++)
            {
                if(check[j][i])
                    minA = Math.min(min,ch[j][i]);
                else
                    min = Math.min(min,ch[j][i]);
            }
            System.out.println(min+" "+minA );
            while(min > 0){
	                result+=(char)(i+97);
	                min--;
            }
            while(minA > 0){
                result+=(char)(i+65);
		          minA--;
            }
        }
        return result;
    }
	static void setRowColZero(ArrayList<ArrayList<Integer>> a,int r,int c, int row, int col)
    {
        for(int i=0; i<col; i++){
        	if(a.get(r).get(i) != 0)
        		a.get(r).set(i,2);
        }
        
        for(int i=0; i<row; i++){
        	if(a.get(i).get(c) != 0)
        		a.get(i).set(c,2);
        }
        System.out.println("Setting: "+ a);
    }
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    int row = a.size();
	    int col = a.get(0).size();
	    
	    for(int i=0; i<row; i++)
	    {
	        for(int j=0; j<col; j++)
	        {
	            if(a.get(i).get(j) == 0)
	            {
	                setRowColZero(a,i,j,row,col);
	            }
	        }
	    }
	    for(int i=0; i<row; i++)
	    {
	    	for(int j=0; j<col; j++)
	    	{
	    		if(a.get(i).get(j) == 2)
	    			a.get(i).set(j, 0);
	    	}
	    }
	    System.out.println(a);
	    
	}
}
