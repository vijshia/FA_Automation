package TestGroup.TestArt;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class testClass {

	WebDriver driver;
	WebDriverWait wait;
	String browsertoLaunch = "ff";
	String url = "http://konnect.miramedtouch.com/index.php?option=com_content&view=featured&Itemid=101";
	String value_batchType = "CHARGES"; // SCHEDULE CHARGES
	String value_facilityId = "CCSC - CRANE CRE";
	String patient_searchorAdd = "search";
	public String batchCode;
	public String episodeID;

	By lnk_Login = By.xpath("//a[text()=' Login  ']");
	By txt_userName = By.id("username");
	By txt_password = By.id("password");
	By btn_login = By.xpath("//input[@value='Sign in']");
	By txt_FApassword = By.id("password");
	By btn_FALogin = By.className("btn-submit");
	By btn_FALogout = By.className("logbutton");
	By frame_LoginPage = By.tagName("frame");
	// Batch Page
	By menu_Batch = By.xpath("//a[text()='Batch']");
	By menu_BatchEntry = By.xpath("//a[text()='Batch Entry']");
	By txt_jobCode = By.xpath("//*[text()='Job Code']/following::input");
	By lookup_jobCode = By.xpath("//*[@name='jobCode']/following-sibling::a");
	By value_jobCode = By.xpath("//*[@name='jobCode']/..");
	By dd_batchType = By.id("batchType");
	By label_elements = By.xpath("//*[text()='Total Amount' or 'Start DOS']");
	By dd_facilityId = By.name("facilityId");
	By valuetoSelect_facilityId = By.xpath("//*[text()='" + value_facilityId + "']");
	By txt_batchDocumentCount = By.id("documentCount");
	By dd_batchStartDOS = By.name("startDOS");
	By dd_batchEndDOS = By.name("endDOS");
	By dd_batchDeliveryType = By.id("deliveryType");
	By dd_batchPriority = By.id("batchPriority");
	By dd_batchScanMode = By.name("scanMode");
	By dd_batchScheduleReceived = By.name("schedRecive");
	By dd_batchSSCount = By.name("schedulePageCountScreen");
	By btn_batchSave = By.id("saveBatchAct");
	By value_BatchCode = By.xpath("//*[text()='Batch Code']/following-sibling::td");
	By msg_BatchSavedConfirmation = By.xpath("//*[@id='saveInProgress']/..");
	By txt_batchTotalAmount = By.id("totalAmount");
	By txt_batchDepositDate = By.id("depositDate");
	// Schedule Receive Page Counter lookup in batchSSCount
	By dd_facility = By.id("facilityIdd");
	By txt_DOS = By.name("dosString");
	By txt_SSCount = By.name("patientCount");
	By btn_SSCSave = By.name("add");
	By msg_Recordsadded = By.className("successerror_style");
	// Batch to be Scanned Page
	By menu_BatchestobeScanned = By.xpath("//a[text()='Batches to be Scanned']");
	By header_Grid = By.id("fixed_header");
	By lnk_sNo = By.xpath("//*[text()='" + batchCode + "']/parent::*");
	By frame_BatchLookup = By.id("fancy_frame");
	By frame_HomePage = By.name("header");
	By chkbox_hasBeenScanned = By.id("hasBeenScannedFlag");
	By txt_StartDCN = By.name("startDCN");
	By txt_EndDCN = By.name("endDCN");
	By btn_Save = By.name("save");
	By icon_BatchLookupClose = By.id("fancy_close");
	// PI Page
	By menu_PI = By.xpath("//a[text()='Pat Reg']");
	By menu_PIBatches = By.xpath("//a[text()='PI Batches']");
	By menu_PIErrorCorrection = By.xpath("//a[text()='PI Error Correction']");
	By txt_joborBatchCode = By.name("jobCode");
	By txt_ErrorCorrection_jobCode = By.name("jobCodeTxt");
	By txt_ErrorCorrection_batchCode = By.name("batchCodeTxt");
	By lookup_ErrorCorrection_jobCode = By.xpath("//a[contains(@href,'searchJobCodes(')]");
	By btn_ErrorCorrection_Search = By.id("search");
	By chkbox_ErrorCorrection_AcceptAll = By.id("acceptAll");
	By btn_ErrorCorrection_acceptErrors = By.name("acceptErrorsButton");
	By msg_ErrorCorrection_noDatafound = By.xpath("//*[text()='No data found']");
	By btn_piBatches_search = By.name("Search");
	By lnk_ResultData = By.name("resultsLink");
	By chkbox_relBatch = By.name("checkHead");
	// PI - Patent Registration Page
	By btn_personalInfo_search = By.name("searchButton");
	By btn_saveEpisode = By.xpath("//*[contains(@onclick,'saveEpisode(')]");
	By lnk_summaryEpisode = By.xpath("//a[contains(@href,'summaryEpisode(')]");
	By value_episodeId = By.xpath("//*[@id='epid']/..");
	By btn_releaseBatch = By.name("release");
	By msg_ReleaseBatch = By.xpath("//*[@class='successerror_style']/preceding-sibling::div");
	// PI - Registration search Patent pop-up
	By header_registrationSearchPatent = By.id("hv");//By.xpath("//a[text()='ospital Validation']");
	By lookup_registrationSearchPatent_jobCode = By.xpath("//a[contains(@href,'searchJobCode(')]");
	By elementtoInvisible = By.id("fancy_overlay");
	By txt_lastName = By.name("plname");
	By txt_firstName = By.name("pfname");
	By lnk_registrationsearchpatent_ResultData = By.xpath("//a[contains(@href,'openRecord(')]");
	// PI - Edit Person Page
	By btn_saveandExit = By.xpath("//*[@value='Save & Exit(F9)']");
	//Coding Page
	By menu_Coding = By.xpath("//a[text()='Coding']");
	By menu_CodingBatches = By.xpath("//a[text()='Coding Batches']");
	By header_Coding_ActionPanel = By.xpath("//*[text()='Action Panel']");
	

//	public static void main(String[] args) {
	@BeforeSuite
	public void LaunchBrowser() throws Exception {

		if (browsertoLaunch.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\ajp16088\\Downloads\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println(" *************** InternetExplorer Browser Launched *************** ");
		} else if (browsertoLaunch.equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ajp16088\\Downloads\\chromedriver_win32 (77.0.3865.40)\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(" *************** Chrome Browser Launched *************** ");
		} else if (browsertoLaunch.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ajp16088\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			String ffBinaryPath = "C:\\Users\\ajp16088\\AppData\\Local\\Mozilla Firefox_oldd\\firefox.exe";
			firefoxOptions.setBinary(ffBinaryPath);
			driver = new FirefoxDriver(firefoxOptions);
			System.out.println(" *************** FireFox Browser Launched *************** ");
		}

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 1000);
	}

