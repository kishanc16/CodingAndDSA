package com.test;
import java.util.*;
public class EmployeeRecordSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  str[]  = {"101 Kishan 30000","102 Amit 25000","103 Sumit 20000","104 Ajay 22000","105 Maurya 24000"};
		Employee employee [] = new Employee[str.length];
		for(int i=0; i<str.length; i++)
		{
			String data[] = str[i].split(" ");			
			employee[i] = new Employee();
			employee[i].empId = Integer.parseInt(data[0]);
			employee[i].empName = data[1];
			employee[i].empSalary = Integer.parseInt(data[2]);
		}
		Arrays.sort(employee);		
		for(Employee emp : employee)
		{
			System.out.println(emp.empId +" "+emp.empName+" "+emp.empSalary);
		}
	}
		

}
class Employee implements Comparable<Employee>{
	int empId;
	String empName;
	int empSalary;
	@Override
	public int compareTo(Employee emp) {
		// TODO Auto-generated method stub
		return this.empName.compareTo(emp.empName);
	}
	
}
