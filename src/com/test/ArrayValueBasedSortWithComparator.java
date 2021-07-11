package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayValueBasedSortWithComparator {

	public static void main(String[] args) {
		String str[] = {"Amit 12 12","Sumit 15 21","Rohit 20 23","Rahul 20 23","Anil 19 12"};
		int n = str.length;
		Student12[] st = new Student12[n];
		for(int i=0;i<n;i++)
		{
			String s[] = str[i].split(" ");
			st[i] = new Student12();
			st[i].name = s[0];
			st[i].mark = Integer.parseInt(s[1]);
			st[i].rank = Integer.parseInt(s[2]);
		}
		
		/*Arrays.sort(st,new SortByRank());
		//System.out.println(Arrays.toString(st+"  "));
		for(int i =0;i<n;i++)
		{
			System.out.println(st[i].toString());
		}*/
		
		// For multiple attribute sort
		List<Student12> list = Arrays.asList(st);
		Collections.sort(list,new ListComparator(new SortByName(),new SortByRank()));
		
		System.out.println(list);
	}

}
class SortByRank implements Comparator<Student12>
{

	@Override
	public int compare(Student12 a1, Student12 a2) {
		
		return a1.rank-a2.rank;
	}
}
class SortByName implements Comparator<Student12>
{

	public int compare(Student12 a, Student12 b) {
		
		return a.name.compareTo(b.name);
	}
}

class Student12
{
	String name;
	int mark;
	int rank;
	
	public String toString()
	{
		return String.format("%s %d %d", name,mark,rank);
	}
}

class ListComparator implements Comparator<Student12>
{
	private List<Comparator<Student12>> comp;
	
	@SafeVarargs
	public ListComparator(Comparator<Student12>... comparator) {
		
		this.comp = Arrays.asList(comparator);
	}


	public int compare(Student12 a, Student12 b) {
		for(Comparator<Student12> listComp : comp)
		{
			int result = listComp.compare(a, b);
			if(result != 0)
			{
				return result;
			}
		}
		return 0;
	}

	
	
}