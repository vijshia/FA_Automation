package app.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test_excelReader {

	public static void main(String args[]) throws Exception {

		// String excelPath = "E:\\KONE\\mobilesitesurveytestautomation\\input\\testdata\\KONEMobileSiteSurvey_TestData.xlsx";
		String excelPath = "KONEMobileSiteSurvey_TestData.xlsx";
		String sheetName = "Mobile_Data";

		test_excelReader testexcelReader = new test_excelReader();
		testexcelReader.GetDataFromSingleRow(excelPath, "Web_Login_Data");
		testexcelReader.GetDataFromMultipleRows(excelPath, sheetName);

	}

	Workbook workbook = null;

	public void ExcelInitializing(String excelname) {

		File filepath = new File(System.getProperty("user.dir") + "\\src\\app\\input\\" + excelname);
		System.out.println("filepath= " + filepath);
		try {
			FileInputStream fstream = new FileInputStream(filepath);
			if (fstream != null) {
				String fileextension = filepath.toString().substring(filepath.toString().indexOf("."));
				if (fileextension.equalsIgnoreCase(".xlsx")) {
					workbook = new XSSFWorkbook(fstream);
				} else if (fileextension.equalsIgnoreCase(".xls")) {
					workbook = new HSSFWorkbook(fstream);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<Integer, HashMap<String, String>> GetDataFromMultipleRows(String excelname, String sheetname)
			throws Exception {

		ExcelInitializing(excelname);
		try {
			HashMap<Integer, HashMap<String, String>> allData = new HashMap<Integer, HashMap<String, String>>();
			Sheet sh = workbook.getSheet(sheetname);
// 		System.out.println("sh.getLastRowNum= " + sh.getLastRowNum() +"sh.getFirstRowNum= " + sh.getFirstRowNum());
			
			for (int i = 1; i < sh.getLastRowNum() + 1; i++) {
				HashMap<String, String> rowData = new HashMap<String, String>();
				Row valueRow = sh.getRow(i);
				for (int j = 0; j < valueRow.getLastCellNum(); j++) {
//		System.out.println(sh.getRow(0).getCell(j).getStringCellValue());
					Cell rowCell = valueRow.getCell(j);
					rowData.put(sh.getRow(0).getCell(j).getStringCellValue(), cellToString(rowCell).trim());
				}
				allData.put(i, rowData);
			}
			return allData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public HashMap<String, String> GetDataFromSingleRow(String excelname, String sheetname) throws Exception {

		ExcelInitializing(excelname);
		try {
			// HashMap<Integer, HashMap<String, String>> allData = new HashMap<Integer, HashMap<String, String>>();
			HashMap<String, String> rowData = null;
			Sheet sh = workbook.getSheet(sheetname);
			
			for (int i = 1; i < sh.getLastRowNum() + 1; i++) {
				rowData = new HashMap<String, String>();
				Row valueRow = sh.getRow(i);
				for (int j = 0; j < valueRow.getLastCellNum(); j++) {
//		System.out.println(sh.getRow(0).getCell(j).getStringCellValue());
					Cell rowCell = valueRow.getCell(j);
					rowData.put(sh.getRow(0).getCell(j).getStringCellValue(), cellToString(rowCell).trim());
				}
				// allData.put(i, rowData);
			}
			return rowData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String cellToString(Cell cell) {

		Object result = null;
		FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

		if (cell == null) {
			result = "NA";
		} else {
			switch (formulaEvaluator.evaluateInCell(cell).getCellTypeEnum()) {
			case NUMERIC:
				DataFormatter formatter = new DataFormatter();
				result = formatter.formatCellValue(cell);
				break;
			case STRING:
				result = cell.getStringCellValue();
				break;
			case BLANK:
				result = "NA";
				break;
			default:
				result = "NA";
			}
		}
		return result.toString();
	}
}
