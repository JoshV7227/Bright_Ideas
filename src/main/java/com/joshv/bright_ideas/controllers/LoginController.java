package com.joshv.bright_ideas.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.joshv.bright_ideas.models.LoginUser;
import com.joshv.bright_ideas.models.User;
import com.joshv.bright_ideas.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class LoginController {
	
	
	@Autowired
	private UserService service;
	
	@Autowired
	private HttpSession session;

	
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user, Model model) {
		
		model.addAttribute("loginUser", new LoginUser());
		
		return "index.jsp";
	}
	
	
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		
		
		
		
		
		User potentialUser = service.getThisEmail(user.getEmail());
		
		if (potentialUser != null) {
			
			result.rejectValue("email", "uniqe", "User already exists in the database, try a different email");
		}
		
		
		User potentialAlias = service.getByAlias(user.getAlias());
		
		if (potentialAlias != null) {
			
			result.rejectValue("alias", "unique alias", "This Alias is already in use!, try something else!");
		}
		
		
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("password", "matches", "Password must match confirm password!");
		
		}
		
		
		if(result.hasErrors()) {
			
			model.addAttribute("loginUser", new LoginUser());
			
			return "index.jsp";
		}
		
		
		
		
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		
		user.setPassword(hashedPassword);
		
		
		
		Long userId = service.createUser(user).getId();
		
		session.setAttribute("loggedInUserId", userId);
		
		
		
		
		return "redirect:/home";
		
		//^ cannot have any spaces between 'redirect:' and '/welcome' or it will throw error
	}
	
	
	
	
	
	
	
	
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("loginUser")LoginUser loginUser, BindingResult result, Model model) {
		
		
		
		User potentialUser = service.getThisEmail(loginUser.getEmail());
		
		if (potentialUser == null) {
			
			result.rejectValue("email", "invalid user" , "Invalid login");
			
		} else {
			
			if(!BCrypt.checkpw(loginUser.getPassword(), potentialUser.getPassword())) {
				
				result.rejectValue("email", "invalid user" , "Invalid login");
			}
		}
		
		
		
		if (result.hasErrors()) {
			
			model.addAttribute("user", new User());
			
			return "index.jsp";
		}
		
		
		
		session.setAttribute("loggedInUserId", potentialUser.getId());
		
		
		return "redirect:/home";
		
		
	}
	
	
	
	@GetMapping("/logout")
	public String logout() {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	
	
	
}
