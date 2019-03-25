package com.practice.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.pages.HomePage;
import com.practice.pages.LoginPage;
import com.practice.pages.SecureArea;

public class LoginTest extends TestBase{
	
	HomePage hp;
	LoginPage lp;
	SecureArea sa;
	String actualmessage;
	boolean strResult;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		hp = new HomePage();
		lp = new LoginPage();
		sa = new SecureArea();
	}
	
	@Test(description = "error message stated 'Your username is invalid!' after clicking on Login Button")
	public void testInvalidLogin()
	{
		hp.goToLogin();
		actualmessage = lp.invalidLogin();
		strResult = actualmessage.contains("Your username is invalid!");
		Assert.assertTrue(strResult, strResult+ "message present on page after clicking on submit button");
	}
	
	@Test(description = "successful message stated 'You logged into a secure area!' on entering valid credentails")
	public void validLogin()
	{
		hp.goToLogin();
		lp.validLogin();
		actualmessage = sa.validLogin();
		strResult = actualmessage.contains("You logged into a secure area!");
		Assert.assertTrue(strResult, strResult+ "message present on page after clicking on submit button");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
