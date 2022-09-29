package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController
{
	@Autowired                   
	private AdminService service;

	//creation
	@PostMapping("/Admin")
	public void add(@RequestBody Admin a)
	{
		service.create(a);
	}
	
	//to Delete the data
	@DeleteMapping("/Admin/{admin_id}")
	public void remove(@PathVariable Integer admin_id)
	{
		service.delete(admin_id);
	}
	
	//Retrieve with all  the records
	@GetMapping("/Admin{admin_id}")
	public List<Admin>list()
	{
		return service.listAll();
		
	}
	
	//Retrieve with specific ID
	public ResponseEntity<Admin> get(@PathVariable Integer admin_id)
	{
		try 
		{
			Admin a=service.retrieve(admin_id);
			return new ResponseEntity<Admin>(a,HttpStatus.OK);
		}	
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}
	   //to update 
		@PutMapping("/Admin{admin_id}")
		public ResponseEntity<Admin> update(@RequestBody Admin a, @PathVariable Integer admin_id)
		{
			try 
			{
				Admin a1=service.retrieve(admin_id);
				service.create(a);
				return new ResponseEntity<Admin>(a1, HttpStatus.OK);
			}	
		    catch(NoSuchElementException e)
			{
				return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
			}
	 
		}
}
