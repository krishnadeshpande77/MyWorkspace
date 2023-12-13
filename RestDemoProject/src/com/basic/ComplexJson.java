package com.basic;

import io.restassured.path.json.JsonPath;

public class ComplexJson
{
	public static void main(String[] args)
	{
		JsonPath js = new JsonPath(Payload.pricePayload());
		//Return how many course are there
		int countofcourse = js.getInt("courses.size()");
		System.out.println(countofcourse);
		//getting purchase amount of course
		int purchaseamt = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount"+"    "+purchaseamt);
		//print title of first course
		//String titleoffirstcourse = js.get("courses[0].title");
		//System.out.println(titleoffirstcourse);
		//print all the courses title and prices
		for(int i =0 ; i<countofcourse;i++)
		{
			System.out.println(js.get("courses["+i+"].title").toString());
			System.out.println(js.get("courses["+i+"].price").toString());
		}
		System.out.println("Print no of copies sold by RPA");
		for(int i =0 ; i<countofcourse;i++)
		{
			String titles = js.get("courses["+i+"].title").toString();
			if(titles.equalsIgnoreCase("RPA"))
			{
				System.out.println(js.get("courses["+i+"].copies").toString());
				break;
			}
			
		}
	}
}
