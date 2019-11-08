/**
 * 
 */
package com.FA.framework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.ITestListener;

import static com.FA.framework.WebContext.*;
import static com.FA.app.tests.baseFactory.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * @author AJP16088
 *
 */
public class TestNGListeners implements ITestListener {

	public void onTestStart(ITestResult result) {

		String[] className = result.getTestClass().getName().split("\\.");
		Log.startTestCase(className[className.length - 1] + "." + result.getMethod().getMethodName());
//		startTest(className[className.length - 1] + "." + result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		
		String [] className = result.getTestClass().getName().split("\\.");
    	Log.endTestCase(className[className.length - 1] +"." + result.getMethod().getMethodName(), resultStatus(result.getStatus()));
//    	getTest().log(Status.PASS, className[className.length - 1] +"." + result.getMethod().getMethodName());
	}
	
	public void onFinish(ITestContext context) {
		
//		endTest();
//		ExtentReport.getInstance().flush();
	}
	
	private String resultStatus(int result) {
		
		String resulttoreturn = null;
		if(result == 1) {
			resulttoreturn = "Success";
		} else if(result == 2) {
			resulttoreturn = "Failure";
		} else if(result == 3) {
			resulttoreturn = "Skipped";
		}			
		return resulttoreturn;		
	}

	public void onTestFailure(ITestResult result) {

		try {
			screenshotCaptureforAllure("SS for the test failure in the method: " +result.getMethod().getMethodName());
			textLogforAllure("Log for the test failure in the method: " +result.getMethod().getMethodName());
			screenshotCapture("SS for the test failure in the method: " + result.getMethod().getMethodName());
			getPageSource("PS for the test failure in the method " + result.getMethod().getMethodName());
			String[] className = result.getTestClass().getName().split("\\.");
			Log.endTestCase(className[className.length - 1] + "." + result.getMethod().getMethodName(), "Failed");
//			getTest().log(Status.FAIL, className[className.length - 1] + "." + result.getMethod().getMethodName()+ "Failed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Attachment(value = "{0}", type = "image/png")
	public byte[] screenshotCaptureforAllure(String desc) {
		
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value = "{0}", type = "text/plain")
	public static String textLogforAllure(String desc) {
		
		return desc;
	}
	
	public void screenshotCapture(String screenshotname) throws IOException {

		String dateformat = new SimpleDateFormat("ddMMMyyyy_hh_mm_ssaa").format(Calendar.getInstance().getTime());
		try {
			TakesScreenshot takescreenshot = (TakesScreenshot) driver;
			File source = takescreenshot.getScreenshotAs(OutputType.FILE);
			File creatFolder = new File(filepath + "\\Screenshots\\" + dateformat);
			creatFolder.mkdir();
			String newfolderLocation = creatFolder.getAbsolutePath();
			File destination = new File(newfolderLocation+"\\SS_"+dateformat+"_"+screenshotname+".png");
			FileUtils.copyFile(source, destination);
//			getTest().addScreenCaptureFromPath(destination.getAbsolutePath());
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void getPageSource(String pagesourcename) {

		driver.getPageSource();
	}
	
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentReport.getInstance();

	public static synchronized ExtentTest getTest() {
		
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {
		
		extent.flush();
	}

	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}
}
