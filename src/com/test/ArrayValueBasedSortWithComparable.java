package com.test;



import java.util.*;

public class ArrayValueBasedSortWithComparable {

	public static void main(String[] args) {
		
		String str[] = {"Amit 12 12","Sumit 15 21","Rohit 20 23","Rahul 20 23","Anil 19 12"};
		Arrays.sort(str);
		int n = str.length;
		Student[] st = new Student[n];
		for(int i=0;i<n;i++)
		{
			String s[] = str[i].split(" ");
			st[i] = new Student();
			st[i].name = s[0];
			st[i].mark = Integer.parseInt(s[1]);
			st[i].rank = Integer.parseInt(s[2]);
		}
		
		Arrays.sort(st);
		System.out.println(Arrays.toString(st));
	}
	
	
}

class Student implements Comparable<Student>
{

	
	String name;
	int mark;
	int rank;
	
	@Override
	public int compareTo(Student s) {
		// TODO Auto-generated method stub
		return s.rank-this.rank ;
		//return this.rank-s.rank ;
	}
	
	public String toString()
	{
		return String.format("%s %d %d", name,mark,rank);
	}
}

