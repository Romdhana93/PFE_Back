package com.generaliTest.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generaliTest.auto.entities.Report;


@Repository
public interface ReportRepository extends JpaRepository<Report,Long>{

	 
}

