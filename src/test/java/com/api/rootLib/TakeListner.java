package com.api.rootLib;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;


public class TakeListner implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("*** Running test Method "+result.getMethod().getMethodName()+"----");
		ExentTestManager.startTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed***"+result.getMethod().getMethodName()+"---test successfully---");
		ExentTestManager.getTest().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("***Test Execution***"+result.getMethod().getMethodName()+"---failed---");
		ExentTestManager.getTest().log(Status.FAIL, "Test Failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("***Test ***"+result.getMethod().getMethodName()+"---skipped---");
		ExentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("***Test failed but within percentage % ***"+result.getMethod().getMethodName());
		ExentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("*** Test Suit"+context.getName()+"started***");
	}

	public void onFinish(ITestContext context) {
		System.out.println("*** Test Suit"+context.getName()+"ending***");
		ExentTestManager.endTest();
		
		ExtentManager.getInstance().flush();
	
	}
}
