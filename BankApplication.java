package com.mohitvirmani;

import java.util.*;
class Employee{
	//git test 
	private static String ename;
	private static int id;
	static Scanner sc=new Scanner(System.in);
	public void enter() {
		System.out.println("enter employee name :");
		ename =sc.next();
		System.out.println("enter employee id :");
		id=sc.nextInt();
	}
	public static void display() {
		System.out.println("Name of the employe :"+ename);
		System.out.println("id of the employee : "+id);
	}
	public static void update(int id,Employee employee[]) {
		int n1=getId(id,employee);
		System.out.println("Enter the updated name ");
		employee[n1].ename=sc.next();
		employee[n1].display();
		
	}
	public static int getId(int id,Employee[] employee) {
		for(int i=0;i<employee.length;i++) {
			if(id==employee[i].id) {
				return i;
			}
		}
		return 0; 
	}
	public static int getName(String name,Employee[] employee) {
		for(int i=0;i<employee.length;i++) {
			if(name.eqemployee[i].ename) {
				return i;
			}
		}
		return 0;
	}
	public static void getDetails(String name,Employee employee[]) {
		int n=getName(name,employee);
		employee[n].display();
	}
	public static void asc(Employee[] employee) {
		int n;
		for(int i=0;i<employee.length;i++) {
			n=i;
			
		}
	}
	
	
}
public class BankApplication{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of employess you want to enter?");
		int n=sc.nextInt();
		 Employee employee[]=new Employee[n];
		for(int i=0;i<n;i++) {
			employee[i]=new Employee();
			employee[i].enter();
		}
		
	int ch;
	System.out.println("***what you want to do?***");
	
	System.out.println("Enter 1 for append");
	 System.out.println("Enter 2 for delete");
	 System.out.println("Enter 3 for update");
	 System.out.println("Enter 4 for Search by name");
	 System.out.println("Enter 5 for sort ASC");
	 System.out.println("Enter 6 for sort DESC");
	 System.out.println("Enter 7 for Exit");
	 ch=sc.nextInt();
	 switch(ch) {
	 case 1:
		 for(int i=0;i<employee.length;i++) {
			 employee[i].display();
		 }
		 break;
	 case 2:
		 
		 break;
	 case 3:
	 {
		 System.out.println("Enter the id you want to update ");
		 int num=sc.nextInt();
		 Employee.update(num,employee);
		 
		 
		 
		 break;
	 }
	 case 4:
	 {
		 System.out.println("Enter the name you want to search");
		 String name=sc.next();
		 Employee.getDetails(name,employee);
		 break;
	 }
	 case 5:
		 Employee.asc(employee);
		 break;
	 }
	
	

}
}
