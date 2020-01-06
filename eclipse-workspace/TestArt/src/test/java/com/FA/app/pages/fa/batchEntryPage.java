/**
 * 
 */
package com.FA.app.pages.fa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.FA.app.pages.basePage;
import com.FA.framework.Log;
import static com.FA.framework.WebContext.batchCode;
import static com.FA.app.pages.fa.piBatchPage.elementtoInvisible;
import static com.FA.app.tests.baseTest.hm_testdata;

/**
 * @author AJP16088
 *
 */
public class batchEntryPage extends basePage {
	
	public static By menu_Batch = By.xpath("//a[text()='Batch']");
	private By lnk_Home = By.xpath("//a[@href='/FirstClaim/action/home']");
//	private By menu_BatchEntry = By.xpath("//a[text()='Batch Entry']");
	private By widget_CreateBatch = By.xpath("//li[contains(@onclick,'batchEntry')]");
	public static By txt_jobCode = By.xpath("//*[text()='Job Code']/following::input");
	private By lookup_jobCode = By.xpath("//*[@name='jobCode']/following-sibling::a");
	private By value_jobCode = By.xpath("//*[@name='jobCode']/..");
	private By dd_batchType = By.id("batchType");
	private By label_elements = By.xpath("//*[text()='Total Amount' or 'Start DOS']");
	private By dd_facilityId = By.name("facilityId");
	private By valuetoSelect_facilityId = By.xpath("//*[text()='" + hm_testdata.get("BE_Facility") + "']");
	private By txt_batchDocumentCount = By.id("documentCount");
	private By dd_batchStartDOS = By.name("startDOS");
	private By dd_batchEndDOS = By.name("endDOS");
	private By dd_batchDeliveryType = By.id("deliveryType");
	private By dd_batchPriority = By.id("batchPriority");
	private By dd_batchScanMode = By.name("scanMode");
	private By dd_batchScheduleReceived = By.name("schedRecive");
	private By dd_batchSSCount = By.name("schedulePageCountScreen");
	private By btn_batchSave = By.id("saveBatchAct");
	private By value_BatchCode = By.xpath("//*[text()='Batch Code']/following-sibling::td");
	private By msg_BatchSavedConfirmation = By.xpath("//*[@id='saveInProgress']/..");
	private By txt_batchTotalAmount = By.id("totalAmount");
	private By txt_batchDepositDate = By.id("depositDate");
	public static By frame_BatchLookup = By.id("fancy_frame");
	private By dd_facility = By.id("facilityIdd");
	private By txt_DOS = By.name("dosString");
	private By txt_SSCount = By.name("patientCount");
	private By btn_SSCSave = By.name("add");
	public static By msg_Recordsadded = By.className("successerror_style");
	public static By frame_HomePage = By.name("header");
	private By icon_BatchLookupClose = By.id("fancy_close");

