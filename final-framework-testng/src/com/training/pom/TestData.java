package com.training.pom;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData  {

	public static String[][] provideData(String getdata){
		String[][] data= null;
	try {

	XSSFWorkbook workBook=new XSSFWorkbook("./"+getdata+".xlsx");
	XSSFSheet workSheet=workBook.getSheetAt(0);

	int rowCount=workSheet.getLastRowNum();
	int columnCount=workSheet.getRow(0).getLastCellNum();
	data=new String[rowCount][columnCount];
	for(int i=1;i<=rowCount;i++) {
		for(int j=0;j<columnCount;j++) {
			try {
			String cellValue=workSheet.getRow(i).getCell(j).getStringCellValue();
			data[i-1][j]=cellValue;
			}
			catch(Exception e) {}
			}
	}
//	workBook.close():
	}
	catch(Exception e) {}
	return data;

}

}