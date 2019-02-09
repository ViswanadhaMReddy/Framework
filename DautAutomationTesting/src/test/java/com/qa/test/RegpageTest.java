package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.Loginpage;
import com.qa.pages.Regpage;
import com.qa.testbase.Testbase;
import com.qa.testutil.Testutil;

public class RegpageTest extends Testbase{
	Loginpage loginpage;
	Regpage regpage;
	Testutil testutil;
	String sheetName="Sheet1";
	
	public RegpageTest()
	{
	super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new Loginpage();
		regpage= new Regpage();
		testutil= new Testutil();
		regpage=loginpage.Emailid(prop.getProperty("emailid"));
		
	}

	@Test(priority=1)
	public void verifyResgisterPageTitleTest()
	{
		String RegTitle =regpage.verifyPageTitle();
		Assert.assertEquals(RegTitle, "Register");
	}
		
	@DataProvider
	public Object[][] getATTestData()
	{
		Object data[][]=Testutil.getTestData(sheetName);
		return data;
	}
	
    @Test(priority=2,dataProvider="getATTestData") 
	public void validateCreateNewReg(String FirstName,String LastName,String Address,String EmailAddress,String Phone,String Gender,String Hobbies,String Languages,
			String Skills, String Con,String sCon,String Ybox,String Month,String Day,String Fpwd,String Spwd ,String Browse )
	{
		regpage.createNewReg(FirstName, LastName, Address, EmailAddress, Phone, Gender, Hobbies, Languages, Skills, Con, sCon, Ybox, Month, Day, Fpwd, Spwd ,Browse);
		
	}
	
//@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}
}
