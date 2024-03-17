package api.utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Report_Manager implements ITestListener {
	
	public ExtentSparkReporter spark;
	public ExtentReports extent; 
	public ExtentTest test;
		
	String repname;
	

	public void onStart(ITestContext context)
	{
		System.out.println("TEST STARTED");
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy HH.mm.ss");

	    String Date = myDateObj.format(myFormatObj);
		repname="Test-Result"+Date+".html";
		
		spark =new ExtentSparkReporter(".\\result\\"+repname);
		
		spark.config().setDocumentTitle("Test_Report");
		spark.config().setReportName("Pet_Store_Report");
		spark.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		
		extent.attachReporter(spark);
		extent.setSystemInfo("Application", "Pet_Store");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Shashikant");
	}
	
	public void onFinish(ITestContext testContext)
	{
		System.out.println("TEST COMPLETED");
		extent.flush();
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("TEST PASSED");
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test Passed");
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("TEST FAILED");
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test fail");
		test.log(Status.FAIL,result.getThrowable().getMessage());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("TEST SKIPPED");
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test fail");
		test.log(Status.SKIP,result.getThrowable().getMessage());
	}
	
	

}
