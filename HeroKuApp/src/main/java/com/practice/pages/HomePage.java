package com.practice.pages;

import static com.practice.wrapper.CommonMethod.*;
import com.practice.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase
{
	@FindBy(linkText="Form Authentication")
	WebElement lnkAuthenitcation;
	
	@FindBy(linkText="JavaScript Alerts")
	WebElement lnkJSAlerts;
	
	@FindBy(linkText="File Upload")
	WebElement lnkFileUpload;
	
	@FindBy(linkText="Frames")
	WebElement lnkFrame;
	 	
	public HomePage()
	{
		//Initializing the Page Objects:
		PageFactory.initElements(driver, this);
	}
	
	public void goToLogin()
	{
		click(driver,lnkAuthenitcation);
	}
	
	public void goToJSAlerts()
	{
		click(driver,lnkJSAlerts);
	}
	
	public void goToFileUpload()
	{
		click(driver,lnkFileUpload);
	}
	
	public void goToFrame()
	{
		click(driver,lnkFrame);
	}
}
