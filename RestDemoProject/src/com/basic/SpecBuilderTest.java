package com.basic;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import com.pojo.AddPlace;
import com.pojo.Location;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilderTest 
{
	public static void main(String[] args)
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		AddPlace add = new AddPlace();
		add.setAccuracy(50);
		add.setName("Frontline house");
		add.setPhone_number("(+91) 983 893 3937");
		add.setAddress("29, side layout, cohen 09");
		add.setLanguage("French-IN");
		add.setWebsite("https://rahulshettyacademy.com");
		List<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shoe");
		add.setTypes(mylist);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		add.setLocation(l);
		RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();
		ResponseSpecification resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		RequestSpecification res=given().spec(req).body(add);
		Response response =res.when().post("/maps/api/place/add/json").then().spec(resspec).extract().response();
		System.out.println(response.asString());
	}
}
