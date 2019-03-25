package com.practice.wrapper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.Reporter;

import com.practice.util.TestUtil;

public class CommonMethod 
{
	public static void sendKeys(WebDriver driver, WebElement element, String text) 
	{
		int count = 0;
		while (count < TestUtil.STATE_ELEMENT_RETRY_LIMIT) {
			try 
			{
				element.clear();
				element.sendKeys(text);
				count += TestUtil.STATE_ELEMENT_RETRY_LIMIT;
			} catch (NoSuchElementException e) {
				throw e;
			} catch (StaleElementReferenceException e) {
				count += 1;
				if (count >= TestUtil.STATE_ELEMENT_RETRY_LIMIT) {
					Reporter.log("Stale element : " + element);
					throw e;
				}
			} catch (ElementNotVisibleException e) {
				throw e;
			} catch (InvalidElementStateException e) {
				throw e;
			}
		}
	}
	
	public static void click(WebDriver driver, WebElement element) {
		int count = 0;
		while (count < TestUtil.STATE_ELEMENT_RETRY_LIMIT) {
			try {
				element.click();
				count += TestUtil.STATE_ELEMENT_RETRY_LIMIT;
			} catch (NoSuchElementException e) {
				throw e;
			} catch (StaleElementReferenceException e) {
				count += 1;
				if (count >= TestUtil.STATE_ELEMENT_RETRY_LIMIT) {
					throw e;
				}
			} catch (ElementNotVisibleException e) {
				throw e;
			} catch (InvalidElementStateException e) {
				throw e;
			}
		}

	}
	
	public static String getText(WebDriver driver, WebElement element) {
		int count = 0;
		while (count < TestUtil.STATE_ELEMENT_RETRY_LIMIT) {
			try {
				return element.getText();
			} catch (NoSuchElementException e) {
				throw e;
			} catch (StaleElementReferenceException e) {
				count += 1;
				if (count >= TestUtil.STATE_ELEMENT_RETRY_LIMIT) {
					throw e;
				}
			}
		}
		return null;
	}
	
	public static void isElementPresent(WebDriver driver, WebElement element)
	{
		int count = 0;
		while (count < TestUtil.STATE_ELEMENT_RETRY_LIMIT) 
		{
			try 
			{
				Boolean iselementpresent =  element.isDisplayed();
				if (iselementpresent == true)
					Assert.assertTrue(true, element+ "is presnet on page");
				else
					Assert.assertTrue(false, element+ "is not presnet on page");
			}
			catch (NoSuchElementException e) {
				throw e;
			} catch (StaleElementReferenceException e) {
				count += 1;
				if (count >= TestUtil.STATE_ELEMENT_RETRY_LIMIT) {
					throw e;
				}
			} catch (ElementNotVisibleException e) {
				throw e;
			} catch (InvalidElementStateException e) {
				throw e;
			}
			
		}
	}
	
	public static boolean isAlertPresent(WebDriver driver)
	{
	    try
        {
	    	Alert alert = driver.switchTo().alert();
        	alert.accept();
        	return true;
        }
        catch(NoAlertPresentException e)
        {
        	throw e;
        }
    }
	
	public static boolean alertSendKeysDismiss(WebDriver driver, String text)
	{
	    try
        {
	    	Alert alert = driver.switchTo().alert();
	    	alert.sendKeys(text);
	    	alert.dismiss();
        	return true;
        }
        catch(NoAlertPresentException e)
        {
        	throw e;
        }
    }
	
	public static void uploadFile(WebDriver driver, String strPath) throws InterruptedException
	{
		StringSelection stringSelection = new StringSelection(strPath);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		   
        Robot robot = null;
 
        try
        {
            robot = new Robot();
        } catch (AWTException e) 
        {
            e.printStackTrace();
        }
 
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(5000);
    }
	
	
	public static void moveToIframeByNameorID(WebDriver driver, String strNameorID)
	{
		try
        {
			driver.switchTo().frame(strNameorID);
	    }
        catch(NoSuchFrameException e)
        {
        	Reporter.log(e.getMessage());
			throw e;
        }
	}
}
