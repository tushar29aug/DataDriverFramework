package com.w2a.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rough {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/*driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("way2Automation");
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[3]/center/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div[1]/a/h3")).click();
		//div[@class='span_1_of_4']/input[2]
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		for(int i=0;i<allLinks.size();i++){
			System.out.println(allLinks.get(i).getText()+"   "+allLinks.get(i));
		}*/
		/*WebDriverWait wait = new WebDriverWait(driver,5);
		driver.get("http://qa.way2automation.com/");
		driver.findElement(By.xpath("//*[@id='load_box']/form/fieldset[1]/input")).sendKeys("Tushar");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id='load_form']/fieldset[4]/select"));
		Select select = new Select(dropdown);
		select.selectByValue("Algeria");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='load_form']/div/div[2]/input")).click();*/
		
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		int rowSize = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr")).size();
		int colSize = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td")).size();
		
		System.out.println(rowSize);
		System.out.println(colSize);
		
		for(int i=1;i<rowSize-1;i++){
			for(int j=1;j<colSize-1;j++){
				System.out.print(driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr["+i+"]/td["+j+"]")).getText()+"  ");
			}
		}
		System.out.println();
		driver.close();
		
		
	}

}
