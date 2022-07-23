package com.MyStore2.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore2.actionDriver.Action;
import com.MyStore2.base.BaseClass;

public class AddToCartPage extends BaseClass{

	@FindBy (id="quantity_wanted")
	WebElement quantity;
	
	@FindBy (xpath="//select[@id='group_1']")
	WebElement size;
	
	@FindBy (xpath="//button[@name='Submit']")
	WebElement addToKartBtn;
	
	@FindBy (xpath="//*[@id='layer_cart']//h2/i")
	WebElement addToCartMessg;
	
	@FindBy (xpath="//*[@id=\"layer_cart\"]//a/span")
	WebElement proceedToCheckoutBtn;
	
	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean enterQuantity(String Quantity1)
	{
		return Action.type(quantity, Quantity1);
	}
	
	public boolean selectSize(String size1)
	{
		return Action.selectByVisibleText(size, size1);
	}
	
	public void clickAddToKart()
	{
		Action.click(driver, addToKartBtn);
	}
	
	public boolean validateAddToKart()
	{
		Action.fluentWait(driver, addToCartMessg, 10);
		return Action.isDisplayed(driver, addToCartMessg);
	}
	
	public OrderPage clickOnCheckOut()
	{
		
		Action.click(driver, proceedToCheckoutBtn);
		return new OrderPage();
	}
	
	
	
	
	
}
