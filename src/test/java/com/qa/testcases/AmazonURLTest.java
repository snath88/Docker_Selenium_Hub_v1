package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class AmazonURLTest extends TestBase{
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser)
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			initialization_chrome();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			initialization_firefox();
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			initialization_edge();
		}
	}
	
	@Test
	public void TitleTest()
	{
		driver.get("https://www.amazon.co.uk/");
		String title= driver.getTitle();
		Assert.assertEquals(title, "Amazon555.co.uk: Low Prices in Electronics, Books, Sports Equipment & more");
	}

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
