package com.buzhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buzhi.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByUsername(String username); 
	
	public User findByEmail(String email); 

}
