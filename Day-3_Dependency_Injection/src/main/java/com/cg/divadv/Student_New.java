package com.cg.divadv;


  //2. Dependency in terms of objects
  //3. Student class is dependent on Mathcheat class


public class Student_New
{
  Mathcheat math;
  
  
  public void cheating()
  {
	  math.mathcheat();
  }
  
//Dependency Injection using  setters
public void setMath(Mathcheat math) {
	this.math = math;
}
		  

}
