package com.generaliTest.auto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generaliTest.auto.entities.TestCase;
import com.generaliTest.auto.entities.User;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long>  {

    @Query("Select t from TestCase t where t.projet.id =:projetId")
	public List<TestCase> getTesCaseByProject(@Param("projetId") Long projetId);
    
    
}
