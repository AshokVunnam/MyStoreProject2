package com.MyStore2.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore2.actionDriver.Action;
import com.MyStore2.base.BaseClass;

public class OrderPage extends BaseClass{

	@FindBy (xpath="//*[@class='cart_unit']/span")
	WebElement unitPrice;
	
	@FindBy (xpath="//*[@id='total_price']")
	WebElement totalPrice;
	
	@FindBy (xpath="//span[text()=\"Proceed to checkout\"]")
	WebElement proceedToCheckout;
	
	public OrderPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice()
	{
		String price=unitPrice.getText().substring(1);
		double finalUnitPrice=Double.parseDouble(price);
		return finalUnitPrice;
	}
	
	public double getTotalPrice()
	{
		String price=totalPrice.getText().substring(1);
		double finalTotalPrice=Double.parseDouble(price);
		return finalTotalPrice;
	}
	
	public LoginPage clickOnCheckout()
	{
		Action.click(driver, proceedToCheckout);
		return new LoginPage();
	}
	
}
