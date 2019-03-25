package com.practice.pages;

import static com.practice.wrapper.CommonMethod.*;
import com.practice.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frames extends TestBase
{
	
	@FindBy(linkText="iFrame")
	WebElement lnkIFrame;
	
	public Frames()
	{
		//Initializing the Page Objects:
		PageFactory.initElements(driver, this);
	}
	
	public void goToiFrame()
	{
		click(driver, lnkIFrame);
	}
}
