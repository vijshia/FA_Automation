/**
 * 
 */
package com.FA.framework;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

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
	 * @return a Map of string (header) & String (value), one row data will be stored in one array.
	 * @throws Exception
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
	 * 
	 * @param sheetname
	 * @return a list of string array, one row data will be stored in one array.
	 * @throws Exception
	 */
	public ArrayList<String[]> GetDataasList(String sheetname) throws Exception {

		try {
			ArrayList<String[]> Data = new ArrayList<String[]>();
			sh = wb.getSheet(sheetname);
//			System.out.println("sh.getLastRowNum= " + sh.getLastRowNum() + " / " + sh.getFirstRowNum());
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

	public static void main(String args[]) throws Exception {

		String xl_path = "C:\\Users\\ajp16088\\Desktop\\ChargeBatch_ExcelReader.xlsx";
		ExcelReader Excel = new ExcelReader(xl_path);
		
		for (String[] data : Excel.GetDataasList("ChargeBatch")) {
			System.out.println("data0="+data[0] + " / " + "data1="+data[1] + " / " + "data2="+data[2] + " / " + "data3="+data[3] + " / " + "data4="+data[4] + " / "
					+ "data5="+data[5] + " / " + "data6="+data[6] + " / " + "data7="+data[7] + " / " + "data8="+data[8] + " / " + "data9="+data[9] + " / " + "data10="+data[10]
					+ " / " + "data11="+data[11] + " / " + "data12="+data[12] + " / " + "data13="+data[13] + " / " + "data14="+data[14] + " / " + "data15="+data[15]
					+ " / " + "data16="+data[16] + " / " + "data17="+data[17] + " / " + "data18="+data[18] + " / " + "data19="+data[19] + " / " + "data20="+data[20]
					+ " / " + "data21="+data[21] + " / " + "data22="+data[22] + " / " + "data23="+data[23] + " / " + "data24="+data[24] + " / " + "data25="+data[25] + " / "
					+ "data26="+data[26] + " / " + "data27="+data[27] + " / " + "data28="+data[28] + " / " + "data29="+data[29] + " / " + "data30="+data[30] + " / "
					+ "data31="+data[31] + " / " + "data32="+data[32] + " / " + "data33="+data[33] + " / " + "data34="+data[34] + " / " + "data35="+data[35] + " / "
					+ "data36="+data[36] + " / " + "data37="+data[37] + " / " + "data38="+data[38] + " / " + "data39="+data[39] + " / " + "data40="+data[40]);
		}
	}

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

}
