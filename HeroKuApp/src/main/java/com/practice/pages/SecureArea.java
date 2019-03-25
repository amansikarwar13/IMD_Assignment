package com.practice.pages;

import static com.practice.wrapper.CommonMethod.getText;
import com.practice.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureArea extends TestBase
{	
	
	@FindBy(xpath="//div[contains(text(),'You logged into a secure area!')]")
	WebElement elmtSecureArea;
	
	public SecureArea()
	{
		//Initializing the Page Objects:
		PageFactory.initElements(driver, this);
	}
	
	public String validLogin() 
	{
		return getText(driver, elmtSecureArea);
	}
}
