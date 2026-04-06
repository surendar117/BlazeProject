package com.utility;

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static String getSingleExcelData(int rowNum, int colNum) {
		String data = null;
		try {
			File file = new File("C:\\Users\\ajith\\Desktop\\JAVA SELENIUM\\EXCEL\\DataDriven_IPT.xlsx");
			Workbook book = new XSSFWorkbook(file);

			Sheet sheet = book.getSheet("Sheet2");
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(colNum);
//			DataFormatter dataFormat = new DataFormatter();
//			String data = dataFormat.formatCellValue(cell);
			data = cell.getStringCellValue();
			System.out.println(data);

		} catch (Exception e) {
		}
		return data;

	}

	public static void getAllExcelData() {

		try {
			File file = new File("C:\\Users\\ajith\\Desktop\\JAVA SELENIUM\\EXCEL\\DataDriven_IPT.xlsx");
			Workbook book = new XSSFWorkbook(file);

			Sheet sheet = book.getSheet("Sheet2");
			int rowNum = sheet.getLastRowNum();
			short colNum = sheet.getRow(0).getLastCellNum();
			System.out.println(rowNum + " " + colNum);
			for (int i = 0; i <= rowNum; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < colNum; j++) {
					Cell cell = sheet.getRow(i).getCell(j);
					DataFormatter data = new DataFormatter();
					String values = data.formatCellValue(cell);
					System.out.println(values);
				}
			}
			// String data = cell.getStringCellValue();
			// System.out.println(data);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

//	public static void main(String[] args) {
//		
//	    getSingleExcelData();
//		getAllExcelData();
//		
//	}

}
