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
public class UserController
{

	@Autowired
	private UserService service;
	
	//creation of rows
		@PostMapping("/user")
		public void add(@RequestBody User user)
		{
			service.create(user);
		}
	//delete
		@DeleteMapping("/user/{id}")
		public void delete(@PathVariable Integer user_id)
		{
			service.delete(user_id);
		}
	
	@GetMapping("/user")
	public List<User>list()
	{
		return service.listAll();
		
	}
	//retrieve a specific records from database
	@GetMapping("/user/{user_id}")
	public ResponseEntity<User>get(@PathVariable Integer user_id)
	{
		try
		{
			User user=service.retrieve(user_id);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//update
	@PutMapping("/user/{id}")
	public ResponseEntity<?>update(@RequestBody User user,@PathVariable Integer user_id)
	{
		try
		{
			@SuppressWarnings("unused")
			User user1=service.retrieve(user_id);
			service.create(user);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
		
}