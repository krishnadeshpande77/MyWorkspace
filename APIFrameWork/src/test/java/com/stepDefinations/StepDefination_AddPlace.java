package com.stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import com.api.resources.ApiResources;
import com.api.resources.TestDataBuild;
import com.api.resources.Utils;
import com.pojoClasses.*;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class StepDefination_AddPlace extends Utils
{
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response ;
	TestDataBuild testdatabuild = new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload(String name , String language , String address) throws Exception 
	{	
		 res=given().spec(requestSpecification()).body(testdatabuild.addPlacePayload(name , language , address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource,String httpMethodName) {
		ApiResources apiResources = ApiResources.valueOf(resource);
		resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(httpMethodName.equalsIgnoreCase("POST"))
			    response =res.when().post(apiResources.getResources());
		else if((httpMethodName.equalsIgnoreCase("GET")))
				response =res.when().get(apiResources.getResources());
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	   assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyval, String Expectedvalue) {
	   
	   assertEquals(getJsonPath(response, keyval),Expectedvalue);
	}
	
	@Then("Verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String httpMethodName) throws Exception
	{
		String place_id = getJsonPath(response, "place_id");
		res=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_post_http_request(httpMethodName,"GET");
		String actualname = getJsonPath(response, "name");
		assertEquals(actualname,expectedname);
	}
}
