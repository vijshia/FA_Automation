/**
 * 
 */
package com.FA.app.pages.fa;

import com.FA.app.pages.basePage;
import com.FA.framework.Log;

import static com.FA.app.pages.fa.piBatchPage.elementtoInvisible;
import static com.FA.app.pages.fa.piBatchPage.txt_joborBatchCode;
import static com.FA.framework.WebContext.batchCode;
import static com.FA.framework.WebContext.codingErrorMessage;
import static com.FA.app.pages.fa.batchestobeScannedPage.btn_piBatches_search;
import static com.FA.app.pages.fa.piBatchPage.lnk_ResultData;
import static com.FA.app.tests.baseTest.hm_testdata;
/*import static com.FA.framework.WebContext.facilityId;
import static com.FA.app.pages.fa.batchEntryPage.frame_BatchLookup;*/
import static com.FA.app.pages.fa.batchEntryPage.frame_HomePage;
import static com.FA.app.pages.fa.piBatchPage.msg_confirmation;
import static com.FA.app.pages.fa.piBatchPage.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * @author ajp16088
 *
 */
public class codingBatchesPage extends basePage {

	private By menu_Coding = By.xpath("//a[text()='Coding']");
	private By menu_CodingBatches = By.xpath("//a[text()='Coding Batches']");
	private By widget_CodingBatches = By.xpath("//li[contains(@onclick,'codingBatchSelectNew')]");
	private By widget_ViewCodingErrors = By.xpath("//img[contains(@src,'cd_errors')]");
	private By menu_CodingErrorCorrection = By.xpath("//a[text()='Coding Error Correction']");
	public static By btn_ErrorCorrection_Search = By.xpath("//*[contains(@onclick,'searchErrors(')]");
	public static By header_CodingActionPanel = By.xpath("//*[text()='Action Panel']");
	private By pageIndex = By.id("index");
	private By elementtoInvisibleinCoding = By.xpath("//a[contains(@href,'Coding Batches B4PI')]");
	private By txt_begDOS = By.name("episode.codingInfo.codingProcedure.serviceDetails.beginDOS");
	private By txt_endDOS = By.name("episode.codingInfo.codingProcedure.serviceDetails.endDOS");
	private By dd_facility = By.name("episode.codingInfo.facilityId");
	private By dd_areaFac = By.name("episode.codingInfo.codingProcedure.serviceDetails.areaFacilityId");
	private By dd_pos = By.name("episode.codingInfo.codingProcedure.serviceDetails.placeOfServiceCode");
	private By txt_icd10 = By.xpath("//*[text()='ICD 10-Diag 1']/parent::td/following-sibling::td/input");
	private By lookup_icd10 = By.xpath("//*[text()='ICD 10-Diag 1']/parent::td/following-sibling::td/a");
	private By txt_icd9 = By.xpath("//*[contains(text(),'ICD 9-Diag 1')]/parent::tr/child::td/input");
	private By lookup_icd9 = By.xpath("//*[contains(text(),'ICD 9-Diag 1')]/parent::tr/child::td/a");
	private By txt_intproc = By.xpath("//*[contains(text(),'NTPROC')]/parent::tr/child::td/input");
	private By lookup_intproc = By.xpath("//*[contains(text(),'NTPROC')]/parent::tr/child::td/a/img/parent::a");
//	private By hiddenvalue_intproc = By.xpath("//*[contains(@name,'procedureCodeTemp')]");
//	private By lnk_intproc_ResultData = By.id("userlink0");
	public static By elementtoInvisibleframeinCoding = By.id("fancy_outer");
	public static By btn_save = By.name("save");
	private By msg_saveConfirmation = By.xpath("//*[@id='saveEpisode']/following-sibling::tr/td");
	private By btn_nextProcedure = By.id("nextProc");
	private By btn_release = By.id("releasebuttonId");
	public static String CodingDOS;
	piBatchPage pibatchpage = new piBatchPage();
	boolean nextProcedure = false;
	boolean nextEpisode = false;
	boolean nextProcedureEpisode = false;
	
	batchEntryPage batchentrypage = new batchEntryPage();

