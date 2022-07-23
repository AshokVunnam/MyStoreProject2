package com.MyStore2.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore2.base.BaseClass;
import com.MyStore2.pageObjects.IndexPage;

public class IndexPageTest extends BaseClass{
	
	IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod (groups={"smoke", "sanity", "regression"})
	public void setup(String browser)
	{
		launchApp(browser);
	}
	
	@AfterMethod (groups={"smoke", "sanity", "regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test (groups ="smoke")
	public void verifyLogo()
	{
		indexPage=new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test (groups="smoke")
	public void verifyTitle()
	{
		indexPage=new IndexPage();
		String actualTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actualTitle, "My Store");
		
	}

}
