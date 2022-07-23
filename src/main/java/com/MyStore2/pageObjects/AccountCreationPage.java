package com.MyStore2.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore2.actionDriver.Action;
import com.MyStore2.base.BaseClass;

public class AccountCreationPage extends BaseClass{
	
	@FindBy (xpath="//h1[text()='Create an account']")
	WebElement formTitle;
	
	@FindBy(id = "id_gender1")
	private WebElement mr;
	
	@FindBy(id = "id_gender2")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(name = "customer_lastname")
	private WebElement lastName;

	@FindBy(name = "passwd")
	private WebElement passWord;

	@FindBy(name = "days")
	private WebElement days;

	@FindBy(name = "months")
	private WebElement months;

	@FindBy(name = "years")
	private WebElement years;

	@FindBy(name = "firstname")
	private WebElement customerNirstName;

	@FindBy(name = "lastname")
	private WebElement customerLastName;

	@FindBy(name = "company")
	private WebElement companyName;

	@FindBy(name = "address1")
	private WebElement address;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "id_state")
	private WebElement state;

	@FindBy(name = "postcode")
	private WebElement postCode;

	@FindBy(name = "id_country")
	private WebElement country;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "phone_mobile")
	private WebElement mobile;

	@FindBy(name = "alias")
	private WebElement ref;

	@FindBy(name = "submitAccount")
	private WebElement registerBtn;
	
	public AccountCreationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year,
			String comPany, 
			String addr, 
			String cityString, 
			String stateName, 
			String zip, 
			String countryName,
			String mobilePhone) throws Throwable {
		
		Action.explicitlyWait(driver, mr, 10);
		
		if(gender.equalsIgnoreCase("Mr")) {
			Action.click(driver, mr);
		} else {
			Action.click(driver, mrs);
		}
		
		Action.type(firstName, fName);
		Action.type(lastName, lName);
		Action.type(passWord, pswd);
		Action.selectByValue(days, day);
		Action.selectByValue(months, month);
		Action.selectByValue(years, year);
		Action.type(companyName, comPany);
		Action.type(address, addr);
		Action.type(city, cityString);
		Action.selectByVisibleText(state, stateName);
		Action.type(postCode, zip);
		Action.selectByVisibleText(country, countryName);
		Action.type(mobile, mobilePhone);
	}
	
	public boolean validateAccountCreationPage()
	{
		Action.fluentWait(driver, formTitle, 20);
		return Action.isDisplayed(driver, formTitle);
	}
	
	public HomePage validateRegistration() throws Throwable {
		registerBtn.click();
		return new HomePage();
	}

}
