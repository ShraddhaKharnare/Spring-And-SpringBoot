package com.cg.depinj;


//1.Dependency in term of literals
public class Student
{
   private String Student_Name;    //variable
   private int rollno;
   
   //DI using Constructor
   //constructor-arg name should pass in beans.xml 
   public Student(String student_Name, int rollno) {
		super();
		Student_Name = student_Name;
		this.rollno = rollno;
	}
   
   /*
public String getStudent_Name() //use getters and setters for private
{
	return Student_Name;
}

public void setRollno(int rollno) {
	this.rollno = rollno;
}
*/
   
//userDefined Method
public void display()
{
	System.out.println("StudentName is :"+Student_Name+" "+"and Roll No is: "+rollno);
}





}
