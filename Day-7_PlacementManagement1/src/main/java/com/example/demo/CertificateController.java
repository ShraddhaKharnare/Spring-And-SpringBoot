package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CertificateController
{
	@Autowired  
	private CertificateService service;
	
	//creation
		@PostMapping("/Certificate")
		public void add(@RequestBody Certificate cert)
		{
			service.create(cert);
		}
		
		//to Delete the data
		@DeleteMapping("/Certificate{cert_id}")
		public void remove(@PathVariable Integer cert_id)
		{
			service.delete(cert_id);
		}

		//Retrieve with all  the records
		public List<Certificate>list()
		{
			return service.listAll();
			
		}
		
		//Retrieve with specific ID
		public ResponseEntity<Certificate> get(@PathVariable Integer cert_id)
		{
			try 
			{
				Certificate cert=service.retrieve(cert_id);
				return new ResponseEntity<Certificate>(cert,HttpStatus.OK);
			}	
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
			}
		}

		 //to update 
		@PutMapping("/Certificate{cert_id}")
		public ResponseEntity<Certificate> update(@RequestBody Certificate cert, @PathVariable Integer cert_id)
		{
			try 
			{
				@SuppressWarnings("unused")
				Certificate cert1=service.retrieve(cert_id);
				service.create(cert);
				return new ResponseEntity<Certificate>(cert, HttpStatus.OK);
			}	
		    catch(NoSuchElementException e)
			{
				return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
			}
	 
		}
		
}
