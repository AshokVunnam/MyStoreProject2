package com.MyStore2.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore2.base.BaseClass;
import com.MyStore2.pageObjects.AddToCartPage;
import com.MyStore2.pageObjects.IndexPage;
import com.MyStore2.pageObjects.OrderPage;
import com.MyStore2.pageObjects.SearchResultPage;

public class OrderPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
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
	
	@Test (groups="regression")
	public void validateOrderPage()
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickAddToKart();
		Assert.assertTrue(addToCartPage.validateAddToKart());
		orderPage=addToCartPage.clickOnCheckOut();
		double unitPrice=orderPage.getUnitPrice();
		double totalPrice=orderPage.getTotalPrice();
		double expectedPrice=(unitPrice*2)+2;
		Assert.assertEquals(totalPrice, expectedPrice);
		
	}

}
