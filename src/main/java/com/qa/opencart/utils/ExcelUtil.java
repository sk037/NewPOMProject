package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	final static String TEST_DATA_PATH="./src/test/resource/TestData/Data.xlsx";
	static Workbook book;
	static Sheet sheet;
	static Object[][] data;
	
	public static Object[][] readData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(TEST_DATA_PATH);
		book=WorkbookFactory.create(fis);
		sheet=book.getSheet(sheetName);
		System.out.println(sheet.getLastRowNum());
		
		data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
			}
			
		}
		return data;
			
		}
	

}
