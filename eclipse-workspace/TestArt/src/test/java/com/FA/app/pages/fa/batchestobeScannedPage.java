/**
 * 
 */
package com.FA.app.pages.fa;

import org.openqa.selenium.By;

import com.FA.app.pages.basePage;
import com.FA.framework.Log;

import static com.FA.app.pages.fa.batchEntryPage.menu_Batch;
import static com.FA.framework.WebContext.batchCode;
import static com.FA.app.tests.test.ChargeBatchTest.BS_StartingDocumentNumber;
/**
 * @author ajp16088
 *
 */
public class batchestobeScannedPage extends basePage{
	
	private By menu_BatchestobeScanned = By.xpath("//a[text()='Batches to be Scanned']");
	private By header_Grid = By.id("fixed_header");
	private By table_value = By.xpath("//a[contains(@href,'editBatchScan')]");
//	private By lnk_sNo = By.xpath("//*[text()='" + batchCode + "']/parent::*");
	public static By frame_BatchLookup = By.id("fancy_frame");
	public static By frame_HomePage = By.name("header");
	private By chkbox_hasBeenScanned = By.id("hasBeenScannedFlag");
	private By txt_StartDCN = By.name("startDCN");
	private By txt_EndDCN = By.name("endDCN");
	private By btn_Save = By.name("save");
	private By icon_BatchLookupClose = By.id("fancy_close");
	public static By txt_joborBatchCode = By.name("jobCode");
	public static By msg_BatchSavedConfirmation = By.xpath("//*[@id='saveInProgress']/..");
	public static By btn_piBatches_search = By.name("Search");
	
	public void NavigatetoBatchestobeScanned() throws Exception {

		javascript_scrollIntoView(menu_Batch);
		action_movetoElementandClick(menu_Batch);
		waitforVisibilityofElementLocated(menu_BatchestobeScanned, 20);
		clickonButton(menu_BatchestobeScanned);
		waitforVisibilityofElementLocated(txt_joborBatchCode, 15);
		enteringValues(txt_joborBatchCode, batchCode);
		clickonButton(btn_piBatches_search);
		waitforVisibilityofElementLocated(header_Grid, 20);
		clickonButton(table_value); 							
		waitforVisibilityofElementLocated(frame_BatchLookup, 15);
		switchtoFrame(frame_BatchLookup);
		waitforVisibilityofElementLocated(chkbox_hasBeenScanned, 10);
		clickonButton(chkbox_hasBeenScanned);
		waitforVisibilityofElementLocated(txt_StartDCN, 10);
		enteringValues(txt_StartDCN, BS_StartingDocumentNumber);
		waitforVisibilityofElementLocated(txt_EndDCN, 10);
		clickonButton(btn_Save);
		System.out.println("*** Save clicked in BatchLookup ***");
		waitforTexttobePresentinElementLocated(msg_BatchSavedConfirmation, 25, "Batch saved successfully.");
		switchtoDefaultFrame();
		switchtoFrame(frame_HomePage);
		clickonButton(icon_BatchLookupClose);
		Log.info(" *************** Batches tobe Scanned Execution Completed *************** ");
	}

}
