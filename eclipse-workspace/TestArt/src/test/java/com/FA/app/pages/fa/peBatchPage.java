/**
 * 
 */
package com.FA.app.pages.fa;

import static com.FA.app.pages.fa.batchestobeScannedPage.btn_piBatches_search;

import static com.FA.app.pages.fa.piBatchPage.elementtoInvisible;
import static com.FA.app.pages.fa.piBatchPage.lnk_ResultData;
import static com.FA.app.pages.fa.piBatchPage.lookup_ErrorCorrection_jobCode;
import static com.FA.app.pages.fa.piBatchPage.msg_ErrorCorrection_noDatafound;
import static com.FA.app.pages.fa.piBatchPage.msg_confirmation;
import static com.FA.app.pages.fa.piBatchPage.txt_ErrorCorrection_batchCode;
import static com.FA.app.pages.fa.piBatchPage.txt_ErrorCorrection_jobCode;
import static com.FA.app.pages.fa.piBatchPage.txt_joborBatchCode;
import static com.FA.framework.WebContext.batchCode;
import static com.FA.framework.WebContext.peErrorMessage;
import static com.FA.app.pages.fa.codingBatchesPage.CodingDOS;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.FA.framework.WebContext.invoice;
import static com.FA.framework.WebContext.episodeID;
import static com.FA.app.pages.fa.codingBatchesPage.header_CodingActionPanel;
import static com.FA.app.pages.fa.codingBatchesPage.btn_save;
import static com.FA.app.pages.fa.codingBatchesPage.btn_ErrorCorrection_Search;
import static com.FA.app.pages.fa.codingBatchesPage.elementtoInvisibleframeinCoding;
import static com.FA.app.pages.fa.batchEntryPage.frame_HomePage;
import static com.FA.app.pages.fa.batchestobeScannedPage.frame_BatchLookup;
import static com.FA.app.pages.fa.piBatchPage.btn_ErrorCorrection_acceptErrors;
import static com.FA.app.pages.fa.piBatchPage.chkbox_ErrorCorrection_AcceptAll;
import static com.FA.app.pages.fa.piBatchPage.chkbox_relBatch;
import static com.FA.app.tests.baseTest.hm_testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.FA.app.pages.basePage;
import com.FA.framework.Log;
/**
 * @author ajp16088
 *
 */
public class peBatchPage extends basePage {

