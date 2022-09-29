package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Certificate 
{

	@Id
    private Integer cert_id;
    private Integer  year;
   
    
  //Getters and setters method
	public long getId() {
		return cert_id;
	}
	public void setId(Integer cert_id) {
		this.cert_id = cert_id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
		
	//ToString Method
	
	@Override
	public String toString() {
		return "Certificate [cert_id=" + cert_id + ", year=" + year + "]";
	}
	
	
	//Super Class Constructor
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Parameterized Constructor
	public Certificate(Integer cert_id, Integer year) {
		super();
		this.cert_id = cert_id;
		this.year = year;
	}
		    
}
