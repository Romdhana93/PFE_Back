package com.generaliTest.auto.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "TestCases")
public class TestCase implements Serializable {

	private static final long serialVersionUID = 6191889143079517027L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	private String libelle;
//
//	private String cheminPhysique;

	private String testCasePath;

	private String testCaseName;
	
	private String description;


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime scheduleAt;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "projet_id")
	private Project projet;

	public TestCase() {
		super();
	}

	public TestCase(Long id, String testCasePath, String testCaseName, String description, LocalDateTime scheduleAt,
			Project projet) {
		super();
		this.id = id;
		this.testCasePath = testCasePath;
		this.testCaseName = testCaseName;
		this.description = description;
		this.scheduleAt = scheduleAt;
		this.projet = projet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTestCasePath() {
		return testCasePath;
	}

	public void setTestCasePath(String testCasePath) {
		this.testCasePath = testCasePath;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getScheduleAt() {
		return scheduleAt;
	}

	public void setScheduleAt(LocalDateTime scheduleAt) {
		this.scheduleAt = scheduleAt;
	}

	public Project getProjet() {
		return projet;
	}

	public void setProjet(Project projet) {
		this.projet = projet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