	private By menu_PE = By.xpath("//a[text()='Proc Entry']");
	private By menu_PEBatches = By.xpath("//a[text()='PE Batches']");
	private By widget_PEBatches = By.xpath("//li[contains(@onclick,'peBatchSelectNew')]");
	private By widget_ViewPEErrors = By.xpath("//img[contains(@src,'pe_errors')]");
	private By menu_episodeSearch = By.xpath("//*[contains(text(),'Episode Search')]");
//	private By menu_episodeSearch = By.xpath("//*[contains(@href,'searchEpisode')]");
//	private By menu_PEErrorCorrection = By.xpath("//a[text()='PE Error Correction']");
	private By dd_AnesType = By.name("lsAnestype");
	private By dd_OPRoom = By.name("operatingRoomCode");
	private By btn_ProviderTime = By.name("addilprov");
	private By txt_ProviderCode = By.name("provider");
	private By lookup_ProviderCode = By.xpath("//*[@name='provider']/following-sibling::a");
	private By tag_forProvidersearchlookup = By.xpath("//*[@id='fancy_content']");
	private By txt_ProviderCode_inProvidersearchlookup = By.name("providerCode");
	private By btn_Search_inProvidersearchlookup = By.name("Search");
	private By value_ProviderCode_inProvidersearchlookup = By.xpath("//*[text()='"+hm_testdata.get("PE_ProviderCode")+"']/parent::*/descendant::a");
	private By txt_StartDate = By.xpath("//*[@name='lsPrcStartDt']/parent::td/following-sibling::td/input");
	private By txt_StartTime = By.name("lsPrcStartTime");
	private By txt_EndTime = By.name("lsPrcStopTime");
	private By txt_ImageInfo = By.name("imageInfo");
//	private By txt_ImageInfo = By.xpath("//*[text()='Image Info']/following-sibling::td/input");
	private By elementtoInvisibleinPE = By.id("fancy_content");
	private By btn_Add = By.id("add");
	private By numberofrecords = By.xpath("//*[text()='Signature Initial']/following-sibling::th/ancestor::div[@id='fixed_header']/child::div[@class='body']/table/*");
	private By numberoferrors = By.xpath("//*[@name='AdditionalProvidersForm']/child::*[@class='successerror_style']/descendant::div");
	private By tableValues = By.xpath("//*[text()='Signature Initial']/following-sibling::th/ancestor::div[@id='fixed_header']/child::div[@class='body']/table/*");
	private By btn_ApplyandExit = By.id("saveAnsExitBtn");
//	private By btn_Exit = By.id("exit");
	private By msg_saveConfirmation = By.xpath("//*[contains(text(),'Record added successfully')]");
	private By btn_QCDRMeasures = By.xpath("//*[@value='QCDR Measures (Alt+W)']");
	private By btn_saveQCDR = By.name("saveButton");
	private By msg_saveQCDRConfirmation = By.xpath("//*[contains(text(),'Epsiode QCDR Measures saved successfully')]");
	private By btn_ExitQCDR = By.name("exitButton");
	private By errorCorrectionPage_CheckBoxes = By.xpath("//*[contains(@id,'accept')]");
//	private By lnk_ErrorCorrectionPage_Episode = By.xpath("//a[contains(@href,'loadEditScreen') and contains(@href,'" + batchCode + "')]");
	private By frame_EpisodePage = By.name("myFrame");
	private By btn_ReleaseBatch = By.id("releasebuttonId");
	private By txt_Episode = By.name("pepisode");
	private By btn_Episodesearch = By.name("Submit");
	private By lnk_Ledger = By.xpath("//a[contains(@href,'summaryLedger')]");
	private By header_SummaryLedger = By.xpath("//*[text()='Summary Ledger']");
	private By header_SummaryLedgerTable = By.xpath("//tr[@class='table_hdr']/parent::tbody/tr");
	private By btn_nextEpisode = By.xpath("//*[@alt='next']");
	private By btn_nextProcedure = By.xpath("//*[text()='(F8) Next >>']");
	private By formtoreload = By.name("ProcEntryForm");
//	private By pageNumber = By.name("selectEpisode");
//	private By lnk_InvoiceNumber = By.name("resultsLink");
	
	batchEntryPage batchentrypage = new batchEntryPage();

