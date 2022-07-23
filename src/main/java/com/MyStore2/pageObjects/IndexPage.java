package com.MyStore2.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore2.actionDriver.Action;
import com.MyStore2.base.BaseClass;

public class IndexPage extends BaseClass{

	@FindBy (xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy (xpath="//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy (xpath="//input[@name='search_query']")
	WebElement searchProductBox;
	
	@FindBy (name="submit_search")
	WebElement searchButton;
	
	public IndexPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn()
	{
		Action.fluentWait(driver, signInBtn, 20);
		Action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		return Action.isDisplayed(driver, myStoreLogo);
	}
	
	public String getMyStoreTitle()
	{
		String myStoreTitle=driver.getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName)
	{
		Action.type(searchProductBox, productName);
		//Action.explicitlyWait(driver, searchButton, 5);
		Action.fluentWait(driver, searchButton, 10);
		Action.click(driver, searchButton);
		return new SearchResultPage();
	}
}
