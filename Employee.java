package com.mohitvirmani

import java.util.*;
import java.util.Arrays;

class Employee
{
    int empid;
    String name;
    String company;
    Employee(int id, String name,String comp){
        empid = id;
        this.name = name;
        company = comp;
    }

    public int getempid()
    {
        return empid;
    }
    public void setempid(int empid)
    {
        this.empid = empid;
    }
    public String getname()
    {
        return name;
    }
    public void setname(String name)
    {
        this.name = name;
    }
    public String getcompany()
    {
        return company;
    }
    public void setcompany(String company)
    {
        this.company = company;
    }

    public void display(){
        System.out.println("Employee ID: "+empid);
        System.out.println("Employee Name: "+name);
        System.out.println("Employee Company: "+company);
        System.out.println("-------------------------------");
    }
}

class EmpManagement{
    public static void main(String args[]){
        Employee data[] = new Employee[2];
        Scanner in = new Scanner(System.in);
        int count = 0,ch=0;

        while(ch != 8){
        System.out.println("-----*****----- Welcome to Employee Management System -----*****-----");
        System.out.println("Operations:");
        System.out.println("1. Create a Employee record");
        System.out.println("2. Append Employee record");
        System.out.println("3. Update Employee Data");
        System.out.println("4. Delete Employee Data");
        System.out.println("5. Search by Name");
        System.out.println("6. Sort Data");
        System.out.println("7. Display Data");
        System.out.println("8. Exit");
        System.out.println();
        System.out.println("Please make a choice: ");
        System.out.println();
        ch = in.nextInt();
        
        switch(ch){
            case 1: 
                int i,n;
                System.out.println("How many records do you want to create?");
                n = in.nextInt();
                count += n;
                if (n<=data.length){
                    for(i=0;i<n;i++){
                    try{
                        System.out.println("Enter ID");
                        int id = in.nextInt();
                        System.out.println("Enter name");
                        String name = in.next();
                        System.out.println("Enter company name");
                        String comp = in.next();
                        Employee emp = new Employee(id,name,comp);
                        data[i]=emp;
                    }
                    catch(InputMismatchException ex){
                        System.out.println(ex);
                    }
                    }
                   
                }
                else{
                    int diff;
                    diff = n - data.length;
                    Employee newdata[] = new Employee[data.length + diff];
                    for(i=0;i<n;i++){
                    try{
                    System.out.println("Enter ID");
                    int id = in.nextInt();
                    System.out.println("Enter name");
                    String name = in.next();
                    System.out.println("Enter company name");
                    String comp = in.next();
                    Employee emp = new Employee(id,name,comp);
                    newdata[i]=emp;
                    }
                    catch(InputMismatchException ex){
                        System.out.println(ex);
                    }
                    data = new Employee[newdata.length];
                    System.arraycopy(newdata,0,data,0,newdata.length);
                    }
                   
                }
                break;

            case 2:
                if (count == data.length){
                    System.out.println("Enter ID");
                    int id = in.nextInt();
                    System.out.println("Enter name");
                    String name = in.next();
                    System.out.println("Enter company name");
                    String comp = in.next();
                    Employee emp = new Employee(id,name,comp);
                    Employee newdata[] = new Employee[data.length + 1];
                    System.arraycopy(data,0,newdata,0,data.length);
                    newdata[newdata.length-1] = emp;
                    data = new Employee[newdata.length];
                    System.arraycopy(newdata,0,data,0,newdata.length);
                    count += 1;
                    System.out.println();
                    System.out.println("Record Added!!");
                }
                else{
                    count += 1;
                    System.out.println("Enter ID");
                    int id = in.nextInt();
                    System.out.println("Enter name");
                    String name = in.next();
                    System.out.println("Enter company name");
                    String comp = in.next();
                    Employee emp = new Employee(id,name,comp);
                    data[count-1] = emp;
                    System.out.println(count);
                    System.out.println();
                    System.out.println("Record Added!!");
                }
                break;
             case 3:
                System.out.println("Enter ID of employee you want to update:");
                int id = in.nextInt();
                int flag=0;
                try{
                for(i=0;i<count;i++){
                    if (data[i].empid == id){
                        flag=1;
                        System.out.println("Enter name");
                        String name = in.next();
                        System.out.println("Enter company name");
                        String comp = in.next();
                        Employee emp = new Employee(id,name,comp);
                        data[i] = emp;
                    }
                }
                }
                catch(IndexOutOfBoundsException ex){
                    System.out.println(ex);
                }
                if (flag==0){
                    System.out.println("Record Not found!!");
                }
                else{
                    System.out.println("Record updated!!");
                }
                break;
            
            case 4:
                System.out.println("Enter ID of employee you want to delete:");
                id = in.nextInt();
                flag=0; 
                int x=0;
                Employee newdata[] = new Employee[data.length];
                for(i=0;i<count;i++){
                    System.out.println(data[i].empid);
                    if (data[i].empid == id){
                        System.out.println(data[i].name);
                        flag=1;
                        continue;
                    }
                    newdata[i] = data[i];
                    x += 1;
                    count -= 1;

                }
                data = new Employee[x];
                System.arraycopy(newdata,0,data,0,x);
                System.out.println("Record Deleted successfully!!");
                break;
            
            case 5:
                System.out.println("Enter name of employee you want to search:");
                String fname = in.next();
                int f = 0;
               
                for(i=0;i<count;i++){
                    if (data[i].name.equalsIgnoreCase(fname)){
                        data[i].display();
                        f = 1;
                        break;
                    }
                }
                if(f==0){
                    System.out.println("Record Not found!!");
                }
                break;
                    
            case 6:
                System.out.println("Press 1 to sort in ASC order or 2 for DESC order");
                int c = in.nextInt();
                if (c==1){
                    for (i=0;i<count;i++){
                        for(int j=i+1;j<count;j++){
                            if(data[i].empid > data[j].empid){
                                int temp = data[i].empid;
                                data[i].empid = data[j].empid;
                                data[j].empid = temp;
                            }
                        }
                    }
                }
                else{
                    for (i=0;i<count;i++){
                        for(int j=i+1;j<count;j++){
                            if(data[i].empid < data[j].empid){
                                int temp = data[i].empid;
                                data[i].empid = data[j].empid;
                                data[j].empid = temp;
                            }
                        }
                    }
                }
                break;

            case 7:
                for(i=0;i<count;i++){
                    data[i].display();
                }
                break;

                
        }
        }



    }
}