	public void NavigatetoPEBatches() throws Exception {

		codingBatchesPage codingbatchespage = new codingBatchesPage();
		billingPage billingpage = new billingPage();
		boolean isBillingPagetoCheck = false;
		Log.info(" *************** PE Batch Execution Started *************** ");
		NavigatetoPEandWaittillResultData();
		String parentWindow = getParentWindow();
		clickonButton(lnk_ResultData);
		if (isAlertPresent()) {
			switchtoAlert(15).sendKeys(generatingCurrentSystemTiming());
			switchtoAlert(15).accept();
		}
		codingbatchespage.isDocumentWindowDisplaying(parentWindow);
		waitforVisibilityofElementLocated(header_CodingActionPanel, 15);
		int iteration = codingbatchespage.IterationCount();
		for (int i = 0; i < iteration; i++) {
			waitforVisibilityofElementLocated(btn_ProviderTime, 25);
			waitforElementtobeClickable(btn_ProviderTime, 25);
			codingbatchespage.isDocumentWindowDisplaying(parentWindow);
			clickonButton(btn_ProviderTime);
			WaitandSwitchtoFancyFrame();
			enteringValues(txt_ProviderCode, hm_testdata.get("PE_ProviderCode"));
			searchProviderCode();			
			if(gettingWebElement(txt_StartDate).getAttribute("name").equalsIgnoreCase("lsPrcStartTime")) {
				enteringProviderTimings();
			}
			waitforVisibilityofElementLocated(txt_ImageInfo, 15);
			enteringValues(txt_ImageInfo, hm_testdata.get("PE_ImageInfo"));
			waitforInVisibilityofElementLocated(elementtoInvisibleinPE, 15);
			waitforVisibilityofElementLocated(btn_Add, 15);
			clickonButton(btn_Add);
//			waitforVisibilityofElementLocated(tableValues, 25);
//			waitforVisibilityofALLElementsLocated(gettingWebElement(tableValues), 25);			
//		System.out.println("******"+gettingListofWebElements(tableValues).size());
			waitforNumberOfElementsmorethanOne(numberoferrors, numberofrecords, 30);
//		System.out.println("******"+gettingListofWebElements(tableValues).size());
			if(gettingListofWebElements(tableValues).size() == 1) {
				enteringValues(txt_ProviderCode, hm_testdata.get("PE_ProviderCode"));
				clickonButton(lookup_ProviderCode);
				enteringProviderTimings();
				waitforVisibilityofElementLocated(txt_ImageInfo, 15);
				enteringValues(txt_ImageInfo, hm_testdata.get("PE_ImageInfo"));
				waitforInVisibilityofElementLocated(elementtoInvisibleinPE, 15);
				waitforVisibilityofElementLocated(btn_Add, 15);
				clickonButton(btn_Add);
			}
			waitforVisibilityofElementLocated(btn_ApplyandExit, 15);
			clickonButton(btn_ApplyandExit);
			SwitchingtoDefaultandtoHomeFrame();
			waitforVisibilityofElementLocated(dd_AnesType, 15);
			selectByVisibleText(dd_AnesType, hm_testdata.get("PE_AnesType"));
			waitforVisibilityofElementLocated(dd_OPRoom, 25);
			selectByVisibleText(dd_OPRoom, hm_testdata.get("PE_OPRoom"));
			waitforInVisibilityofElementLocated(elementtoInvisibleframeinCoding, 15);
			waitforVisibilityofElementLocated(btn_QCDRMeasures, 20);
			clickonButton(btn_QCDRMeasures);
			WaitandSwitchtoFancyFrame();
			waitforVisibilityofElementLocated(btn_saveQCDR, 15);
			clickonButton(btn_saveQCDR);
			waitforVisibilityofElementLocated(msg_saveQCDRConfirmation, 20);
			Log.info("*** PE Batches QCDR save Confirmation message: " + gettingWebElement(msg_saveQCDRConfirmation).getText());
			waitforVisibilityofElementLocated(btn_ExitQCDR, 15);
			clickonButton(btn_ExitQCDR);
			SwitchingtoDefaultandtoHomeFrame();
			waitforVisibilityofElementLocated(btn_save, 15);
			clickonButton(btn_save);
			if (isAlertPresent() || !isPEBatchesSaveMessage().contains("Record added successfully")) {
				Log.info("*** PE Batches Provider Selection Save message: " + switchtoAlert(15).getText());
				if (switchtoAlert(15).getText().contains("operating room")) {
					switchtoAlert(15).accept();
					waitforVisibilityofElementLocated(dd_OPRoom, 15);
					selectByVisibleText(dd_OPRoom, hm_testdata.get("PE_OPRoom"));
					waitforInVisibilityofElementLocated(elementtoInvisibleinPE, 15);
					waitforVisibilityofElementLocated(btn_save, 15);
					clickonButton(btn_save);
				}
			}
			waitforVisibilityofElementLocated(msg_saveConfirmation, 15);
			int episodecount = i+1;
			Log.info("*** PE Batches Episode "+episodecount+" Save message: " + gettingWebElement(msg_saveConfirmation).getText());
			/* if (hm_testdata.get("BE_DocumentCount").contentEquals("2") && i + 1 <
			 * Integer.valueOf(hm_testdata.get("BE_DocumentCount"))) {
			 * waitforVisibilityofElementLocated(btn_nextEpisode, 15);
			 * clickonButton(btn_nextEpisode);
			 * waitforAttributeToBeinElementLocated(pageNumber, 20, "value",
			 * String.valueOf(i+2)); waitforNumberOfWindowstobePresent(2, 25); } */
			codingbatchespage.ClickonNextProcedureorEpisode(i, btn_nextProcedure, btn_nextEpisode);
			WaitTillthePageLoads();
			waitforAttributeToBeinElementLocated(formtoreload, 30, "action", "http://172.22.21.95:8180/FirstClaim/action/procedureEntryAddNew");
		}
		NavigatetoPEandClickonReleaseBatch();
		if (!gettingWebElement(msg_confirmation).getText().contains("released successfully")) {
			NavigatetoPEErrors();
			enteringValues(txt_ErrorCorrection_jobCode, hm_testdata.get("BE_JobCode"));
			waitforVisibilityofALLElementsLocated(gettingWebElement(lookup_ErrorCorrection_jobCode), 15);
			action_clickElement(lookup_ErrorCorrection_jobCode);
			enteringValues(txt_ErrorCorrection_batchCode, batchCode);
			waitforInVisibilityofElementLocated(elementtoInvisible, 15);
			clickonButton(btn_ErrorCorrection_Search);
			waitforVisibilityofElementLocated(chkbox_ErrorCorrection_AcceptAll, 15);
			peErrorMessage = errorMessage();
			By chkbox_ErrorCorrection_Accept = By.xpath("//*[@id='acceptChkbox_" + batchCode + "']");
			waitforVisibilityofElementLocated(errorCorrectionPage_CheckBoxes, 20);
			if (gettingListofWebElements(errorCorrectionPage_CheckBoxes).size() == 1) { // By.xpath("//*[contains(@id,'accept')]")
				navigatingtoErrorEpisode(parentWindow);
			} else {
				waitforVisibilityofElementLocated(chkbox_ErrorCorrection_Accept, 20);
			}
			if (gettingWebElement(chkbox_ErrorCorrection_Accept).isDisplayed()) {
				waitforElementtobeClickable(chkbox_ErrorCorrection_AcceptAll, 15);
				clickonButton(chkbox_ErrorCorrection_AcceptAll);
				waitforElementtobeClickable(btn_ErrorCorrection_acceptErrors, 15);
				clickonButton(btn_ErrorCorrection_acceptErrors);
				waitforInVisibilityofElementLocated(msg_ErrorCorrection_noDatafound, 15);
			}
			NavigatetoPEandClickonReleaseBatch();
		}
		Log.info("********* PE Batches Release message: " + gettingWebElement(msg_confirmation).getText());
		Log.info("");
		if (gettingWebElement(msg_confirmation).getText().contains("released successfully")) {
			NavigatetoEpisodeSearchandWaittillResultData();
			int toIterate = 1;
			for(int i=0; i < toIterate; i++) {
				EnterEpisodeinSearchandWaittillResultData(i);
//				toIterate = splitEpisodeIDs(episodeID).length;
				clickonButton(lnk_ResultData);
				codingbatchespage.isDocumentWindowDisplaying(parentWindow);
				waitforVisibilityofElementLocated(header_CodingActionPanel, 15);
				codingbatchespage.isDocumentWindowDisplaying(parentWindow);
				waitforVisibilityofElementLocated(lnk_Ledger, 15);
				clickonButton(lnk_Ledger);				
				closingDocumentWindowandnavigatingtoLedgerWindow(parentWindow);		
				waitforVisibilityofElementLocated(header_SummaryLedger, 25);					
				if (gettingListofWebElements(header_SummaryLedgerTable).size() > 1) { //gettingListofWebElements(header_SummaryLedgerTable).size() > 1
					invoice = getInvoiceNumberfromSummaryLedgerWindow();
					codingbatchespage.isDocumentWindowDisplaying(parentWindow);				
				} else {
					isBillingPagetoCheck = true;
				}				
				String invoicenumber = invoice == null ? "No InvoiceNumber" : invoice;
				Log.info("*** Invoice Number: " + invoicenumber +" *** ");
				codingbatchespage.isDocumentWindowDisplaying(parentWindow);
			}
		}
		if (isBillingPagetoCheck) {
			billingpage.NavigatetoBillingProcess();
		}
		Log.info(" *************** PE Batch Execution Completed *************** ");
		Log.info("");
	}	

