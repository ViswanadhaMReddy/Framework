package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.Loginpage;
import com.qa.pages.Regpage;
import com.qa.testbase.Testbase;

public class LoginpageTest extends Testbase{

	Loginpage loginpage;
	Regpage regpage;
	
	public LoginpageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new Loginpage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.validatePageTitle();
		Assert.assertEquals(title, "Index");
	}
	
	@Test(priority=2)
	public void  validateATimageTest()
	{
		boolean flag=loginpage.validateATImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LogInTest()
	{
		regpage=loginpage.Emailid(prop.getProperty("emailid"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	}
	
	
