package com.api.testScript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.api.rootLib.RootClass;
import io.restassured.response.Response;

@Listeners(com.api.rootLib.TakeListner.class)
public class FetchAllCountry extends RootClass 
{
	@Test
	public void getCountryDetails()
	{
		String apiData = config.getPropertiesObject("getAllCountries");
		
		Response resp = config.executeRequest(apiData);
		resp.then().log().all();
	}

}
