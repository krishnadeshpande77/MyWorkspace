package com.stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

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
	
	@Given("Add Place Payload")
	public void add_place_payload() 
	{	
		 resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 res=given().spec(requestSpecification()).body(testdatabuild.addPlacePayload());
	}

	@When("user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {
		 response =res.when().post("/maps/api/place/add/json").then().spec(resspec).extract().response();
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	   assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyval, String Expectedvalue) {
	   String res = response.asString();
	   JsonPath js= new JsonPath(res);
	   assertEquals( js.get(keyval).toString(),Expectedvalue);
	}
	
}
