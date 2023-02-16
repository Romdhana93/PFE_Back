package com.generaliTest.auto.service;

import java.util.List;

import com.generaliTest.auto.entities.Project;
import com.generaliTest.auto.entities.TestCase;
import com.generaliTest.auto.entities.User;

public interface ITestCaseService {

	public List<TestCase> getTestCases();

	public TestCase addTestCase(TestCase t);

	public boolean supprimerTestCaset(Long id);

	public TestCase updateTestCase(Long id, TestCase t);
	
	public List<TestCase>  getTesCaseByProject (Long projetId);
	
	public void executeTestCase(TestCase t) throws Exception;
	
	public void executeSchedulerTestCase(TestCase t) throws Exception;

	public TestCase findTestCaseById(Long id);

}
