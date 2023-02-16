package com.generaliTest.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generaliTest.auto.entities.Project;
import com.generaliTest.auto.entities.User;

@Repository
public interface ProjetRepository extends JpaRepository<Project, Long>  {

}
