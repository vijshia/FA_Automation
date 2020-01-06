/**
 * 
 */
package com.FA.app.pages.fa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.FA.app.pages.basePage;
import com.FA.framework.Log;

import static com.FA.framework.WebContext.batchCode;
import static com.FA.framework.WebContext.episodeID;
import static com.FA.framework.WebContext.piErrorMessage;
import static com.FA.app.pages.fa.batchestobeScannedPage.frame_BatchLookup;
import static com.FA.app.pages.fa.batchEntryPage.txt_jobCode;
import static com.FA.app.pages.fa.batchEntryPage.frame_HomePage;
import static com.FA.app.pages.fa.batchEntryPage.msg_Recordsadded;
import static com.FA.app.tests.baseTest.hm_testdata;

/**
 * @author ajp16088
 *
 */
public class piBatchPage extends basePage {

//	private By menu_PI = By.xpath("//a[text()='Pat Reg']");
//	private By menu_PIBatches = By.xpath("//a[text()='PI Batches']");
	private By widget_PIBatches = By.xpath("//li[contains(@onclick,'piBatchSelectNew')]");
	private By widget_ViewPIErrors = By.xpath("//img[contains(@src,'pi_errors')]");
//	private By menu_PIErrorCorrection = By.xpath("//a[text()='PI Error Correction']");
	public static By txt_joborBatchCode = By.name("jobCode");
	public static By txt_ErrorCorrection_jobCode = By.name("jobCodeTxt");
	public static By txt_ErrorCorrection_batchCode = By.name("batchCodeTxt");
	public static By lookup_ErrorCorrection_jobCode = By.xpath("//a[contains(@href,'searchJobCodes(')]");
	private By btn_ErrorCorrection_Search = By.id("search");
	public static By chkbox_ErrorCorrection_AcceptAll = By.id("acceptAll");
	public static By btn_ErrorCorrection_acceptErrors = By.name("acceptErrorsButton");
	public static By msg_ErrorCorrection_noDatafound = By.xpath("//*[text()='No data found']");
	private By btn_piBatches_search = By.name("Search");
	private By msg_loadingProgress = By.id("loadingProgress");
	private By elementtoDisplay = By.xpath("//*[contains(@href,'openRecord(') or contains(text(),'Data not found')]");
	public static By lnk_ResultData = By.name("resultsLink");
	public static By chkbox_relBatch = By.name("checkHead");
	// PI - Patent Registration Page
	// PI - Add Patent - Personal Info
	private By btn_addPatient = By.name("addPatient");
	private By header_editPerson = By.xpath("//*[contains(text(),'Edit Person')]");
//	private By txt_last = By.name("person.lastName");
//	private By txt_first = By.name("person.firstName");
	private By dd_gender = By.name("person.sex");
	private By txt_dob = By.name("person.birthDateString");
	private By txt_ssn = By.name("person.ssn");
	private By dd_empStudentStatus = By.name("person.employmentStatus.employmentStatusCode");
	private By btn_apply = By.name("Apply");
	private By msg_PI_confirmation = By.xpath("//div[@class='successstyle']");
	// PI - Add Patent - Contacts
	private By tab_contacts = By.id("contactslink");
	private By header_addresses = By.xpath("//*[contains(text(),'Addresses')]");
	private By txt_contactsLast = By.name("contact.name.lastName");
	private By txt_contactsFirst = By.name("contact.name.firstName");
	private By txt_address1 = By.name("contact.address.line1");
//	private By txt_city = By.name("contact.address.city");
//	private By txt_stateProv = By.name("contact.address.stateCode");
	private By txt_zipCode = By.name("contact.address.zipcode");
//	private By txt_zipCodePlus = By.name("contact.address.zipPlus4");
	private By txt_areaCode = By.name("selectedPhone.areaCode");
	private By txt_phoneNumber = By.name("selectedPhone.phoneNumber");
//	private By txt_extn = By.name("selectedPhone.extension");
	private By elementtoInvisible1 = By.id("disabledZone");
	private By btn_add = By.name("Add");
//	private By btn_save = By.name("Save");
	// PI - Add Patent - Insurance Data
	private By tab_insurancePaths = By.xpath("//*[contains(@onclick,'loadInsurance')]");
	private By header_insuranceData = By.xpath("//*[contains(text(),'Insurance Data')]");
	private By txt_insCode = By.name("personInsurance.insuranceCompany.insCompanyCode");
	private By lookup_insCode = By.id("insCodeSearchIcon");
	private By header_insuranceSearch = By.xpath("//*[contains(text(),'Insurance Search')]");
	private By result_insurance = By.name("resultsLink");
	private By txt_imageInsName = By.name("personInsurance.imageInsName");
	private By txt_Contract = By.id("contract1");
	private By txt_confirmContract = By.name("personInsurance.contractNumber");
	private By btn_addPath = By.name("AddPath");
	private By btn_saveandUpdate = By.name("saveAndUpdate");
	private By btn_INS_saveandExit = By.name("saveAndExit");
	// PI - Search
	private By btn_personalInfo_search = By.name("searchButton");
	private By btn_saveEpisode = By.xpath("//*[contains(@onclick,'saveEpisode(')]");
	private By msg_saveConfirmation = By.xpath("//*[contains(text(),'Record saved successfully')]");
//	private By lnk_summaryEpisode = By.xpath("//a[contains(@href,'summaryEpisode(')]");
	private By value_episodeId = By.xpath("//*[@id='epid']/..");
	public static By btn_nextEpisode = By.xpath("//a[contains(@href,'nextEpisode')]");
	public static By btn_releaseBatch = By.name("release");
	public static By msg_confirmation = By.xpath("//*[contains(text(),' batch(es)')]");
//	By msg_ReleaseBatch = By.xpath("//*[@class='successerror_style']/preceding-sibling::div");
	// PI - Registration search Patent pop-up
	private By header_registrationSearchPatent = By.id("hv");// By.xpath("//a[text()='ospital Validation']");
	private By focus_txt_lastName = By.className("focus-txtbox");
	private By lookup_registrationSearchPatent_jobCode = By.xpath("//a[contains(@href,'searchJobCode(')]");
	public static By elementtoInvisible = By.id("fancy_overlay");
	private By txt_lastName = By.name("plname");
	private By txt_firstName = By.name("pfname");
	private By lnk_registrationsearchpatent_ResultData = By.xpath("//a[contains(@href,'openRecord(')]");
	// PI - Edit Person Page
	By btn_saveandExit = By.xpath("//*[@value='Save & Exit(F9)']");