	public void NavigatetoCodingBatches() throws Exception {

		Log.info(" *************** Coding Batch Execution Started *************** ");
		String parentWindow = getParentWindow();
		NavigatetoCodingandWaittillResultData();
		clickonButton(lnk_ResultData);
		int iteration = IterationCount();
		for (int i = 0; i < iteration; i++) { // Integer.valueOf(hm_testdata.get("BE_DocumentCount"))
			WaitTillthePageLoads();
			isDocumentWindowDisplaying(parentWindow);
			waitforVisibilityofElementLocated(pageIndex, 25);
			isDocumentWindowDisplaying(parentWindow);
			waitforVisibilityofElementLocated(header_CodingActionPanel, 30);
			isDocumentWindowDisplaying(parentWindow);
			waitforVisibilityofElementLocated(txt_begDOS, 25);
			clickonButton(txt_begDOS);
			isDocumentWindowDisplaying(parentWindow);
			if (i > 0) {
				waitforTexttobePresentinElementLocated(dd_facility, 20, "-Select-");
				selectByVisibleText(dd_facility, "-Select-");
			}
			isDocumentWindowDisplaying(parentWindow);
			clearValues(txt_begDOS);
			isDocumentWindowDisplaying(parentWindow);
			CodingDOS = generatingDOSforCodingPage(hm_testdata.get("BE_StartDOS"), 1);
			enteringValues(txt_begDOS, CodingDOS.replace("/", "")); // hm_testdata.get("BE_StartDOS")
			enteringKeyStrokes(txt_begDOS, Keys.TAB);
			isDocumentWindowDisplaying(parentWindow);
			clickonButton(txt_endDOS);
			enteringKeyStrokes(txt_begDOS, Keys.TAB);
			isDocumentWindowDisplaying(parentWindow);
			clickonButton(txt_begDOS);
			isDocumentWindowDisplaying(parentWindow);
			waitforVisibilityofALLElementsLocated(gettingWebElement(dd_facility), 20);
			waitforTexttobePresentinElementLocated(dd_facility, 30, hm_testdata.get("Coding_Facility"));
			selectByVisibleText(dd_facility, hm_testdata.get("Coding_Facility"));
			isDocumentWindowDisplaying(parentWindow);
			waitforTexttobePresentinElementLocated(dd_areaFac, 30, hm_testdata.get("Coding_AreaFac"));
			selectByVisibleText(dd_areaFac, hm_testdata.get("Coding_AreaFac"));
			isDocumentWindowDisplaying(parentWindow);
			waitforTexttobePresentinElementLocated(dd_pos, 20, hm_testdata.get("Coding_POS"));
			selectByVisibleText(dd_pos, hm_testdata.get("Coding_POS"));
			isDocumentWindowDisplaying(parentWindow);
			clearValues(txt_icd10);
			enteringValues(txt_icd10, hm_testdata.get("Coding_ICD10"));
			enteringKeyStrokes(lookup_icd10, Keys.TAB);
			if (gettingWebElement(txt_icd9).isDisplayed()) {
				clearValues(txt_icd9);
				enteringValues(txt_icd9, hm_testdata.get("Coding_ICD9"));
				enteringKeyStrokes(lookup_icd9, Keys.TAB);
			}
			isDocumentWindowDisplaying(parentWindow);
			waitforVisibilityofElementLocated(txt_intproc, 30);
			clearValues(txt_intproc);
			waitforVisibilityofElementLocated(txt_intproc, 15);
			enteringValues(txt_intproc, hm_testdata.get("Coding_INTPROC"));
			waitforElementtobeClickable(lookup_intproc, 20);
			clickonButton(lookup_intproc);
			isDocumentWindowDisplaying(parentWindow);
			/*
			 * waitforVisibilityofElementLocated(frame_BatchLookup, 15);
			 * switchtoFrame(frame_BatchLookup);
			 * waitforVisibilityofElementLocated(lnk_intproc_ResultData, 20);
			 * clickonButton(lnk_intproc_ResultData);
			 */
			switchtoDefaultFrame();
			switchtoFrame(frame_HomePage);
			waitforInVisibilityofElementLocated(elementtoInvisibleframeinCoding, 25);
			waitforVisibilityofALLElementsLocated(gettingWebElement(btn_save), 25);
			waitforElementtobeClickable(btn_save, 25);
			javascript_click(btn_save); // javascript_click
//		SwitchtoActiveElement();
			if (isAlertPresent()) {
				if (switchtoAlert(15).getText().contains("Please Wait")) {
					Log.info("*** Alert Displaying: " + switchtoAlert(15).getText() + " ***");
					switchtoAlert(15).accept();
					waitforElementtobeClickable(btn_save, 25);
					javascript_click(btn_save);
				}
			}
			isDocumentWindowDisplaying(parentWindow);
			waitforVisibilityofElementLocated(msg_saveConfirmation, 20);
			if (!gettingWebElement(msg_saveConfirmation).getText().contains("Record Saved Successfully")) {
				clickonButton(btn_save);
			}
			int episodecount = i + 1;
			Log.info("*** CodingBatches Episode " + episodecount + " Save message: "
					+ gettingWebElement(msg_saveConfirmation).getText());

			/* if (hm_testdata.get("BE_DocumentCount").contentEquals("2") && i + 1 <
			 * Integer.valueOf(hm_testdata.get("BE_DocumentCount"))) {
			 * waitforVisibilityofElementLocated(btn_nextEpisode, 15); // btn_nextEpisode
			 * clickonButton(btn_nextEpisode); }
			 */
			ClickonNextProcedureorEpisode(i, btn_nextProcedure, btn_nextEpisode);
		}
		waitforVisibilityofElementLocated(btn_release, 15);
		clickonButton(btn_release);
		waitforVisibilityofElementLocated(msg_confirmation, 20);
		Log.info("*** CodingBatches: " + gettingWebElement(msg_confirmation).getText());
		if (!gettingWebElement(msg_confirmation).getText().contains("released successfully")) {
			NavigatetoCodingErrors();
			enteringValues(txt_ErrorCorrection_jobCode, hm_testdata.get("BE_JobCode"));
			waitforVisibilityofALLElementsLocated(gettingWebElement(lookup_ErrorCorrection_jobCode), 15);
			action_clickElement(lookup_ErrorCorrection_jobCode);
			enteringValues(txt_ErrorCorrection_batchCode, batchCode);
			waitforInVisibilityofElementLocated(elementtoInvisible, 15);
			clickonButton(btn_ErrorCorrection_Search);
			waitforVisibilityofElementLocated(chkbox_ErrorCorrection_AcceptAll, 15);
			codingErrorMessage = errorMessage();
			By chkbox_ErrorCorrection_Accept = By.xpath("//*[@id='acceptChkbox_" + batchCode + "']");
			waitforVisibilityofElementLocated(chkbox_ErrorCorrection_Accept, 20);
			if (gettingWebElement(chkbox_ErrorCorrection_Accept).isDisplayed()) {
				waitforElementtobeClickable(chkbox_ErrorCorrection_AcceptAll, 15);
				clickonButton(chkbox_ErrorCorrection_AcceptAll);
				waitforElementtobeClickable(btn_ErrorCorrection_acceptErrors, 15);
				clickonButton(btn_ErrorCorrection_acceptErrors);
				waitforInVisibilityofElementLocated(msg_ErrorCorrection_noDatafound, 15);
			}
			NavigatetoCodingandWaittillResultData();
			waitforElementtobeClickable(chkbox_relBatch, 15);
			clickonButton(chkbox_relBatch);
			waitforElementtobeClickable(btn_releaseBatch, 15);
			clickonButton(btn_releaseBatch);
			waitforVisibilityofElementLocated(msg_confirmation, 25);
			Log.info("********* Coding Batches Release message: " + gettingWebElement(msg_confirmation).getText());
		}
		Log.info(" *************** Coding Batch Execution Completed *************** ");
		Log.info("");
	}

