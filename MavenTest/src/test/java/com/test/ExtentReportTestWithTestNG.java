package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.StartBrowser;

public class ExtentReportTestWithTestNG 
{
	public static String browserName;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static String URL;
	public static FileInputStream fis;
	public String projectPath=System.getProperty("user.dir");
	
	@BeforeClass
	public void init() throws IOException
	{
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(projectPath+"\\Report\\First.html");
		extent.attachReporter(spark);
		extent.createTest("ExtentReportTestWithTestNG");
		try {
			fis = new FileInputStream(projectPath+"PropertyFiles\\test.properties");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeSuite
	public void intilization()
	{
		Properties prop = new Properties();
		try 
		{
			prop.load(fis);
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StartBrowser.BrowserFactory(prop.getProperty("browsername"));
		driver.get(URL);
	}
	
	
	
	
	
	
	
	
}