	batchEntryPage batchentrypage = new batchEntryPage();

	public void NavigatetoPIBatches() throws Exception {

		Log.info(" *************** PI Batch Execution Started *************** ");
		NavigatetoPIandWaittillResultData();
		String parentWindow = getParentWindow();
		clickonButton(lnk_ResultData);
		for (int i = 0; i < Integer.valueOf(hm_testdata.get("BE_DocumentCount")); i++) {
			ClosingDocumentWindowandSwitchingtoDefaultandtoFrame(parentWindow);
			waitforVisibilityofElementLocated(btn_personalInfo_search, 25);
			clickonButton(btn_personalInfo_search);
			waitforVisibilityofElementLocated(frame_BatchLookup, 15);
			switchtoFrame(frame_BatchLookup);
			waitforVisibilityofElementLocated(header_registrationSearchPatent, 15);
			waitforVisibilityofElementLocated(focus_txt_lastName, 15);
			waitforVisibilityofElementLocated(txt_jobCode, 15);
			enteringValues(txt_jobCode, hm_testdata.get("BE_JobCode"));
			waitforVisibilityofALLElementsLocated(gettingWebElement(lookup_registrationSearchPatent_jobCode), 15);
			action_clickElement(lookup_registrationSearchPatent_jobCode);
			waitforVisibilityofElementLocated(txt_lastName, 15);
			enteringValues(txt_lastName, hm_testdata.get("PI_LastName_" + i + ""));
			enteringValues(txt_firstName, hm_testdata.get("PI_FirstName_" + i + ""));
			waitforInVisibilityofElementLocated(elementtoInvisible, 15);
			waitforElementtobeClickable(btn_personalInfo_search, 15);
			clickonButton(btn_personalInfo_search);
			waitforVisibilityofElementLocated(msg_loadingProgress, 40);
			waitforVisibilityofElementLocated(elementtoDisplay, 25);
			if (gettingWebElement(msg_Recordsadded).getText().contains("Data not found")) {
				Log.info("*** UserName not exists hence creating new user");
				clickonButton(btn_addPatient);
				waitforVisibilityofElementLocated(header_editPerson, 20);
				selectByVisibleText(dd_gender, "M");
				enteringValues(txt_dob, hm_testdata.get("PI_DOB_" + i + ""));
				waitforElementtobeClickable(txt_ssn, 15);
				enteringValues(txt_ssn, generatingRandomNumbers().replace(9, 12, "").toString());
				enteringKeyStrokes(txt_ssn, Keys.TAB);
				selectByVisibleText(dd_empStudentStatus, hm_testdata.get("PI_EMPStudentStatus"));
				clickonButton(btn_apply);
				waitforVisibilityofElementLocated(msg_PI_confirmation, 15);

				clickonButton(tab_contacts);
				waitforVisibilityofElementLocated(header_addresses, 15);
				enteringValues(txt_contactsLast, hm_testdata.get("PI_LastName_" + i + ""));
				enteringValues(txt_contactsFirst, hm_testdata.get("PI_FirstName_" + i + ""));
				enteringValues(txt_address1, hm_testdata.get("PI_Address1"));
				// enteringValues(txt_city, "MICHIGAN CITY");
				enteringValues(txt_zipCode, hm_testdata.get("PI_ZipCode"));
				// enteringValues(txt_zipCodePlus, "001");
				enteringValues(txt_areaCode, hm_testdata.get("PI_AreaCode"));
				enteringValues(txt_phoneNumber, hm_testdata.get("PI_PhoneNumber"));
				waitforInVisibilityofElementLocated(elementtoInvisible1, 15);
				clickonButton(btn_add);
				waitforVisibilityofElementLocated(msg_PI_confirmation, 15);
				clickonButton(tab_insurancePaths);
				waitforVisibilityofElementLocated(header_insuranceData, 15);
				enteringValues(txt_insCode, hm_testdata.get("PI_InsCode"));
				waitforElementtobeClickable(lookup_insCode, 15);
				clickonButton(lookup_insCode);
				waitforVisibilityofElementLocated(frame_BatchLookup, 15);
				switchtoFrame(frame_BatchLookup);
				waitforVisibilityofElementLocated(header_insuranceSearch, 20);
				clickonButton(result_insurance);
				SwitchingtoDefaultandtoFrame(parentWindow);
				switchtoFrame(frame_BatchLookup);
				waitforVisibilityofElementLocated(txt_imageInsName, 15);
				enteringValues(txt_imageInsName, hm_testdata.get("PI_ImageInsName"));
				enteringValues(txt_Contract, hm_testdata.get("PI_Contract"));
				enteringValues(txt_confirmContract, hm_testdata.get("PI_Contract"));
				waitforVisibilityofElementLocated(btn_addPath, 15);
				clickonButton(btn_addPath);
				clickonButton(btn_saveandUpdate);
				waitforVisibilityofElementLocated(msg_PI_confirmation, 15);

				waitforElementtobeClickable(btn_INS_saveandExit, 15);
				clickonButton(btn_INS_saveandExit);
			} else {
				Log.info("*** UserName: " + hm_testdata.get("PI_LastName_" + i + "") + " "
						+ hm_testdata.get("PI_FirstName_" + i + "") + " Exits"); // hm_testdata.get("PI_FirstName"+i+"")
				waitforVisibilityofElementLocated(lnk_registrationsearchpatent_ResultData, 15);
				clickonButton(lnk_registrationsearchpatent_ResultData);
				waitforVisibilityofElementLocated(btn_saveandExit, 15);
				clickonButton(btn_saveandExit);
			}
			if(isAlertPresent()) {
				switchtoAlert(15).accept();
				Log.info("*** Alert Accepted");
			}
			ClosingDocumentWindowandSwitchingtoDefaultandtoFrame(parentWindow);
			/*
			 * SwitchingtoDefaultandtoFrame();
			 * Log.info(" btn_personalInfo_search is displaying ");
			 */
			waitforVisibilityofElementLocated(btn_saveEpisode, 15);
			clickonButton(btn_saveEpisode);
			waitforVisibilityofElementLocated(btn_releaseBatch, 15);
			waitforVisibilityofElementLocated(msg_saveConfirmation, 35);
			int episodecount = i + 1;
			Log.info("*** PI Batches Episode " + episodecount + " Save message: "
					+ gettingWebElement(msg_saveConfirmation).getText());
			if (!gettingWebElement(msg_saveConfirmation).getText().contains("Record saved successfully")) {
				clickonButton(btn_saveEpisode);
			}
			waitforVisibilityofElementLocated(value_episodeId, 15);
			gettingEpisodeID(i);
			// episodeID = gettingWebElement(value_episodeId).getText();
			Log.info("*** EpisodeID: " + episodeID);
			if (hm_testdata.get("BE_DocumentCount").contentEquals("2")
					&& i + 1 < Integer.valueOf(hm_testdata.get("BE_DocumentCount"))) {
				waitforVisibilityofElementLocated(btn_nextEpisode, 15);
				clickonButton(btn_nextEpisode);
			}
		}
		clickonButton(btn_releaseBatch);
		if (gettingSetofWindows().size() > 1) {
			ClosingDocumentWindowandSwitchingtoDefaultandtoFrame(parentWindow);
		}
		waitforVisibilityofElementLocated(msg_confirmation, 30);
		Log.info("*** PI Batch - Confirmation msg: " + gettingWebElement(msg_confirmation).getText());
		if (!gettingWebElement(msg_confirmation).getText().contains("released successfully")) {
			NavigatetoPIErrors();
			enteringValues(txt_ErrorCorrection_jobCode, hm_testdata.get("BE_JobCode"));
			waitforVisibilityofALLElementsLocated(gettingWebElement(lookup_ErrorCorrection_jobCode), 15);
			action_clickElement(lookup_ErrorCorrection_jobCode);
			enteringValues(txt_ErrorCorrection_batchCode, batchCode);
			waitforInVisibilityofElementLocated(elementtoInvisible, 15);
			clickonButton(btn_ErrorCorrection_Search);
			waitforVisibilityofElementLocated(chkbox_ErrorCorrection_AcceptAll, 15);
			/*
			 * By chkbox_ErrorCorrection_Accept = By.xpath("//*[@id='acceptChkbox_" +
			 * batchCode + "']"); if
			 * (gettingWebElement(chkbox_ErrorCorrection_Accept).isDisplayed()) {
			 * waitforElementtobeClickable(chkbox_ErrorCorrection_Accept, 15);
			 * clickonButton(chkbox_ErrorCorrection_Accept);
			 */
			piErrorMessage = errorMessage();
			if (gettingWebElement(chkbox_ErrorCorrection_AcceptAll).isDisplayed()) {
				waitforElementtobeClickable(chkbox_ErrorCorrection_AcceptAll, 15);
				clickonButton(chkbox_ErrorCorrection_AcceptAll);
				waitforElementtobeClickable(btn_ErrorCorrection_acceptErrors, 15);
				clickonButton(btn_ErrorCorrection_acceptErrors);
				waitforInVisibilityofElementLocated(msg_ErrorCorrection_noDatafound, 15);
			}
			NavigatetoPIandWaittillResultData();
			waitforElementtobeClickable(chkbox_relBatch, 15);
			clickonButton(chkbox_relBatch);
			waitforElementtobeClickable(btn_releaseBatch, 15);
			clickonButton(btn_releaseBatch);
			waitforVisibilityofElementLocated(msg_confirmation, 25); // By.xpath("//*[contains(text(),' batch(es)')]")
			Log.info("********* PI Batch Release message: " + gettingWebElement(msg_Recordsadded).getText());
		}
		Log.info(" *************** PI Batch Execution Completed *************** ");
		Log.info("");
	}

