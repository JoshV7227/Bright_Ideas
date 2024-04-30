package com.joshv.bright_ideas.UserRepository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joshv.bright_ideas.models.Idea;


@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long>{

	
	public ArrayList<Idea> findAll();
	
	
}
