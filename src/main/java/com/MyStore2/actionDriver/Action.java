package com.MyStore2.actionDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MyStore2.base.BaseClass;

public class Action extends BaseClass{
	
	public static void click(WebDriver Idriver, WebElement locatorName)
	{
		Actions act=new Actions(Idriver);
		act.moveToElement(locatorName).click().build().perform();
	}
	
	public void implicitWait(WebDriver Idriver, int timeOut)
	{
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public void pageLoadTimeout(WebDriver Idriver, int timeout)
	{
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
	}
	
	public static boolean isDisplayed(WebDriver Idriver, WebElement element)
	{
		boolean flag=false;
		flag=findElement(Idriver, element);
		if(flag)
		{
			flag=element.isDisplayed();
			if(flag)
			{
				System.out.println("Element is displayed at");
			}else {
				System.out.println("Element is not displayed at");
			}
			
		}else {
			System.out.println("Element Not displayed");
		}
		
		return flag;
	}
	
	public static boolean findElement(WebDriver Idriver, WebElement element)
	{
		boolean flag=false;
		try {
			element.isDisplayed();
			flag=true;
		} catch (Exception e) {
			// TODO: handle exception
			flag=false;
		} finally {
			if(flag)
				System.out.println("Able to find element at:");
			else
			{
				System.out.println("Unable to find element at");
			}
		}
		
		return flag;
	}
	
	public static boolean type(WebElement element, String text)
	{
		boolean flag=false;
		try {
			flag=element.isDisplayed();
			Action.explicitlyWait(driver, element, 5);
			element.clear();
			Action.explicitlyWait(driver, element, 5);
			element.sendKeys(text);
		}catch (Exception e) {
			// TODO: handle exception
			flag=false;
			System.out.println("Location Not found");
		}finally {
			if(flag) {
				System.out.println("Successfully Entered Text");
			}
			else {
				System.out.println("Unable to Enter Value");
			}
				
		}
		
		return flag;
	}
	
	
	public static boolean selectByVisibleText(WebElement element, String visibleText)
	{
		boolean flag=false;
		try {
			Select s=new Select(element);
			s.selectByVisibleText(visibleText);
			flag=true;
			return flag;
		}catch (Exception e) {
			// TODO: handle exception
			flag=false;
			return flag;
		}finally {
			if(flag)
				System.out.println("Option selected by visibleText");
			else {
				System.out.println("Option not selected by visibleText");
			}
		}
	}
	
	
	public static void fluentWait(WebDriver Idriver, WebElement element, int timeout)
	{
		Wait<WebDriver> wait=null;
		try {
			wait= new FluentWait<WebDriver>((WebDriver)Idriver)
					.withTimeout(Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void explicitlyWait(WebDriver driver, WebElement element, int timeout)
	{
		WebDriverWait w=new WebDriverWait(driver, timeout);
		w.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public static boolean selectByValue(WebElement element, String value)
	{
		boolean flag=false;
		try {
			Select s=new Select(element);
			s.selectByValue(value);
			flag=true;
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}finally {
			if(flag)
				System.out.println("Option selected by Value");
			else
				System.out.println("Option not selected by Value");
		}
	}
	
	
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
	}
}
