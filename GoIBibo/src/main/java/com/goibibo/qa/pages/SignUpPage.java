package com.goibibo.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goibibo.qa.base.TestBase;

public class SignUpPage extends TestBase{

	HomePage homePage;
	
	public SignUpPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="get_sign_up")
	WebElement signupLink;
	
	@FindBy(xpath = "//input[contains(text(),'Enter Mobile Number']")
	WebElement authNum;
	
	@FindBy(xpath ="//button[contains(text(),'Continue']")
	WebElement continuebtn;
	
	public void signUp()
	{
		signupLink.click();
	}
	
	public HomePage mobileEnter()
	{
		authNum.sendKeys(prop.getProperty("mobnum"));
		continuebtn.click();
		return homePage;
	}
	
}
