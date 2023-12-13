package com.api.resources;

import java.util.ArrayList;
import java.util.List;

import com.pojoClasses.AddPlace;
import com.pojoClasses.Location;

public class TestDataBuild
{
	public AddPlace addPlacePayload()
	{
		AddPlace add = new AddPlace();
		add.setAccuracy(50);
		add.setName("Frontline house");
		add.setPhone_number("(+91) 983 893 3937");
		add.setAddress("29, side layout, cohen 09");
		add.setLanguage("French-IN");
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
}
