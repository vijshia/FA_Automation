/**
 * 
 */
package com.FA.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author ajp16088
 *
 */
public class RetryListener implements IAnnotationTransformer {

	@SuppressWarnings({ "rawtypes", "deprecation" }) // , "deprecation"
	@Override
	public void transform(ITestAnnotation itestannotation, Class testClass, Constructor testConstructor,
			Method testMethod) {		
//		  Class<? extends IRetryAnalyzer> retry = itestannotation.getRetryAnalyzerClass(); 		  
		/*
		 * if (retry == null) { testannotation.setRetryAnalyzer(RetryFailedTC.class); }
		 */		 		
		  IRetryAnalyzer retry = itestannotation.getRetryAnalyzer(); 
//		  System.out.println("retry="+retry);
		  if (retry == null) { 
			  itestannotation.setRetryAnalyzer(RetryFailedTC.class); 
//			  System.out.println("---------retry == null-----");
		  }
//		  System.out.println("retry analyzer: " + testMethod.getName() + itestannotation.getRetryAnalyzer());
	}

}
