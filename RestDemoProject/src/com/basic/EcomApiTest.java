package com.basic;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.pojo.LoginRequest;
import com.pojo.LoginResponse;
import com.pojo.OrderDetails;
import com.pojo.Orders;

public class EcomApiTest 
{
	public static void main(String[] args) 
	{
		RequestSpecification request =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		LoginRequest login = new LoginRequest();
		login.setUserEmail("krishnadeshpande77@gmail.com");
		login.setUserPassword("Gaju3333#");
		
		RequestSpecification requestLogin =given().relaxedHTTPSValidation().log().all().spec(request).body(login);
		LoginResponse loginresponse = requestLogin.when().post("/api/ecom/auth/login").then().log().all().extract().response().as(LoginResponse.class);
		String token =loginresponse.getToken();
		//add product
		RequestSpecification addProductBaserequest =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("authorization", token).build();
		RequestSpecification requestaddProduct=given().log().all().spec(addProductBaserequest).param("productName", "Laptop").param("productAddedBy", loginresponse.getUserID()).param("productCategory", "fashion").
		param("productSubCategory", "shirts").param("productPrice", "11500").param("productDescription", "Lenova").param("productFor", "men").
		multiPart("productImage",new File("Anyimgpath"));
		String addProductResponce =requestaddProduct.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
		JsonPath js = ReuseableMethods.rawToJson(addProductResponce);
		String productID = js.get("productId");
		//create Order
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setCountry("India");
		orderDetails.setProductOrderedId(productID);
		List<OrderDetails> orderdetailslist = new ArrayList<>();
		orderdetailslist.add(orderDetails);
		Orders orders = new Orders();
		orders.setOrders(orderdetailslist);
		RequestSpecification createOrderBaserequest =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("authorization", token).
				setContentType(ContentType.JSON).build();
		RequestSpecification createOrderrequest=given().log().all().spec(createOrderBaserequest).body(orders);
		String createOrderResponse = createOrderrequest.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
		//DeleteProduct
		RequestSpecification deleteOrderBaserequest =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("authorization", token).
				setContentType(ContentType.JSON).build();
		RequestSpecification deleteProdectReq =  given().log().all().spec(deleteOrderBaserequest).pathParam("productID", productID);
		String responsedelete = deleteProdectReq.when().delete("/api/ecom/product/delete-product/{productID}").then().extract().response().asString();
		JsonPath js1 =ReuseableMethods.rawToJson(responsedelete);
		Assert.assertEquals("Product Deleted Successfully", js1.get("message"));
		
	}
}
