package com.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser 
{
	public static WebDriver driver;
	
	public static WebDriver getChromeBrowser()
	{
		WebDriverManager.chromedriver().browserVersion("114.0.0").setup();
		return new ChromeDriver();
	}
	
	public static WebDriver getFirefoxBrowser()
	{
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
	
	public static WebDriver getEdgeBrowser()
	{
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	}
	
	public static WebDriver BrowserFactory(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			 driver = getChromeBrowser();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			 driver = getFirefoxBrowser();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			 driver = getEdgeBrowser();
		}
		else
		{
			System.out.println("Enter Correct Choice");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return driver;	
	}
}