	private void enteringProviderTimings() throws Exception {
		
		waitforVisibilityofElementLocated(txt_StartTime, 15);
		clearValues(txt_StartTime);
		String starttime = generatingProviderTimings("StartTime");
		enteringValues(txt_StartTime, starttime); // hm_testdata.get("PE_StartTime")
		Log.info("*** Starttime: "+starttime+" entered in "+txt_StartTime);
		waitforVisibilityofElementLocated(txt_EndTime, 15);
		clearValues(txt_EndTime);
		String endtime = generatingProviderTimings("endTime");
		enteringValues(txt_EndTime, endtime); // hm_testdata.get("PE_EndTime")
		Log.info("*** Endtime: "+endtime+" entered in "+txt_EndTime);
	}
	
	private void closingDocumentWindowandnavigatingtoLedgerWindow(String parentwindow) throws Exception {

		waitforNumberOfWindowstobePresent(3, 20);
		String windowtonavigate = null;
		for (String window : gettingSetofWindows()) {
			if (!window.equals(parentwindow)) {
				navigatetoParentWindow(window);
				if (!gettingCurrentURL().contains("http://172.22.21.95:8180/FirstClaim")) {
					closeCurrentBrowser();
				} else {
					windowtonavigate = window;
				}
			}
		}
		navigatetoParentWindow(parentwindow);
		navigatetoParentWindow(windowtonavigate);
	}	
		
