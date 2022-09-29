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
public class CollegeController
{

	   @Autowired                      
	   private CollegeService service;
	     //creation
		@PostMapping("/College")
		public void add(@RequestBody College col)
		{
			service.create(col);
		}
		
		//to Delete the data
		@DeleteMapping("/College/{col_id}")
		public void remove(@PathVariable Integer col_id)
		{
			service.delete(col_id);
		}
		
		//Retrieve with all  the records
		@GetMapping("/College{col_id}")
		public List<College>list()
		{
			return service.listAll();
			
		}
		
		//Retrieve with specific ID
		public ResponseEntity<College> get(@PathVariable Integer col_id)
		{
			try 
			{
				College s=service.retrieve(col_id);
				return new ResponseEntity<College>(s,HttpStatus.OK);
			}	
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
			}
		}
		   //to update 
			@PutMapping("/College{col_id}")
			public ResponseEntity<College> update(@RequestBody College col, @PathVariable Integer col_id)
			{
				try 
				{
					@SuppressWarnings("unused")
					College col1=service.retrieve(col_id);
					service.create(col);
					return new ResponseEntity<College>(col, HttpStatus.OK);
				}	
			    catch(NoSuchElementException e)
				{
					return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
				}
		 
			}
	
	
}


