package com.practice.pages;

import static com.practice.wrapper.CommonMethod.*;
import com.practice.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploaded extends TestBase
{	
	@FindBy(id="content")
	WebElement elmtFileUploaded;
	
	public FileUploaded()
	{
		//Initializing the Page Objects:
		PageFactory.initElements(driver, this);
	}
	
	public String validateFileUploaded()
	{
		return getText(driver, elmtFileUploaded);
	}
}
