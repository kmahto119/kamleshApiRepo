package com.api.testScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.api.rootLib.RootClass;
import io.restassured.response.Response;

@Listeners(com.api.rootLib.TakeListner.class)
public class FetchAllCountry extends RootClass 
{
	@Test
	public void getCountryDetails() throws Throwable
	{
		String apiData = config.getPropertiesObject("getAllCountries");
		
		Response resp = config.executeRequest(apiData);
		int statusCode = resp.statusCode();
		
		Assert.assertEquals(200, statusCode);
		Reporter.log("Status code is:"+statusCode);
		//resp.then().log().all();
		long time = resp.time();
		Reporter.log("Time is"+time);
	}

}
