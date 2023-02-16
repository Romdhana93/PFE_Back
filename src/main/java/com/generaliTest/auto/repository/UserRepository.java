package com.generaliTest.auto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.generaliTest.auto.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String email);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
	
	}
