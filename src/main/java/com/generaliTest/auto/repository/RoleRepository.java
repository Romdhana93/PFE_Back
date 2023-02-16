package com.generaliTest.auto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.generaliTest.auto.entities.ERol;
import com.generaliTest.auto.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long>{
	  Optional<Role> findByName(ERol name);

	
}
