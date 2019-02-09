package com.qa.testutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.testbase.Testbase;

public class Testutil extends Testbase{
	
	public static String TESTDATA_SHEET_PATH="E:/TestMaven/DautAutomationTesting/src/main/java/com/qa/testdata/TestAut.xlsx";	

	static Workbook  book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream fis=null;
		try
		{
			fis= new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book=WorkbookFactory.create(fis);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		 catch(NullPointerException e)
		{
			 e.printStackTrace();
		}
		
		
		sheet = book.getSheet(sheetName);
		
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum(); k++)
			{
				data[i][k]=sheet.getRow(i + 1).getCell(k).toString();
								
			}
	}
		
return data;
		}
}

	
/*File f = new File("E:/TestMaven/DautAutomationTesting/src/main/java/com/qa/testdata/TestAut.xlsx");
Workbook wb= WorkbookFactory.create(f);
Sheet s =wb.getSheet("sheet1");
int rowCount=s.getLastRowNum();
for (int i=0;i<=rowcount;i++)
{
	Row r=s.getRow(i);
int colCount=r.getLastCellNum();
String data =" ";
for (int j=0;j<=colCount; j++)
{
if (s.getRow(i).getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int celldata=(int)(s.getRow(0).getCell(0).getNumericCellValue());
			data= String.valueOf(celldata);
		}
		else
		{
			data=String.getRow(i).getCell(j).getStringCellValue();
		}
	
	}*/


	
			




	