	public void NavigatetoCodingBatcheswithMultipleProcedures() throws Exception {

		Log.info(" *************** Coding Batch Execution Started *************** ");
		String parentWindow = getParentWindow();
		NavigatetoCodingandWaittillResultData();
		clickonButton(lnk_ResultData);
		int iteration = IterationCount();
		for (int i = 0; i < iteration; i++) {
			WaitTillthePageLoads();
			isDocumentWindowDisplaying(parentWindow);
			waitforVisibilityofElementLocated(pageIndex, 25);
			isDocumentWindowDisplaying(parentWindow);
			waitforVisibilityofElementLocated(header_CodingActionPanel, 30);
			isDocumentWindowDisplaying(parentWindow);
			waitforVisibilityofElementLocated(txt_begDOS, 25);
			clickonButton(txt_begDOS);
			isDocumentWindowDisplaying(parentWindow);
			if (i > 0) {
				waitforTexttobePresentinElementLocated(dd_facility, 20, "-Select-");
				selectByVisibleText(dd_facility, "-Select-");
			}
			isDocumentWindowDisplaying(parentWindow);
			clearValues(txt_begDOS);
			isDocumentWindowDisplaying(parentWindow);
			CodingDOS = generatingDOSforCodingPage(hm_testdata.get("BE_StartDOS"), 1);
			enteringValues(txt_begDOS, CodingDOS.replace("/", "")); // hm_testdata.get("BE_StartDOS")
			enteringKeyStrokes(txt_begDOS, Keys.TAB);
			isDocumentWindowDisplaying(parentWindow);
			clickonButton(txt_endDOS);
			enteringKeyStrokes(txt_begDOS, Keys.TAB);
			isDocumentWindowDisplaying(parentWindow);
			clickonButton(txt_begDOS);
			isDocumentWindowDisplaying(parentWindow);
			waitforVisibilityofALLElementsLocated(gettingWebElement(dd_facility), 20);
			waitforTexttobePresentinElementLocated(dd_facility, 30, hm_testdata.get("Coding_Facility"));
			selectByVisibleText(dd_facility, hm_testdata.get("Coding_Facility"));
			isDocumentWindowDisplaying(parentWindow);
			waitforTexttobePresentinElementLocated(dd_areaFac, 30, hm_testdata.get("Coding_AreaFac"));
			selectByVisibleText(dd_areaFac, hm_testdata.get("Coding_AreaFac"));
			isDocumentWindowDisplaying(parentWindow);
			waitforTexttobePresentinElementLocated(dd_pos, 20, hm_testdata.get("Coding_POS"));
			selectByVisibleText(dd_pos, hm_testdata.get("Coding_POS"));
			isDocumentWindowDisplaying(parentWindow);
			clearValues(txt_icd10);
			enteringValues(txt_icd10, hm_testdata.get("Coding_ICD10"));
			enteringKeyStrokes(lookup_icd10, Keys.TAB);
			if (gettingWebElement(txt_icd9).isDisplayed()) {
				clearValues(txt_icd9);
				enteringValues(txt_icd9, hm_testdata.get("Coding_ICD9"));
				enteringKeyStrokes(lookup_icd9, Keys.TAB);
			}
			isDocumentWindowDisplaying(parentWindow);
			waitforVisibilityofElementLocated(txt_intproc, 30);
			clearValues(txt_intproc);
			waitforVisibilityofElementLocated(txt_intproc, 15);
			enteringValues(txt_intproc, hm_testdata.get("Coding_INTPROC"));
			waitforElementtobeClickable(lookup_intproc, 20);
			clickonButton(lookup_intproc);
			isDocumentWindowDisplaying(parentWindow);
			switchtoDefaultFrame();
			switchtoFrame(frame_HomePage);
			waitforInVisibilityofElementLocated(elementtoInvisibleframeinCoding, 25);
			waitforVisibilityofALLElementsLocated(gettingWebElement(btn_save), 25);
			waitforElementtobeClickable(btn_save, 25);
			javascript_click(btn_save);
			if (isAlertPresent()) {
				if (switchtoAlert(15).getText().contains("Please Wait")) {
					Log.info("*** Alert Displaying: " + switchtoAlert(15).getText() + " ***");
					switchtoAlert(15).accept();
					waitforElementtobeClickable(btn_save, 25);
					javascript_click(btn_save);
				}
			}
			isDocumentWindowDisplaying(parentWindow);
			waitforVisibilityofElementLocated(msg_saveConfirmation, 20);
			if (!gettingWebElement(msg_saveConfirmation).getText().contains("Record Saved Successfully")) {
				clickonButton(btn_save);
			}
			int episodecount = i + 1;
			Log.info("*** CodingBatches Episode " + episodecount + " Save message: "
					+ gettingWebElement(msg_saveConfirmation).getText());

			if (hm_testdata.get("BE_DocumentCount").contentEquals("2")
					&& i + 1 < Integer.valueOf(hm_testdata.get("BE_DocumentCount"))) {
				waitforVisibilityofElementLocated(btn_nextProcedure, 15);
				clickonButton(btn_nextProcedure);
			}
		}
		waitforVisibilityofElementLocated(btn_release, 15);
		clickonButton(btn_release);
		waitforVisibilityofElementLocated(msg_confirmation, 20);
		Log.info("*** CodingBatches: " + gettingWebElement(msg_confirmation).getText());
		if (!gettingWebElement(msg_confirmation).getText().contains("released successfully")) {
			NavigatetoCoding();
			clickonButton(menu_CodingErrorCorrection);
			waitforVisibilityofElementLocated(txt_ErrorCorrection_jobCode, 15);
			enteringValues(txt_ErrorCorrection_jobCode, hm_testdata.get("BE_JobCode"));
			waitforVisibilityofALLElementsLocated(gettingWebElement(lookup_ErrorCorrection_jobCode), 15);
			action_clickElement(lookup_ErrorCorrection_jobCode);
			enteringValues(txt_ErrorCorrection_batchCode, batchCode);
			waitforInVisibilityofElementLocated(elementtoInvisible, 15);
			clickonButton(btn_ErrorCorrection_Search);
			waitforVisibilityofElementLocated(chkbox_ErrorCorrection_AcceptAll, 15);
			codingErrorMessage = errorMessage();
			By chkbox_ErrorCorrection_Accept = By.xpath("//*[@id='acceptChkbox_" + batchCode + "']");
			waitforVisibilityofElementLocated(chkbox_ErrorCorrection_Accept, 20);
			if (gettingWebElement(chkbox_ErrorCorrection_Accept).isDisplayed()) {
				waitforElementtobeClickable(chkbox_ErrorCorrection_AcceptAll, 15);
				clickonButton(chkbox_ErrorCorrection_AcceptAll);
				waitforElementtobeClickable(btn_ErrorCorrection_acceptErrors, 15);
				clickonButton(btn_ErrorCorrection_acceptErrors);
				waitforInVisibilityofElementLocated(msg_ErrorCorrection_noDatafound, 15);
			}
			NavigatetoCodingandWaittillResultData();
			waitforElementtobeClickable(chkbox_relBatch, 15);
			clickonButton(chkbox_relBatch);
			waitforElementtobeClickable(btn_releaseBatch, 15);
			clickonButton(btn_releaseBatch);
			waitforVisibilityofElementLocated(msg_confirmation, 25);
			Log.info("********* Coding Batches Release message: " + gettingWebElement(msg_confirmation).getText());
		}
		Log.info(" *************** Coding Batch Execution Completed *************** ");
		Log.info("");
	}
	
