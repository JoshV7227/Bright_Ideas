package com.joshv.bright_ideas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshv.bright_ideas.UserRepository.UserRepository;
import com.joshv.bright_ideas.models.User;

@Service
public class UserService {

	
	@Autowired
	public UserRepository repo;
	
	
	
	
	// Get one user by ID
	public User getUser(Long id) {
		
		return repo.findById(id).orElse(null);
	}
	
	
	// Get one user by Email
	public User getThisEmail(String email) {
		
		return repo.findByEmail(email);
	}
	

	// Get by alias
	public User getByAlias(String alias) {
		
		return repo.findByAlias(alias);
	}
	
	
	// Create new user
	public User createUser(User user) {
		
		return repo.save(user);
	}
	
	
	// Update user
	public User updateUser(User user) {
		
		return repo.save(user);
	}
	
	
	// Find all users
	public ArrayList<User>AllUsers(){
		
		return repo.findAll();
	}
	
}
