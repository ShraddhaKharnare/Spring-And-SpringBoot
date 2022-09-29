package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;


//JPARepository is existing in Spring data JPA dependencies 
//and it contains all the CRUD operations of Spring JPA
public interface StudentRepository extends JpaRepository<Student,Integer>
{
    
	
}
