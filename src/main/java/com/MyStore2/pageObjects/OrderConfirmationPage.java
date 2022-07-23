package com.MyStore2.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore2.actionDriver.Action;
import com.MyStore2.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	
	@FindBy (xpath="//*[@id='center_column']//p/strong")
	WebElement confirmMessag;
	
	public OrderConfirmationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateConfirmMessage()
	{
		//return Action.isDisplayed(driver, confirmMessag);
		String confirmMsg=confirmMessag.getText();
		return confirmMsg;
	}

}
