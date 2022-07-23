package com.MyStore2.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore.utility.Log;
import com.MyStore2.base.BaseClass;
import com.MyStore2.dataProvider.DataProviders;
import com.MyStore2.pageObjects.HomePage;
import com.MyStore2.pageObjects.IndexPage;
import com.MyStore2.pageObjects.LoginPage;

public class LoginPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
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
	
	@Test (dataProvider = "Credentials", dataProviderClass = DataProviders.class, groups={"smoke", "sanity"})
	public void loginTest(String uname, String pswd)
	{
		Log.startTestCase("LoginTest");
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		Log.info("Clicked on SignIn button");
		
		//homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.Login(uname, pswd);
		Log.info("Entered username and password");
		String actualUrl=homePage.getCurrtUrl();
		String expectedUrl="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.endTestCase("LoginTest");
	}
	
	
}
