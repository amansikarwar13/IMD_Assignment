package com.practice.pages;

import static com.practice.wrapper.CommonMethod.click;
import static com.practice.wrapper.CommonMethod.uploadFile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.base.TestBase;

public class FileUpload extends TestBase
{	
	@FindBy(id="file-upload")
	WebElement fileChoose;
	
	@FindBy(id="file-submit")
	WebElement btnUpload;
	
	String strFileName = prop.getProperty("filename");
	String strFilePath = System.getProperty("user.dir") +"\\"+ strFileName;
	
	public FileUpload()
	{
		//Initializing the Page Objects:
		PageFactory.initElements(driver, this);
	}
	
	public void clickChooseFile()
	{
		click(driver, fileChoose);
	}

	public void UploadJPGFile() throws InterruptedException
	{
		uploadFile(driver, strFilePath);
	}
	
	public void clickUpload()
	{
		click(driver, btnUpload);
	}

}
