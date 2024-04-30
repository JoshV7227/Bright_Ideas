package com.joshv.bright_ideas.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshv.bright_ideas.UserRepository.IdeaRepository;
import com.joshv.bright_ideas.models.Idea;
import com.joshv.bright_ideas.models.User;

@Service
public class IdeaService {

	@Autowired
	public IdeaRepository repo;
	
	
	
	// get all
	
	public ArrayList<Idea>allIdeas(){
		
		
		return repo.findAll();
	}
	
	
	
	
	// SINGLE OUT MULTIPLE LIKES
	
	public Set<User> IdeaLikers(Long id){
		
		List<User> likers = thisIdea(id).getUsers();
		
		Set<User> thisIdeaSet = new HashSet<>(likers);
		
		return thisIdeaSet;
	}
	
	
	
	
	// get one
	
	public Idea thisIdea(Long id) {
		
		return repo.findById(id).orElse(null);
	}
	
	
	
	// create idea
	
	public Idea newIdea(Idea idea) {
		
		return repo.save(idea);
	}
	
	
	// update idea
	
	public Idea updateIdea(Idea idea) {
		
		return repo.save(idea);
	}
	
	
	
	
	//delete idea
	
	public void destroyIdea(Long id) {
		
		repo.deleteById(id);
	}
	

}
