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
	@PostMapping("/college")
	public void add(@RequestBody College col)
	{
		service.create(col);
	}
	//deletion
	@DeleteMapping("/college/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);
	}
	//Retrieve with all the records
	@GetMapping("/college")
	public List<College>list()
	{
		return service.listAll();
		
	}
	//Retrieve with specific id
	@GetMapping("/college/{id}")
	public ResponseEntity<College> get(@PathVariable Integer col_id)
	{
		try {
			College col=service.retrieve(col_id);
			return new ResponseEntity<College>(col,HttpStatus.OK);
		
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	//to update
	@PutMapping("/college/{col_id}")
	public ResponseEntity<College> update(@RequestBody College col, @PathVariable Integer col_id)
	{
		try {
			@SuppressWarnings("unused")
			College c1=service.retrieve(col_id);
			service.create(col);
			return new ResponseEntity<College>(col,HttpStatus.OK);
		
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
}


