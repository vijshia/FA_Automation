/**
 * 
 */
package com.FA.app.pages.fa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.FA.app.pages.basePage;
import com.FA.framework.Log;
import static com.FA.framework.WebContext.*;
import static com.FA.app.tests.test.ChargeBatchTest.*;

/**
 * @author AJP16088
 *
 */
public class batchEntryPage extends basePage {
	
	public static By menu_Batch = By.xpath("//a[text()='Batch']");
	private By menu_BatchEntry = By.xpath("//a[text()='Batch Entry']");
	public static By txt_jobCode = By.xpath("//*[text()='Job Code']/following::input");
	private By lookup_jobCode = By.xpath("//*[@name='jobCode']/following-sibling::a");
	private By value_jobCode = By.xpath("//*[@name='jobCode']/..");
	private By dd_batchType = By.id("batchType");
	private By label_elements = By.xpath("//*[text()='Total Amount' or 'Start DOS']");
	private By dd_facilityId = By.name("facilityId");
	private By valuetoSelect_facilityId = By.xpath("//*[text()='" + facilityId + "']");
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
	private By frame_BatchLookup = By.id("fancy_frame");
	private By dd_facility = By.id("facilityIdd");
	private By txt_DOS = By.name("dosString");
	private By txt_SSCount = By.name("patientCount");
	private By btn_SSCSave = By.name("add");
	public static By msg_Recordsadded = By.className("successerror_style");
	private By frame_HomePage = By.name("header");
	private By icon_BatchLookupClose = By.id("fancy_close");

	public void NavigatetoBatch() throws Exception {

		javascript_scrollIntoView(menu_Batch);
		action_movetoElementandClick(menu_Batch);
		waitforVisibilityofElementLocated(menu_BatchEntry, 15);
		clickonButton(menu_BatchEntry);
		waitforVisibilityofElementLocated(txt_jobCode, 15);
		enteringValues(txt_jobCode, BE_JobCode);
		Log.info(" "+BE_JobCode+" entered in jobcode ");
		WebElement element_lookupjobCode = gettingWebElement(lookup_jobCode);
		waitforVisibilityofALLElementsLocated(element_lookupjobCode, 25);
		action_clickElement(lookup_jobCode);
		if (gettingWebElement(value_jobCode).getText().isEmpty()) {
			waitforTexttobePresentinElementLocated(value_jobCode, 20," ");
		}
		enteringValues(txt_batchDocumentCount, BE_DocumentCount);
		selectByVisibleText(dd_batchType, batchType);
		Log.info(" " + batchType + " selected in batchType ");
		waitforVisibilityofElementLocated(label_elements, 15);
		if (batchType.equalsIgnoreCase("CHARGES") || batchType.equalsIgnoreCase("SCHEDULE")) {
			enteringValues(dd_batchStartDOS, BE_StartDOS);
			enteringValues(dd_batchEndDOS, BE_EndDOS);
			clickonButton(dd_facilityId);
			waitforElementtobeClickable(valuetoSelect_facilityId, 20);
			clickonButton(valuetoSelect_facilityId);
			waitforVisibilityofElementLocated(dd_batchStartDOS, 15);
			if (batchType.equalsIgnoreCase("CHARGES")) {
				selectByVisibleText(dd_batchDeliveryType, BE_Delivery);
				selectByVisibleText(dd_batchScheduleReceived, BE_ScheduleReceived);
			} else {
				clickonButton(dd_batchSSCount);
				Log.info(" SSCount Clicked ");
				waitforVisibilityofElementLocated(frame_BatchLookup, 15);
				switchtoFrame(frame_BatchLookup);
				selectByVisibleText(dd_facility, facilityId);
				enteringValues(txt_DOS, "10162019");
				enteringValues(txt_SSCount, "1");
				clickonButton(btn_SSCSave);
				Log.info(" btn_SSCSave clicked in btn_SSCLookup");
				waitforTexttobePresentinElementLocated(msg_Recordsadded, 25, "Record Fields Added successfully.");
				switchtoDefaultFrame();
				switchtoFrame(frame_HomePage);
				clickonButton(icon_BatchLookupClose);
				Log.info(" SSC lookup Closed ");
			}
		} else {
			enteringValues(txt_batchTotalAmount, "1");
			enteringValues(txt_batchDepositDate, "10162018");
		}
		selectByVisibleText(dd_batchPriority, BE_Priority);
		selectByVisibleText(dd_batchScanMode, BE_ScanMode);
		clickonButton(btn_batchSave);
		batchCode = gettingWebElement(value_BatchCode).getText();
		Log.info(" *** Batch Code: " + batchCode);
		waitforTexttobePresentinElementLocated(msg_BatchSavedConfirmation, 25, "Batch saved successfully.");
//		System.out.println(driver.findElement(msg_BatchSavedConfirmation).getText());
		Log.info(" *************** Batch Creation Execution Completed *************** ");
	}
}
