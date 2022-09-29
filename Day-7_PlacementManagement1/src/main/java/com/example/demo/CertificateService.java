package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CertificateService 
{

	@Autowired
	private CertificateRepository repo;
	
	   //to retrieve all the data of students class
		public List<Certificate>listAll()
		{
			return repo.findAll();
		}
		
		//insert/create a data
		public void create (Certificate cert)
		{
			 repo.save(cert);
		}
		
	  //to retrieve a single record
		public Certificate retrieve(Integer id)
		{
			return repo.findById(id).get();
		}

		//to delete a data
		public void delete(Integer id )
		{
			repo.deleteById(id);
		}		
}
