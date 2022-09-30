package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User 
{
	@Id
	private Integer user_id;
	private String user_name;
	private String user_type;
	private String user_pass;
	
	//Super Class Constructor
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		// Parameterized Constructor
		public User(int user_id, String user_name, String user_type, String user_pass) {
			super();
			this.user_id = user_id;
			this.user_name = user_name;
			this.user_type = user_type;
			this.user_pass = user_pass;
		}
	
	//Getters and setters method
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	
	//ToString Method
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_type=" + user_type + ", user_pass="
				+ user_pass + "]";
	}
	
	
	
	
	
}
