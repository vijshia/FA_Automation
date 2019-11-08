/**
 * 
 */
package com.FA.framework;

//import java.io.File;
//import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

//import org.openqa.selenium.support.ui.WebDriverWait;
import static com.FA.app.tests.baseFactory.filepath;
import com.FA.framework.Log;

/**
 * @author AJP16088
 *
 */
public class WebContext {

	public static WebDriver driver;
	
//	  public static WebDriverWait wait; 

	  public static	String batchType; 
	  public static String facilityId; 
	  public static String batchCode;
	  public static String episodeID;
	 

	protected static final String TEST_DATA_PROPERTY_PATH = "\\Inputs\\config - Copy.properties";

	/*
	 * public WebContext() {
	 * 
	 * 
	 * try { getPropertyvalues(); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * 
	 * private void getPropertyvalues() throws Exception {
	 * 
	 * PropertyReader propreader = new PropertyReader(); try { for (String key :
	 * propreader.getProperty(filepath +
	 * TEST_DATA_PROPERTY_PATH).stringPropertyNames()) { String value =
	 * propreader.getProperty(filepath + TEST_DATA_PROPERTY_PATH).getProperty(key);
	 * if (key.equalsIgnoreCase("browser")) { browsertoLaunch = value; } else if
	 * (key.equalsIgnoreCase("login_username")) { userName = value; } else if
	 * (key.equalsIgnoreCase("login_password")) { password = value; } else if
	 * (key.equalsIgnoreCase("value_facilityId")) { facilityId = value; } } } catch
	 * (IOException e) { e.printStackTrace(); } }
	 */

	public void LaunchBrowser(String browsertolaunch, String url) throws Exception {

		/*
		 * WebContext webcontext = new WebContext(); try {
		 * webcontext.getPropertyvalues(); } catch (Exception e) { e.printStackTrace();
		 * }
		 */

		if (browsertolaunch.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", filepath + "\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Log.info(" InternetExplorer Browser Launched ");
		} else if (browsertolaunch.equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver", filepath + "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			Log.info(" Chrome Browser Launched ");
		} else if (browsertolaunch.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", filepath + "\\Drivers\\geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			String ffBinaryPath = "C:\\Users\\ajp16088\\AppData\\Local\\Mozilla Firefox_oldd\\firefox.exe";
			firefoxOptions.setBinary(ffBinaryPath);
			driver = new FirefoxDriver(firefoxOptions);
			Log.info(" FireFox Browser Launched ");
		}

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
//		wait = new WebDriverWait(driver, 1500);
		driver.get(url);
	}

}
