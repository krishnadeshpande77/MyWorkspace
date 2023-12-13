package com.basic;

public class Payload 
{
	public static String pricePayload()
	{
		return"{\r\n"
				+ "\"dashboard\":{\r\n"
				+ "	\"purchaseAmount\":1510,\r\n"
				+ "	\"website\":\"www.rahulshetty.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\":\r\n"
				+ "[{\r\n"
				+ "\"title\":\"selenium python\",\r\n"
				+ "\"price\":50,\r\n"
				+ "\"copies\":6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\":\"cypress\",\r\n"
				+ "\"price\":40,\r\n"
				+ "\"copies\":4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\":\"RPA\",\r\n"
				+ "\"price\":45,\r\n"
				+ "\"copies\":10\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\":\"Java\",\r\n"
				+ "\"price\":60,\r\n"
				+ "\"copies\":10\r\n"
				+ "}]	\r\n"
				+ "}";
	}
	
	public static String addBook(String isbn,String aisle)
	{
		String bodyofjson ="{\r\n"
				+ "    \"name\":\"Automation With Java\",\r\n"
				+ "    \"isbn\":\""+isbn+"\",\r\n"
				+ "    \"aisle\":\""+aisle+"\",\r\n"
				+ "    \"author\":\"John foe\"\r\n"
				+ "\r\n"
				+ "}";
		return bodyofjson;
	}
}
