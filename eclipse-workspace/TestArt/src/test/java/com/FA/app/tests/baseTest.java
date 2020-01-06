/**
 * 
 */
package com.FA.app.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import static com.FA.app.tests.baseFactory.*;
import static com.FA.framework.WebContext.*;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.common.collect.ImmutableMap;
import com.FA.app.pages.basePage;
import com.FA.app.pages.fa.loginPage;
import com.FA.framework.ExcelReader;
import com.FA.framework.PropertyReader;
import com.FA.framework.WebContext;

/**
 * @author AJP16088
 *
 */
public class baseTest {

	private basePage basepage;
	public static WebDriver driver;

	public baseTest() {

		basepage = new basePage();
	}

	@BeforeSuite
	@Parameters({ "browser", "url", "user-name", "password" })
	public void getDriver(String browsertolaunch, String url, String username, String password) throws Exception {

//		driver = WebContext.driver;
		WebContext webcontext = new WebContext();
		webcontext.LaunchBrowser(browsertolaunch, url);
		loginPage loginpage = new loginPage();
		loginpage.LogintoFA(username, password, url + "/DefaultNew.jsp");
	}

	@AfterSuite(alwaysRun = true)
	public void closeWebdriver() throws Exception {

		basepage.CloseallBrowsers();
	}

	void setAllureEnvironment() {
		allureEnvironmentWriter(
				ImmutableMap.<String, String>builder().put("Browser", "Chrome").put("Browser.Version", "70.0.3538.77")
						.put("URL", "http://testjs.site88.net").build(),
				System.getProperty("user.dir") + "/allure-results/");
	}

	public static HashMap<String, String> hm_testdata;

