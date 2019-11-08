/**
 * 
 */
package com.FA.app.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import com.FA.app.pages.basePage;
import com.FA.framework.WebContext;

/**
 * @author AJP16088
 *
 */
public class baseTest {
	
	private basePage basepage;
	public static WebDriver driver;
	
	public baseTest() {

		 basepage = new basePage();
	}
	
	@BeforeSuite //(alwaysRun = false)
	@Parameters({ "browser", "url" })
	public void getDriver(String browsertolaunch, String url) throws Exception {
		
//		driver = WebContext.driver;
		WebContext webcontext = new WebContext();
		webcontext.LaunchBrowser(browsertolaunch, url);
	}	
	
	@AfterSuite(alwaysRun = true)
	public void closeWebdriver() throws Exception {

		basepage.CloseallBrowsers();
	}
	
	void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "70.0.3538.77")
                        .put("URL", "http://testjs.site88.net")
                        .build(), System.getProperty("user.dir")
                        + "/allure-results/");
    }

}
