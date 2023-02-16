package com.generaliTest.auto.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generaliTest.auto.entities.TestCase;
import com.generaliTest.auto.entities.User;
import com.generaliTest.auto.repository.TestCaseRepository;

@Service
public class TestCaseServiceImpl implements ITestCaseService{

    private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	TestCaseRepository  testCaseRep;
	
	@Override
	public List<TestCase> getTestCases() {
		// TODO Auto-generated method stub
		return testCaseRep.findAll();
	}

	@Override
	public TestCase addTestCase(TestCase t) {
		// TODO Auto-generated method stub
		return testCaseRep.save(t);
	}

	@Override
	public boolean supprimerTestCaset(Long id) {

		testCaseRep.deleteById(id);
		return false;
	}

	@Override
	public TestCase updateTestCase(Long id, TestCase t) {

		t.setId(id);
		return testCaseRep.save(t);
	}

	@Override
	public List<TestCase> getTesCaseByProject(Long projetId) {
		// TODO Auto-generated method stub
		return testCaseRep.getTesCaseByProject(projetId);
	}

	@Override
	public void executeTestCase(TestCase t) throws Exception {

		String cmd ="java -jar ";
		String jar = cmd + t.getTestCasePath()  + t.getTestCaseName() ;
		
		// Create run arguments for the
		String line;
	    OutputStream stdin = null;
	    InputStream stderr = null;
	    InputStream stdout = null;

	      // launch EXE and grab stdin/stdout and stderr
	      Process process = Runtime.getRuntime ().exec (jar);
	      stdin = process.getOutputStream ();
	      stderr = process.getErrorStream ();
	      stdout = process.getInputStream ();

	      // "write" the parms into stdin
	      line = "param1" + "\n";
	      stdin.write(line.getBytes() );
	      stdin.flush();

	      line = "param2" + "\n";
	      stdin.write(line.getBytes() );
	      stdin.flush();

	      line = "param3" + "\n";
	      stdin.write(line.getBytes() );
	      stdin.flush();

	      stdin.close();

	      // clean up if any output in stdout
	      BufferedReader brCleanUp =
	        new BufferedReader (new InputStreamReader (stdout));
	      while ((line = brCleanUp.readLine ()) != null) {
	        //System.out.println ("[Stdout] " + line);
	      }
	      brCleanUp.close();

	      // clean up if any output in stderr
	      brCleanUp =
	        new BufferedReader (new InputStreamReader (stderr));
	      while ((line = brCleanUp.readLine ()) != null) {
	        //System.out.println ("[Stderr] " + line);
	      }
	      brCleanUp.close();
	 
	}

	@Override
	public void executeSchedulerTestCase(TestCase t) throws Exception {

		  
		   logger.info("The sample job has begun.");
	        
			String cmd ="java -jar ";
			String jar = cmd + t.getTestCasePath()  + t.getTestCaseName() ;
			
			// Create run arguments for the
			String line;
		    OutputStream stdin = null;
		    InputStream stderr = null;
		    InputStream stdout = null;

		      // launch EXE and grab stdin/stdout and stderr
		      Process process = Runtime.getRuntime ().exec (jar);
		   // get the output stream
		      stdin = process.getOutputStream ();
		      stderr = process.getErrorStream ();
		      stdout = process.getInputStream ();

		      // "write" the parms into stdin
		      line = "param1" + "\n";
		     // converts a string into a sequence of bytes
		      stdin.write(line.getBytes() );
		      // to make sure that the data is saved, without closing a stream,
		      stdin.flush();

		      line = "param2" + "\n";
		      stdin.write(line.getBytes() );
		      stdin.flush();

		      line = "param3" + "\n";
		      stdin.write(line.getBytes() );
		      stdin.flush();

		      stdin.close();

		      // clean up if any output in stdout
		      BufferedReader brCleanUp =
		        new BufferedReader (new InputStreamReader (stdout));
		      while ((line = brCleanUp.readLine ()) != null) {
		        //System.out.println ("[Stdout] " + line);
		      }
		      brCleanUp.close();

		      // clean up if any output in stderr
		      brCleanUp =
		        new BufferedReader (new InputStreamReader (stderr));
		      while ((line = brCleanUp.readLine ()) != null) {
		        //System.out.println ("[Stderr] " + line);
		      }
		      brCleanUp.close();
		 

			   logger.info("The sample job has finish.");

		}

	@Override
	public TestCase findTestCaseById(Long id) {
		// TODO Auto-generated method stub
		return testCaseRep.findById(id).get();
	}
	}


