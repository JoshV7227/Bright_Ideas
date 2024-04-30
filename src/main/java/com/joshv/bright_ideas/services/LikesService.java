package com.joshv.bright_ideas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshv.bright_ideas.models.Idea;
import com.joshv.bright_ideas.models.User;


@Service
public class LikesService {
	
	
	@Autowired private UserService users;
	@Autowired private IdeaService ideas;

	
	public void assignLikes(Long userId, Long ideadId) {
		
		User theUser = users.getUser(userId);
		
		Idea theIdea = ideas.thisIdea(ideadId);
		
		theUser.getIdeas().add(theIdea);
		
		
		users.updateUser(theUser);
		
	}

}
