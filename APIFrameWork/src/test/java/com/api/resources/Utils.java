package com.api.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils 
{
	public static RequestSpecification req;
	static String  userDir = System.getProperty("user.dir");
	public static String getGlobalValue(String key) throws FileNotFoundException,IOException
	{
		FileInputStream fis = new FileInputStream(userDir+"\\src\\test\\java\\com\\api\\resources\\GlobalValue.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		return properties.getProperty(key);
	}
	public RequestSpecification requestSpecification() throws Exception
	{
		if(req==null)
		{
			PrintStream log= new PrintStream(new FileOutputStream("logging.txt"));
			req =new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
				return req;
		}
		return req;
	}
	
	public String getJsonPath(Response response,String key)
	{
			 String resp = response.asString();
		     JsonPath js= new JsonPath(resp);
		     return js.get(key).toString();
	}
}
