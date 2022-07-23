package com.MyStore2.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore2.actionDriver.Action;
import com.MyStore2.base.BaseClass;

public class SearchResultPage extends BaseClass{
	
	@FindBy (xpath="//*[@id='center_column']//img")
	WebElement productResult;
	
	public SearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable()
	{
		return Action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnProduct()
	{
		Action.click(driver, productResult);
		return new AddToCartPage();
	}

}
