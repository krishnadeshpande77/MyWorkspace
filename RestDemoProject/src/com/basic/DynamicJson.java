package com.basic;

import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class DynamicJson
{
	String ID="";
	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().log().all().header("Content-Type","application/json").body(Payload.addBook(isbn,aisle))
		.when().post("/Library/Addbook.php").then().log().all().statusCode(200).extract().response().asString();
		JsonPath js = ReuseableMethods.rawToJson(response);
		 ID = js.get("ID");
		System.out.println("BOOK ID"+"       "+ID);
	}
	
	@Test(dataProvider="BooksData")
	  public void DeleteBook(String isbn,String aisle) 
	  { 
		  RestAssured.baseURI="http://216.10.245.166";
		  given().header("Content-Type","application/json").body(Payload.addBook(isbn,aisle))
		  .when().delete("/Library/DeleteBook.php").then().statusCode(200);
		  }
	 
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][] {{"GGG","123545"},{"KKK","7989556"},{"HHH","568656"}};
	}
}
