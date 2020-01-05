package com.w2a.listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.w2a.utilities.TestUtils;

public class ExtentListners implements ITestListener {
	
	static Date d = new Date();
	static String file = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	
	
	private static ExtentReports extent = ExtentManager.createInstance("C:\\Users\\trast2\\workspace\\DataDrivenFramework\\reports\\"+file);
	public static ThreadLocal<ExtentTest> testReporter = new ThreadLocal<ExtentTest>();
	public WebDriver driver;

	public void onFinish(ITestContext arg0) {
		extent.flush();
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String methodName = result.getMethod().getMethodName();		
		Markup m = MarkupHelper.createLabel(methodName, ExtentColor.RED);
		testReporter.get().fail(m);
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();		
		Markup m = MarkupHelper.createLabel(methodName, ExtentColor.YELLOW);
		testReporter.get().skip(m);
		
	}

	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getTestClass().getName()+" " +result.getMethod().getMethodName());
		testReporter.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();		
		Markup m = MarkupHelper.createLabel(methodName, ExtentColor.GREEN);
		testReporter.get().pass(m);
		
	}

}
