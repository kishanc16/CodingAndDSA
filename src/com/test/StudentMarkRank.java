package com.test;

import java.io.*;
import java.util.*;

public class StudentMarkRank {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\503132605\\git\\TestProject\\TestProject\\src\\com\\test\\student.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		int n = 10;
		StudentRank std[] = new StudentRank[n];
		int i =0;
		String str;
		br.readLine();
		while((str = br.readLine()) != null)
		{
			std[i] = new StudentRank();
			String s[] = str.split(" ");
			std[i].name = s[0];
			std[i].marks = Integer.parseInt(s[1]);
			i++;
		}
		Arrays.sort(std, new sortbymarks());
		generateRank(std,n);
		writeData(std,n);
		prizeDistribute(std,n);
		/*for(int x=0;x<n;x++)
		{
			System.out.println(std[x].name+" "+ std[x].marks + " "+std[x].ranks);
		}*/
		br.close();
	}

	private static void prizeDistribute(StudentRank[] std, int no) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\503132605\\git\\TestProject\\TestProject\\src\\com\\test\\prize.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		int n = 5;
		Prize pr[] = new Prize[n];
		int i =0;
		String str;
		br.readLine();
		while((str = br.readLine()) != null)
		{
			pr[i] = new Prize();
			String s[] = str.split(" ");
			pr[i].rank = Integer.parseInt(s[0]);
			pr[i].prize_money= Integer.parseInt(s[1]);
			i++;
		}
		for(int x=0;x<n;x++)
		{
			System.out.println(pr[x].rank+" "+ pr[x].prize_money );
		}
		br.close();
	}

	private static void writeData(StudentRank[] std ,int n)throws IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = new PrintWriter("C:\\Users\\503132605\\git\\TestProject\\TestProject\\src\\com\\test\\studentres.txt");
		writer.println("Name Marks Rank");
		for(int i=0; i<n ; i++)
		{
			writer.println(std[i].name + " "+std[i].marks+" "+ std[i].ranks);
		}
		writer.close();
	}

	private static void generateRank(StudentRank[] std, int n) {
		int rank = 1,i=1,c=0;;
		std[0].ranks = 1;
		while(i<n)
		{
			int j = i-1;
			if(std[i].marks == std[j].marks)
			{
				std[i].ranks = rank;
				c++;
			}else{
				rank+=c;
				c=0;
				rank++;
				std[i].ranks = rank;
			}
			i++;
		}
	}
	
}
class sortbymarks implements Comparator<StudentRank>
{
	@Override
	public int compare(StudentRank arg0, StudentRank arg1) {
		// TODO Auto-generated method stub
		return arg1.marks-arg0.marks;
	}	
}
class StudentRank
{
String name;
int  marks;
int ranks;

}
class Prize
{
	int rank;
	int prize_money;
}
