package com.practice.pages;

import static com.practice.wrapper.CommonMethod.*;
import com.practice.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//button/i[text()=' Login']")
	WebElement btnLogin;
	
	@FindBy(id="username")
	WebElement edtUsername;
	
	@FindBy(id="password")
	WebElement edtPassword;
	
	@FindBy(xpath="//div[contains(text(),'Your username is invalid!')]")
	WebElement elmtErrorMsg;
	
	public LoginPage()
	{
		//Initializing the Page Objects:
		PageFactory.initElements(driver, this);
	}
	
	public String invalidLogin() {
		click(driver, btnLogin);
		return getText(driver, elmtErrorMsg);
	}
	
	public void validLogin() 
	{
		String strUserName = prop.getProperty("username");
		String strPwd = prop.getProperty("password");

		sendKeys(driver, edtUsername, strUserName);
		sendKeys(driver, edtPassword, strPwd);
		
		click(driver, btnLogin);
	}
}
