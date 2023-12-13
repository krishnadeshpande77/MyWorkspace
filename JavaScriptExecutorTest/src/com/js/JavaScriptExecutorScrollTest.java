package com.js;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;




public class JavaScriptExecutorScrollTest 
{
	
	public  static void main(String [] args)
	{
		ChromeOptions option = new ChromeOptions();
		
		//WebDriverManager.chromedriver().browserVersion("114.0.0").setup();
		WebDriver driver =  new ChromeDriver(option);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			
		}
		WebElement closebtn = driver.findElement(By.xpath("//div[@class='JFPqaw']/span[@role='button']"));
		closebtn.click();
		WebElement lbl_HomeFur = driver.findElement(By.xpath("//h2[text()='Home and Furniture']"));
		JavascriptExecutor js  = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", lbl_HomeFur);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scrfile = ts.getScreenshotAs(OutputType.FILE);
		File destpath = new File("D:\\Testing\\img0.jpeg");
		try {
			FileUtils.copyFile(scrfile, destpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
		
	}
	
	
	
		
	
}
