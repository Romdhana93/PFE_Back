package com.generaliTest.auto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Roles")
public class Role implements Serializable {

	private static final long serialVersionUID = 6191889143079517027L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERol name;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long id, ERol name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ERol getName() {
		return name;
	}

	public void setName(ERol name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
