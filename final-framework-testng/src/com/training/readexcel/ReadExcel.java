package com.training.readexcel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.testng.annotations.DataProvider;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {
	
	public String[][] getExcelData(String testdata1, String data) 
	   {
			String[][] arrayExcelData = null;
			try 
			{
				FileInputStream fs = new FileInputStream(testdata1);
				Workbook wb = Workbook.getWorkbook(fs);
				Sheet sh = wb.getSheet(data);

				int totalNoOfCols = sh.getColumns();
				int totalNoOfRows = sh.getRows();
				System.out.println("Total Number Of Rows : " +totalNoOfRows);
				System.out.println("Number of Cols " + totalNoOfCols);
				
				arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
				
				for (int i= 1 ; i < totalNoOfRows; i++) 
				{
					for (int j=0; j < totalNoOfCols; j++) 
					{
						arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
					}
				}
			}catch (IOException | BiffException e) 
			{
				e.printStackTrace();
			}
			return arrayExcelData;
		}

	// Test method, change the path of the .xls file 
	public static void main(String[] args) throws Exception {
		//String[][] result = new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	
		String[][] result = new ReadExcel().getExcelData("C:/Users/ShriSuganthi/git/IBMProject1/final-framework-testng/src/com/training/dataproviders/testdata1.xlsx","data");
		for(String [] temp : result){
			for(String temp1: temp){
				System.out.println(temp1);
				
				/*
				 * File src=new File(
				 * "C:\\Users\\ShriSuganthi\\git\\IBMProject1\\final-framework-testng\\src\\com\\training\\dataproviders\\testdata1.xlsx")
				 * ; FileInputStream fis = new FileInputStream(src); XSSFEvaluationWorkbook wb =
				 * XSSFWorkbook(fis);
				 */
		
			}
		}
	}

	/*
	 * private static XSSFEvaluationWorkbook XSSFWorkbook(FileInputStream fis) { //
	 * TODO Auto-generated method stub return null; }
	 */

	
}
