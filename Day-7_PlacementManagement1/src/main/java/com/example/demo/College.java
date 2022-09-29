package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class College 
{
	
	@Id
    private Integer col_id;
    private String  collegeName;
    private String  location;
       
  //Getters and setters method
	
	public Integer getCol_id() {
		return col_id;
	}

	public void setCol_id(Integer col_id) {
		this.col_id = col_id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	//ToString Method
	
	@Override
	public String toString() {
		return "College [col_id=" + col_id + ", collegeName=" + collegeName + ", location=" + location + "]";
	}
	
	
	
	//Super Class Constructor
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Parameterized Constructor

	public College(Integer col_id, String collegeName, String location) {
		super();
		this.col_id = col_id;
		this.collegeName = collegeName;
		this.location = location;
	}
	
    
}
