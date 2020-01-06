/**
 * 
 */
package com.FA.app.pages.fa;

import static com.FA.app.pages.fa.piBatchPage.elementtoInvisible;
import static com.FA.framework.WebContext.batchCode;
import static com.FA.app.pages.fa.piBatchPage.txt_ErrorCorrection_jobCode;
import static com.FA.app.tests.baseTest.hm_testdata;
import static com.FA.app.pages.fa.piBatchPage.lookup_ErrorCorrection_jobCode;
import static com.FA.app.pages.fa.piBatchPage.txt_ErrorCorrection_batchCode;
import static com.FA.app.pages.fa.piBatchPage.chkbox_ErrorCorrection_AcceptAll;
import static com.FA.framework.WebContext.billingErrorMessage;
import java.util.HashMap;

import org.openqa.selenium.By;

import com.FA.app.pages.basePage;
import com.FA.framework.Log;

/**
 * @author ajp16088
 *
 */
public class billingPage extends basePage {

	/* private By menu_Billing = By.xpath("//a[text()='Billing']"); private By
	 * menu_Process = By.xpath("//a[text()='Process']");  */
	private By widget_CodingPreInvoiceBatches = By.xpath("//li[contains(@onclick,'preInvoiceProcessNew')]");
	private By widget_ViewPreInvoiceErrors = By.xpath("//img[contains(@src,'invoice_error')]");
	private By btn_BillingProcessSearch = By.name("searchButton");
	private By txt_batchCode = By.name("batchCode");
	private By checkbox_QueueBatch = By.xpath("//*[@type='checkbox']");
//	pri vate By menu_Errors = By.xpath("//a[text()='Errors']");
	private By btn_SearchErrors = By.xpath("//*[@value='Search(F9)']");

	batchEntryPage batchentrypage = new batchEntryPage();
	
	public void NavigatetoBillingProcess() throws Exception {

		Log.info(" *************** Billing Process Execution Started *************** ");
		NavigatetoBillingProcessandRetriveResultData();
		Log.info(" *************** Billing Process Execution Completed *************** ");
		Log.info("");
		Log.info(" *************** Billing Errors Execution Started *************** ");
		NavigatetoBillingErrorsandRetriveErrors();
		Log.info(" *************** Billing Errors Execution Completed *************** ");
		Log.info("");
	}

	/*
	 * private void NavigatetoBilling() throws Exception {
	 * 
	 * waitforInVisibilityofElementLocated(elementtoInvisible, 15);
	 * javascript_scrollIntoView(menu_Billing);
	 * action_movetoElementandClick(menu_Billing);
	 * waitforVisibilityofElementLocated(menu_Process, 25); }
	 */

	private void NavigatetoBillingProcessandRetriveResultData() throws Exception {

		/* NavigatetoBilling(); action_movetoElementandClick(menu_Process);
		 * waitforInVisibilityofElementLocated(elementtoInvisible, 20);
		 * waitforInVisibilityofElementLocated(menu_Process, 20);  */
		batchentrypage.NavigatetoHomePage();
		javascript_scrollIntoView(widget_CodingPreInvoiceBatches);
		waitforVisibilityofElementLocated(widget_CodingPreInvoiceBatches, 15);
		waitforElementtobeClickable(widget_CodingPreInvoiceBatches, 15);
		clickonButton(widget_CodingPreInvoiceBatches);
		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		waitforVisibilityofElementLocated(txt_batchCode, 25);
		enteringValues(txt_batchCode, batchCode);
		waitforElementtobeClickable(btn_BillingProcessSearch, 15);
//		waitforInVisibilityofElementLocated(elementtoInvisibleinCoding, 25);
		clickonButton(btn_BillingProcessSearch);
		waitforNumberOfElementstobePresent(checkbox_QueueBatch, 15, gettingListofWebElements(checkbox_QueueBatch).size());
		HashMap<String, String> billingProcessTableData = billingProcessTableData();
		Log.info(" *** Complete: " + billingProcessTableData.get("Complete") + " *** Fatal: "
				+ billingProcessTableData.get("Fatal") + " *** Warning: "
				+ billingProcessTableData.get("Warning"));
	}

	private void NavigatetoBillingErrorsandRetriveErrors() throws Exception {

		/* NavigatetoBilling(); action_movetoElementandClick(menu_Errors);  */
		batchentrypage.NavigatetoHomePage();
		javascript_scrollIntoView(widget_ViewPreInvoiceErrors);
		waitforVisibilityofElementLocated(widget_ViewPreInvoiceErrors, 15);
		waitforElementtobeClickable(widget_ViewPreInvoiceErrors, 15);
		clickonButton(widget_ViewPreInvoiceErrors);
		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		waitforVisibilityofElementLocated(txt_ErrorCorrection_jobCode, 15);
		enteringValues(txt_ErrorCorrection_jobCode, hm_testdata.get("BE_JobCode"));
		waitforVisibilityofALLElementsLocated(gettingWebElement(lookup_ErrorCorrection_jobCode), 15);
		action_clickElement(lookup_ErrorCorrection_jobCode);
		enteringValues(txt_ErrorCorrection_batchCode, batchCode);
		waitforInVisibilityofElementLocated(elementtoInvisible, 15);
		clickonButton(btn_SearchErrors);
		waitforVisibilityofElementLocated(chkbox_ErrorCorrection_AcceptAll, 15);
		billingErrorMessage = errorMessage();
	}
	
}
