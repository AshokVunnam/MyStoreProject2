package com.MyStore2.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.MyStore.utility.ExtentManager;
import com.MyStore2.actionDriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite (groups={"smoke", "sanity", "regression"})
	public void loadConfig()
	{
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop=new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
			System.out.println("driver: "+driver);
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void afterSuite()
	{
		ExtentManager.endReport();
	}
	
	
	public static void launchApp(String browserName)
	{
		WebDriverManager.chromedriver().setup();
		//String browserName=prop.getProperty("browser");
		
		if(browserName.contains("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.contains("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.contains("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}
	
	

}
