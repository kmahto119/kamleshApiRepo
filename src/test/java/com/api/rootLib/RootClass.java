package com.api.rootLib;

import org.testng.annotations.BeforeSuite;

import com.api.rootLib.ApiConfig;

public class RootClass {
	public ApiConfig config=new  ApiConfig();
	@BeforeSuite
	public void config()
	{
		
	}

}
