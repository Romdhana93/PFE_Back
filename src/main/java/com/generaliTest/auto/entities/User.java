package com.generaliTest.auto.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
@Table(name = "Users")
public class User implements Serializable {

	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String username;

	private String email;
	
    @JsonProperty(access = JsonProperty.Access.AUTO)
	private String password;

    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles", 
          joinColumns = @JoinColumn(name = "user_id"), 
          inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role = new HashSet<>();

    
    
	public User() {
		super();
	}



	public User(long id, String username, String email, String password,
			Set<com.generaliTest.auto.entities.Role> role) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
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



	public Set<Role> getRole() {
		return role;
	}



	public void setRole(Set<Role> role) {
		this.role = role;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
