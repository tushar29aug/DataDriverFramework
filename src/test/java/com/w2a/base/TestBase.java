package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	public void setup() throws IOException{
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		prop.load(fis);
		log.debug("Prop file loaded");
		
		if(prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:/Users/trast2/Downloads/chromedriver_win32/chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.debug("Browser Launched");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
	}
	
	public void tearDown(){
		driver.quit();
		
	}
}
