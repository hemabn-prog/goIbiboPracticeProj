package com.goibibo.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.goibibo.qa.base.TestBase;

public class TestUtil extends TestBase {
	


	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	static Workbook book;
	static Sheet sheet;
		
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT =30;
	public static String TEST_DATA_PATH= "C:/work/eclipse-ws/GoIBibo/src"
			+ "/main/java/com/goibibo/qa/testdata/TestData.xlsx";
	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("authiframe");
	}

	public static void takeScreenshot(String methodname) throws IOException
	{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir = System.getProperty("user.dir");
		FileUtils.copyFile(srcfile, new File(currentdir+"/screenshots/"+methodname+".jpg"));
	}
	
	
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(TEST_DATA_PATH);
		sheetName="TestData-Monday";
		book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetName);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	
}
