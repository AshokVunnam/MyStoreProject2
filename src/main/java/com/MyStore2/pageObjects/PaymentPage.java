package com.MyStore2.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore2.actionDriver.Action;
import com.MyStore2.base.BaseClass;

public class PaymentPage extends BaseClass{
	
	@FindBy (xpath="//a[@class='bankwire']")
	WebElement bankWireMethod;
	
	@FindBy (xpath="//a[contains(text(),'Pay by check']")
	WebElement payByCheckMethod;
	
	public PaymentPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummary clickOnPaymentMethod()
	{
		Action.click(driver, bankWireMethod);
		return new OrderSummary();
	}

}
