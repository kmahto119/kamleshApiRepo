package com.api.rootLib;

import java.awt.Event;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	private static ExtentReports extents;
	private static String reportFileName="Test-Execution-Report"+".html";
	
	public static ExtentReports getInstance()
	{
		if(extents==null)
		{
			
			createInstance();
		}
		return extents;
	}

	private static ExtentReports createInstance() 
	{
		Date d=new Date();
		String currentTime=d.toString();
		currentTime=currentTime.replaceAll(".", "").replaceAll(":", "");
		//String fileName=getReportPath(reportFilePath);
		reportFileName=reportFileName+currentTime;
		
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("./TestReport/test-report"+currentTime+".html");
		
		
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(reportFileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(reportFileName);
		htmlReporter.config().setTimeStampFormat("EEEE , MMMM DD, YYYY,hh:mm  a'('zzz')'");
		extents = new ExtentReports();
		extents.attachReporter(htmlReporter);
		//set environment details
		extents.setSystemInfo("os", "windows");
		extents.setSystemInfo("AUT", "Gourav");
		return extents;
	}
	
	

}
