package com.joshv.bright_ideas.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	
	
	//___________________________________________Table variables
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@NotEmpty(message="name is required!")
	@Size(min = 3, max = 200, message="name needs at least 3 characters, my guy!")
	private String name;
	
	
	@NotEmpty(message="You must enter an Alias")
	@Size(min = 3, max=200, message="Your Alias must be at least 3 characters")
	private String alias;
	
	
	@NotBlank
	@Email(message="Please enter a valid Email")
	private String email;
	
	
	
	@NotEmpty(message="Password is required!")
	@Size(min = 3, max = 200, message="Password needs to be at least 8 characters, my guy!")
	private String password;
	

	@Transient
	@NotEmpty(message="Confirm password is required!")
	@Size(min = 3, max = 200, message="Confirm Password must be at least 8 characters")
	private String confirm;
	
	
	
	
	
	
	//_____________________________________Dates

	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	
	
	
	
	@PrePersist
	protected void onCreate() {
		
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		
		this.updatedAt = new Date();
	}
	
	
	
	// _________________________________________Test relationship
	
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Idea> userIdeas;
	
	
	
	
	
	
	
	
	//______________________________________Relation ship 
	
	
	//	realtionship here
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "likes",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "idea_id")
			
			)
	
	private List<Idea> ideas;
	
	
	//________________________________Empty constructor 
	
	
	public User() {}
	
	
	
	
	
	//_______________________________Getters and Setters
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}

	public List<Idea> getUserIdeas() {
		return userIdeas;
	}

	public void setUserIdeas(List<Idea> userIdeas) {
		this.userIdeas = userIdeas;
	}
	
	
	
	
	
}
