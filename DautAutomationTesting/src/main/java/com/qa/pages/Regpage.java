package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.testbase.Testbase;

public class Regpage extends Testbase{
//	@FindBy(xpath="//*[@id='section']/div/h2") WebElement Register;
	@FindBy(xpath="//input[@placeholder='First Name']") WebElement FName;
	@FindBy(xpath="//input[@placeholder='Last Name']") WebElement LName;
	@FindBy(xpath="//*[@id='basicBootstrapForm']/div[2]/div/textarea") WebElement Address;
	@FindBy(xpath="//input[@type='email']") WebElement Email;
	@FindBy(xpath="//input[@type='tel']") WebElement Phone;
	@FindBy(xpath="//*[@value='Male']")WebElement Gender;
	@FindBy(xpath="//*[@id='checkbox1']") WebElement Hobbies;
//	@FindBy(xpath="//*[@id='msdd']")WebElement Languages;
	@FindBy(xpath="//*[@id='Skills']") WebElement Skills;
	@FindBy(xpath="//*[@id='countries']")WebElement Country;
	@FindBy(xpath="//*[@id='basicBootstrapForm']/div[10]/div/span/span[1]/span") WebElement sCountry;
	@FindBy(xpath="//*[@id='yearbox']")WebElement Ybox;
	@FindBy(xpath="//*[@id='basicBootstrapForm']/div[11]/div[2]/select") WebElement Month;
	@FindBy(xpath="//*[@id='daybox']")WebElement Day;
	@FindBy(xpath="//*[@id='firstpassword']")WebElement Fpwd;
	@FindBy(xpath="//*[@id='secondpassword']")WebElement Spwd;
	@FindBy(xpath="//*[@id='imagesrc']") WebElement Browse;
    @FindBy(xpath="//*[@id='submitbtn']")WebElement SignUp;
   
  
public  Regpage()
{
PageFactory.initElements(driver, this);
}

public  String verifyPageTitle()
{
return driver.getTitle();
}

public String verifyRegisterForm()
{
	return driver.getTitle();
}
 
public void createNewReg(String ftName,String ltName,String ads,String emailAd,String phone,String gender,String hobbies,
		String lang,String skills,String con,String sCon,String ybox,String month,String day,String fpwd,String spwd,String browse)
{
	FName.sendKeys(ftName);
	LName.sendKeys(ltName);
	Address.sendKeys(ads);
	Email.sendKeys(emailAd);
	Phone.sendKeys(phone);
	Gender.click();
	Hobbies.click();
//	Languages.sendKeys(lang);
	Select sel1=new Select(driver.findElement(By.id("Skills")));
	sel1.selectByVisibleText(skills);
	Select sel2= new Select(driver.findElement(By.id("countries")));
	sel2.selectByVisibleText(con);
	driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[10]/div/span/span[1]/span")).sendKeys(sCon);
	Select sel3= new Select(driver.findElement(By.id("yearbox")));
	sel3.selectByVisibleText(ybox);
	Select sel4= new Select(driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[11]/div[2]/select")));
	sel4.selectByVisibleText(month);
	Select sel5= new Select(driver.findElement(By.id("daybox")));
	sel5.selectByVisibleText(day);
	Fpwd.sendKeys(fpwd);
	Spwd.sendKeys(spwd);
	Browse.sendKeys(browse);
	SignUp.click();
			
	
	
}
}
