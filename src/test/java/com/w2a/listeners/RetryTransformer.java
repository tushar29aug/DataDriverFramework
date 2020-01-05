package com.w2a.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryTransformer implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor arg2, Method arg3) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
	}

}
