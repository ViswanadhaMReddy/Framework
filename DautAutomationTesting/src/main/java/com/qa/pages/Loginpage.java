package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.testbase.Testbase;

public class Loginpage extends Testbase{

	@FindBy(xpath="//input[@id='email']") WebElement Emailid;
	@FindBy(xpath="//img[@id='enterimg']") WebElement Enter;
	@FindBy(xpath="//img[@id='logo']") WebElement ATlogo;
	
	public Loginpage()
	{
	PageFactory.initElements(driver, this);
		}
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateATImage()
	{
		return ATlogo.isDisplayed();
	}
	
	
	public Regpage Emailid(String eid)
	{
		Emailid.sendKeys(eid);
	    Enter.click();
	return new Regpage();
	}
	}
		
	