//	@BeforeTest
	public void NavigatetoURL() throws Exception {

		driver.get(url);
		System.out.println(" *************** Navigated to URL: " + url + " *************** ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lnk_Login));
	}

//	@Test // (threadPoolSize=4, invocationCount=2)
	public void NavigatetoLoginPage() throws Exception {

		String parentPage = driver.getWindowHandle();
		driver.findElement(lnk_Login).click();
		System.out.println(" *************** Login icon: " + lnk_Login + " Clicked *************** ");
		waitforNumberOfWindowstobePresent(2);
		Set<String> allPages = driver.getWindowHandles();
		System.out.println(allPages.size());
		for (String currentPage : allPages) {
			if (!currentPage.equals(parentPage)) {
				driver.switchTo().window(currentPage);
				System.out.println(" *************** Switched to Login Page *************** ");
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(txt_userName));
		System.out.println(" *************** UserName textbox: " + txt_userName + " is displaying *************** "
				+ Thread.currentThread().getId());

		Login();
	}

	public void Login() throws Exception {

		driver.findElement(txt_userName).sendKeys("Vijay");
		System.out.println(" *************** UserName Entered *************** ");
		driver.findElement(txt_password).sendKeys("vijay");
		System.out.println(" *************** Password Entered *************** ");
		driver.findElement(btn_login).click();
	}

	@Test(priority = 1)
	public void NavigatetoABCURL() throws Exception {

		driver.get("https://pound.abc.llc:8943/cas-server-webapp/login?service=http://172.22.21.95:8180/FirstClaim/action/loginNew");
		System.out.println(" *** Navigated to ABC URL *** ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(txt_userName));

		LogintoFA();
	}

	public void LogintoFA() throws Exception {

		enteringValues(txt_userName, "BERRY_A");
//		System.out.println(" *** UserName Entered *** ");
		enteringValues(txt_FApassword, "Goblue@1817");
//		System.out.println(" *** Password Entered *** ");
		waitforElementtobeClickable(btn_FALogin);
		clickonButton(btn_FALogin);
//		System.out.println(" *** LoginButton Clicked *** ");
		switchtoFrame(frame_LoginPage);
//		System.out.println(" *** Switched to frame_LoginPage *** ");
		waitforVisibilityofElementLocated(btn_FALogout);
		System.out.println(" *** FA HomePage displaying *** ");

		NavigatetoBatch();
		NavigatetoBatchestobeScanned();
		NavigatetoPIBatches();
		codingBatches();
	}

	public void NavigatetoBatch() throws Exception {

		javascript_scrollIntoView(menu_Batch);
		action_movetoElementandClick(menu_Batch);
		waitforVisibilityofElementLocated(menu_BatchEntry);
		clickonButton(menu_BatchEntry);
		System.out.println(" ********* menu_BatchEntry Clicked ********* ");
		waitforVisibilityofElementLocated(txt_jobCode);
		enteringValues(txt_jobCode, "AAOFA");
		System.out.println("*** AAOFA entered in jobcode ***");
		WebElement element_lookupjobCode = gettingWebElement(lookup_jobCode);
		waitforVisibilityofALLElementsLocated(element_lookupjobCode);
		action_clickElement(lookup_jobCode);
		if (gettingWebElement(value_jobCode).getText().isEmpty()) {
			waitforTexttobePresentinElementLocated(value_jobCode, " ");
		}
		enteringValues(txt_batchDocumentCount, "1");
		selectByVisibleText(dd_batchType, value_batchType);
		System.out.println("*** " + value_batchType + " selected in batchType ***");
		waitforVisibilityofElementLocated(label_elements);
		if (value_batchType.equalsIgnoreCase("CHARGES") || value_batchType.equalsIgnoreCase("SCHEDULE")) {
			/*
			 * WebElement selectElement = driver.findElement(dd_facilityId);
			 * ((JavascriptExecutor)driver).
			 * executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }"
			 * , selectElement, "CCSC - CRANE CRE"); Select select_facility = new
			 * Select(driver.findElement(dd_facilityId));
			 * select_facility.selectByVisibleText("CCSC - CRANE CRE");
			 */
			enteringValues(dd_batchStartDOS, "10162017");
//			System.out.println("*** 10162017 entered in Start DOS ***");
			enteringValues(dd_batchEndDOS, "10162018");
//			System.out.println("*** 10162018 entered in END DOS ***");
			clickonButton(dd_facilityId);
			waitforElementtobeClickable(valuetoSelect_facilityId);
			clickonButton(valuetoSelect_facilityId);
//			System.out.println("*** " + valuetoSelect_facilityId + " selected in facility ***");
			waitforVisibilityofElementLocated(dd_batchStartDOS);
			if (value_batchType.equalsIgnoreCase("CHARGES")) {
				selectByVisibleText(dd_batchDeliveryType, "DOCTOR DEPOSITED");
//				System.out.println("*** DOCTOR DEPOSITED selected in DeliveryType ***");
				selectByVisibleText(dd_batchScheduleReceived, "No");
//				System.out.println("*** No selected in ScheduleReceived ***");
			} else {
				clickonButton(dd_batchSSCount);
				System.out.println("*** SSCount Clicked ***");
				waitforVisibilityofElementLocated(frame_BatchLookup);
				switchtoFrame(frame_BatchLookup);
				selectByVisibleText(dd_facility, "CFP-CENTER FOR PLASTIC SX");
				enteringValues(txt_DOS, "10162019");
				enteringValues(txt_SSCount, "1");
				clickonButton(btn_SSCSave);
				System.out.println("*** btn_SSCSave clicked in btn_SSCLookup ***");
				waitforTexttobePresentinElementLocated(msg_Recordsadded, "Record Fields Added successfully.");
				switchtoDefaultFrame();
				switchtoFrame(frame_HomePage);
				clickonButton(icon_BatchLookupClose);
				System.out.println("*** SSC lookup Closed ***");
			}
		} else {
			enteringValues(txt_batchTotalAmount, "1");
			enteringValues(txt_batchDepositDate, "10162018");
		}
		selectByVisibleText(dd_batchPriority, "LOWEST PRIORITY");
		selectByVisibleText(dd_batchScanMode, "NORMAL");
		clickonButton(btn_batchSave);
		batchCode = gettingWebElement(value_BatchCode).getText();
		System.out.println("Batch Code: " + batchCode);
		waitforTexttobePresentinElementLocated(msg_BatchSavedConfirmation, "Batch saved successfully.");
//		System.out.println(driver.findElement(msg_BatchSavedConfirmation).getText());
		System.out.println();
		System.out.println(" *************** Batch Creation Execution Completed *************** ");
		System.out.println();
	}

	public void NavigatetoBatchestobeScanned() throws Exception {

		javascript_scrollIntoView(menu_Batch);
		action_movetoElementandClick(menu_Batch);
		waitforVisibilityofElementLocated(menu_BatchestobeScanned);
		clickonButton(menu_BatchestobeScanned);
		System.out.println(" ********* menu_BatchestobeScanned Clicked ********* ");
		waitforVisibilityofElementLocated(txt_joborBatchCode);
		enteringValues(txt_joborBatchCode, batchCode);
//		System.out.println("*** " + batchCode + " entered in joborBatchCode ***");
		clickonButton(btn_piBatches_search);
//		System.out.println("*** Search Clicked ***");
		waitforVisibilityofElementLocated(header_Grid);
		clickonButton(By.xpath("//a[contains(@href,'editBatchScan')]"));
//		System.out.println("*** Batch Link Clicked ***");
		waitforVisibilityofElementLocated(frame_BatchLookup);
		switchtoFrame(frame_BatchLookup);
//		System.out.println("*** Switched to frame_BatchLookup ***");
		waitforVisibilityofElementLocated(chkbox_hasBeenScanned);
		clickonButton(chkbox_hasBeenScanned);
//		System.out.println("*** hasBeenScanned chkbox clicked ***");
		waitforVisibilityofElementLocated(txt_StartDCN);
		enteringValues(txt_StartDCN, "999999999999999");
//		System.out.println("*** Start DCN entered ***");
		waitforVisibilityofElementLocated(txt_EndDCN);
		clickonButton(btn_Save);
		System.out.println("*** Save clicked in BatchLookup ***");
		waitforTexttobePresentinElementLocated(msg_BatchSavedConfirmation, "Batch saved successfully.");
		switchtoDefaultFrame();
		switchtoFrame(frame_HomePage);
		clickonButton(icon_BatchLookupClose);
//		System.out.println("*** BatchLookup Closed ***");
		System.out.println();
		System.out.println(" *************** Batches tobe Scanned Execution Completed *************** ");
		System.out.println();
	}

	public void NavigatetoPI() throws Exception {

		javascript_scrollIntoView(menu_PI);
		action_movetoElementandClick(menu_PI);
		waitforVisibilityofElementLocated(menu_PIBatches);
	}
	
	public void NavigatetoPIBatches() throws Exception {

		waitforInVisibilityofElementLocated(elementtoInvisible);	
		/*
		 * clickonButton(menu_PI); 
		 * waitforElementtobeClickable(menu_PIBatches);
		 */
		NavigatetoPI();
		clickonButton(menu_PIBatches);
//		System.out.println(" ********* menu_PIBatches Clicked ********* ");
		waitforInVisibilityofElementLocated(menu_PIBatches);
		waitforElementtobeClickable(txt_joborBatchCode);
		enteringValues(txt_joborBatchCode, batchCode); // batchCode
		waitforElementtobeClickable(btn_piBatches_search);
		clickonButton(btn_piBatches_search);
		waitforVisibilityofElementLocated(lnk_ResultData);
		String parentWindow = getParentWindow();
		clickonButton(lnk_ResultData);
		waitforNumberOfWindowstobePresent(2);
		navigatetoChildWindow(parentWindow);
		closeCurrentBrowser();
//		System.out.println("*** 1 Document Window got Closed ***");
		navigatetoParentWindow(parentWindow);
		switchtoDefaultFrame();
		switchtoFrame(frame_HomePage);
		waitforVisibilityofElementLocated(btn_personalInfo_search);
		clickonButton(btn_personalInfo_search);
		waitforVisibilityofElementLocated(frame_BatchLookup);
		switchtoFrame(frame_BatchLookup);
		waitforVisibilityofElementLocated(header_registrationSearchPatent);
		if (patient_searchorAdd.equalsIgnoreCase("ADD")) {

		} else {
			waitforVisibilityofElementLocated(txt_jobCode);
			enteringValues(txt_jobCode, "PLAA");
			waitforVisibilityofALLElementsLocated(gettingWebElement(lookup_registrationSearchPatent_jobCode));
			action_clickElement(lookup_registrationSearchPatent_jobCode);			 
			waitforVisibilityofElementLocated(txt_lastName);
			enteringValues(txt_lastName, "KARTHICK");
			enteringValues(txt_firstName, "R");
			waitforInVisibilityofElementLocated(elementtoInvisible);			
			waitforElementtobeClickable(btn_personalInfo_search);
			clickonButton(btn_personalInfo_search);
			waitforVisibilityofElementLocated(lnk_registrationsearchpatent_ResultData);
			clickonButton(lnk_registrationsearchpatent_ResultData);
			waitforVisibilityofElementLocated(btn_saveandExit);
			clickonButton(btn_saveandExit);
//			System.out.println("*** btn_saveandExit clicked ***");
			waitforNumberOfWindowstobePresent(2);
			navigatetoChildWindow(parentWindow);
			closeCurrentBrowser();
//			System.out.println("*** 2 Document Window got Closed ***");
			navigatetoParentWindow(parentWindow);
			switchtoDefaultFrame();
			switchtoFrame(frame_HomePage);
			switchtoDefaultFrame();
			switchtoFrame(frame_HomePage);
//			waitforVisibilityofElementLocated(btn_personalInfo_search);
			System.out.println("*** btn_personalInfo_search is displaying ***");
		}
		waitforVisibilityofElementLocated(btn_saveEpisode);
//		System.out.println("*** btn_saveEpisode clicked ***");
		clickonButton(btn_saveEpisode);
		waitforNumberOfWindowstobePresent(2);
		navigatetoChildWindow(parentWindow);
		closeCurrentBrowser();
//		System.out.println("*** 3 Document Window got Closed ***");
		navigatetoParentWindow(parentWindow);
		switchtoDefaultFrame();
		switchtoFrame(frame_HomePage);		
		/*waitforVisibilityofElementLocated(lnk_summaryEpisode);
		 * clickonButton(lnk_summaryEpisode); 
		 * navigatetoChildWindow(parentWindow);
		 */		
		waitforVisibilityofElementLocated(btn_releaseBatch);
		episodeID = gettingWebElement(value_episodeId).getText();
		System.out.println("EpisodeID: "+episodeID);
		clickonButton(btn_releaseBatch);
		System.out.println(" ********* Batch released from PI ********* ");
		waitforVisibilityofElementLocated(By.xpath("//*[contains(text(),' batch(es)')]"));
//	System.out.println("------"+gettingWebElement(By.xpath("//*[contains(text(),' batch(es)')]")).getText());
		if(!gettingWebElement(By.xpath("//*[contains(text(),' batch(es)')]")).getText().contains("released successfully")) {
			NavigatetoPI();
			clickonButton(menu_PIErrorCorrection);
//			System.out.println(" ********* menu_PIErrorCorrection Clicked ********* ");
			waitforVisibilityofElementLocated(txt_ErrorCorrection_jobCode);
			enteringValues(txt_ErrorCorrection_jobCode, "AAOFA");
			waitforVisibilityofALLElementsLocated(gettingWebElement(lookup_ErrorCorrection_jobCode));
			action_clickElement(lookup_ErrorCorrection_jobCode);			 
			enteringValues(txt_ErrorCorrection_batchCode, batchCode); // batchCode
			waitforInVisibilityofElementLocated(elementtoInvisible);
			clickonButton(btn_ErrorCorrection_Search);
			waitforVisibilityofElementLocated(chkbox_ErrorCorrection_AcceptAll);	
			By chkbox_ErrorCorrection_Accept = By.xpath("//*[@id='acceptChkbox_"+batchCode+"']"); //'acceptChkbox_"+batchCode+"'
			if(gettingWebElement(chkbox_ErrorCorrection_Accept).isDisplayed()) {
				waitforElementtobeClickable(chkbox_ErrorCorrection_Accept);
				clickonButton(chkbox_ErrorCorrection_Accept);
//				System.out.println(" ********* chkbox Accept Clicked ********* ");
				waitforElementtobeClickable(btn_ErrorCorrection_acceptErrors);
				clickonButton(btn_ErrorCorrection_acceptErrors);
//				System.out.println(" ********* button acceptErrors Clicked ********* ");
				waitforInVisibilityofElementLocated(msg_ErrorCorrection_noDatafound);
			}
			waitforInVisibilityofElementLocated(elementtoInvisible);	
			waitforElementtobeClickable(menu_PI);
			NavigatetoPI();
			clickonButton(menu_PIBatches);
			waitforInVisibilityofElementLocated(menu_PIBatches);
			waitforElementtobeClickable(txt_joborBatchCode);
			enteringValues(txt_joborBatchCode, batchCode); // batchCode
			waitforElementtobeClickable(btn_piBatches_search);
			clickonButton(btn_piBatches_search);
			waitforVisibilityofElementLocated(lnk_ResultData);
			waitforElementtobeClickable(chkbox_relBatch);
			clickonButton(chkbox_relBatch);
			waitforElementtobeClickable(btn_releaseBatch);
			clickonButton(btn_releaseBatch);
			System.out.println(" ********* Batch released from PI ********* ");
			waitforVisibilityofElementLocated(By.xpath("//*[contains(text(),' batch(es)')]"));
			System.out.println(" ********* Confirmation msg: "+gettingWebElement(msg_Recordsadded).getText());
		}				
	}
	
	public void NavigatetoCoding() throws Exception {

		waitforInVisibilityofElementLocated(elementtoInvisible);
		javascript_scrollIntoView(menu_Coding);
		action_movetoElementandClick(menu_Coding);
		waitforVisibilityofElementLocated(menu_CodingBatches);	
	}

	public void codingBatches() throws Exception {
		
		NavigatetoCoding();
		action_movetoElementandClick(menu_CodingBatches);
		System.out.println(" ********* menu_CodingBatches Clicked ********* ");
		waitforVisibilityofElementLocated(txt_joborBatchCode);
		waitforInVisibilityofElementLocated(elementtoInvisible);
		enteringValues(txt_joborBatchCode, batchCode); //batchCode
		waitforElementtobeClickable(btn_piBatches_search);
		clickonButton(btn_piBatches_search);
		waitforVisibilityofElementLocated(lnk_ResultData);
		clickonButton(lnk_ResultData);
		waitforVisibilityofElementLocated(header_Coding_ActionPanel);
		System.out.println("is header_ActionPanel displaying: "+gettingWebElement(header_Coding_ActionPanel).isDisplayed());
	}
	
	public void msgcheck() throws Exception {
		System.out.println(gettingWebElement(msg_Recordsadded).getText());
		System.out.println("------------");
		System.out.println(gettingWebElement(By.xpath("//*[@name='PIBatchForm']")).getText());
		System.out.println("------------");
		String a[] = gettingWebElement(By.xpath("//*[@name='PIBatchForm']")).getText().split("(es)");
		System.out.println(a[1]);
		System.out.println("------------------------------------------------");
		System.out.println(gettingWebElement(By.xpath("//*[contains(text(),' batch(es)')]")).getText());
	}

	@AfterSuite
	public void CloseallBrowsers() throws Exception {

		System.out.println(" *************** All Browsers will be Closed *************** ");
		driver.quit();
	}
	
	
	//------------------------------------*****************************------------------------------------
	
	public void closeCurrentBrowser() throws Exception {
		driver.close();
	}

	public void enteringValues(By locator, String value) throws Exception {
		try {
			driver.findElement(locator).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonButton(By locator) throws Exception {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectByVisibleText(By locator, String value) throws Exception {
		try {
			Select select_batchType = new Select(gettingWebElement(locator));
			select_batchType.selectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebElement gettingWebElement(By locator) throws Exception {
		try {
			return driver.findElement(locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void waitforElementtobeClickable(By locator) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitforVisibilityofElementLocated(By locator) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitforVisibilityofALLElementsLocated(WebElement webelement) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(webelement));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitforTexttobePresentinElementLocated(By locator, String value) throws Exception {
		try {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, value));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitforInVisibilityofElementLocated(By locator) throws Exception {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void waitforNumberOfWindowstobePresent(int windows) throws Exception {
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(windows));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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

	public String getParentWindow() throws Exception {
		try {
			return driver.getWindowHandle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

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

	public void navigatetoParentWindow(String parentwindow) throws Exception {
		try {
			driver.switchTo().window(parentwindow);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void switchtoFrame(By locator) throws Exception {
		try {
			driver.switchTo().frame(gettingWebElement(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void switchtoDefaultFrame() throws Exception {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void action_movetoElementandClick(By locator) throws Exception {
		try {
			Actions action = new Actions(driver);
			WebElement mouseovertoelement = gettingWebElement(locator);
			action.moveToElement(mouseovertoelement).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void action_clickElement(By locator) throws Exception {
		try {
			Actions action = new Actions(driver);
			WebElement clickelement = gettingWebElement(locator);
			action.click(clickelement).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void javascript_scrollIntoView(By locator) throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", gettingWebElement(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
