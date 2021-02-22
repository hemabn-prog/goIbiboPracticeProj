package com.goibibo.qa.tests;


import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.pages.SignUpPage;
import com.goibibo.qa.util.TestUtil;

public class SignUpPageTest extends TestBase{

	SignUpPage signUp;
	TestUtil testUtil;
	
	public SignUpPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException 
	{
		initialization();
		 signUp = new SignUpPage();
		 testUtil = new TestUtil();
	}
	
	@Test
	public void validateSignUpTest()
	{
		
		signUp.signUp();
		Set<String> handler= driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentid = it.next();
		System.out.println(parentid);
		String childid = it.next();
		System.out.println(childid);
		driver.switchTo().window(childid);
		//testUtil.switchToFrame();
		signUp.mobileEnter();
	}
	
	
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
