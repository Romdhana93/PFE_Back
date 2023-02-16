package com.generaliTest.auto.controller;

import java.util.List;

import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.generaliTest.auto.entities.Project;
import com.generaliTest.auto.entities.TestCase;
import com.generaliTest.auto.entities.User;
import com.generaliTest.auto.payload.response.MessageResponse;
import com.generaliTest.auto.service.IProjetService;
import com.generaliTest.auto.service.ITestCaseService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth/testcase")
public class TestCaseRestController {

	@Autowired
	ITestCaseService itestCaseService;
	
	@Autowired
	private JobScheduler jobScheduler;
	
	@RequestMapping(value="/testCases",method=RequestMethod.GET)
	public List<TestCase> getTestCases(){
		
		return itestCaseService.getTestCases();
		}
	
	@PostMapping("/ajouterTest")
	@ResponseBody
	public TestCase ajouterTestCase(@RequestBody TestCase r)
	{
		TestCase testCase = itestCaseService.addTestCase(r);
		 return testCase;
	}
	@RequestMapping(value="/supprimerTest/{id}",method=RequestMethod.DELETE)
	public boolean supprimerTestCase(@PathVariable Long  id){
		
		return itestCaseService.supprimerTestCaset(id);
	}
	
	@RequestMapping(value="/modiferTest/{id}",method=RequestMethod.PUT)
	public TestCase updateTestCase(@PathVariable Long id ,@RequestBody TestCase r){
		return itestCaseService.updateTestCase(id, r);
	}
	@RequestMapping(value="/testCaseById/{id}",method=RequestMethod.GET)
	public TestCase getTestCaseById(@PathVariable Long  id){
		
		return itestCaseService.findTestCaseById(id);
		}
	
	@RequestMapping(value="/testCasesByProjet/{idProjet}",method=RequestMethod.GET)
	public List<TestCase> getTesCaseByProject(@PathVariable ("idProjet") Long idProjet){
		
		return itestCaseService.getTesCaseByProject(idProjet);
		}
	
	@RequestMapping(value="/runTestCase",method=RequestMethod.POST)
	public ResponseEntity<?> runJar(@RequestBody  TestCase  t) throws Exception{
		
		itestCaseService.executeTestCase(t);
		return ResponseEntity.ok(new MessageResponse("The test case is runned!")) ;
	}
	
	@RequestMapping(value = "/scheduleTest", method=RequestMethod.POST)
    public ResponseEntity<?> schedule(
    		@RequestBody TestCase  t){
        jobScheduler.schedule(t.getScheduleAt(), () -> itestCaseService.executeTestCase(t));
        return ResponseEntity.ok(new MessageResponse("job scheduled successfully"));
    }
}
