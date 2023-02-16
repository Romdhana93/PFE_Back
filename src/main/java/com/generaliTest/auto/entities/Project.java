package com.generaliTest.auto.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
@Table(name = "Projects")
public class Project implements Serializable {

	private static final long serialVersionUID = 6191889143079517027L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;

	
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="projet")
	private Set<TestCase> testCases;

	public Project() {
		super();
	}

	public Project(Long id, String name, String description, Set<TestCase> testCases) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.testCases = testCases;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<TestCase> getTestCases() {
		return testCases;
	}

	public void setTestCases(Set<TestCase> testCases) {
		this.testCases = testCases;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
