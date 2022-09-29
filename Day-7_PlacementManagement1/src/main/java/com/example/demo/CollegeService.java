package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CollegeService 
{
	
	   @Autowired
    	private CollegeRepository repo;

	    //to retrieve all the data of students class
		public List<College>listAll()
		{
			return repo.findAll();
		}
		
		//insert/create a data
		public void create (College col)
		{
			 repo.save(col);
		}
		
	  //to retrieve a single record
		public College retrieve(Integer col_id)
		{
			return repo.findById(col_id).get();
		}

		//to delete a data
		public void delete(Integer col_id)
		{
			repo.deleteById(col_id);
		}
}
