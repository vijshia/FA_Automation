/**
 * 
 */
package com.FA.app.pages.fa;

import org.openqa.selenium.By;

import com.FA.app.pages.basePage;
import com.FA.framework.Log;

import static com.FA.framework.WebContext.batchCode;
import static com.FA.framework.WebContext.episodeID;
import static com.FA.app.pages.fa.batchestobeScannedPage.frame_BatchLookup;
import static com.FA.app.pages.fa.batchestobeScannedPage.frame_HomePage;
import static com.FA.app.pages.fa.batchEntryPage.txt_jobCode;
import static com.FA.app.pages.fa.batchEntryPage.msg_Recordsadded;
import static com.FA.app.tests.test.ChargeBatchTest.PI_PatientSearchorAdd;

/**
 * @author ajp16088
 *
 */
public class piBatchPage extends basePage {

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
	By msg_confirmation = By.xpath("//*[contains(text(),' batch(es)')]");
//	By msg_ReleaseBatch = By.xpath("//*[@class='successerror_style']/preceding-sibling::div");
	// PI - Registration search Patent pop-up
	By header_registrationSearchPatent = By.id("hv");// By.xpath("//a[text()='ospital Validation']");
	By lookup_registrationSearchPatent_jobCode = By.xpath("//a[contains(@href,'searchJobCode(')]");
	By elementtoInvisible = By.id("fancy_overlay");
	By txt_lastName = By.name("plname");
	By txt_firstName = By.name("pfname");
	By lnk_registrationsearchpatent_ResultData = By.xpath("//a[contains(@href,'openRecord(')]");
	// PI - Edit Person Page
	By btn_saveandExit = By.xpath("//*[@value='Save & Exit(F9)']");

