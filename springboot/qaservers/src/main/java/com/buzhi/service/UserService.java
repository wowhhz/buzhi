package com.buzhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.buzhi.model.Page;
import com.buzhi.model.User;
import com.buzhi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findByUsername(String username){
		User user = userRepository.findByUsername(username);
		user.setPassword("");
		return user;
	}

	public User findByEmail(String email){
		User user = userRepository.findByEmail(email);
		user.setPassword("");
		return user;
	}
	
	public List<User> findAll(Page page){
		return null;
//		return userRepository.findAll(Pageable);
	}
}
