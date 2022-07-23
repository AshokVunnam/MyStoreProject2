package com.MyStore2.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore2.actionDriver.Action;
import com.MyStore2.base.BaseClass;

public class AddressPage extends BaseClass{

	@FindBy (xpath="//button[@name='processAddress']")
	WebElement proceedToCheckOut;
	
	public AddressPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ShippingPage clickOnCheckOut()
	{
		Action.click(driver, proceedToCheckOut);
		return new ShippingPage();
	}
}
