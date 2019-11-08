/**
 * 
 */
package com.FA.app.tests.test;

import java.util.ArrayList;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.FA.app.tests.baseTest;
import com.FA.app.pages.fa.batchEntryPage;
import com.FA.app.pages.fa.batchestobeScannedPage;
import com.FA.app.pages.fa.loginPage;

import static com.FA.framework.WebContext.facilityId;
import static com.FA.framework.WebContext.batchType;

/**
 * @author AJP16088
 *
 */
public class ChargeBatchTest extends baseTest {

	private ArrayList<String[]> allData;

	loginPage loginpage;
	batchEntryPage batchentrypage;
	batchestobeScannedPage batchestobescannedpage;
//	  WebContext webcontext;

	public ChargeBatchTest(ArrayList<String[]> allData) {

		this.allData = allData;
		/*
		 * webcontext = new WebContext(); loginpage = new loginPage(); batchpage = new
		 * batchPage();
		 */
	}

//	public static int iterationFlag = 0;
	@Test(groups = { "buildverify", "regression" }, description="Batch Entry and Batch tobe Scanned")
	@Parameters({"user-name", "password", "url"})
	void ChargeBatchCreation(String username, String password, String url) throws Exception {

		loginpage = new loginPage();	
		
		loginpage.LogintoFA(username, password, url+"/DefaultNew.jsp");

		for (String[] rowdata : allData) {
			TestDataAssigning(rowdata);
			batchentrypage = new batchEntryPage();
			batchestobescannedpage = new batchestobeScannedPage();
			
			batchentrypage.NavigatetoBatch();	
			batchestobescannedpage.NavigatetoBatchestobeScanned();
//			iterationFlag++;
		}
	}

	public static String BE_JobCode;
//	public String BE_BatchType ;
	public static String BE_DocumentCount;
	public static String BE_StartDOS;
	public static String BE_EndDOS;
//	public String BE_Facility ;
	public static String BE_Delivery;
	public static String BE_ScanMode;
	public static String BE_Priority;
	public static String BE_ScheduleReceived;
	public static String BS_StartingDocumentNumber;
	public static String PI_PatientSearchorAdd;
	
	public void TestDataAssigning(String[] allData) {

		BE_JobCode = allData[0];
		batchType = allData[1];
		BE_DocumentCount = allData[2];
		BE_StartDOS = allData[3];
		BE_EndDOS = allData[4];
		facilityId = allData[5];
		BE_Delivery = allData[6];
		BE_ScanMode = allData[7];
		BE_Priority = allData[8];
		BE_ScheduleReceived = allData[9];
		BS_StartingDocumentNumber = allData[10];
		PI_PatientSearchorAdd = allData[11];
	}

}
