package com.practice.pages;

import static com.practice.wrapper.CommonMethod.*;
import com.practice.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlerts extends TestBase
{
	@FindBy(xpath="//button[text()='Click for JS Confirm']")
	WebElement btnJSConfirm;
	
	@FindBy(xpath="//button[text()='Click for JS Prompt']")
	WebElement btnJSPromt;
	
	@FindBy(xpath="//p[text()='You clicked: Ok']")
	WebElement elmtClickedOK;
	
	@FindBy(id="result")
	WebElement elmtAlertResult;
	 	
	public JavaScriptAlerts()
	{
		//Initializing the Page Objects:
		PageFactory.initElements(driver, this);
	}
	
	public void clickJSConfirm()
	{
		click(driver, btnJSConfirm);
	}
	
	public void clickJSPromt()
	{
		click(driver, btnJSPromt);
	}
	
	public boolean alertPresent()
	{
		return isAlertPresent(driver);
	}
	
	public String validateJSAlert()
	{
		return getText(driver, elmtAlertResult);
	}
	
	public boolean dismissAlertSendKeys()
	{
		return alertSendKeysDismiss(driver, "Test JS Prompt");
	}
}
