/**
 * 
 */
package com.FA.app.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.FA.framework.Log;

import ru.yandex.qatools.allure.annotations.Step;

import static com.FA.framework.WebContext.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author AJP16088
 *
 */
public class basePage {

	public basePage() {
//		driver = WebContext.driver;	
	}

	/**
	 * Reuse method, it will enter value in a text box Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @param value:   Value to be entered in the field
	 * @throws Exception: For exception handling
	 */
	@Step("Entering value in: {0} - value: {1}")
	public void enteringValues(By locator, String value) throws Exception {

		try {
			driver.findElement(locator).sendKeys(value);
//			Log.info("Entering Value in the text field " + locator + " / with the value " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will enter keystrokes Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @param value:   Value to be entered in the field
	 * @throws Exception: For exception handling
	 */
	@Step("Entering value in: {0} - value: {1}")
	public void enteringKeyStrokes(By locator, Keys key) throws Exception {

		try {
			driver.findElement(locator).sendKeys(key);
//			Log.info("Entering Value in the text field " + locator + " / with the value " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will perform click action over the element Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @throws Exception: For exception handling
	 */
	@Step("Clicking on the Element: {0}")
	public void clickonButton(By locator) throws Exception {

		try {
			driver.findElement(locator).click();
//			Log.info("Click action performed in the link or button " + locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will clear the existing values in the text box Author:
	 * AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @throws Exception: For exception handling
	 */
	@Step("Clicking on the Element: {0}")
	public void clearValues(By locator) throws Exception {

		try {
			driver.findElement(locator).clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will select value from the dropdown Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @param value:   Value to be entered in the field
	 * @throws Exception: For exception handling
	 */
	public void selectByVisibleText(By locator, String value) throws Exception {

		try {
			Select select_batchType = new Select(gettingWebElement(locator));
			select_batchType.selectByVisibleText(value);
//			Log.info("Selecting Value in from the dropdown field " + locator+ " / with the value " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will retrive webelement Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @return: webelement
	 * @throws Exception: For exception handling
	 */
	public WebElement gettingWebElement(By locator) throws Exception {

		try {
			return driver.findElement(locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reuse method, it will retrive list of webelements Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @return: list<webelement>
	 * @throws Exception: For exception handling
	 */
	public List<WebElement> gettingListofWebElements(By locator) throws Exception {

		try {
			return driver.findElements(locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebDriverWait webdriverwait(long waitseconds) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, waitseconds);
		return wait;
	}

	/**
	 * Reuse method, it will wait till the element is clickable in DOM Author:
	 * AJP16088
	 * 
	 * @param locator:     Locator of the element to be identified
	 * @param waitseconds: wait in seconds
	 * @throws Exception: For exception handling
	 */
//	@Step("Wait for element to be clickable: {0} - Timeout: {1} seconds")
	public void waitforElementtobeClickable(By locator, long waitseconds) throws Exception {

		try {
			webdriverwait(waitseconds).until(ExpectedConditions.elementToBeClickable(locator));
			/*
			 * WebDriverWait wait = new WebDriverWait(driver, waitseconds);
			 * wait.until(ExpectedConditions.elementToBeClickable(locator));
			 */
//			Log.info("Wait for element to be Clickable: " + locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will wait till the element is visible in DOM Author:
	 * AJP16088
	 * 
	 * @param locator:     Locator of the element to be identified
	 * @param waitseconds: wait in seconds
	 * @throws Exception: For exception handling
	 */
//	@Step("Wait for element visibility: {0} - Timeout: {1} seconds")
	public void waitforVisibilityofElementLocated(By locator, long waitseconds) throws Exception {

		try {
			webdriverwait(waitseconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
//			Log.info("Wait for element to be Visible: " + locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will wait till all the elements are visible in DOM Author:
	 * AJP16088
	 * 
	 * @param locator:     Locator of the element to be identified
	 * @param waitseconds: wait in seconds
	 * @throws Exception: For exception handling
	 */
//	@Step("Wait for visibility of all elements: {0} - Timeout: {1} seconds")
	public void waitforVisibilityofALLElementsLocated(WebElement webelement, long waitseconds) throws Exception {

		try {
			webdriverwait(waitseconds).until(ExpectedConditions.visibilityOfAllElements(webelement));
//			Log.info("Wait for all elements to be Visible: " + webelement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will wait till the element having the text in DOM 
	 * Author: AJP16088
	 * @param locator:     Locator of the element to be identified
	 * @param waitseconds: wait in seconds
	 * @param value:       value to be present
	 * @throws Exception: For exception handling
	 */
//	@Step("Wait for text: {2} - to be present: {0} - Timeout: {1} seconds")
	public void waitforTexttobePresentinElementLocated(By locator, long waitseconds, String value) throws Exception {

		try {
			webdriverwait(waitseconds).until(ExpectedConditions.textToBePresentInElementLocated(locator, value));
//			Log.info("Wait for text '"+value+"' to be present in the element: " + locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will wait till the element's attribute having the text in DOM 
	 * Author: AJP16088
	 * @param locator: Locator of the element to be identified
	 * @param waitseconds: wait in seconds
	 * @param attribute: Attribute in the webelement
	 * @param value: value to be present
	 * @throws Exception: For exception handling
	 */
//	@Step("Wait for text: {2} - to be present: {0} - Timeout: {1} seconds")
	public void waitforAttributeToBeinElementLocated(By locator, long waitseconds, String attribute, String value) throws Exception {

		try {
			webdriverwait(waitseconds).until(ExpectedConditions.attributeToBe(locator, attribute, value));
//			Log.info("Wait for text '"+value+"' to be present in the element: " + locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reuse method, it will wait till the element is invisible in DOM Author:
	 * AJP16088
	 * 
	 * @param locator:     Locator of the element to be identified
	 * @param waitseconds: wait in seconds
	 * @throws Exception: For exception handling
	 */
//	@Step("Wait for element invisibility: {0} - Timeout: {1} seconds")
	public void waitforInVisibilityofElementLocated(By locator, long waitseconds) throws Exception {

		try {
			webdriverwait(waitseconds).until(ExpectedConditions.invisibilityOfElementLocated(locator));
//			Log.info("Wait for element to be Invisible: " + locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will wait till number of windows present Author: AJP16088
	 * 
	 * @param windows:     windows to be present in int
	 * @param waitseconds: wait in seconds
	 * @throws Exception: For exception handling
	 */
//	@Step("Wait for number of windows: {0} - Timeout: {1} seconds")
	public void waitforNumberOfWindowstobePresent(int windows, long waitseconds) throws Exception {

		try {
			webdriverwait(waitseconds).until(ExpectedConditions.numberOfWindowsToBe(windows));
//			Log.info("Wait for number of windows '"+windows+"' to be Visible");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will wait till number of windows present Author: AJP16088
	 * 
	 * @param expectedurl: URL to be present
	 * @param waitseconds: wait in seconds
	 * @throws Exception: For exception handling
	 */
//	@Step("Wait for url: {0} - Timeout: {1} seconds")
	public void waitforURLtobeNavigated(String expectedurl, long waitseconds) throws Exception {

		try {
			webdriverwait(waitseconds).until(ExpectedConditions.urlToBe(expectedurl));
//			Log.info("Wait for the url '"+expectedurl+"' to be navigated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitforNumberOfElementstobePresent(By locator, long waitseconds, int numbers) throws Exception {

		try {
			webdriverwait(waitseconds).until(ExpectedConditions.numberOfElementsToBe(locator, numbers));
//			Log.info("Wait for the url '"+expectedurl+"' to be navigated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will wait till the element is visible in the frame in DOM
	 * Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @throws Exception: For exception handling
	 */
	public static ExpectedCondition<WebElement> elementToBeVisibleInFrame(final By locatorFrame, final By locator) {
		return new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				try {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(locatorFrame));
					WebElement elem = driver.findElement(locator);
					return elem.isDisplayed() && elem.isEnabled() ? elem : null;
				} catch (Exception e) {
					return null;
				}
			}

			@Override
			public String toString() {
				return "element located by: " + locator + " in " + locatorFrame;
			}
		};
	}

	public void WaitTillthePageLoads() throws Exception {

		fluentwaitwithJavascriptExecutor(driver, 45);
	}

	public void fluentwaitwithJavascriptExecutor(WebDriver driver, long waitseconds) throws Exception {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		webdriverwait(waitseconds).until(pageLoadCondition);
	}
	
	public String gettingCurrentURL() throws Exception {
		
		return driver.getCurrentUrl();		
	}

	/**
	 * Reuse method, it will get the window which is present Author: AJP16088
	 * 
	 * @return: window as string
	 * @throws Exception: For exception handling
	 */
	public String getParentWindow() throws Exception {

		try {
			return driver.getWindowHandle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reuse method, it will get the windows which is present and navigate to first
	 * child Author: AJP16088
	 * 
	 * @param parentwindow: parent window as string
	 * @throws Exception: For exception handling
	 */
	public void navigatetoChildWindow(String parentwindow) throws Exception {

		try {
			for (String window : driver.getWindowHandles()) {
				if (!window.equals(parentwindow)) {
					driver.switchTo().window(window);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will get the windows which is present and return Author:
	 * AJP16088
	 * 
	 * @return: will return the Set of string windows
	 * @throws Exception: For exception handling
	 */
	public Set<String> gettingSetofWindows() throws Exception {

		return driver.getWindowHandles();
	}

	/**
	 * Reuse method, switching to the window Author: AJP16088
	 * 
	 * @param parentwindow: parent window as string
	 * @throws Exception: For exception handling
	 */
	public void navigatetoParentWindow(String parentwindow) throws Exception {

		try {
			driver.switchTo().window(parentwindow);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, switching to frame Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @throws Exception: For exception handling
	 */
	public void switchtoFrame(By locator) throws Exception {

		try {
			driver.switchTo().frame(gettingWebElement(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, switching to default frame Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @throws Exception: For exception handling
	 */
	public void switchtoDefaultFrame() throws Exception {

		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, move to the element and perform click Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @throws Exception: For exception handling
	 */
	public void action_movetoElementandClick(By locator) throws Exception {

		try {
			Actions action = new Actions(driver);
			WebElement mouseovertoelement = gettingWebElement(locator);
			action.moveToElement(mouseovertoelement).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, perform click Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @throws Exception: For exception handling
	 */
	public void action_clickElement(By locator) throws Exception {

		try {
			Actions action = new Actions(driver);
			WebElement clickelement = gettingWebElement(locator);
			action.click(clickelement).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, scroll to the element Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @throws Exception: For exception handling
	 */
	public void javascript_scrollIntoView(By locator) throws Exception {

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", gettingWebElement(locator));
//			Log.info("Page scrolled has been performed to the element: "+locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, scroll to the element Author: AJP16088
	 * 
	 * @param locator: Locator of the element to be identified
	 * @throws Exception: For exception handling
	 */
	public void javascript_click(By locator) throws Exception {

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", gettingWebElement(locator));
//			Log.info("Page scrolled has been performed to the element: "+locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reuse method, it will close all the browsers Author: AJP16088
	 * 
	 * @throws Exception: For exception handling
	 */
	public void CloseallBrowsers() throws Exception {

		driver.quit();
//		Log.info("Closed all browsers");
	}

	/**
	 * Reuse method, it will close the current focused browser Author: AJP16088
	 * 
	 * @throws Exception: For exception handling
	 */
	public void closeCurrentBrowser() throws Exception {

		driver.close();
//		Log.info("Closed current focused browser");
	}

	/**
	 * Reuse method, it will generate the RandomNumbers from system, date hours
	 * minutes seconds used in piBatchPage for entering SSN Author: AJP16088
	 * 
	 * @return: return as stringbuilder
	 * @throws Exception: For exception handling
	 */
	public StringBuilder generatingRandomNumbers() throws Exception {

		String dateformat = new SimpleDateFormat("ddhhmmsssS").format(Calendar.getInstance().getTime());
		StringBuilder stringbuilder = new StringBuilder(dateformat);
		return stringbuilder;
	}

	/**
	 * Reuse method, it will generate the system time from system, month date year
	 * used in peBatchPage for entering in alert Author: AJP16088
	 * 
	 * @return: return as string
	 * @throws Exception: For exception handling
	 */
	public String generatingCurrentSystemTiming() throws Exception {

		return new SimpleDateFormat("MMddyyyy").format(Calendar.getInstance().getTime());
	}

	/**
	 * Reuse method, it will generate the system time from system, month date year
	 * used in peBatchPage for entering in alert Author: AJP16088
	 * 
	 * @return: return as string
	 * @throws Exception: For exception handling
	 */
	public String generatingDOSforCodingPage(String dosvalue, int yearvalue) throws Exception {

		StringBuilder stringbuilder = new StringBuilder(dosvalue);
		stringbuilder.insert(2, "/");
		stringbuilder.insert(5, "/");
//		System.out.println("inserted="+stringbuilder.toString());
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate dates = LocalDate.parse(stringbuilder.toString(), dateformat).plusYears(yearvalue); // .minusYears(yearvalue)
		dosvalue = dateformat.format(dates);
//		System.out.println("dos=> "+dosvalue);
		return dosvalue;
	}	

	/**
	 * Reuse method, it will wait till alert presnt and switch to alert Author:
	 * ajp16088
	 * 
	 * @param waitseconds: wait in seconds
	 * @return: return as alert
	 * @throws Exception: For exception handling
	 */
	@Step("Waited for the alert - Timeout: {0} seconds")
	public Alert switchtoAlert(long waitseconds) throws Exception {

		Alert alert = webdriverwait(waitseconds).until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	public Boolean isAlertPresent() throws Exception {

		Boolean alertpresent = null;
		try {
			switchtoAlert(20);
			driver.switchTo().alert();
			alertpresent = true;
		} catch (Exception e) {
			alertpresent = false;
		}
		return alertpresent;
	}

	/**
	 * Reuse method, it will read the error messages in correction page and return
	 * as string Author: ajp16088
	 * 
	 * @return: return as string
	 * @throws Exception: For exception handling
	 */
	public String errorMessage() throws Exception {

		String error = null;
		WebElement dataHeader = driver.findElement(By.xpath(".//*[@id='fixed_header']/div[2]"));
		List<WebElement> dataHeaderRows = dataHeader.findElements(By.tagName("tr"));
		int errorcount = 1;
		for (WebElement headerRow : dataHeaderRows) {
			List<WebElement> headerColumnData = headerRow.findElements(By.tagName("td"));
			for (WebElement header : headerColumnData) {
				if (header.getText().contains(": ")) {
					/*
					 * if (header.getText().contains("In-Valid") || header.getText().contains("Bad")
					 * || header.getText().contains("FA Rule") ||
					 * header.getText().contains("Discrepancy") ||
					 * header.getText().contains("Warning") ||
					 * header.getText().contains("Duplicate") || header.getText().contains("rror")
					 * || header.getText().contains("already") || header.getText().contains("old:"))
					 * { if (!header.getText().contains("Add/View Error Notes")) {
					 */
//						 System.out.println(header.getText());					
					error = error == null ? errorcount + ". " + header.getText()
							: error + ", " + errorcount + ". " + header.getText();
//						System.out.println(error);
					errorcount++;
//					}
				}
			}
		}
		return error;
	}

	/**
	 * Reuse method, it will read the billing Process Table Data and return as
	 * string Author: ajp16088
	 * 
	 * @return: return as HashMap<String, String>
	 * @throws Exception: For exception handling
	 */
	public HashMap<String, String> billingProcessTableData() throws Exception {

		String[] columnnames = null;
		String[] columnvalues = null;
		waitforVisibilityofElementLocated(By.xpath(".//*[@id='fixed_header']"), 25);
		WebElement dataHeader = driver.findElement(By.xpath(".//*[@id='fixed_header']"));
		List<WebElement> dataHeaderRowscolumnname = dataHeader.findElements(By.tagName("tr"));
		int columncount1 = 0;
		for (WebElement headerRow : dataHeaderRowscolumnname) {
			List<WebElement> headerColumnHeaders = headerRow.findElements(By.tagName("th"));
			if (headerColumnHeaders.size() != 0) {
				columnnames = new String[headerColumnHeaders.size()];
				for (WebElement header : headerColumnHeaders) {
					if (!header.getText().contains("Auto Release Date") && !header.getText().contains("Validate")
							&& !header.getText().contains("Queue batch")) {
						columnnames[columncount1] = header.getText();
//							System.out.println(columnnames[columncount1]);
						columncount1++;
					}
				}
			}
		}
//			System.out.println("columncount="+columncount1);
		int columncount2 = 0;
		for (WebElement headerRow : dataHeaderRowscolumnname) {
			List<WebElement> headerColumnValues = headerRow.findElements(By.tagName("td"));
			if (headerColumnValues.size() != 0) {
				columnvalues = new String[headerColumnValues.size()];
				for (WebElement header : headerColumnValues) {
					if (!header.getText().isEmpty()) {
						columnvalues[columncount2] = header.getText();
//							System.out.println(columnvalues[columncount2]);						
						columncount2++;
					}
				}
			}
		}
//			System.out.println("columncount="+columncount2);
		HashMap<String, String> billingProcessTableDatas = new HashMap<String, String>();
		if (columncount1 == columncount2) {
			for (int i = 0; i < columncount2; i++) {
				billingProcessTableDatas.put(columnnames[i], columnvalues[i]);
			}
		}
		return billingProcessTableDatas;
	}

}