	private void gettingEpisodeID(int count) throws Exception {

		count = count + 1;
		episodeID = episodeID == null ? count + ". " + gettingWebElement(value_episodeId).getText()
				: episodeID + ", " + count + ". " + gettingWebElement(value_episodeId).getText();
	}

	/*
	 * private void NavigatetoPI() throws Exception {
	 * 
	 * javascript_scrollIntoView(menu_PI); action_movetoElementandClick(menu_PI);
	 * waitforVisibilityofElementLocated(menu_PIBatches, 25); }
	 */

	private void NavigatetoPIandWaittillResultData() throws Exception {

		batchentrypage.NavigatetoHomePage();
		javascript_scrollIntoView(widget_PIBatches);
		waitforVisibilityofElementLocated(widget_PIBatches, 15);
		waitforElementtobeClickable(widget_PIBatches, 15);
		clickonButton(widget_PIBatches);
		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		/*
		 * waitforElementtobeClickable(menu_PI, 35); NavigatetoPI();
		 * clickonButton(menu_PIBatches);
		 * waitforInVisibilityofElementLocated(menu_PIBatches, 15);
		 */
		waitforElementtobeClickable(txt_joborBatchCode, 15);
		enteringValues(txt_joborBatchCode, batchCode);
		waitforElementtobeClickable(btn_piBatches_search, 15);
		clickonButton(btn_piBatches_search);
		waitforVisibilityofElementLocated(lnk_ResultData, 15);
	}

