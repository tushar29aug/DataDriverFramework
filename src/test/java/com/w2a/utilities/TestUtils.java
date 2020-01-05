package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.w2a.base.TestBase;

public class TestUtils extends TestBase {

	public static String screenshotFile;
	public static void captureScreenshot() throws IOException{
		Date d = new Date();		
		screenshotFile = "Scr_" + d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\trast2\\workspace\\DataDrivenFramework\\screenshot\\"+screenshotFile));
		
		}
		
	}