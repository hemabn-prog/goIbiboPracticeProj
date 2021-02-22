package com.goibibo.qa.pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.goibibo.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath = "//a[@class='hdrLogo']")
	WebElement logo;
	
	@FindBy(xpath  = "//span[@id='oneway']")
	WebElement tripField;

	@FindBy(id = "gosuggest_inputSrc")
	WebElement fromField;

	@FindBy(id = "gosuggest_inputDest")
	WebElement toField;
		
	@FindBy(id = "departureCalendar")
	WebElement departCalendar;
	
	@FindBy(xpath  = "//span[@id='pax_label']")
	WebElement travellerField;
	
	@FindBy(xpath = "//button[@id='adultPaxPlus']")
	WebElement adultPlus;
	
	@FindBy(xpath = "//button[@id='childPaxPlus']")
	WebElement childPlus;
	
	@FindBy(xpath = "//select[@id='gi_class']")
	WebElement travelClass;
	
	@FindBy(id = "gi_search_btn")
	WebElement searchbtn;
	
	@FindBy(css = "[class*='white ico']")
	WebElement promoOffersText;
	
	@FindBy(linkText = "VIEW ALL PRODUCTS")
	WebElement prodbtn;
	
	
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public void bookFlight(String from, String to) throws InterruptedException
	{
		tripField.click();
		fromField.sendKeys(from);
		Thread.sleep(2000L);
		fromField.sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
		toField.sendKeys(to);
		Thread.sleep(2000L);
		for(int i=0;i<3;i++)
		{
			toField.sendKeys(Keys.ARROW_DOWN);
		}
		toField.sendKeys(Keys.RETURN);
	}
	
	public void calendar() 
	{
		while(!driver.findElement(By.cssSelector("[class='DayPicker-Caption']")).getText().contains("January"))
		{
		driver.findElement(By.cssSelector("[class='DayPicker-NavBar'] span[class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.className("calDate"));
		int count = dates.size();
		
		for(int i=0;i<count;i++)
		{
			String desireddate = driver.findElements(By.className("calDate")).get(i).getText();
			
			if(desireddate.equalsIgnoreCase("15"))
			{
				driver.findElements(By.className("calDate")).get(i).click();
				break;
			}
		}
	}
	
	public void travellersDetail()
	{
		travellerField.click();
		for (int i=0;i<3;i++)
		{
			adultPlus.click();
		}
		childPlus.click();
		Select s = new Select(travelClass);
		s.selectByVisibleText("First class");
	}
	
	public SearchPage searchPage()
	{
		searchbtn.click();		
		return new SearchPage();
	}
	
	public void promo()
	{
		prodbtn.click();
		
	}
	
}
