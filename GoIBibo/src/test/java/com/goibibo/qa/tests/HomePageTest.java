package com.goibibo.qa.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.pages.HomePage;
import com.goibibo.qa.pages.SignUpPage;
import com.goibibo.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	HomePage homePage;
	public HomePageTest() throws IOException {
		super();
		
	}

	@BeforeMethod()
	public void setUp() throws IOException  
	{
		initialization();
		homePage = new HomePage();
	}
	
	
	@Test
	public void logoValidationTest()
	{
		homePage.validateLogo();
		homePage.validateTitle();
	}
	
	@Test
	public void flightBookTest() throws InterruptedException
	{
		homePage.bookFlight(prop.getProperty("from"), prop.getProperty("to"));
		homePage.calendar();
		homePage.travellersDetail();
		homePage.searchPage();
	}
	
	@Test
	public Object[][] getTestData() throws FileNotFoundException
	{
		Object data[][] = TestUtil.getTestData("TestData-Monday");
		return data;
	}
	
	
	@Test
	public void advTest()
	{
		homePage.promo();
	}
	
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
}
