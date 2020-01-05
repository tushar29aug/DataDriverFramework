package com.w2a.testcases;

import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Roughtestng {
	
	public ExtentHtmlReporter htmlReport;
	public ExtentReports extent;
	public ExtentTest test;
	
	//@BeforeTest
	public void setReport(){
		htmlReport = new ExtentHtmlReporter("./reports/extent.html");
		
		htmlReport.config().setEncoding("utf-8");
		htmlReport.config().setDocumentTitle("Automation Report Tushar");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("Report Name Tushar");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		
		extent.setSystemInfo("Automation Tester", "Tushar Rastogi");
		extent.setSystemInfo("Organization", "Sapient");
		
	}

	//@AfterTest
	public void endReport(){
		extent.flush();
	}
	
	@Test
	public void passTest(){
		
		System.out.println("Pass Test");
	}
	
	@Test
	public void failTest(){
		
		System.out.println("Fail Test");
		Assert.fail("Failing the test");
	}
	
	@Test
	public void skipTest(){
		
		System.out.println("Skip Test");
		throw new SkipException("Skipping this test");
	}
	
	//@AfterMethod
	public void tearDown(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel(methodName, ExtentColor.RED);
			test.fail(m);
			
		}else if(result.getStatus()==ITestResult.SUCCESS){
			
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel(methodName, ExtentColor.GREEN);
			test.pass(m);
			
		}else if(result.getStatus()==ITestResult.SKIP){
			
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel(methodName, ExtentColor.YELLOW);
			test.skip(m);
			
		}
		
	}
}
