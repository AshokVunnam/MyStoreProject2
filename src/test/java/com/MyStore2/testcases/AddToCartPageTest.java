package com.MyStore2.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore2.base.BaseClass;
import com.MyStore2.dataProvider.DataProviders;
import com.MyStore2.pageObjects.AddToCartPage;
import com.MyStore2.pageObjects.IndexPage;
import com.MyStore2.pageObjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	
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
	
	@Test (dataProvider = "ProductDetails", dataProviderClass = DataProviders.class, groups= {"regression", "sanity"})
	public void addToCartTest(String product, String qty, String size)
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct(product);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickAddToKart();
		Assert.assertTrue(addToCartPage.validateAddToKart());
		
	}

}
