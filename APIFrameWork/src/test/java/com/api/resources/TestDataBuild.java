package com.api.resources;

import java.util.ArrayList;
import java.util.List;

import com.pojoClasses.AddPlace;
import com.pojoClasses.Location;

public class TestDataBuild
{
	public AddPlace addPlacePayload(String name , String language , String address)
	{
		AddPlace add = new AddPlace();
		add.setAccuracy(50);
		add.setName(name);
		add.setPhone_number("(+91) 999 636 9898");
		add.setAddress(address);
		add.setLanguage(language);
		add.setWebsite("https://rahulshettyacademy.com");
		List<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shoe");
		add.setTypes(mylist);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		add.setLocation(l);
		return add;	
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}
}
