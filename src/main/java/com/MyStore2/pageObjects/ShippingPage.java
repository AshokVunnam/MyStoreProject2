package com.MyStore2.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore2.actionDriver.Action;
import com.MyStore2.base.BaseClass;

public class ShippingPage extends BaseClass{
	
	@FindBy (xpath="//input[@id='cgv']")
	WebElement checkBox;
	
	@FindBy (xpath="//*[@id='form']/p/button")
	WebElement proceedToCheckout;
	
	public ShippingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkTheTerms()
	{
		Action.click(driver, checkBox);
	}
	
	public PaymentPage clickOnCheckout()
	{
		Action.click(driver, proceedToCheckout);
		return new PaymentPage();
	}

}
