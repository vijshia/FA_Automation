/**
 * 
 */
package com.FA.framework;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import ru.yandex.qatools.allure.annotations.Step;


/**
 * @author AJP16088
 *
 */
public class Log {
	
	private static Logger Log = Logger.getLogger(Log.class);
	private final static String LOG_PATTERN_LAYOUT = "%d{yyyy-MMM-dd HH:mm:ss} %p - %m%n";
//	freemarker.log.Logger.selectLoggerLibrary(freemarker.log.Logger.LIBRARY_NONE);
	
	static {
		BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(LOG_PATTERN_LAYOUT)));
	}
	
	@Step(" *** Testcase: {0} - execution started *** ")
	public static void startTestCase(String sTestCaseName){
		
		Log.info("");
		Log.info("**************************** Starts Test Case: \"" + sTestCaseName + "\" ****************************");
	}
	
	@Step(" ************* Testcase: {0} - execution Result: {1} ************* ")
	public static void endTestCase(String sTestCaseName, String result){
	 
		Log.info("**************************** Ends Test Case: \"" +sTestCaseName + "\" - Result: " + result+" ****************************");
		Log.info("");
	 }
	
	@Step(" {0} ")
	public static void info(String message) {
		 
		 Log.info(message);	 
	}

}