	/*
	 * private void SwitchtoActiveElement() throws Exception {
	 * 
	 * WebElement activeelement = driver.switchTo().activeElement();
	 * Log.info("getText:"+activeelement.getText()+" / getTagName:"+activeelement.
	 * getTagName()); }
	 */

	public void isDocumentWindowDisplaying(String parentwindow) throws Exception {

		if (gettingSetofWindows().size() > 1) {
			pibatchpage.ClosingDocumentWindowandSwitchingtoDefaultandtoFrame(parentwindow);
		}
	}

	public int IterationCount() throws Exception {

		int iteration = 0;
		if (Integer.valueOf(hm_testdata.get("BE_DocumentCount")) > 1
				&& hm_testdata.get("Coding_MultipleProcedures").equalsIgnoreCase("no")) {
			iteration = Integer.valueOf(hm_testdata.get("BE_DocumentCount"));
			nextEpisode = true;
//			System.out.println("DC>1|| MuNo iteration="+iteration);
		} else if (Integer.valueOf(hm_testdata.get("BE_DocumentCount")) > 1
				&& hm_testdata.get("Coding_MultipleProcedures").equalsIgnoreCase("yes")) {
			iteration = Integer.valueOf(hm_testdata.get("BE_DocumentCount")) + 1;
			nextProcedureEpisode = true;
//			System.out.println("DC>1|| MuNo iteration="+iteration);
		} else if (Integer.valueOf(hm_testdata.get("BE_DocumentCount")) == 1
				&& hm_testdata.get("Coding_MultipleProcedures").equalsIgnoreCase("yes")) {
			iteration = 2;
			nextProcedure = true;
//			System.out.println("DC1 & MuYes iteration="+iteration);
		} else if (Integer.valueOf(hm_testdata.get("BE_DocumentCount")) == 1
				&& hm_testdata.get("Coding_MultipleProcedures").equalsIgnoreCase("no")) {
			iteration = Integer.valueOf(hm_testdata.get("BE_DocumentCount"));
		}
		return iteration;
	}

