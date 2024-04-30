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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="ideas")
public class Idea {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty(message="An Idea is required!")
	@Size(min = 3, max =200, message="Minimum characters is 3 and maximum is 200. Make it count!")
	private String idea;
	
	
	
	//____________________________________________dates
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
		
		
		
		
		
	
	//______________________________________________Relationships
		
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
				name = "likes",
				joinColumns = @JoinColumn(name = "idea_id"),
				inverseJoinColumns = @JoinColumn(name = "user_id")
				
				)
		
		private List<User> users;
		
		
		
		
	//_______________________________________________Constructor	
		
		public Idea() {}
		
		
		
		
		
		
		
	//_________________________________________________Getters and Setters
		
		


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getIdea() {
			return idea;
		}


		public void setIdea(String idea) {
			this.idea = idea;
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


		public List<User> getUsers() {
			return users;
		}


		public void setUsers(List<User> users) {
			this.users = users;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		
		
		
		
		
		
		
		
	
	
}
