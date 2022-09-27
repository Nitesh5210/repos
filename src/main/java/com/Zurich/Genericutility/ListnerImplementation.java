package com.Zurich.Genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener{
private ExtentReports reports;
public static ExtentTest stest;
private ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=reports.createTest(result.getMethod().getMethodName());
		stest=test;
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.pass(result.getMethod().getMethodName()+" Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getMethod().getMethodName()+" fail");
		System.out.println(Thread.currentThread().getId());
		
	new WebDriverUtility().takeScreenShot(BaseClass.sdriver,BaseClass.sjavautility,
					result.getMethod().getMethodName());
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip("Test skip");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("document title-sdet40");
		spark.config().setDocumentTitle("Report Name-sdet40");
		spark.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author","Nitesh");
		reports.setSystemInfo("os", "win 10");
		reports.setSystemInfo("Browser", "chrome");
	}

	@Override
	public void onFinish(ITestContext context) {
	reports.flush();
		
	}

}
