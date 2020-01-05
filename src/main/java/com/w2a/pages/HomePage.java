package com.w2a.pages;

import org.omg.PortableServer.ServantActivatorHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")
	WebElement searchBox;
	
	@FindBy(xpath="//*[@id='tsf']/div[2]/div[1]/div[3]/center/input[1]")
	WebElement searchButton;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void searchOnGoogle(){
		searchBox.sendKeys("way2Automation");
		searchButton.click();
		
	}
	
	public String getpageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public String getFontSize(){
		String fontSize = searchButton.getCssValue("font-size");
		return fontSize;
	}
	
	public String getTagName(){
		String tagName = searchButton.getTagName();
		return tagName;
	}

}