	private void NavigatetoPIErrors() throws Exception {

		batchentrypage.NavigatetoHomePage();
		javascript_scrollIntoView(widget_ViewPIErrors);
		waitforVisibilityofElementLocated(widget_ViewPIErrors, 15);
		waitforElementtobeClickable(widget_ViewPIErrors, 15);
		clickonButton(widget_ViewPIErrors);
		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		waitforVisibilityofElementLocated(txt_ErrorCorrection_jobCode, 15);
	}

	public void SwitchingtoDefaultandtoFrame(String parentwindow) throws Exception {

		navigatetoParentWindow(parentwindow);
		switchtoDefaultFrame();
		waitforVisibilityofElementLocated(frame_HomePage, 15);
		switchtoFrame(frame_HomePage);
	}

	public void ClosingDocumentWindow(String parentwindow) throws Exception {

		waitforNumberOfWindowstobePresent(2, 25);
		navigatetoChildWindow(parentwindow);
		closeCurrentBrowser();
	}

	public void ClosingDocumentWindowandSwitchingtoDefaultandtoFrame(String parentwindow) throws Exception {

		ClosingDocumentWindow(parentwindow);
		SwitchingtoDefaultandtoFrame(parentwindow);
	}

	/*
	 * private void checking() throws Exception {
	 * 
	 * System.out.println("-----"); System.out.println("--**-");
	 * if(isAlertPresent()) { switchtoAlert(15).accept(); }
	 * System.out.println("-----"); System.out.println("--**-");
	 * 
	 * }
	 */

}
