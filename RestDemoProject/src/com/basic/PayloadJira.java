package com.basic;

public class PayloadJira 
{
	public static String Login()
	{
		return"{ \"username\": \"deshpandekrishna72\", \"password\": \"Gaju9090#\" }";
	}
	
	public static String createComment(String cmt)
	{
		return "{\r\n"
				+ "    \"body\": \""+cmt+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}";
	}
}
