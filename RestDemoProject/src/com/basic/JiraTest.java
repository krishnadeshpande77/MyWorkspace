package com.basic;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
public class JiraTest 
{
	@Test
	public  void Jira()
	{
		SessionFilter session = new SessionFilter();
		RestAssured.baseURI="http://localhost:8080";
		//login with jira
		String loginres = given().relaxedHTTPSValidation().log().all().header("Content-Type","application/json").body(PayloadJira.Login()).when().filter(session).
		post("/rest/auth/1/session").then().log().all().extract().response().asString();
		//add comments
		String responseOfAddComments = given().pathParam("key","10200").log().all().header("Content-Type","application/json").body(PayloadJira.createComment("Hi This is my new commet Krishna")).
		filter(session).when().post("/rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = ReuseableMethods.rawToJson(responseOfAddComments);
		String commentID = js.getString("id");

		//pasing attachments
		given().header("X-Atlassian-Token","no-check").filter(session).pathParam("key","10200").header("Content-Type","multipart/form-data")
		.multiPart("file",new File("D:\\MyWorkspace\\RestDemoProject\\jira.txt")).
		when().post("/rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
		
		//get issue details
		String res = given().filter(session).pathParam("key", "10200").queryParam("fields", "comment").log().all()
				.when().get("/rest/api/2/issue/{key}").then().log().all().extract().response().asString();
		System.out.println("issue details"+ "   " +res);
		
		JsonPath js1 = ReuseableMethods.rawToJson(res);
		int countofcmts = js1.getInt("fields.comment.comments.size()");
		for(int i = 0; i < countofcmts; i++ )
		{
			
			String issueID = js1.get("fields.comment.comments["+i+"].id").toString();
			if(issueID.equalsIgnoreCase(commentID))
			{
				String messegeBody = js1.get("fields.comment.comments["+i+"].body").toString();
				System.out.println("MsgBody"+messegeBody);
				Assert.assertEquals(messegeBody, "Hi This is my new commet Krishna");
			}
		}
		
		
	}
}
