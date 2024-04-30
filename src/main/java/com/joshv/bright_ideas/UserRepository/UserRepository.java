package com.joshv.bright_ideas.UserRepository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joshv.bright_ideas.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	
	
	public User findByEmail(String email);
	
	public User findByAlias(String alias);
	
	public ArrayList<User> findAll();


	
	
}
