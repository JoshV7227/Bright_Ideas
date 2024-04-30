package com.joshv.bright_ideas.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {

	
	
	
	
	// __________________________________________Login information
	

	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String email;
	
	@NotEmpty(message="Password is required!")
	@Size(min=3, max = 200, message="Password must be at least 8 characters")
	private String password;
	
	
	
	
	//_____________________________________________Constructor 
	
	
	public LoginUser() {}

	
	
	
	
	
//_______________________________________________Getters and Setters

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
