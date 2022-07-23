/**
 * 
 */
package com.MyStore2.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore2.actionDriver.Action;
import com.MyStore2.base.BaseClass;

/**
 * @author Labuser
 *
 */
public class HomePage extends BaseClass{
	
	@FindBy (xpath = "//a[@title='My wishlists']")
	WebElement myWishlist;
	
	@FindBy (xpath="//a[@title='Orders']")
	WebElement orderHistory;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyWishlist()
	{
		return Action.isDisplayed(driver, myWishlist);
	}
	
	public boolean validateOrderHistory()
	{
		return Action.isDisplayed(driver, orderHistory);
	}
	
	public String getCurrtUrl()
	{
		String homePageUrl =driver.getCurrentUrl();
		return homePageUrl;
	}

}
