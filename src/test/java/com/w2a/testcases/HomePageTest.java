package com.w2a.testcases;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.pages.HomePage;

import junit.framework.Assert;

public class HomePageTest extends TestBase{

	@BeforeMethod
	public void initialize() throws IOException{
		setup();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void searchOnGooglePage(){
		
		HomePage hm = new HomePage(driver);
		System.out.println(hm.getFontSize());
		System.out.println(hm.getTagName());
		log.info("Home Page Object Created");
		hm.searchOnGoogle();
		String title = hm.getpageTitle();
		
		
		Reporter.log("Test Passed");
		log.error("error message");
		
		
	}
	
	@AfterMethod
	public void close(){
		tearDown();
		log.info("Browser Closed");
		Reporter.log("Browser Closed");
	}
}
