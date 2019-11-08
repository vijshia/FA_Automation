/**
 * 
 */
package com.FA.app.tests;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.FA.framework.ExcelReader;

/**
 * @author AJP16088
 *
 */
public class baseFactory {
	
	public static File filepath = new File(System.getProperty("user.dir"));
	protected static final String TEST_DATA_Excel_PATH = "\\Inputs\\FA_TestData_1.xlsx";
	
	@DataProvider(name = "allDataProvider")
	public Object[][] surveyDataProvider(ITestContext context) throws IOException {

		ExcelReader exlReader = new ExcelReader(filepath+TEST_DATA_Excel_PATH);
		Object[][] data = new Object[1][1];
		try {
			data[0][0] = exlReader.GetDataasList("Sheet1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
