package com.MyStore2.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore2.base.BaseClass;
import com.MyStore2.pageObjects.HomePage;
import com.MyStore2.pageObjects.IndexPage;
import com.MyStore2.pageObjects.LoginPage;

public class HomePageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod (groups={"smoke", "sanity", "regression"})
	public void setup(String browser)
	{
		launchApp(browser);
	}
	
	@AfterMethod (groups={"smoke", "sanity", "regression"})
	public void teardown()
	{
		driver.quit();
	}
	
	@Test (groups="smoke")
	public void wishListTest()
	{
		indexPage = new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.validateMyWishlist());
	}
	
	@Test (groups="smoke")
	public void orderHistoryAndDetails()
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.validateOrderHistory());
		
	}

}
