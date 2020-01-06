/**
 * 
 */
package com.FA.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author AJP16088
 *
 */
public class ExcelReader {

	Workbook wb;
	Sheet sh;
	String ExcelPath;

	public ExcelReader(String ExcelPath) {

		this.ExcelPath = ExcelPath;
		try {
			FileInputStream fstream = new FileInputStream(new File(ExcelPath));
			String fileextension = ExcelPath.substring(ExcelPath.indexOf("."));
			if (fileextension.equalsIgnoreCase(".xlsx")) {
				wb = new XSSFWorkbook(fstream);
			} else if (fileextension.equalsIgnoreCase(".xls")) {
				wb = new HSSFWorkbook(fstream);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the data from an excel sheet as HashMap
	 * @param sheetname
	 * @return a Map of string (header) & String (value), one row data will be
	 *         stored in one array.
	 * @throws Exception: For exception handling
	 */
//	public HashMap<String, List<String>> GetData(String sheetname) throws Exception {
	public HashMap<String, String> GetDataasMap(String sheetname) throws Exception {

		try {
			sh = wb.getSheet(sheetname);
//			HashMap<String, List<String>> hm_ex_data = Data_from_Excel(sheetname);
			HashMap<String, String> hm_ex_data = new HashMap<String, String>();
			String Data_Header = null;
			Row header_row = sh.getRow(sh.getFirstRowNum());
			int header_row_Count = header_row.getLastCellNum();
			for (int i = 0; i < header_row_Count; i++) {
				Data_Header = header_row.getCell(i).getStringCellValue();
//				List<String> Data_valueS = new LinkedList<String>();
				String Data_Values = null;
				for (int j = 1; j < sh.getLastRowNum() + 1; j++) {
//					int last = sh.getLastRowNum();
					Row value_row = sh.getRow(j);
					Cell cell = value_row.getCell(i);
					String cellString = null;
					if (cell != null) {
						cellString = cellToString(cell);
					}
					if (cellString != "NA" && !cellString.isEmpty() && cellString != null) {
						Data_Values = cellString;
					}
				}
				hm_ex_data.put(Data_Header, Data_Values);
			}
			return hm_ex_data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Get the data from an excel sheet as List
	 * @param sheetname: Name of the sheet
	 * @return a list of string array, one row data will be stored in one array.
	 * @throws Exception: For exception handling
	 */
	public ArrayList<String[]> GetDataasList(String sheetname) throws Exception {

		try {
			ArrayList<String[]> Data = new ArrayList<String[]>();
			sh = wb.getSheet(sheetname);
//			System.out.println("sh.getLastRowNum= " + sh.getLastRowNum() + " /sh.getFirstRowNum= " + sh.getFirstRowNum());
			for (int k = 1; k < sh.getLastRowNum() + 1; k++) {
				String[] rowData = new String[sh.getRow(k).getLastCellNum()];
//				System.out.println("rowData size= " + rowData.length);
				Row valueRow = sh.getRow(k);
				for (int l = 0; l < valueRow.getLastCellNum(); l++) {
					Cell rowCell = valueRow.getCell(l);
					rowData[l] = cellToString(rowCell).trim();
				}
				Data.add(rowData);
			}
			return Data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Get the data from an excel sheet as HashMap with value as String  Array
	 * @param sheetname: Name of the sheet
	 * @return a HashMap of string array, one row of excel data will be stored in one array in Map value and the Map key will store the row number.
	 * @throws Exception: For exception handling
	 */
	public HashMap<Integer, String[]> GetDataasMapArray(String sheetname) throws Exception {

		try {
			HashMap<Integer, String[]> Data = new HashMap<Integer, String[]>();
			sh = wb.getSheet(sheetname);
//		System.out.println("sh.getLastRowNum= " + sh.getLastRowNum() + " /sh.getFirstRowNum= " + sh.getFirstRowNum());
			for (int k = 1; k < sh.getLastRowNum() + 1; k++) {
				String[] rowData = new String[sh.getRow(k).getLastCellNum()];
//				System.out.println("rowData size= " + rowData.length);				
				Row valueRow = sh.getRow(k);
				for (int l = 0; l < valueRow.getLastCellNum(); l++) {
//					System.out.println(sh.getRow(0).getCell(l).getStringCellValue());
					Cell rowCell = valueRow.getCell(l);
					rowData[l] = cellToString(rowCell).trim();
				}
				Data.put(k, rowData);
			}
			return Data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get the data from an excel sheet as HashMap with value as String  Array
	 * @param sheetname: Name of the sheet
	 * @return a HashMap of string array, one row of excel data will be stored in one array in Map value and the Map key will store the row number.
	 * @throws Exception: For exception handling
	 */
	public HashMap<Integer, HashMap<String, String>> GetDataasMapofMap(String sheetname) throws Exception {

		try {
			HashMap<Integer, HashMap<String, String>> Data = new HashMap<Integer, HashMap<String, String>>();			
			sh = wb.getSheet(sheetname);
//		System.out.println("sh.getLastRowNum= " + sh.getLastRowNum() + " /sh.getFirstRowNum= " + sh.getFirstRowNum());
			for (int k = 1; k < sh.getLastRowNum() + 1; k++) {
				HashMap<String, String> rowData = new HashMap<String, String>();			
				Row valueRow = sh.getRow(k);
				for (int l = 0; l < valueRow.getLastCellNum(); l++) {
//					System.out.println(sh.getRow(0).getCell(l).getStringCellValue());
					Cell rowCell = valueRow.getCell(l);
					rowData.put(sh.getRow(0).getCell(l).getStringCellValue(), cellToString(rowCell).trim());
				}
				Data.put(k, rowData);
			}
			return Data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * To convert the cell value to String
	 * Author: ajp16088
	 * @param cell: cell to convert
	 * @return a String
	 */
	private String cellToString(Cell cell) {

		Object result = null;
		FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

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
		return result.toString();
	}

	/**
	 * To write batchCode, episodeID in excel against the testdata
	 * Author: ajp16088
	 * @param sheetname: Name of the sheet
	 * @param rowNum: Row number to write the output
	 * @param columnNum: Column number to write the output
	 * @param data: Data to write in ouput
	 * @throws Exception: For exception handling
	 */
	public void WriteOutputtoExcel(String sheetname, int rowNum, int columnNum, String[] data) throws Exception {
//	System.out.println("sheetname="+sheetname+"/rowNum="+rowNum+"/columnNum="+columnNum);
		FileOutputStream foutstream = null;
		try {
			sh = wb.getSheet(sheetname);
			Row row = sh.getRow(rowNum);
			int k = 0;
			int j = columnNum + 1;
			int columns = j + data.length;
			for (int i = rowNum; i < rowNum + 1; i++) {
				for (; j < columns; j++) {
					Cell cell = row.createCell(j);
//				System.out.println("j="+j+"/data[k]=="+data[k]);
					cell.setCellValue(data[k]);
					foutstream = new FileOutputStream(ExcelPath);
					wb.write(foutstream);
					k++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			foutstream.close();
		}
	}
	
	public static void main(String args[]) throws Exception {

		String xl_path = "C:\\Users\\ajp16088\\eclipse-workspace\\TestArt\\Inputs\\FA_TestData_1.xlsx";
		ExcelReader Excel = new ExcelReader(xl_path);
		
		String sheetname = "Sheet1"; String batchCode = "CASA1911182643"; String episodeID = "12656250"; 
		String batchCode1 = "FAOA1911182643"; String episodeID1 = "47893254";
		
		String[] rowData = new String[4];
		rowData[0] = batchCode; rowData[1] = episodeID; rowData[2] = batchCode1; rowData[3] = episodeID1;
		
		for (Entry<Integer, HashMap<String, String>> data : Excel.GetDataasMapofMap(sheetname).entrySet()) {
			System.out.println("Key=" + data.getKey() + "/ Value0=" + data.getValue()+"/ size=" +data.getValue().size());
			Excel.WriteOutputtoExcel(sheetname, data.getKey(), data.getValue().size(), rowData);
		}
		
		for (Entry<Integer, String[]> data : Excel.GetDataasMapArray(sheetname).entrySet()) {
			System.out.println("Key=" + data.getKey() + "/ Value0=" + data.getValue()[0]);
			Excel.WriteOutputtoExcel(sheetname, data.getKey(), data.getValue().length, rowData);
		}

		for (String[] data : Excel.GetDataasList("ChargeBatch")) {
			System.out.println("data0=" + data[0] + " / " + "data1=" + data[1] + " / " + "data2=" + data[2] + " / "
					+ "data3=" + data[3] + " / " + "data4=" + data[4] + " / " + "data5=" + data[5] + " / " + "data6="
					+ data[6] + " / " + "data7=" + data[7] + " / " + "data8=" + data[8] + " / " + "data9=" + data[9]
					+ " / " + "data10=" + data[10]);
		}
	}
	
}
