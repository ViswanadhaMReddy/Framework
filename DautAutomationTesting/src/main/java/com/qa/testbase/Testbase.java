package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;

public Testbase()
{
	try
	{
	prop= new Properties();
	FileInputStream fis = new FileInputStream("E:/TestMaven/DautAutomationTesting/src/main/java/com/qa/config/config.properties");
	prop.load(fis);
	}
	catch(FileNotFoundException e)
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
}


public static void initialization()
{
String browserName = prop.getProperty("browser");
if(browserName.equalsIgnoreCase("chrome"))
{
System.setProperty("webdriver.chrome.driver","C:/Selenium Chrome Driver/chromedriver.exe");
driver= new ChromeDriver();
}
else
if(browserName.equalsIgnoreCase("firefox"))
{
System.setProperty("WebDriver.gecko.driver", "C:/Users/lenovo/Downloads/geckodriver.exe");
driver= new FirefoxDriver();
}

driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
driver.get(prop.getProperty("url"));



}
}

