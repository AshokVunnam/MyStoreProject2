package com.MyStore2.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore2.base.BaseClass;
import com.MyStore2.pageObjects.AddToCartPage;
import com.MyStore2.pageObjects.AddressPage;
import com.MyStore2.pageObjects.IndexPage;
import com.MyStore2.pageObjects.LoginPage;
import com.MyStore2.pageObjects.OrderConfirmationPage;
import com.MyStore2.pageObjects.OrderPage;
import com.MyStore2.pageObjects.OrderSummary;
import com.MyStore2.pageObjects.PaymentPage;
import com.MyStore2.pageObjects.SearchResultPage;
import com.MyStore2.pageObjects.ShippingPage;

public class EndToEndTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary orderSummary;
	OrderConfirmationPage orderConfirmationPage;
	
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
	
	@Test (groups="regression")
	public void validateOrderPage()
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickAddToKart();
		Assert.assertTrue(addToCartPage.validateAddToKart());
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckout();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnCheckout();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnConfirmOrderBtn();
		String orderMsg=orderConfirmationPage.validateConfirmMessage();
		Assert.assertEquals(orderMsg, "Your order on My Store is complete.");
	}

}
