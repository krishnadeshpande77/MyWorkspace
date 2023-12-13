package com.basic;

import io.restassured.path.json.JsonPath;

public class ReuseableMethods
{
	public static JsonPath rawToJson(String filepath)
	{
		JsonPath js = new JsonPath(filepath);
		return js;
	}
}
