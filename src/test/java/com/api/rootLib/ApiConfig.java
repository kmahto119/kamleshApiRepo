package com.api.rootLib;

import java.io.FileInputStream;
import java.util.Properties;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Listeners;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


@Listeners(com.api.rootLib.TakeListner.class)
public class ApiConfig {
	
	Response resp;
	Properties pobj=new Properties();
	String[] keyValue;
	
	
	public String getPropertiesObject(String key)
	{
		try {
			
			FileInputStream fis=new FileInputStream("./apiList.properties");
			pobj.load(fis);
			
		   }
		catch(Exception e)
		  {
		   e.printStackTrace();	   
		  }
		return pobj.getProperty(key);	
	}
	
	
	public Response executeRequest(String apiData)
	{
		String[] arr=apiData.split(";");
		
		if(arr[0].equals("get"))
		{
				resp=given().param("userId", "7").when().get(arr[1]);	
			
		}
		else if (arr[0].equals("post"))
		{
			String postObj=createJSONObject(arr[2]);
			resp=given()
					.contentType(ContentType.JSON)
					.body(postObj)
					.when()
					.post(arr[1]);
		}
		else if (arr[0].equals("patch"))
		{
			String postObj = createJSONObject(arr[2]);
			resp=given()
					.contentType(ContentType.JSON)
					.body(postObj)
					.when()
					.patch(arr[1]);
		}
		else if (arr[1].equals("put"))
		{
			String putObj = createJSONObject(arr[2]);
			resp=given()
					.contentType(ContentType.JSON)
					.body(putObj)
					.when()
					.put(arr[1]);
			
		}
		if (arr[0].equals("delete"))
		{
			resp = delete(arr[1]);
			
		} 		
		return resp;	
			
		}


	private String createJSONObject(String data) 
	{
		JSONObject jObj=new JSONObject();
		String[] arrJsonData = data.split(",");
		
		for (int i = 0; i < arrJsonData.length; i++) 
		{	
			keyValue=arrJsonData[i].split(":");
			jObj.put(keyValue[0],keyValue[1]);
			
		}
		return jObj.toJSONString();
	}	
}
