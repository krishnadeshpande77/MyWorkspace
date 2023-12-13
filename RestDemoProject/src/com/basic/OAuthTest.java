package com.basic;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pojo.API;
import com.pojo.GetCourses;
import com.pojo.WebAutomation;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
public class OAuthTest 
{
	public static void main(String[] args) 
	{
		String [] titles = {"Selenium WebDriver Java","Cypress","Protractor"};
		String url = "https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#\";";
		String particalCode = url.split("code=")[1];
		String code = particalCode.split("&scope")[0];
		String accessTokenRes = given().urlEncodingEnabled(false).
		queryParam("code",code).
		queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
		queryParams("grant_type", "authorization_code").
		queryParams("state", "verifyfjdss").
		queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8").
		queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js = new JsonPath(accessTokenRes);
		String accessToken = js.getString("access_token");
		GetCourses gc =  (GetCourses) given().queryParam("access_token",accessToken).expect().defaultParser(Parser.JSON).
				when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourses.class);
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		List<API> listofapicourses = gc.getCourses().getApi();
		for(int i = 0; i<listofapicourses.size(); i++)
		{
			if(listofapicourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices Testing"))
			{
				System.out.println(listofapicourses.get(i).getPrice());
			}
		}
		List<String> l = new ArrayList<String>();
		List<String>c = Arrays.asList(titles);
		List<WebAutomation> wa = gc.getCourses().getWebAutomation();
		for(int i = 0;i<wa.size();i++)
		{
			l.add(wa.get(i).getCourseTitle());
		}
		Assert.assertTrue(l.equals(c));
	}
}
