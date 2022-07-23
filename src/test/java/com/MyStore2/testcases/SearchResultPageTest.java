package com.MyStore2.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore2.base.BaseClass;
import com.MyStore2.dataProvider.DataProviders;
import com.MyStore2.pageObjects.IndexPage;
import com.MyStore2.pageObjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod (groups={"smoke", "sanity", "regression"})
	public void setup(String browser)
	{
		launchApp(browser);
	}
	
	@AfterMethod (groups={"smoke", "sanity", "regression"})
	public void teatdown()
	{
		driver.quit();
	}
	
	@Test (dataProvider = "SearchProduct", dataProviderClass = DataProviders.class, groups="smoke")
	public void productAvailabilityTest(String tshirt)
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct(tshirt);
		Assert.assertTrue(searchResultPage.isProductAvailable());
	}

}
