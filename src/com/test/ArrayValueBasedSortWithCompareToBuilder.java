package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.builder.CompareToBuilder;

// CompareToBuilder is an  api which is used for sorting list of  multiple attribute 
public class ArrayValueBasedSortWithCompareToBuilder {

	public static void main(String[] args) {
		String str[] = {"Amit 12 12","Sumit 15 21","Rohit 20 23","Rahul 20 23","Anil 19 12"};
		int n = str.length;
		Student13[] st = new Student13[n];
		for(int i=0;i<n;i++)
		{
			String s[] = str[i].split(" ");
			st[i] = new Student13();
			st[i].setName(s[0])  ;
			st[i].setMark(Integer.parseInt(s[1])) ;
			st[i].setRank(Integer.parseInt(s[2])); 
		}
		
		List<Student13> list = Arrays.asList(st);
		Collections.sort(list,new StudentComparator());
		System.out.println(list);
	}

}

class Student13
{
	private String name;
	private int mark;
	private int rank;
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	public String toString()
	{
		return String.format("%s %d %d", name,mark,rank);
	}
}
class StudentComparator implements Comparator<Student13>
{

	@Override
	public int compare(Student13 a, Student13 b) {
		
		return new CompareToBuilder()
				.append(a.getName(),b.getName())
				.append(a.getRank(),b.getRank())
				.toComparison();
	}
	}

