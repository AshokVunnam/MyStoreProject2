package com.MyStore2.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore2.actionDriver.Action;
import com.MyStore2.base.BaseClass;

public class OrderSummary extends BaseClass {

	@FindBy (xpath="//*[@id='cart_navigation']/button")
	WebElement confirmOrderBtnElement;
	
	public OrderSummary()
	{
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrderBtn()
	{
		Action.click(driver, confirmOrderBtnElement);
		return new OrderConfirmationPage();
	}
}
