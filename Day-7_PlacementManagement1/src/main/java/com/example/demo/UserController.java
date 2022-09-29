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

	//creation
	@PostMapping("/User")
	public void add(@RequestBody User u)
	{
		service.create(u);
	}
	
	//to Delete the data
		@DeleteMapping("/User/{user_id}")
		public void remove(@PathVariable Integer user_id)
		{
			service.delete(user_id);
		}

		//Retrieve with all  the records
		@GetMapping("/User{user_id}")
		public List<User>list()
		{
			return service.listAll();
			
		}
		
		//Retrieve with specific ID
		   public ResponseEntity<User> get(@PathVariable Integer user_id)
		   {
			try 
			{
				User u=service.retrieve(user_id);
				return new ResponseEntity<User>(u,HttpStatus.OK);
			}	
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
		}
		   
		 //to update 
			@PutMapping("/User{user_id}")
			public ResponseEntity<User> update(@RequestBody User u, @PathVariable Integer user_id)
			{
				try 
				{
					
					@SuppressWarnings("unused")
					User u1=service.retrieve(user_id);
					service.create(u);
					return new ResponseEntity<User>(u, HttpStatus.OK);
				}	
			    catch(NoSuchElementException e)
				{
					return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
				}
		 
			}
}