	public void ClickonNextProcedureorEpisode(int iteration, By procedure, By episode) throws Exception {

		if (nextProcedure && iteration + 1 < IterationCount()) {
			nextProcedure = false;
			waitforVisibilityofElementLocated(procedure, 15);
			clickonButton(procedure);
		} else if (nextEpisode && iteration + 1 < IterationCount()) {
			nextEpisode = false;
			waitforVisibilityofElementLocated(episode, 15);
			clickonButton(episode);
		} else if (nextProcedureEpisode && iteration + 1 < IterationCount()) {
			if (iteration == 0) {
				nextProcedure = false;
				waitforVisibilityofElementLocated(procedure, 15);
				clickonButton(procedure);
			} else {
				nextEpisode = false;
				waitforVisibilityofElementLocated(episode, 15);
				clickonButton(episode);
			}
		}
	}

	private void NavigatetoCoding() throws Exception {

		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		javascript_scrollIntoView(menu_Coding);
		action_movetoElementandClick(menu_Coding);
		waitforVisibilityofElementLocated(menu_CodingBatches, 25);
	}

	private void NavigatetoCodingandWaittillResultData() throws Exception {

		/* NavigatetoCoding(); action_movetoElementandClick(menu_CodingBatches);
		 * waitforInVisibilityofElementLocated(elementtoInvisible, 20);
		 * waitforInVisibilityofElementLocated(menu_CodingBatches, 20);  */
		batchentrypage.NavigatetoHomePage();
		javascript_scrollIntoView(widget_CodingBatches);
		waitforVisibilityofElementLocated(widget_CodingBatches, 15);
		waitforElementtobeClickable(widget_CodingBatches, 15);
		clickonButton(widget_CodingBatches);
		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		waitforVisibilityofElementLocated(txt_joborBatchCode, 25);
		enteringValues(txt_joborBatchCode, batchCode);
		waitforElementtobeClickable(btn_piBatches_search, 15);
		waitforInVisibilityofElementLocated(elementtoInvisibleinCoding, 25);
		clickonButton(btn_piBatches_search);
		waitforVisibilityofElementLocated(lnk_ResultData, 15);
	}
	
	private void NavigatetoCodingErrors() throws Exception {

		batchentrypage.NavigatetoHomePage();
		javascript_scrollIntoView(widget_ViewCodingErrors);
		waitforVisibilityofElementLocated(widget_ViewCodingErrors, 15);
		waitforElementtobeClickable(widget_ViewCodingErrors, 15);
		clickonButton(widget_ViewCodingErrors);
		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		waitforVisibilityofElementLocated(txt_ErrorCorrection_jobCode, 15);
	}

	/*
	 * private void checking() throws Exception {
	 * 
	 * // Log.info("*** "+gettingWebElement(By.xpath(
	 * "//*[@id='saveEpisode']/following-sibling::tr/td1")).getText());
	 * gettingWebElement(By.xpath("//*[@id='saveEpisode']/following-sibling::tr/td1"
	 * )).getText(); System.out.println("-----"); System.out.println("--**-"); }
	 */

}