	private void navigatingtoErrorEpisode(String parentwindow) throws Exception {

		By lnk_ErrorCorrectionPage_Episode = By.xpath("//a[contains(@href,'loadEditScreen') and contains(@href,'" + batchCode + "')]");
		clickonButton(lnk_ErrorCorrectionPage_Episode); // By.xpath("//a[contains(@href,'loadEditScreen') and contains(@href,'"+batchCode+"')]")
		waitforNumberOfWindowstobePresent(3, 20);
		String windowtonavigate = null;
		for (String window : gettingSetofWindows()) {
//			System.out.println(window);
			if (!window.equals(parentwindow)) {
//			System.out.println(window);
				navigatetoParentWindow(window);
				if (!gettingCurrentURL().contains("http://172.22.21.95:8180/FirstClaim")) {
					closeCurrentBrowser();
				} else {
					windowtonavigate = window;
				}
			}
		}
		navigatetoParentWindow(parentwindow);
		navigatetoParentWindow(windowtonavigate);
		switchtoFrame(frame_EpisodePage); // By.name("myFrame")
		javascript_scrollIntoView(dd_OPRoom);
		waitforVisibilityofElementLocated(dd_OPRoom, 15);
		selectByVisibleText(dd_OPRoom, hm_testdata.get("PE_OPRoom"));		
		waitforElementtobeClickable(btn_save, 25);
		javascript_click(btn_save);
		closeCurrentBrowser();
		navigatetoParentWindow(parentwindow);
		SwitchingtoDefaultandtoHomeFrame();
	}

	private String generatingProviderTimings(String whichtime) throws Exception {

		DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("hh:mm");
		LocalTime localTime = LocalTime.now();
		String time = null;
		if (whichtime.contains("Start")) {
			String Starttime = FOMATTER.format(localTime);
//			time = Starttime.replace(":", "");
			time = time == Starttime.replace(":", "") ? time+1 : Starttime.replace(":", "");
		} else {
			String Endtime = FOMATTER.format(localTime.plusMinutes(30));
//			time = Endtime.replace(":", "");
			time = time == Endtime.replace(":", "") ? time+1 : Endtime.replace(":", "");
		}
		return time;
	}

