package com.MyStore2.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore2.actionDriver.Action;
import com.MyStore2.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(name="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(xpath="//*[@id='email_create']")
	WebElement emailForNewAccount;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement createNewAccountBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage Login(String uname, String pswd)
	{
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(driver, signInBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String uname, String pswd)
	{
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(driver, signInBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String email)
	{
		Action.fluentWait(driver, emailForNewAccount, 10);
		Action.type(emailForNewAccount, email);
		Action.click(driver, createNewAccountBtn);
		return new AccountCreationPage();
	}
	

}
