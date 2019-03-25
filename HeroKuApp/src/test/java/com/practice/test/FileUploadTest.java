package com.practice.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.pages.FileUpload;
import com.practice.pages.FileUploaded;
import com.practice.pages.HomePage;

public class FileUploadTest extends TestBase
{
	HomePage hp;
	FileUpload fu;
	FileUploaded fd;
	boolean strResult;
	String actualMsg;
	
	public FileUploadTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		hp = new HomePage();
		fu = new FileUpload();
		fd = new FileUploaded();
	}
		
	@Test(description = "screen should show File Uploaded! as title and filename burrito.jpg after uploading file")
	public void fileUpload() throws InterruptedException
	{
		hp.goToFileUpload();
		fu.clickChooseFile();
		fu.UploadJPGFile();
		fu.clickUpload();
		
		//validating confirmation message after uploading file
		actualMsg = fd.validateFileUploaded();
		strResult = actualMsg.contains("File Uploaded!");
		Assert.assertTrue(strResult, actualMsg+ "message present on page after uploading file!");
	}
		
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
