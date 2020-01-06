/**
 * 
 */
package com.FA.app.tests.test;

import java.util.HashMap;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.FA.app.tests.baseTest;
import com.FA.app.pages.fa.batchEntryPage;
import com.FA.app.pages.fa.batchestobeScannedPage;
import com.FA.app.pages.fa.codingBatchesPage;
import com.FA.app.pages.fa.peBatchPage;
import com.FA.app.pages.fa.piBatchPage;

/**
 * @author AJP16088
 *
 */
public class ChargeBatchTest extends baseTest {

//	private ArrayList<String[]> allData;
	private HashMap<Integer, HashMap<String, String>> allDataasMap;

	batchEntryPage batchentrypage;
	batchestobeScannedPage batchestobescannedpage;
	piBatchPage pibatchpage;
	codingBatchesPage codingbatchespage;
	peBatchPage pebatchpage;	

//	public ChargeBatchTest(ArrayList<String[]> allData) {
	public ChargeBatchTest(HashMap<Integer, HashMap<String, String>> allData) {

		this.allDataasMap = allData;
	}

//	public static int iterationFlag = 0;

	@Test(groups = { "basebuild", "regression" }, description = "Batch Entry and Batch tobe Scanned")
	void ChargeBatchCreation() throws Exception {

//		for (String[] rowdata : allData) {
		for (Entry<Integer, HashMap<String, String>> rowdata : allDataasMap.entrySet()) {
			TestDataAssigning(rowdata.getValue());
			batchentrypage = new batchEntryPage();
			batchestobescannedpage = new batchestobeScannedPage();
			pibatchpage = new piBatchPage();
			codingbatchespage = new codingBatchesPage();
			pebatchpage = new peBatchPage();

			batchentrypage.NavigatetoBatch();			
			batchestobescannedpage.NavigatetoBatchestobeScanned();
			pibatchpage.NavigatetoPIBatches();
			codingbatchespage.NavigatetoCodingBatches();
			pebatchpage.NavigatetoPEBatches();			
			
			UpdateExcelwithbatchCodeepisodeID(rowdata);
//			iterationFlag++;
		}
	}

	/*
	 * @Test(groups = { "buildverify", "regression" }, description="Batch Entry and Batch tobe Scanned")
	 * @Parameters({"user-name", "password", "url"}) 
	 * void ChargeBatchCreation(String username, String password, String url) throws Exception {
	 * 
	 * loginpage = new loginPage(); loginpage.LogintoFA(username, password, url+"/DefaultNew.jsp");
	 */

}