	public void NavigatetoBatch() throws Exception {

		Log.info(" *************** Batch Creation Execution Started *************** ");
		/*
		 * javascript_scrollIntoView(menu_Batch);
		 * action_movetoElementandClick(menu_Batch);
		 * waitforVisibilityofElementLocated(menu_BatchEntry, 15);
		 * clickonButton(menu_BatchEntry);
		 */
		NavigatetoCreateBatch();
		waitforVisibilityofElementLocated(txt_jobCode, 15);
		enteringValues(txt_jobCode, hm_testdata.get("BE_JobCode"));
		Log.info("*** "+hm_testdata.get("BE_JobCode")+" entered in jobcode ");
		WebElement element_lookupjobCode = gettingWebElement(lookup_jobCode);
		waitforVisibilityofALLElementsLocated(element_lookupjobCode, 25);
		action_clickElement(lookup_jobCode);
		if (gettingWebElement(value_jobCode).getText().isEmpty()) {
			waitforTexttobePresentinElementLocated(value_jobCode, 20," ");
		}
		enteringValues(txt_batchDocumentCount, hm_testdata.get("BE_DocumentCount"));
		selectByVisibleText(dd_batchType, hm_testdata.get("BE_BatchType"));
		Log.info("*** " + hm_testdata.get("BE_BatchType") + " selected in batchType ");
		waitforVisibilityofElementLocated(label_elements, 15);
		if (hm_testdata.get("BE_BatchType").equalsIgnoreCase("CHARGES") || hm_testdata.get("BE_BatchType").equalsIgnoreCase("SCHEDULE")) {
			enteringValues(dd_batchStartDOS, hm_testdata.get("BE_StartDOS"));
			enteringValues(dd_batchEndDOS, hm_testdata.get("BE_EndDOS"));
			clickonButton(dd_facilityId);
			waitforElementtobeClickable(valuetoSelect_facilityId, 20);
			clickonButton(valuetoSelect_facilityId);
			waitforVisibilityofElementLocated(dd_batchStartDOS, 15);
			if (hm_testdata.get("BE_BatchType").equalsIgnoreCase("CHARGES")) {
				selectByVisibleText(dd_batchDeliveryType, hm_testdata.get("BE_Delivery"));
				selectByVisibleText(dd_batchScheduleReceived, hm_testdata.get("BE_ScheduleReceived"));
			} else {
				clickonButton(dd_batchSSCount);
				Log.info(" SSCount Clicked ");
				waitforVisibilityofElementLocated(frame_BatchLookup, 15);
				switchtoFrame(frame_BatchLookup);
				selectByVisibleText(dd_facility, hm_testdata.get("BE_Facility"));
				enteringValues(txt_DOS, hm_testdata.get("BE_DOS"));
				enteringValues(txt_SSCount, hm_testdata.get("BE_SSCount"));
				clickonButton(btn_SSCSave);
				Log.info(" btn_SSCSave clicked in btn_SSCLookup");
				waitforTexttobePresentinElementLocated(msg_Recordsadded, 25, "Record Fields Added successfully.");
				switchtoDefaultFrame();
				switchtoFrame(frame_HomePage);
				clickonButton(icon_BatchLookupClose);
				Log.info(" SSC lookup Closed ");
			}
		} else {
			enteringValues(txt_batchTotalAmount, hm_testdata.get("BE_BatchTotalAmount"));
			enteringValues(txt_batchDepositDate, hm_testdata.get("BE_BatchDepositDate"));
		}
		selectByVisibleText(dd_batchPriority, hm_testdata.get("BE_Priority"));
		selectByVisibleText(dd_batchScanMode, hm_testdata.get("BE_ScanMode"));
		clickonButton(btn_batchSave);
		batchCode = gettingWebElement(value_BatchCode).getText();
		Log.info("*** Batch Code: " + batchCode);
		waitforTexttobePresentinElementLocated(msg_BatchSavedConfirmation, 35, "Batch saved successfully.");
		Log.info("********* Batch Creation Save message: "+gettingWebElement(msg_BatchSavedConfirmation).getText());
		Log.info(" *************** Batch Creation Execution Completed *************** ");
		Log.info("");
	}
	
	private void NavigatetoCreateBatch() throws Exception {
		
		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		javascript_scrollIntoView(widget_CreateBatch);
		waitforVisibilityofElementLocated(widget_CreateBatch, 20);
		clickonButton(widget_CreateBatch);
		waitforVisibilityofElementLocated(txt_jobCode, 25);
	}	
	
	public void NavigatetoHomePage() throws Exception {

		waitforVisibilityofElementLocated(lnk_Home, 25);
		javascript_scrollIntoView(lnk_Home);
		clickonButton(lnk_Home);
		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		waitforVisibilityofElementLocated(widget_CreateBatch, 25);
		javascript_scrollIntoView(widget_CreateBatch);
		Log.info("*** Navigating to HomePage ***" );
		
	}	
}
