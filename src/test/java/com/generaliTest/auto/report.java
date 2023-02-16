package com.generaliTest.auto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.generaliTest.auto.entities.Report;
import com.generaliTest.auto.repository.ReportRepository;



public class report {

	@Autowired
	private ReportRepository reportRepository ;
  

	
	private WebDriver driver = null;
	
	 static ExtentReports extent;
	 ExtentSparkReporter spark;

	// static ExtentTest test;
	 static ExtentTest test1;
	 static ExtentTest test2;
	 static ExtentTest test3;

	// Connection object
		 static Connection con = null;
		 // Statement object
		 private static Statement   stmt;
		 // Constant for Database URL
		 public static String DB_URL = "jdbc:mysql://localhost:3306/pfe";
		 //Database Username
		 public static String DB_USER = "root";
		 // Database Password
		 public static String DB_PASSWORD = "";
	 
	 @BeforeClass(alwaysRun = true)
		public void setUp() throws Exception {

			
//			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//			driver = new ChromeDriver();
		
			 extent = new ExtentReports();
			 spark = new ExtentSparkReporter("./Reports/Spark.html");
			extent.attachReporter(spark);

		//	test = extent.createTest("MyFirstTest");
			test1 = extent.createTest("Creation Projet Prevoyance");
			test2 = extent.createTest("Creation Projet Sante");
			test3 = extent.createTest("Creation Projet Prevoyance et Sante");


		}
	 
//	 @BeforeTest
//		public void setUp2() throws Exception {
//		try{
//		// Database connection
//		String dbClass = "com.mysql.cj.jdbc.Driver";
//		Class.forName(dbClass).newInstance();
//		// Get connection to DB
//		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//		// Statement object to send the SQL statement to the Database
//		stmt = con.createStatement();
//		}
//		catch (Exception e)
//		{
//		e.printStackTrace();
//		}
//		}
 
//	@Test
//	public void loginTestCase() throws Exception {
//		
//
//		LoginPage loginPage = new LoginPage(driver);
//
//		driver.get(
//				"http://10.2.140.157/auth/realms/GENERALI/protocol/openid-connect/auth?response_type=code&client_id=public-client&state=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC&redirect_uri=http%3A%2F%2F10.1.144.54%2F&scope=group%20openid%20profile%20email%20offline_access&code_challenge=qns5yIxHbxKtpSBNbC3eM61W26dhowwXJccQaUcsxLk&code_challenge_method=S256&nonce=YnozY2dFRnctamJybWNZQ25hNVhMQ2hnQUttdG8xUUR6Ry5PR1FTRXo3ZzdC");
//
//		loginPage.setUserName("b012cag");
//		loginPage.SetPassword("generali");
//		loginPage.clickLogin();
//		 
//
//		  test.log(Status.PASS, "Test passed!");
//	}
	@Test
	public void createProjetPrev() throws Exception {
		
		  test1.log(Status.INFO, "The use case Creation Project Prevoyance  is started!");


		  test1.log(Status.PASS, "Test passed!");
	}
	@Test
	public void createProjetSante() throws Exception {
		

		  test2.log(Status.INFO, "The use case Creation Project Sante  is started!");

	
		  test2.log(Status.PASS, "Test passed!");
	}
	
	@Test
	public void crateProjetSantePrev() throws Exception {
		

		  test3.log(Status.INFO, "The use case Creation Project prevoyance and Sante  is started!");


		  test3.log(Status.PASS, "Test passed!");
		  
//			Report reportToSave = new Report();
//			reportToSave.setResultPath("C:\\Users\\msromdhana\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\Generali_Test_Project\\Reports");
//			try {
//				if (ObjectUtils.isEmpty(reportToSave)) {
//					System.out.print("Repos null");
//				} else {
//			reportRepository.save(reportToSave);
//				}
//			} catch(Exception ex) {
//				ex.printStackTrace();
//			}
	}
	
	
	
	@AfterClass(alwaysRun = true)
	public void endReport()     {
		
		  extent.flush();

		String dbClass = "com.mysql.cj.jdbc.Driver";
		
		//Class.forName(dbClass).newInstance();
		// Get connection to DB
		Connection con;
		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			stmt = con.createStatement();		
			String reportPath = "..\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\Generali_Test_Project\\Reports\\";	
		// Statement object to send the SQL statement to the Database
			PreparedStatement st = con.prepareStatement("INSERT INTO pfe.reports (result_path) values (?)");
			st.setString(1, reportPath.trim());
			st.executeUpdate();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