	public void NavigatetoPIBatches() throws Exception {

		NavigatetoPIandWaittillResultData();
		String parentWindow = getParentWindow();
		clickonButton(lnk_ResultData);
		ClosingDocumentWindow(parentWindow);
		SwitchingtoDefaultandtoFrame(parentWindow);
		waitforVisibilityofElementLocated(btn_personalInfo_search, 15);
		clickonButton(btn_personalInfo_search);
		waitforVisibilityofElementLocated(frame_BatchLookup, 15);
		switchtoFrame(frame_BatchLookup);
		waitforVisibilityofElementLocated(header_registrationSearchPatent, 15);
		if (PI_PatientSearchorAdd.equalsIgnoreCase("ADD")) {

		} else {
			waitforVisibilityofElementLocated(txt_jobCode, 15);
			enteringValues(txt_jobCode, "PLAA");
			waitforVisibilityofALLElementsLocated(gettingWebElement(lookup_registrationSearchPatent_jobCode), 15);
			action_clickElement(lookup_registrationSearchPatent_jobCode);
			waitforVisibilityofElementLocated(txt_lastName, 15);
			enteringValues(txt_lastName, "KARTHICK");
			enteringValues(txt_firstName, "R");
			waitforInVisibilityofElementLocated(elementtoInvisible, 15);
			waitforElementtobeClickable(btn_personalInfo_search, 15);
			clickonButton(btn_personalInfo_search);
			waitforVisibilityofElementLocated(lnk_registrationsearchpatent_ResultData, 15);
			clickonButton(lnk_registrationsearchpatent_ResultData);
			waitforVisibilityofElementLocated(btn_saveandExit, 15);
			clickonButton(btn_saveandExit);
			ClosingDocumentWindow(parentWindow);
			SwitchingtoDefaultandtoFrame(parentWindow);
//			SwitchingtoDefaultandtoFrame();
			Log.info(" btn_personalInfo_search is displaying ");
		}
		waitforVisibilityofElementLocated(btn_saveEpisode, 15);
		clickonButton(btn_saveEpisode);
		ClosingDocumentWindow(parentWindow);
		SwitchingtoDefaultandtoFrame(parentWindow);
		waitforVisibilityofElementLocated(btn_releaseBatch, 15);
		episodeID = gettingWebElement(value_episodeId).getText();
		Log.info("*** EpisodeID: " + episodeID);
		clickonButton(btn_releaseBatch);
		Log.info(" Batch released from PI ");
		waitforVisibilityofElementLocated(By.xpath("//*[contains(text(),' batch(es)')]"), 15);
//	System.out.println("------"+gettingWebElement(By.xpath("//*[contains(text(),' batch(es)')]")).getText());
		if (!gettingWebElement(By.xpath("//*[contains(text(),' batch(es)')]")).getText().contains("released successfully")) {
			NavigatetoPI();
			clickonButton(menu_PIErrorCorrection);
			waitforVisibilityofElementLocated(txt_ErrorCorrection_jobCode, 15);
			enteringValues(txt_ErrorCorrection_jobCode, "AAOFA");
			waitforVisibilityofALLElementsLocated(gettingWebElement(lookup_ErrorCorrection_jobCode), 15);
			action_clickElement(lookup_ErrorCorrection_jobCode);
			enteringValues(txt_ErrorCorrection_batchCode, batchCode); 
			waitforInVisibilityofElementLocated(elementtoInvisible, 15);
			clickonButton(btn_ErrorCorrection_Search);
			waitforVisibilityofElementLocated(chkbox_ErrorCorrection_AcceptAll, 15);
			By chkbox_ErrorCorrection_Accept = By.xpath("//*[@id='acceptChkbox_" + batchCode + "']");
			if (gettingWebElement(chkbox_ErrorCorrection_Accept).isDisplayed()) {
				waitforElementtobeClickable(chkbox_ErrorCorrection_Accept, 15);
				clickonButton(chkbox_ErrorCorrection_Accept);
				waitforElementtobeClickable(btn_ErrorCorrection_acceptErrors, 15);
				clickonButton(btn_ErrorCorrection_acceptErrors);
				waitforInVisibilityofElementLocated(msg_ErrorCorrection_noDatafound, 15);
			}
			NavigatetoPIandWaittillResultData();
			waitforElementtobeClickable(chkbox_relBatch, 15);
			clickonButton(chkbox_relBatch);
			waitforElementtobeClickable(btn_releaseBatch, 15);
			clickonButton(btn_releaseBatch);
			Log.info(" Batch released from PI ");
			waitforVisibilityofElementLocated(msg_confirmation, 15);		//By.xpath("//*[contains(text(),' batch(es)')]")
			Log.info(" ********* Confirmation msg: " + gettingWebElement(msg_Recordsadded).getText());
		}
	}

	private void NavigatetoPI() throws Exception {

		javascript_scrollIntoView(menu_PI);
		action_movetoElementandClick(menu_PI);
		waitforVisibilityofElementLocated(menu_PIBatches, 15);
	}
	
	private void NavigatetoPIandWaittillResultData() throws Exception {
		
		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		waitforElementtobeClickable(menu_PI, 15);
		NavigatetoPI();
		clickonButton(menu_PIBatches);
		waitforInVisibilityofElementLocated(menu_PIBatches, 15);
		waitforElementtobeClickable(txt_joborBatchCode, 15);
		enteringValues(txt_joborBatchCode, batchCode);
		waitforElementtobeClickable(btn_piBatches_search, 15);
		clickonButton(btn_piBatches_search);
		waitforVisibilityofElementLocated(lnk_ResultData, 15);		
	}
	
	private void SwitchingtoDefaultandtoFrame(String parentwindow) throws Exception {
		
		navigatetoParentWindow(parentwindow);
		switchtoDefaultFrame();
		switchtoFrame(frame_HomePage);
	}
	
	private void ClosingDocumentWindow(String parentwindow) throws Exception {
		
		waitforNumberOfWindowstobePresent(2, 15);
		navigatetoChildWindow(parentwindow);
		closeCurrentBrowser();		
	}
}