	private String getInvoiceNumberfromSummaryLedgerWindow() throws Exception {

		String invoice = null;
//	  System.out.println(gettingListofWebElements(header_SummaryLedgerTable).size()); 
		List<WebElement> tables = gettingListofWebElements(header_SummaryLedgerTable);
//		Boolean tobreak = false;
		int count = 1;
		for (WebElement table : tables) {
			Boolean tobreak = false;
			List<WebElement> values = table.findElements(By.tagName("td"));
			for (WebElement value : values) {
//		System.out.println("=>"+value.getText()+"<- .="+value.getText().contains(".")+"/="+value.getText().contains("/")+" ="+value.getText().contains(" "));
				if (!value.getText().contains(".") && !value.getText().contains("/") && !value.getText().contains(" ")
						&& !value.getText().contains("OPEN") && !value.getText().contains("INVALID")
						|| value.getText().contains(CodingDOS)) {
					if (value.getText().contains(CodingDOS)) {
						tobreak = true;
						break;
					}
					invoice = invoice == null ? count + ". " + value.getText()
							: invoice + ", " + count + ". " + value.getText();
//				System.out.println("invoice="+invoice);
					count++;
				}
				if (!value.getText().contains(CodingDOS) && value.getText().contains("/") && !value.getText().contains("-") && !value.getText().contains("Add/View")) {
					String[] invoicesplit = invoice.split(count-1+". ");
//				System.out.println("invoicesplit0="+invoicesplit[0]+"invoicesplit1="+invoicesplit[1]);
					invoice = invoicesplit[0];
				}
				if (tobreak) {
					break;
				}
			}
			/*
			 * if (tobreak) { break; }
			 */
		}
		return invoice;
	}

	private void WaitandSwitchtoFancyFrame() throws Exception {

		waitforVisibilityofElementLocated(frame_BatchLookup, 15);
		switchtoFrame(frame_BatchLookup);
	}

	private void SwitchingtoDefaultandtoHomeFrame() throws Exception {

		switchtoDefaultFrame();
		waitforVisibilityofElementLocated(frame_HomePage, 15);
		switchtoFrame(frame_HomePage);
	}

	private String isPEBatchesSaveMessage() throws Exception {

		waitforVisibilityofElementLocated(msg_saveConfirmation, 15);
		return gettingWebElement(msg_saveConfirmation).getText();
	}

	private void NavigatetoPEandClickonReleaseBatch() throws Exception {

		NavigatetoPEandWaittillResultData();
		waitforVisibilityofElementLocated(chkbox_relBatch, 15);
		clickonButton(chkbox_relBatch);
		waitforVisibilityofElementLocated(btn_ReleaseBatch, 15);
		clickonButton(btn_ReleaseBatch);
		waitforVisibilityofElementLocated(msg_confirmation, 20);
	}

	private void NavigatetoPE() throws Exception {

		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		javascript_scrollIntoView(menu_PE);
		waitforVisibilityofElementLocated(menu_PE, 15);
		action_movetoElementandClick(menu_PE);
		waitforVisibilityofElementLocated(menu_PEBatches, 25);
	}

	private void NavigatetoPEandWaittillResultData() throws Exception {

		/* NavigatetoPE(); action_movetoElementandClick(menu_PEBatches);
		 * waitforInVisibilityofElementLocated(elementtoInvisible, 20);
		 * waitforInVisibilityofElementLocated(menu_PEBatches, 20);  */
		batchentrypage.NavigatetoHomePage();
		javascript_scrollIntoView(widget_PEBatches);
		waitforVisibilityofElementLocated(widget_PEBatches, 15);
		waitforElementtobeClickable(widget_PEBatches, 15);
		clickonButton(widget_PEBatches);
		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		waitforVisibilityofElementLocated(txt_joborBatchCode, 25);
		enteringValues(txt_joborBatchCode, batchCode);
		waitforElementtobeClickable(btn_piBatches_search, 15);
		clickonButton(btn_piBatches_search);
		waitforVisibilityofElementLocated(lnk_ResultData, 25);
	}
	
	private void NavigatetoPEErrors() throws Exception {

		batchentrypage.NavigatetoHomePage();
		javascript_scrollIntoView(widget_ViewPEErrors);
		waitforVisibilityofElementLocated(widget_ViewPEErrors, 15);
		waitforElementtobeClickable(widget_ViewPEErrors, 15);
		clickonButton(widget_ViewPEErrors);
		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		waitforVisibilityofElementLocated(txt_ErrorCorrection_jobCode, 15);
	}

	private void NavigatetoEpisodeSearchandWaittillResultData() throws Exception {

		NavigatetoPE();
		javascript_click(menu_episodeSearch); // By.xpath("//*[contains(text(),'Episode Search')]")
		waitforVisibilityofElementLocated(txt_Episode, 25); 
	}
	