	public void TestDataAssigning(HashMap<String, String> allData) throws Exception {

//		System.out.println("allData="+allData.length);
		hm_testdata = new HashMap<String, String>();		
		PropertyReader propreader = new PropertyReader();		
		try {
			hm_testdata.putAll(allData);
			propreader.getProperty(filepath + TEST_DATA_PROPERTY_PATH).forEach((k, v)->hm_testdata.put(String.valueOf(k), String.valueOf(v)));
//			propreader.getProperty(filepath + TEST_DATA_PROPERTY_PATH).forEach((k, v)->System.out.println("Item : " + k + " Count : " + v));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void UpdateExcelwithbatchCodeepisodeID(Entry<Integer, HashMap<String, String>> data) throws Exception {

		String[] rowData = new String[] { batchCode, episodeID,
				piErrorMessage == null ? "No_PIErrorMessage" : piErrorMessage,
				codingErrorMessage == null ? "No_CodingErrorMessage" : codingErrorMessage,
				peErrorMessage == null ? "No_PEErrorMessage" : peErrorMessage,
				invoice == null ? "No_invoicenumber" : invoice, 
				billingErrorMessage == null ? "No_BillingErrorMessage" : billingErrorMessage};

		ExcelReader excelreader = new ExcelReader(filepath + TEST_DATA_Excel_PATH);
//		for (Entry<Integer, String[]> data : excelreader.GetDataasMapArray(TEST_DATA_Sheet_Name).entrySet()) {
//		System.out.println("Key="+data.getKey()+"/ Value0="+data.getValue()[0]);
		excelreader.WriteOutputtoExcel(TEST_DATA_Sheet_Name, data.getKey(), data.getValue().size(), rowData);
	}

	/*
	 * // Data from Excel file public static String BE_JobCode; // public String
	 * BE_BatchType ; public static String BE_DocumentCount; public static String
	 * BE_StartDOS; public static String BE_EndDOS; // public String BE_Facility ;
	 * public static String BS_StartingDocumentNumber; public static String
	 * PI_LastName; public static String PI_FirstName; public static String PI_DOB;
	 * public static String Coding_Facility;
	 * 
	 * // Data from Property file public static String BE_Delivery; public static
	 * String BE_ScanMode; public static String BE_Priority; public static String
	 * BE_ScheduleReceived; public static String BE_DOS; public static String
	 * BE_SSCount; public static String BE_BatchTotalAmount; public static String
	 * BE_BatchDepositDate; public static String PI_Address1; public static String
	 * PI_ZipCode; public static String PI_EMPStudentStatus; public static String
	 * PI_InsCode; public static String PI_AreaCode; public static String
	 * PI_PhoneNumber; public static String PI_ImageInsName; public static String
	 * PI_Contract; public static String PI_ConfirmContract; public static String
	 * Coding_AreaFac; public static String Coding_POS; public static String
	 * Coding_ICD10; public static String Coding_ICD9; public static String
	 * Coding_INTPROC; public static String PE_ProviderCode; public static String
	 * PE_StartTime; public static String PE_EndTime; public static String
	 * PE_ImageInfo; public static String PE_AnesType; public static String
	 * PE_OPRoom;
	 * 
	 * public void TestDataAssigning1(String[] allData) throws Exception { //
	 * System.out.println("allData="+allData.length);
	 * 
	 * BE_JobCode = allData[0]; BE_BatchType = allData[1]; BE_DocumentCount =
	 * allData[2]; BE_StartDOS = allData[3]; BE_EndDOS = allData[4]; BE_Facility =
	 * allData[5]; BS_StartingDocumentNumber = allData[6]; PI_LastName = allData[7];
	 * PI_FirstName = allData[8]; PI_DOB = allData[9]; Coding_Facility =
	 * allData[10];
	 * 
	 * PropertyReader propreader = new PropertyReader();
	 * 
	 * try { for (String key : propreader.getProperty(filepath +
	 * TEST_DATA_PROPERTY_PATH).stringPropertyNames()) { String value =
	 * propreader.getProperty(filepath + TEST_DATA_PROPERTY_PATH).getProperty(key);
	 * // System.out.println("key="+key+" /value="+value); switch (key) { case
	 * "BE_Delivery": BE_Delivery = value; break; case "BE_ScanMode": BE_ScanMode =
	 * value; break; case "BE_Priority": BE_Priority = value; break; case
	 * "BE_ScheduleReceived": BE_ScheduleReceived = value; break; case "BE_DOS":
	 * BE_DOS = value; break; case "BE_SSCount": BE_SSCount = value; break; case
	 * "BE_BatchTotalAmount": BE_BatchTotalAmount = value; break; case
	 * "BE_BatchDepositDate": BE_BatchDepositDate = value; break; case
	 * "PI_EMPStudentStatus": PI_EMPStudentStatus = value; break; case "PI_InsCode":
	 * PI_InsCode = value; break; case "PI_Address1": PI_Address1 = value; break;
	 * case "PI_ZipCode": PI_ZipCode = value; break; case "PI_AreaCode": PI_AreaCode
	 * = value; break; case "PI_PhoneNumber": PI_PhoneNumber = value; break; case
	 * "PI_ImageInsName": PI_ImageInsName = value; break; case "PI_Contract":
	 * PI_Contract = value; break; case "PI_ConfirmContract": PI_ConfirmContract =
	 * value; break; case "Coding_AreaFac": Coding_AreaFac = value; break; case
	 * "Coding_POS": Coding_POS = value; break; case "Coding_ICD10": Coding_ICD10 =
	 * value; break; case "Coding_ICD9": Coding_ICD9 = value; break; case
	 * "Coding_INTPROC": Coding_INTPROC = value; break; case "PE_ProviderCode":
	 * PE_ProviderCode = value; break; case "PE_StartTime": PE_StartTime = value;
	 * break; case "PE_EndTime": PE_EndTime = value; break; case "PE_ImageInfo":
	 * PE_ImageInfo = value; break; case "PE_AnesType": PE_AnesType = value; break;
	 * case "PE_OPRoom": PE_OPRoom = value; break; } } } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */
	
}
