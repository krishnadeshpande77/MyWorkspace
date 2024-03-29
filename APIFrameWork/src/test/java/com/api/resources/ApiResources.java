package com.api.resources;

public enum ApiResources 
{
	
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	ApiResources(String resource) 
	{
		this.resource = resource;
	}
	
	public String getResources()
	{
		return resource;
	}
}
