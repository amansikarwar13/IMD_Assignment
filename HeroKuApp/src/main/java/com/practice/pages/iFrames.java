package com.practice.pages;

import static com.practice.wrapper.CommonMethod.*;
import com.practice.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iFrames extends TestBase
{
	
	@FindBy(id="tinymce")
	WebElement edtTinyMCE;
	
	public iFrames()
	{
		//Initializing the Page Objects:
		PageFactory.initElements(driver, this);
	}
	
	public void moveToiFrame()
	{
		moveToIframeByNameorID(driver, "mce_0_ifr");
	}
	
	public String edtiFrameTxt()
	{
		sendKeys(driver, edtTinyMCE, "I love pizza");
		return getText(driver, edtTinyMCE);
	}
}
