package com.mohitvirmani;
import java.util.*;

class Student{
    private int rollNo;
    private String name;
    private int age;

    public Student(int rollNo, String name, int age) {
    this.rollNo = rollNo;
    this.name = name;
    this.age = age;
    }

    @Override
    public String toString() {
    return "RollNo-" + this.rollNo + ", Name-" + this.name + ", Age-" + this.age;
    }
}

class Main{
    public static void main(String[] args) {
    Map<String, Student> map = new TreeMap<String, Student>();

    map.put("ID4",new Student(3, "Raju", 20));
    map.put("ID3",new Student(5, "Mohan", 18));
    map.put("ID2",new Student(4, "Ghanshyam", 19));
    map.put("ID5",new Student(1, "Sunil", 25));
    map.put("ID1",new Student(2, "Karthik", 26));
    
    Set<String> keys = map.keySet();
    Collection<Student> values = map.values();

    for(Student s:values){
        System.out.println(s);
    }
    for(String str:keys){
        System.out.println("key as "+str+" value "+map.get(str));
    }
    }
}
