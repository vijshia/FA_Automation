/**
 * 
 */
package com.FA.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.FA.app.tests.baseFactory.filepath;
import com.FA.framework.Log;

/**
 * @author AJP16088
 *
 */
public class WebContext {

	public static WebDriver driver;
	public static String BE_BatchType;
	public static String BE_Facility;
	public static String batchCode;
	public static String episodeID;
	public static String invoice;
	public static String piErrorMessage;
	public static String codingErrorMessage;
	public static String peErrorMessage;
	public static String billingErrorMessage;

	public static final String TEST_DATA_PROPERTY_PATH = "\\Inputs\\config - Copy.properties";

	public void LaunchBrowser(String browsertolaunch, String url) throws Exception {

		if (browsertolaunch.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", filepath + "\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Log.info(" InternetExplorer Browser Launched ");
		} else if (browsertolaunch.equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver", filepath + "\\Drivers\\chromedriver.exe");			
			ChromeOptions choptions = new ChromeOptions();			
			choptions.setAcceptInsecureCerts(true);
			choptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
//			choptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, "DISMISS");
			driver = new ChromeDriver(choptions);			
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

	/*
	 * public WebContext() {
	 * 
	 * try { getPropertyvalues(); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
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
}
