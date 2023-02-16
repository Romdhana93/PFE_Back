package com.generaliTest.auto.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Tests_Results")
public class Report implements Serializable {

	private static final long serialVersionUID = 6191889143079517027L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String resultPath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResultPath() {
		return resultPath;
	}

	public void setResultPath(String resultPath) {
		this.resultPath = resultPath;
	}

	
}
