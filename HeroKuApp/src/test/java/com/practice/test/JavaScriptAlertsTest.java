package com.practice.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.pages.HomePage;
import com.practice.pages.JavaScriptAlerts;
import com.practice.pages.LoginPage;

public class JavaScriptAlertsTest extends TestBase
{
	HomePage hp;
	LoginPage lp;
	JavaScriptAlerts jsa;
	boolean alertWindow;

	public JavaScriptAlertsTest()
	{
		super();
	}
		
	@BeforeMethod
	public void setup()
	{
		initialization();
		hp = new HomePage();
		lp = new LoginPage();
		jsa = new JavaScriptAlerts();
	}
		
	@Test(description = "result showing 'You clicked: Ok' on clicking 'Click for JS Cofirm'")
	public void alertConfirm()
	{
		hp.goToJSAlerts();
		jsa.clickJSConfirm();
		
		//validating alert on Page
		alertWindow = jsa.alertPresent();
		Assert.assertTrue(alertWindow, "Alert present on page and is handled successfully");
		
		//validating text after handling alert 
		String strResult = jsa.validateJSAlert();
		Assert.assertEquals(strResult, "You clicked: Ok","You clicked: Ok message is not present");
	}
	
	@Test(description = "result showing 'You entered: null' on entering text and dismissing alert")
	public void alertTextVerification()
	{
		hp.goToJSAlerts();
		jsa.clickJSPromt();
		
		//Entering values in alert text box and dismissing alert 
		alertWindow = jsa.dismissAlertSendKeys();
		Assert.assertTrue(alertWindow, "Text entered successfully and dismiss the changes made");
		
		//validating text after dismissing alert 
		String strResult = jsa.validateJSAlert();
		Assert.assertEquals(strResult, "You entered: null","You entered: null message is not present");
	}

	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}

}

