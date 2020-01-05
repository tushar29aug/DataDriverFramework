package com.w2a.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	public int counter=0;
	public int maxRetryCount = 3;

	public boolean retry(ITestResult result) {
		if(counter<maxRetryCount){
			counter++;
			return true;
		}else
		return false;
	}

}
