package com.joshv.bright_ideas.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joshv.bright_ideas.models.Idea;
import com.joshv.bright_ideas.models.User;
import com.joshv.bright_ideas.services.IdeaService;
import com.joshv.bright_ideas.services.LikesService;
import com.joshv.bright_ideas.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class IdeaController {

	
	@Autowired
	private HttpSession session;
	
	@Autowired 
	private UserService uService;
	
	@Autowired
	private IdeaService service;
	
	@Autowired
	private LikesService lService;
	
	
	
	
	
	
	// ____________________________________________________ home page
	
	@GetMapping("/home")
	public String homePage(RedirectAttributes redirect, Model model) {
		
		if(session.getAttribute("loggedInUserId") == null) {
			
			redirect.addFlashAttribute("notLoggedIn", "You must be logged in to view page");
			
			return "redirect:/";
		}
		
	
		
		User thisUser = uService.getUser((Long)session.getAttribute("loggedInUserId"));	
			
		
		
		//				Trying to figure out how to sort likes. 	
		//_____________________________________________________
		
		
		List<Idea> sortedIdeas = service.allIdeas();
		
		Collections.sort(sortedIdeas,(idea1, idea2) -> Integer.compare(idea2.getUsers().size(), idea1.getUsers().size()));
		
		model.addAttribute("sortedIdeas", sortedIdeas);
		
		
		//______________________________________________
		//_____________________________________________
		
		
			
		model.addAttribute("userName", thisUser.getAlias());
		
		model.addAttribute("userId", thisUser.getId());
		
		
		
		// For the form model attribute
		
		model.addAttribute("thisIdea", new Idea());
		
		
		
		return "homePage.jsp";
	}
	
	
	
	
	
	// ____________________________________________________Create new idea
	
	@PostMapping("/newIdea")
	public String addIdea(@Valid @ModelAttribute("thisIdea")Idea idea, BindingResult result, Model model) {
		
	if(session.getAttribute("loggedInUserId") == null) {
			
			return "redirect:/";
		}
		
		
		if (result.hasErrors()) {
			
				User thisUser = uService.getUser((Long)session.getAttribute("loggedInUserId"));	
				
				List<Idea> sortedIdeas = service.allIdeas();
				
				Collections.sort(sortedIdeas,(idea1, idea2) -> Integer.compare(idea2.getUsers().size(), idea1.getUsers().size()));
				
				model.addAttribute("sortedIdeas", sortedIdeas);
				
				model.addAttribute("userName", thisUser.getAlias());
				
				model.addAttribute("userId", thisUser.getId());
			
			
			return "homePage.jsp";
		}
		
		
		service.newIdea(idea);
		
		
		return "redirect:/home";
		
	}
	
	
	
	
	//____________________________________________________ Like button
	
	@GetMapping("/likeButton/{userId}/{id}")
	public String likeThis(@PathVariable Long userId, @PathVariable Long id) {
		
		if(session.getAttribute("loggedInUserId") == null) {
			
			return "redirect:/";
		}
		
		
		lService.assignLikes(userId, id);
		
		return "redirect:/home";
		

	}
	
	
	
	
	//____________________________________________________Idea / Likes page
	
	@GetMapping("/likesPage/{id}")
	public String likesPage(@PathVariable Long id, Model model) {
		
		if(session.getAttribute("loggedInUserId") == null) {
			
			return "redirect:/";
		}
				
		User thisUser = uService.getUser((Long)session.getAttribute("loggedInUserId"));	
		
		model.addAttribute("userId", thisUser.getId());
		
		
		
		model.addAttribute("ideaInfo", service.thisIdea(id));
		
		model.addAttribute("uniqueLikers", service.IdeaLikers(id));
		
		model.addAttribute("updateIdea", new Idea());
		
		
		return "likes.jsp";
	}
	
	
	
	
	
	
	//___________________________________________________Update Idea
	
	@PutMapping("/updateIdea/{id}")
	public String updatingIdea(@Valid @ModelAttribute("updateIdea")Idea idea, BindingResult result, Model model, @PathVariable Long id) {
		
		if(session.getAttribute("loggedInUserId") == null) {
			
			return "redirect:/";
		}
		
		
		
		if (result.hasErrors()) {
			
			
			model.addAttribute("ideaInfo", service.thisIdea(id));
			
			model.addAttribute("uniqueLikers", service.IdeaLikers(id));
			
			return "likes.jsp";
		}
		
		
		idea.setUsers(service.thisIdea(id).getUsers());
		
		service.updateIdea(idea);
		
		return "redirect:/home";
		
	}
	
	
	
	
	
	
	
	
	// ____________________________________________________Users profile 
	
	@GetMapping("/userPage/{id}")
	public String profile(@PathVariable Long id, Model model) {
		
		if(session.getAttribute("loggedInUserId") == null) {
			
			return "redirect:/";
		}
		
		
		User userThings = uService.getUser(id);
		
		
		model.addAttribute("userInfo", userThings);
		
		model.addAttribute("numIdeas", userThings.getUserIdeas().size());
		
		model.addAttribute("numLikes", userThings.getIdeas().size());
		
		
		return "profilePage.jsp";
	}
	
	
	
	
	
	
	
	
	
	//_________________________________________________________Delete idea
	
	
	@DeleteMapping("/burnIdea/{id}")
	public String deleteIdea(@PathVariable("id") Long id) {
		
		if(session.getAttribute("loggedInUserId") == null) {
			
			return "redirect:/";
		}
		
		service.destroyIdea(id);
		
		return "redirect:/home";
	}
	


	
	
	
}
