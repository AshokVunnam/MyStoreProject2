package com.MyStore2.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore.utility.Log;
import com.MyStore2.base.BaseClass;
import com.MyStore2.dataProvider.DataProviders;
import com.MyStore2.pageObjects.AccountCreationPage;
import com.MyStore2.pageObjects.HomePage;
import com.MyStore2.pageObjects.IndexPage;
import com.MyStore2.pageObjects.LoginPage;

public class AccountCreationTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod (groups={"smoke", "sanity", "regression"})
	public void setup(String browser)
	{
		launchApp(browser);
	}
	
	@AfterMethod (groups={"smoke", "sanity", "regression"})
	public void teardown()
	{
		driver.quit();
	}
	
	
	@Test (priority = 2, dataProvider = "Email", dataProviderClass = DataProviders.class)
	public void verifyCreateAccountPageTest(String email)
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createNewAccount(email);
		Assert.assertTrue(accountCreationPage.validateAccountCreationPage());
	}
	
	@Test (priority = 1, dataProvider = "AccountCreationData", dataProviderClass = DataProviders.class, groups="sanity")
	public void createAccountTest(HashMap<String, String> hashMapValue) throws Throwable
	{
		Log.startTestCase("Create Account Testcase");
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createNewAccount(hashMapValue.get("Email"));
		accountCreationPage.createAccount(hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"),
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone"));
		
		homePage=accountCreationPage.validateRegistration();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homePage.getCurrtUrl());
		Log.endTestCase("createAccountTest");
		
	}

}