package com.stepDefinations;

import io.cucumber.java.Before;

public class Hooks 
{
	@Before("@DeletePlace")
	public void beforeScenario() throws Exception
	{
		StepDefination_AddPlace step = new StepDefination_AddPlace();
		if(StepDefination_AddPlace.place_id==null)
		{
			step.add_place_payload("Krishna Deshpande", "Telgu", "USA");
			step.user_calls_with_post_http_request("addPlaceAPI","POST");
			step.verify_place_id_created_maps_to_using("Krishna Deshpande", "getPlaceAPI");
		}
	}
}
