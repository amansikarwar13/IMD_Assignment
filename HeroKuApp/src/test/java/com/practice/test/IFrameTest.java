package com.practice.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.pages.Frames;
import com.practice.pages.HomePage;
import com.practice.pages.iFrames;

public class IFrameTest extends TestBase
{
	HomePage hp;
	Frames fr;
	iFrames ifr;
	
	public IFrameTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		hp = new HomePage();
		fr = new Frames();
		ifr = new iFrames();
	}
	
	@Test(description = "iFrame textbox shows I love pizza")
	public void fileUpload() throws InterruptedException
	{
		hp.goToFrame();
		fr.goToiFrame();
		ifr.moveToiFrame();
		String strFrameTxt = ifr.edtiFrameTxt();
		Assert.assertEquals(strFrameTxt, "I love pizza", "I love pizza is not present inside Frame");
	}
		
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