	private void EnterEpisodeinSearchandWaittillResultData(int toIterate) throws Exception {
		
		waitforVisibilityofElementLocated(txt_Episode, 25); 
		String episodeid = splitEpisodeIDs(episodeID)[toIterate];
		enteringValues(txt_Episode, episodeid); //episodeID
		Log.info("*** EpisodeID: "+ episodeid+" entered in search field ***" );
		waitforElementtobeClickable(btn_Episodesearch, 15);
		clickonButton(btn_Episodesearch);
		waitforVisibilityofElementLocated(lnk_ResultData, 15);
	}

	private String[] splitEpisodeIDs(String episode) throws Exception {

		String[] splitepisodeids = episode.split(". ");
		String[] EpisodeIDs = new String[] { splitepisodeids[1], splitepisodeids[3] };
		return EpisodeIDs;
	}
	
	private void searchProviderCode() throws Exception {
		
		clickonButton(lookup_ProviderCode);		
		if(isProviderSearchLookupPresent()) {
			WaitandSwitchtoFancyFrame();
			waitforVisibilityofElementLocated(txt_ProviderCode_inProvidersearchlookup, 25);
			enteringValues(txt_ProviderCode_inProvidersearchlookup, hm_testdata.get("PE_ProviderCode")); 
			clickonButton(btn_Search_inProvidersearchlookup);
			waitforElementtobeClickable(value_ProviderCode_inProvidersearchlookup, 25);
			clickonButton(value_ProviderCode_inProvidersearchlookup);
			SwitchingtoDefaultandtoHomeFrame();
			WaitandSwitchtoFancyFrame();
		}
		waitforVisibilityofElementLocated(txt_StartTime, 50);
	}
	
	private Boolean isProviderSearchLookupPresent() throws Exception {

		Boolean lookuppresent = false;
//		By tag_forProvidersearchlookup = By.xpath("//*[@id='fancy_content']"); //*[@id='fancy_outer']/descendant::*
//		By providersearchlookup_Child = By.tagName("iframe");
		webdriverwait(50).until(ExpectedConditions.visibilityOfElementLocated(tag_forProvidersearchlookup));
		for(WebElement webelement:gettingListofWebElements(tag_forProvidersearchlookup)) {
			for(WebElement element:webelement.findElements(By.xpath("./*"))) {
				if(isIFrameVisible(element) && isIFrameTagVisible(element)) {				
					lookuppresent = true;
					break;
				}
			}
		}
//	System.out.println("----lookuppresent="+lookuppresent);
		return lookuppresent;
	}
	
	private Boolean isIFrameTagVisible(WebElement element) throws Exception {
		Boolean isiframe = true;
		try {
			webdriverwait(50).until(ExpectedConditions.visibilityOf(element));
			element.getTagName().contains("iframe");
		} catch (Exception e) {
			isiframe = false;
		}
//	System.out.println("----isiframe="+isiframe);
		return isiframe;
	}
	
	private Boolean isIFrameVisible(WebElement element) throws Exception {
		Boolean isiframe = false;
		try {
			webdriverwait(50).until(ExpectedConditions.visibilityOf(element));
			webdriverwait(50).until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			isiframe = true;
		}
//	System.out.println("----isiframe="+isiframe);
		return isiframe;
	}
	
	/*
	 * private void checking1() throws Exception {
	 * 
	 * By numberofrecords = By.
	 * xpath("//*[text()='Signature Initial']/following-sibling::th/ancestor::div[@id='fixed_header']/child::div[@class='body']/table/*"
	 * ); By numberoferrors = By.xpath(
	 * "//*[@name='AdditionalProvidersForm']/child::*[@class='successerror_style']/descendant::div"
	 * ); System.out.println("-----"); System.out.println("--**-");
	 * webdriverwait(25).until(ExpectedConditions.or(ExpectedConditions.
	 * numberOfElementsToBeMoreThan(numberofrecords, 1),
	 * ExpectedConditions.numberOfElementsToBeMoreThan(numberoferrors, 1)));
	 * System.out.println("-----"); System.out.println("--**-"); }
	 */	 
}
