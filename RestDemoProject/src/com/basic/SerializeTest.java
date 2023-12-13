package com.basic;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import com.pojo.AddPlace;
import com.pojo.Location;

import io.restassured.RestAssured;

public class SerializeTest 
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
		String response = given().log().all().queryParam("key", "qaclick123").body(add)
		.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
	}
}
